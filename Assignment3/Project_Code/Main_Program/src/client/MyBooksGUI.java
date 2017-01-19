package client;

import java.awt.Color;
import java.awt.Font;
import java.io.IOException;

import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import common.Message;
import good_reading.Book;
import good_reading.BookReview;
import good_reading.Customer;


public class MyBooksGUI extends JPanel {

	private ClientInterface clientInterface;
	
	/**
	 * Create the panel.
	 */
	public MyBooksGUI(ClientInterface clientInterface, Customer customer) {
		super();
		setBackground(Color.WHITE);
		this.clientInterface = clientInterface;
		setLayout(null);
		
		JPanel imagePanel = new JPanel();
		imagePanel.setBounds(0, 0, 727, 588);
		imagePanel.setBackground(new Color(250, 243, 232));
		add(imagePanel);
		imagePanel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(32, 101, 346, 354);
		imagePanel.add(scrollPane);
		
		DefaultListModel<String> listModel = new DefaultListModel<String>();
		
		JList<String> list = new JList<String>(listModel);
		
		scrollPane.setViewportView(list);
		
		JLabel lblResultTitle = new JLabel("ID            Title                                                       Language            Price           Summary");
		lblResultTitle.setFont(new Font("Tahoma", Font.BOLD, 11));
		scrollPane.setColumnHeaderView(lblResultTitle);
		
		Message msg = new Message("MyBooks", "CustomerController");
		msg.add(customer);
		
		try {
			clientInterface.client.openConnection();
			clientInterface.client.sendToServer(msg);
		} catch (IOException e) {
			e.printStackTrace();
		}
		clientInterface.waitForServer();
		
		Book[] myBooks = (Book[])clientInterface.getMsgFromServer();
		listModel.clear();
		
		if (myBooks.length == 0) 
			listModel.addElement("There are no matching results to your query.");
		else
			for(int i=0; i< myBooks.length;i++)
			{
				listModel.addElement(String.format("%-6d%-24s%-11s%-8.2f%s", myBooks[i].get_bid(), myBooks[i].get_title(), myBooks[i].get_language(), myBooks[i].get_price(), myBooks[i].get_summary()));
			}
		
		list.addListSelectionListener(new ListSelectionListener() { 
			/**
			 * Listener selected review - displays the review in detail
			 */
			public void valueChanged(ListSelectionEvent e) {
				int index = list.getSelectedIndex();   //index in the list of the selected review
				clientInterface.mainPanel.remove(clientInterface.mainPanel.currentPanel);
				clientInterface.mainPanel.currentPanel = new ViewBookGUI(clientInterface, myBooks[index]);
				clientInterface.mainPanel.currentPanel.setBounds(176, 1, 724, 475);
				clientInterface.mainPanel.currentPanel.setBackground(new Color(250, 243, 232));
				clientInterface.mainPanel.add(clientInterface.mainPanel.currentPanel);
				clientInterface.mainPanel.currentPanel.setLayout(null);
				clientInterface.mainPanel.currentPanel.revalidate();
				clientInterface.mainPanel.currentPanel.repaint();
				
			}
		});
	}

}
