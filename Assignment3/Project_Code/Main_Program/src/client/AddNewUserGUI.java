package client;

import javax.swing.JPanel;

import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.border.EtchedBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import common.Define;
import common.Message;
import good_reading.Book;
import good_reading.BookReview;
import good_reading.SystemUser;

import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;

public class AddNewUserGUI extends JPanel {
	
	private ClientInterface clientInterface;
	private SystemUser[] users ;   //a list of all awaiting approval users        
	private int size;  
	private DefaultListModel model;	
	private final JScrollPane scrollPane = new JScrollPane();

	
	/**
	 * constructor
	 * @param clientInterface
	 */
	
	public AddNewUserGUI(ClientInterface clientInterface) {
		
		super();
		this.clientInterface = clientInterface;
		setLayout(null);
		scrollPane.setBounds(22, 210, 410, 155);
		add(scrollPane);

		DefaultListModel<String> listModel = new DefaultListModel<String>();
		
		JLabel ResultTitle = new JLabel("Name         LastName         ID");
		ResultTitle.setFont(new Font("Tahoma", Font.BOLD, 11));
		scrollPane.setColumnHeaderView(ResultTitle);
		JList<String> list = new JList<String>( listModel );
		scrollPane.setViewportView(list);
		list.setFont( new Font("monospaced", Font.PLAIN, 14) );
		
		Message msg = new Message("ViewUsersWithCondition", "LibrarianController");
		msg.add(1);
		
		try {
			clientInterface.client.openConnection();
			clientInterface.client.sendToServer(msg);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		clientInterface.waitForServer();  // Waiting for approval from the server

		
		users = (SystemUser[])clientInterface.getMsgFromServer();
		
		size=users.length;
		
		if(size==0) listModel.addElement("There is no users that waiting for approval!" );
		else
		{
			for(int i=0;i<size;i++)  
			{
			listModel.addElement(String.format("%-9s%-9s%s",users[i].get_firstName(),users[i].get_lastName(),users[i].get_uid()));
			}
		}
		JLabel lblTheReviewsThat = new JLabel("Users that waiting for approve:");
		lblTheReviewsThat.setBounds(41, 95, 281, 29);
		lblTheReviewsThat.setFont(new Font("Tahoma", Font.ITALIC, 15));
		add(lblTheReviewsThat);
		
		JButton btnAddUser = new JButton("Add");
		btnAddUser.setBounds(156, 137, 83, 44);
		add(btnAddUser);
		
		
		list.addListSelectionListener(new ListSelectionListener() {
			
		
			public void valueChanged(ListSelectionEvent e) {
				int index = list.getSelectedIndex();
				
				btnAddUser.addActionListener(new ActionListener() {

					public void actionPerformed(ActionEvent arg0) {
						
						try {
							Message msg = new Message("AddNewUser", "LibrarianController");
							msg.add(users[index].get_uid());
							clientInterface.client.openConnection();
							clientInterface.client.sendToServer(msg);
						} catch (IOException e) {
							e.printStackTrace();
						}
						
						//clientInterface.waitForServer();
						JOptionPane.showMessageDialog(null, "The User Status Changed To DISCONNECTED");
					}
					
				});
				
				
			} 	
			
		});
			
	}
}		
					
		
	



	
