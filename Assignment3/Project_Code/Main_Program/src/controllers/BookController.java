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
