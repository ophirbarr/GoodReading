package controllers;

import java.awt.Color;

import javax.swing.JPanel;

import org.orm.PersistentException;
import org.orm.PersistentSession;
import org.orm.PersistentTransaction;

import client.ClientInterface;
import client.MainGUI;
import client.SubmitReviewGUI;
import client.ViewBookGUI;
import good_reading.Book;
import good_reading.BookReview;
import good_reading.GoodReadingPersistentManager;

public class CostumerController {
	
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
	
	public static void BuyBook()
	{
		
	}
	
	public static void MyBooks()
	{
		
	}
	
	public static void UpdateAccountType()
	{
		
	}
	
	public static void ValidateAccount()
	{
		
	}
}
