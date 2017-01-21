package client;

import java.awt.Color;
import java.awt.Font;
import java.io.IOException;

import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.border.EtchedBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import common.Message;
import good_reading.Book;
import good_reading.BookReview;
import good_reading.Customer;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * GUI class. Extends JPanel. Displays all the customer's purchased books.
 * @author yair
 */
public class MyBooksGUI extends JPanel {

	private ClientInterface clientInterface;
	
	/**
	 * Constructor that creates the panel.
	 * @param clientInterface The main class of the program.
	 * @param customer The customer using the program.
	 */
	public MyBooksGUI(ClientInterface clientInterface, Customer customer) {
		super();
		setBackground(Color.WHITE);
		this.clientInterface = clientInterface;
		setLayout(null);
		
		JPanel imagePanel = new JPanel();
		imagePanel.setBounds(0, 0, 727, 579);
		imagePanel.setBackground(new Color(250, 243, 232));
		add(imagePanel);
		imagePanel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(23, 101, 520, 354);
		imagePanel.add(scrollPane);
		
		DefaultListModel<String> listModel = new DefaultListModel<String>();
		
		JList<String> list = new JList<String>(listModel);
		
		scrollPane.setViewportView(list);
		
		JLabel lblResultTitle = new JLabel("ID            Title                                                       Language            Price           Summary");
		lblResultTitle.setFont(new Font("Tahoma", Font.BOLD, 11));
		scrollPane.setColumnHeaderView(lblResultTitle);
		
		JLabel lblMyBooks = new JLabel("My Books");
		lblMyBooks.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblMyBooks.setBounds(167, 40, 90, 30);
		imagePanel.add(lblMyBooks);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(MyBooksGUI.class.getResource("/design/g27726.png")));
		label.setBounds(583, 355, 61, 100);
		imagePanel.add(label);
		
		JButton lblDownloadBook = new JButton("Download Book");
		lblDownloadBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		lblDownloadBook.setBounds(583, 255, 118, 30);
		imagePanel.add(lblDownloadBook);
		
		JPanel typePanel = new JPanel();
		typePanel.setBounds(601, 139, 100, 90);
		imagePanel.add(typePanel);
		typePanel.setLayout(null);
		typePanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		
		JRadioButton rdbtnBooks = new JRadioButton("books");
		rdbtnBooks.setSelected(true);
		rdbtnBooks.setBounds(6, 7, 88, 23);
		typePanel.add(rdbtnBooks);
		
		JRadioButton rdbtnSubjects = new JRadioButton("subjects");
		rdbtnSubjects.setBounds(6, 33, 88, 23);
		typePanel.add(rdbtnSubjects);
		
		JRadioButton rdbtnDomains = new JRadioButton("domains");
		rdbtnDomains.setBounds(6, 60, 88, 23);
		typePanel.add(rdbtnDomains);
		
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
