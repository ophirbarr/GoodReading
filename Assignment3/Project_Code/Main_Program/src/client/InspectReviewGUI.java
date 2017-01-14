package client;

import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JPanel;
import common.Message;
import good_reading.BookReview;

import javax.swing.JToolBar;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JList;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import java.awt.Button;
import java.awt.Color;
import java.awt.ScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.AbstractListModel;

/**
 * 
 * @author avihai
 *class GUI which displays a list of all awaiting approval reviews
 */
public class InspectReviewGUI extends JPanel  {
	//Class variables
	private ClientInterface clientInterface;
	private BookReview[] br ;          //a list of all awaiting approval reviews
	private int size;                  //Number of awaiting approval reviews
	private DefaultListModel model;
	private String[] name_book;        //Book titles which were written reviews
		
	
	/**
	 * constructor
	 * @param clientInterface User Object
	 */
	public InspectReviewGUI(ClientInterface clientInterface) {
		super();
		this.clientInterface = clientInterface;
		InspectReview();
		
	
		Message msg = (Message) clientInterface.getMsgFromServer();   //Query Results
		br = (BookReview[])msg.getParameters().get(0);
		name_book = (String[]) msg.getParameters().get(1);
		size = br.length;
		
		model = new DefaultListModel();
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(106, 63, 277, 212);
		add(scrollPane);
		JList list = new JList();
		
		//size = 0 : There is no awaiting approval reviews
		if(size==0) model.addElement("There is no reviews that waiting for approval!" ); 
		else for(int i=0;i<size;i++)  //additional the reviews to Jlist
				model.addElement(String.format("%-50s%-40s", name_book[i],br[i].get_review()));
		
		list.setModel(model);
		
		list.addListSelectionListener(new ListSelectionListener() { 
			/**
			 * Listener selected review - displays the review in detail
			 */
			public void valueChanged(ListSelectionEvent e) {
				int index = list.getSelectedIndex();   //index in the list of the selected review
				clientInterface.mainPanel.remove(clientInterface.mainPanel.currentPanel);
				clientInterface.mainPanel.currentPanel = new BookreviewGUI(clientInterface,br[index],name_book[index]);
				clientInterface.mainPanel.currentPanel.setBounds(176, 1, 724, 475);
				clientInterface.mainPanel.currentPanel.setBackground(new Color(250, 243, 232));
				clientInterface.mainPanel.add(clientInterface.mainPanel.currentPanel);
				clientInterface.mainPanel.currentPanel.setLayout(null);
				clientInterface.mainPanel.currentPanel.revalidate();
				clientInterface.mainPanel.currentPanel.repaint();
				
			}
		});
		
	
		
		scrollPane.setViewportView(list);
		
		JLabel lblWrittenForBook = new JLabel("Written for Book:                            The Review:");
		scrollPane.setColumnHeaderView(lblWrittenForBook);
		
		JLabel lblTheReviewsThat = new JLabel("The Reviews that waiting for approve:");
		lblTheReviewsThat.setFont(new Font("Tahoma", Font.ITALIC, 15));
		lblTheReviewsThat.setBounds(106, 11, 295, 26);
		add(lblTheReviewsThat);
		
	
	
}
	/**
	 * Sends a request to the server - a list of all awaiting approval reviews
	 */
public void InspectReview(){
		
	Message msg = new Message("getInspectReview", "BookInspectReview");
		clientInterface.msgFromServer = null;
		try {
			clientInterface.client.openConnection();
			clientInterface.client.sendToServer(msg);
		} catch (IOException e) {
			e.printStackTrace();
		}
		clientInterface.waitForServer();  // Waiting for approval from the server
		
}
}
