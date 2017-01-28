package client;

import java.io.IOException;
import javax.swing.JPanel;
import common.Message;
import good_reading.BookReview;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JList;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.DefaultListModel;
import java.awt.Color;
import javax.swing.JScrollPane;
/**
 * class GUI which displays a list of all awaiting approval reviews
 * @author avihai
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
		scrollPane.setBounds(10, 63, 577, 264);
		add(scrollPane);
		JList list = new JList();
		list.setValueIsAdjusting(true);
		list.setFont(new Font("Monospaced", Font.ITALIC, 12));
		
		//size = 0 : There is no awaiting approval reviews
		if(size==0) model.addElement("There is no reviews that waiting for approval!" ); 
		else for(int i=0;i<size;i++)  //additional the reviews to Jlist
				model.addElement(String.format("%-40s%-20s", name_book[i],br[i].get_review()));
		
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
		
		JLabel lblWrittenForBook = new JLabel("Written for Book:                                                             The Review:");
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
		
	Message msg = new Message("InspectReviews", "InspectReviewController");
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
