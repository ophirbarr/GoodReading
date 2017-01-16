package controllers;

import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;

import javax.swing.JPanel;

import org.orm.PersistentException;
import org.orm.PersistentSession;
import org.orm.PersistentTransaction;

import common.Define;
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
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
	
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
	
	public static void BuyBook(SystemUser user, Book book)
	{
		float price = book.get_price();
		try {
			if(Customer.getCustomerByORMID(user.get_uid()) != null)
			{
				if(ValidateAccount(user))
					if(((Customer)user).get_accountType() == Define.ACCOUNT_MONTHLY)
						price = price*(float)(1-0.25);
					else if(((Customer)user).get_accountType() == Define.ACCOUNT_YEARLY)
						price = price*(float)(1-0.5);
				
				//TODO continue
				
				
			}
		} catch (PersistentException e) {
			e.printStackTrace();
		}
	}
	
	public static Book[] MyBooks(SystemUser user) // need to check
	{
		Book books[] = null;
		Customer_Book customerBook[];
		
		try {
			customerBook = Customer_Book.listCustomer_BookByQuery("_uid = '" + user.get_uid(), "_bid");
				
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
	
	public static void UpdateAccountType(SystemUser user)
	{
		if(ValidateAccount(user))
		{
			if(((Customer)user).get_accountType() != Define.ACCOUNT_PER_BOOK)
				;//TODO Send message to client that he already has an active subscription
			else
				;//TODO Get a new type from user, update the _waitingForChangeType to the correct value.
		}
		else
			;//TODO Send message to client that the account is blocked
		
	}
	
	public static boolean ValidateAccount(SystemUser user)
	{
		boolean isValid = false;
		
		if(((Customer)user).get_accountStatus() == Define.ACCOUNT_FULL_PERMISSION)
		{
			if(((Customer)user).get_accountType() != Define.ACCOUNT_PER_BOOK)
			{
				if(((Customer)user).get_endDate().before(date))
				{
					((Customer)user).set_accountType(Define.ACCOUNT_PER_BOOK);
					
					// TODO Send message to client that the date has expired
					new PopUpMessageGUI("The subsciption date has been expired");
				}
			}
				
			isValid = true;
		}
		return isValid;
	}
}
