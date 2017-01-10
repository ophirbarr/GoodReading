package controllers;
import java.awt.Color;

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
}
