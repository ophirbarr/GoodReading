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
import client.PopUpMessageGUI;
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
	public static void SubmitReview(BookReview review)
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
	}
	
	public static BufferedInputStream DownloadBook(String format, String paths)
	{
		String AllPaths[] = paths.split(" ");
		String path = null;
		
		if(format.equals("PDF"))
			path = AllPaths[0];
		else if(format == "DOC")
			path = AllPaths[1];
		else if(format == "FB2")
			path = AllPaths[2];

		BufferedInputStream bin = null;
		
		try {
			File transferFile = new File (path);
			byte [] bytearray = new byte [(int)transferFile.length()];
			FileInputStream fin = new FileInputStream(transferFile);
			bin = new BufferedInputStream(fin);
			bin.read(bytearray,0,bytearray.length);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return bin;
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
					
					new PopUpMessageGUI(clientInterface.frame, "You've got a discount. Only " + price + "$", Define.Like);
				}
				
				msg = new Message ("AddBookToCustomer", "CustomerController");
				msg.add(book.get_bid());
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
				new PopUpMessageGUI(clientInterface.frame, "You already have this book.<br>Look up MyBooks", Define.Notice);
		}

		return isPurchase;
	}
	
	/**
	 * Adds a book to a customer's book list using Customer_Book to the data base.
	 * This function is used by the server.
	 * @param bid The ID of the book to be added.
	 * @param uid The user ID.
	 */
	public static void AddBookToCustomer(int bid, int uid)
	{
		try {
			PersistentSession session = GoodReadingPersistentManager.instance().getSession();
	
			Customer_Book customer_book = new Customer_Book();
			customer_book.set_bid(bid);
			customer_book.set_uid(uid);
			
			//----add customer_book to database
			PersistentTransaction t = session.beginTransaction();
			session.save(customer_book);
			t.commit();
		
			session.close();
		} catch (PersistentException e) {
			e.printStackTrace();
		}
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
	 * Updates the account type of a customer to a new type. 
	 * @param clientInterface The main class of the program.
	 * @param customer The customer whose account type is to be updated.
	 * @param Type The new account type requested by the customer.
	 */
	public static void UpdateAccountType(ClientInterface clientInterface, Customer customer, int Type)
	{
		if(ValidateAccount(clientInterface, customer))
		{
			if((customer).get_accountType() != Define.ACCOUNT_PER_BOOK)
				new PopUpMessageGUI(clientInterface.frame, "You already have an active subscription.", Define.Notice);
			else
			{
				customer.set_accountType(Type);
				Message msg = new Message ("UpdateCustomer", "CustomerController");
				msg.add(customer);
				try {
					clientInterface.client.openConnection();
					clientInterface.client.sendToServer(msg);
				} catch (IOException e) {
					e.printStackTrace();
				}
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
		int isValid = 0;
		
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
						isValid = 3;
					}						
				}
			}
			else
				isValid = 2;
		}
		else
			isValid = 1;
		
		if(isValid != 0)
			ValidateAccountMessage(clientInterface, isValid);
		
		return (isValid == 0);
	}
	
	/**
	 * Notifies the customer about the validation of the account.
	 * @param clientInterface The main class of the program.
	 * @param isValid A flag to indicate the account validation status (WAIT, BLOCKED, EXPIRED).
	 */
	public static void ValidateAccountMessage(ClientInterface clientInterface, int isValid)
	{
		final int WAIT = 1, BLOCKED = 2, EXPIRED = 3;
		
		switch(isValid)
		{
		case WAIT:
			new PopUpMessageGUI(clientInterface.frame, "Your request to open an account is still being processed.", Define.Build);
			break;
		case BLOCKED:
			new PopUpMessageGUI(clientInterface.frame, "The account is blocked.<br>Please contact the manager.", Define.Error);
			break;
		case EXPIRED:
			new PopUpMessageGUI(clientInterface.frame, "The subsciption date has been expired", Define.Notice);
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
			session = GoodReadingPersistentManager.instance().getSession();
			//----update book in database
			PersistentTransaction t = session.beginTransaction();
			session.save(customer);
			t.commit();
			session.close();
		} catch (PersistentException e) {
			e.printStackTrace();
		}
	}
}
