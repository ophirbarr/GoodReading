package controllers;

import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JPanel;

import client.ClientInterface;
import client.MainGUI;
import client.SearchBookGUI;
import client.ViewBookGUI;
import good_reading.Book;

public class BookController {

	public static void ViewBook(ClientInterface clientInterface, Book book)
	{
		MainGUI mainGUI = clientInterface.mainPanel;
		JPanel currentPanel = mainGUI.currentPanel;
		mainGUI.remove(currentPanel);
		currentPanel = new ViewBookGUI(clientInterface, book);
		currentPanel.setBounds(176, 1, 724, 475);
		currentPanel.setBackground(new Color(255, 255, 255));
		mainGUI.add(currentPanel);
		currentPanel.setLayout(null);
		currentPanel.revalidate(); // For Java 1.7 or above.
		// frame.getContentPane().validate(); // For Java 1.6 or below.
		currentPanel.repaint();
	}
	
	public static void AddToSearchLog(Book book)
	{
		Calendar cal = Calendar.getInstance();
		Date date = cal.getTime();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
		String searchLog = book.get_searchLog();
		if(!searchLog.isEmpty())
			searchLog = searchLog + " " +sdf.format(date);
		else
			searchLog = sdf.format(date);
		book.set_searchLog(searchLog);
	}
	
	public static void AddToPurchaseLog(Book book)
	{
		Calendar cal = Calendar.getInstance();
		Date date = cal.getTime();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
		String purchaseLog = book.get_purchaseLog();
		if(!purchaseLog.isEmpty())
			purchaseLog = purchaseLog + " " +sdf.format(date);
		else
			purchaseLog = sdf.format(date);
		book.set_purchaseLog(purchaseLog);
		book.set_purchaseCount(book.get_purchaseCount()+1);
	}
}
