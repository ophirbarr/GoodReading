package controllers;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import org.orm.PersistentException;
import org.orm.PersistentSession;
import org.orm.PersistentTransaction;

import common.Define;
import common.Message;
import client.ClientInterface;
import good_reading.Book;
import good_reading.BookReview;
import good_reading.Customer;
import good_reading.Customer_Book;
import good_reading.GoodReadingPersistentManager;
/**
 * @author yair
 * Controller class. Contains all the function that can be activated by a customer.
 */
public class CustomerController {
	
	private static Calendar cal = Calendar.getInstance();
	private static Date date = cal.getTime();
	
	/**
	 * Adds a new book review to the data base. This function is used by the server.
	 * @param review The review to be added.
	 */
	public static boolean SubmitReview(BookReview review)
	{
		if(!(review.get_review().isEmpty()))
		{
			PersistentSession session;
			try {
				session = GoodReadingPersistentManager.instance().getSession();
				//----update book in database
				PersistentTransaction t = session.beginTransaction();
				session.save(review);
				t.commit();
				session.close();
			} catch (PersistentException e) {
				e.printStackTrace();
			}
			return true;
		}
		return false;
	}
	
	public static byte[] DownloadBook(String format, String paths)
	{
		String AllPaths[] = paths.split(" ");
		String path = null;
		
		if(format.equals("PDF"))
			path = AllPaths[0];
		else if(format.equals("DOC"))
			path = AllPaths[1];
		else if(format.equals("FB2"))
			path = AllPaths[2];

		BufferedInputStream bin = null;
		byte [] bytearray = null;
		try {
			File transferFile = new File (path);
			bytearray = new byte [(int)transferFile.length()];
			FileInputStream fin = new FileInputStream(transferFile);
			bin = new BufferedInputStream(fin);
			bin.read(bytearray,0,bytearray.length);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return bytearray;
	}
	
	/**
	 * Checks the possibility  to sell the book to the customer.
	 * The function checks the validation of the customers account and if the customer already has this book.
	 * If all above are o.k then the correct price is being calculated according to the account type.
	 * A message is sent to the server to add the book to the customer's book list in the data base. 
	 * @param clientInterface The main class of the program.
	 * @param customer The customer requesting to buy a book.
	 * @param book The book that is to be purchased.
	 * @return Returns true/false, according to whether the purchase had been completed or not.
	 */
	public static boolean BuyBook(ClientInterface clientInterface, Customer customer, Book book)
	{
		boolean isPurchase = false, hasBook = false;
		float price = book.get_price();
		
		if(ValidateAccount(clientInterface, customer))
		{
			//get all customer's books and check that he didn't buy that book
			Message msg = new Message ("MyBooks", "CustomerController");
			msg.add(customer);
			try {
				clientInterface.client.openConnection();
				clientInterface.client.sendToServer(msg);
			} catch (IOException e) {
				e.printStackTrace();
			}
			clientInterface.waitForServer();
			Book books[] = (Book[])clientInterface.getMsgFromServer();
			
			if(books != null)
				for(Book ibook : books)
					if(ibook.get_bid() == book.get_bid())
						hasBook = true;
			
			if(!hasBook)
			{
				if(customer.get_accountType() != Define.ACCOUNT_PER_BOOK)
				{
					if(customer.get_accountType() == Define.ACCOUNT_MONTHLY)
						price = price*(float)(1-0.25);
					else if(customer.get_accountType() == Define.ACCOUNT_YEARLY)
						price = price*(float)(1-0.5);
					
					Define.PopUp("You've got a discount. Only " + price + "$", Define.Like);
				}
				
				msg = new Message ("AddBookToCustomer", "CustomerController");
				msg.add(book);
				msg.add(customer.get_uid());
				try {
					clientInterface.client.openConnection();
					clientInterface.client.sendToServer(msg);
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				isPurchase = true;
			}
			else
				Define.PopUp("You already have this book.<br>Look up MyBooks", Define.Notice);
		}

		return isPurchase;
	}
	
	/**
	 * Adds a book to a customer's book list using Customer_Book to the data base.
	 * This function is used by the server.
	 * @param book The book to be added.
	 * @param uid The user ID.
	 */
	public static void AddBookToCustomer(Book book, int uid)
	{
		try {
			PersistentSession session = GoodReadingPersistentManager.instance().getSession();
	
			Customer_Book customer_book = new Customer_Book();
			customer_book.set_bid(book.get_bid());
			customer_book.set_uid(uid);
			
			//----add customer_book to database
			PersistentTransaction t = session.beginTransaction();
			session.save(customer_book);
			t.commit();
		
			session.close();
		} catch (PersistentException e) {
			e.printStackTrace();
		}
		
		BookController.AddToPurchaseLog(book.get_bid());
	}
	
	/**
	 * Returns all the customers books using the Customer_Book table. 
	 * This function is used by the server.
	 * @param customer The customer whom books are to be return
	 * @return A list of books purchased by the customer.
	 */
	public static Book[] MyBooks(Customer customer)
	{
		Book books[] = null;
		Customer_Book customerBook[];
		
		try {
			customerBook = Customer_Book.listCustomer_BookByQuery("_uid = '" + customer.get_uid() + "'", "_bid");
				
		if (customerBook.length > 0)
		{
			books = new Book[customerBook.length];
			for (int i = 0; i < customerBook.length; i++)
			{
				books[i]= Book.loadBookByQuery("_bid = '" + customerBook[i].get_bid() + "'", null);
			}
		}
		
		} catch (PersistentException e) {
			e.printStackTrace();
		}
		
		return books;
	}
	
	/**
	 * Updates the account _waitingForChangeType status of a customer to a new type. 
	 * @param clientInterface The main class of the program.
	 * @param customer The customer whose account type is to be updated.
	 * @param Type The new account type requested by the customer.
	 */
	public static void WaitForAccountTypeChange(ClientInterface clientInterface, Customer customer, int Type)
	{
		if(ValidateAccount(clientInterface, customer))
		{
				customer.set_waitingForChangeType(Type);
				Message msg = new Message ("UpdateCustomer", "CustomerController");
				msg.add(customer);
				try {
					clientInterface.client.openConnection();
					clientInterface.client.sendToServer(msg);
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				msg = new Message ("CustomerChangeType", "ServerMessage");
				try {
					clientInterface.client.openConnection();
					clientInterface.client.sendToServer(msg);
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}
	
	/**
	 * Checks if the customer's account is valid. 
	 * Updates account type if the subscription date had been expired, and sends message to server to update the date in the data base.
	 * Uses ValidateAccountMessage() to notify the customer. 
	 * @param clientInterface The main class of the program.
	 * @param customer The customer whose account is validated.
	 * @return Returns true/false according to the validation of the account.
	 */
	public static boolean ValidateAccount(ClientInterface clientInterface, Customer customer)
	{
		int isValid = 0, print = 0;
		final int WAIT = 1, BLOCKED = 2, EXPIRED = 3;
		
		if(customer.get_waitingForChangeType() != Define.FROM_USER_TO_CUSTOMER)
		{
			if(customer.get_accountStatus() == Define.ACCOUNT_FULL_PERMISSION)
			{
				if(customer.get_accountType() != Define.ACCOUNT_PER_BOOK)
				{
					if(customer.get_endDate().before(date))
					{
						customer.set_accountType(Define.ACCOUNT_PER_BOOK);
						Message msg = new Message ("UpdateCustomer", "CustomerController");
						msg.add(customer);
						try {
							clientInterface.client.openConnection();
							clientInterface.client.sendToServer(msg);
						} catch (IOException e) {
							e.printStackTrace();
						}
						print = EXPIRED;
					}						
				}
			}
			else
			{
				print = BLOCKED;
				isValid = -1;
			}
		}
		else
		{
			print = WAIT;
			isValid = -1;
		}
		
		if(print != 0)
			ValidateAccountMessage(clientInterface, print);
		
		return (isValid == 0);
	}
	
	/**
	 * Notifies the customer about the validation of the account.
	 * @param clientInterface The main class of the program.
	 * @param print A flag to indicate the account validation status (WAIT, BLOCKED, EXPIRED).
	 */
	public static void ValidateAccountMessage(ClientInterface clientInterface, int print)
	{
		final int WAIT = 1, BLOCKED = 2, EXPIRED = 3;
		
		switch(print)
		{
		case WAIT:
			Define.PopUp("Your request to open an account is still being processed.", Define.Build);
			break;
		case BLOCKED:
			Define.PopUp("The account is blocked.<br>Please contact the manager.", Define.Error);
			break;
		case EXPIRED:
			Define.PopUp("The subsciption date has been expired", Define.Notice);
			break;
		}
	}
	
	/**
	 * Updates a customer in the data base.
	 * This function is used by the server.
	 * @param customer The customer to be updated.
	 */
	public static void UpdateCustomer(Customer customer)
	{
		PersistentSession session;
		try {
			Customer id_customer = Customer.getCustomerByORMID(customer.get_uid());
			
			id_customer.set_accountStatus(customer.get_accountStatus());
			id_customer.set_accountType(customer.get_accountType());
			id_customer.set_endDate(customer.get_endDate());
			id_customer.set_userStatus(customer.get_userStatus());
			id_customer.set_waitingForChangeType(customer.get_waitingForChangeType());
			
			session = GoodReadingPersistentManager.instance().getSession();
			//----update book in database
			PersistentTransaction t = session.beginTransaction();
			session.save(id_customer);
			t.commit();
			session.close();
		} catch (PersistentException e) {
			e.printStackTrace();
		}
	}
}
