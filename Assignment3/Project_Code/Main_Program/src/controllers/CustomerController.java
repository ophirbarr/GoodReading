package controllers;

import java.awt.Color;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;

import javax.swing.JPanel;

import org.orm.PersistentException;
import org.orm.PersistentSession;
import org.orm.PersistentTransaction;

import common.Define;
import common.Message;
import client.ClientInterface;
import client.MainGUI;
import client.PopUpMessageGUI;
import client.SubmitReviewGUI;
import client.ViewBookGUI;
import good_reading.Book;
import good_reading.BookReview;
import good_reading.Customer;
import good_reading.Customer_Book;
import good_reading.GoodReadingPersistentManager;
import good_reading.SystemUser;

public class CustomerController {
	
	private static Calendar cal = Calendar.getInstance();
	private static Date date = cal.getTime();
	
	
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
	
	public static void DownloadBook()
	{
		
	}
	
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
			{
				for(Book ibook : books)
				{
					if(ibook.get_bid() == book.get_bid())
					{
						new PopUpMessageGUI(clientInterface.frame, "You already have this book. Look up MyBooks", Define.Notice);
						hasBook = true;
					}
				}
			}
			
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
		}

		return isPurchase;
	}
	
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
	
	
	public static Book[] MyBooks(Customer customer)
	{
		Book books[] = null;
		Customer_Book customerBook[];
		
		try {
			customerBook = Customer_Book.listCustomer_BookByQuery("_uid = '" + customer.get_uid(), "_bid");
				
		if (customerBook.length > 0)
		{
			books = new Book[customerBook.length];
			for (int i = 0; i < customerBook.length; i++)
			{
				books[i]= Book.loadBookByQuery("_bid = '" + customerBook[i].get_bid(), null);
			}
		}
		
		} catch (PersistentException e) {
			e.printStackTrace();
		}
		
		return books;
	}
	
	
	public static void UpdateAccountType(ClientInterface clientInterface, Customer customer, int Type)
	{
		if(ValidateAccount(clientInterface, customer))
		{
			if((customer).get_accountType() != Define.ACCOUNT_PER_BOOK)
				new PopUpMessageGUI(clientInterface.frame, "You already have an active subscription", Define.Notice);
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
					}
					else
						isValid = 3;
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
	
	
	public static void ValidateAccountMessage(ClientInterface clientInterface, int isValid)
	{
		switch(isValid)
		{
		case 1:
			new PopUpMessageGUI(clientInterface.frame, "Your request to open an account is still being processed.", Define.Build);
			break;
		case 2:
			new PopUpMessageGUI(clientInterface.frame, "The account is blocked. Please contact the manager.", Define.Error);
			break;
		case 3:
			new PopUpMessageGUI(clientInterface.frame, "The subsciption date has been expired", Define.Notice);
			break;
		}
	}
	
	
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
