package client;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import common.Message;
import good_reading.Customer;
import good_reading.SystemUser;

public class FromUserToCostumerGUI extends JPanel {
	
	private ClientInterface clientInterface;
	private Customer[] customers ;   //a list of all awaiting approval customers        
	private int size;  
	private DefaultListModel model;	
	private final JScrollPane scrollPane = new JScrollPane();
	
	/**
	 * constructor
	 * @param clientInterface
	 */
	
	
	public FromUserToCostumerGUI(ClientInterface clientInterface) {
		
		super();
		this.clientInterface = clientInterface;
		setLayout(null);
		scrollPane.setBounds(22, 210, 410, 155);
		add(scrollPane);

		DefaultListModel<String> listModel = new DefaultListModel<String>();
		
		JLabel ResultTitle = new JLabel("Name       LastName       ID");
		ResultTitle.setFont(new Font("Tahoma", Font.BOLD, 11));
		scrollPane.setColumnHeaderView(ResultTitle);
		JList<String> list = new JList<String>( listModel );
		scrollPane.setViewportView(list);
		list.setFont( new Font("monospaced", Font.PLAIN, 14) );
		
		Message msg = new Message("ViewUsersWithCondition", "LibrarianController");
		msg.add(2);

		
		try {
			clientInterface.client.openConnection();
			clientInterface.client.sendToServer(msg);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		clientInterface.waitForServer();  // Waiting for approval from the server
		

		customers = (Customer[])clientInterface.getMsgFromServer();

			
		if(customers.length==0) listModel.addElement("There is no new customers that waiting for approval!" );
		else
		{
			for(int i=0;i<customers.length;i++)  
			{
			listModel.addElement(customers[i].get_firstName());
			}
		}
		
		JLabel lblTheReviewsThat = new JLabel("New customers that waiting for approval:");
		lblTheReviewsThat.setBounds(41, 95, 274, 28);
		lblTheReviewsThat.setFont(new Font("Tahoma", Font.ITALIC, 15));
		add(lblTheReviewsThat);
		
		JButton btnChangeAccount = new JButton("Change Account Status");
		btnChangeAccount.setBounds(141, 135, 155, 55);
		add(btnChangeAccount);
		
		
		list.addListSelectionListener(new ListSelectionListener() {
			
		
			public void valueChanged(ListSelectionEvent e) {
				int index = list.getSelectedIndex();
				
				btnChangeAccount.addActionListener(new ActionListener() {

					public void actionPerformed(ActionEvent arg0) {
						
						try {
							Message msg = new Message("FromUserToCostumer", "LibrarianController");
							msg.add(customers[index].get_uid());
							clientInterface.client.openConnection();
							clientInterface.client.sendToServer(msg);
						} catch (IOException e) {
							e.printStackTrace();
						}
						
						//clientInterface.waitForServer();
						JOptionPane.showMessageDialog(null, "The User Account Status Changed");
					}
					
				});
				
				
			} 				
		});
	}
	
	
}
