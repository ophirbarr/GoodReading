package client;

import javax.swing.JPanel;

import java.awt.Font;
import java.io.IOException;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTable;

import common.Message;
import good_reading.BookReview;
import good_reading.SystemUser;

import javax.swing.JScrollPane;
import javax.swing.JList;

public class AddNewUserGUI extends JPanel {
	
	private ClientInterface clientInterface;
	private SystemUser[] users ;   //a list of all awaiting approval users        
	private int size;   //number of awaiting approval users
	private DefaultListModel model;

	/**
	 * Create the panel.
	 */
	
	/**
	 * constructor
	 * @param clientInterface
	 */
	
	public AddNewUserGUI(ClientInterface clientInterface) {
		
		super();
		this.clientInterface = clientInterface;
		ViewUsers();

		Message msg = (Message) clientInterface.getMsgFromServer();
		users = (SystemUser[])msg.getParameters().get(0);
		size=users.length;

		model = new DefaultListModel();
		setLayout(null);
		
		JButton btnAddUser = new JButton("Add");
		btnAddUser.setBounds(345, 61, 76, 42);
		add(btnAddUser);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(38, 61, 277, 212);
		add(scrollPane);
		
		if(size==0) model.addElement("There is no users that waiting for approval!" );
		else for(int i=0;i<size;i++)  //additional the reviews to Jlist
			model.addElement(String.format("%-50s%-40s", users[i].get_firstName()));
		
		
		JLabel lblWrittenForBook = new JLabel("UserName                            UserId");
		scrollPane.setColumnHeaderView(lblWrittenForBook);
		JList list = new JList();
		scrollPane.setViewportView(list);
		
		list.setModel(model);
		
		JLabel lblTheReviewsThat = new JLabel("The Users that waiting for approve:");
		lblTheReviewsThat.setFont(new Font("Tahoma", Font.ITALIC, 15));
		lblTheReviewsThat.setBounds(38, 11, 295, 26);
		add(lblTheReviewsThat);
					
		}
	
	
	public void ViewUsers() {
		
		Message msg = new Message("ViewUsersWithCondition", "LibrarianController");
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

	
