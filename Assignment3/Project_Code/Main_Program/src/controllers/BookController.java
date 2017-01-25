package controllers;

import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.orm.PersistentException;
import org.orm.PersistentSession;
import org.orm.PersistentTransaction;

import client.ClientInterface;
import client.ViewBookGUI;
import good_reading.Book;
import good_reading.GoodReadingPersistentManager;
/**
 * @author yair
 * Controller class. Contains all function regarding a book.
 */
public class BookController {

	private static Calendar cal = Calendar.getInstance();
	private static Date date = cal.getTime();
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
	
	/**
	 * Changes the current panel on the main frame to the ViewBookGUI panel.
	 * @param clientInterface The main class of the program.
	 * @param book A book to display on the ViewBookGUI panel.
	 */
	public static void ViewBook(ClientInterface clientInterface, Book book)
	{
		clientInterface.mainPanel.remove(clientInterface.mainPanel.currentPanel);
		clientInterface.mainPanel.currentPanel = new ViewBookGUI(clientInterface, book);
		clientInterface.mainPanel.currentPanel.setBounds(176, 1, 724, 475);
		clientInterface.mainPanel.currentPanel.setBackground(new Color(255, 255, 255));
		clientInterface.mainPanel.add(clientInterface.mainPanel.currentPanel);
		clientInterface.mainPanel.currentPanel.setLayout(null);
		clientInterface.mainPanel.currentPanel.revalidate();
		clientInterface.mainPanel.currentPanel.repaint();
	}
	
	/**
	 * Adds the current date to a book's search log and updates the book in the data base.
	 * This function is used by the server.
	 * @param book The book that it's search log needs to be updated.
	 */
	public static void AddToSearchLog(Book book)
	{
		int _bid = book.get_bid();
		
		try {
			book = Book.loadBookByORMID(_bid);
		} catch (PersistentException e) {
			e.printStackTrace();
		}
		
		String searchLog = book.get_searchLog();
		
		if(searchLog != null)
			searchLog = searchLog + " " +sdf.format(date);
		else
			searchLog = sdf.format(date);
		book.set_searchLog(searchLog);
		
		PersistentSession session;
		try {
			session = GoodReadingPersistentManager.instance().getSession();
			//----update book in database
			PersistentTransaction t = session.beginTransaction();
			session.update(book);
			t.commit();
			session.close();
		} catch (PersistentException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Adds the current date to a book's purchase log and updates the book in the data base.
	 * This function is used by the server.
	 * @param book The book that it's purchase log needs to be updated.
	 */
	public static void AddToPurchaseLog(int _bid)
	{
		Book book = null;
		try {
			book = Book.loadBookByORMID(_bid);
		} catch (PersistentException e) {
			e.printStackTrace();
		}
		
		String purchaseLog = book.get_purchaseLog();
		
		if(purchaseLog != null)
			purchaseLog = purchaseLog + " " +sdf.format(date);
		else
			purchaseLog = sdf.format(date);
		book.set_purchaseLog(purchaseLog);
		book.set_purchaseCount(book.get_purchaseCount()+1);
		
		PersistentSession session;
		try {
			session = GoodReadingPersistentManager.instance().getSession();
			//----update book in database
			PersistentTransaction t = session.beginTransaction();
			session.update(book);
			t.commit();
			session.close();
		} catch (PersistentException e) {
			e.printStackTrace();
		}
	}
}
