package controllers;

import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JPanel;

import org.orm.PersistentException;
import org.orm.PersistentSession;
import org.orm.PersistentTransaction;

import client.ClientInterface;
import client.MainGUI;
import client.SearchBookGUI;
import client.ViewBookGUI;
import good_reading.Book;
import good_reading.GoodReadingPersistentManager;

public class BookController {

	private static Calendar cal = Calendar.getInstance();
	private static Date date = cal.getTime();
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
	
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
	
	public static void AddToSearchLog(Book book)
	{
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
	
	public static void AddToPurchaseLog(Book book)
	{
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
