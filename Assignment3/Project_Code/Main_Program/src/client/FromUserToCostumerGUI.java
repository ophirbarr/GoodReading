package client;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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

/**
 * 
 * @author Inna
 *Class GUI which displays all the customers for the librarian that pending approval
 */
public class FromUserToCostumerGUI extends JPanel {
	
	private ClientInterface clientInterface;
	private Customer[] customers ;   //a list of all awaiting approval customers        
	private int size;  
	private DefaultListModel model;	
	private final JScrollPane scrollPane = new JScrollPane();
	
	/**
	 * constructor that creates the panel.
	 * @param clientInterface The main class of the program.
	 */
	
	
	public FromUserToCostumerGUI(ClientInterface clientInterface) {
		
		super();
		this.clientInterface = clientInterface;
		setLayout(null);
		scrollPane.setBounds(22, 210, 410, 155);
		add(scrollPane);

		DefaultListModel<String> listModel = new DefaultListModel<String>();
		
		JLabel ResultTitle = new JLabel("Name          LastName         ID");
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
			listModel.addElement(String.format("%-9s%-9s%s",customers[i].get_firstName(),customers[i].get_lastName(),customers[i].get_uid()));
			}
		}
		
		JLabel lblcustomers = new JLabel("New customers that waiting for approval:");
		lblcustomers.setBounds(41, 95, 274, 28);
		lblcustomers.setFont(new Font("Tahoma", Font.ITALIC, 15));
		add(lblcustomers);
		
		JButton btnChangeAccount = new JButton("Change Account Status");
		btnChangeAccount.setBounds(141, 135, 187, 54);
		add(btnChangeAccount);
		
		/**
		 * ListSelectionListener to know which customer is selected
		 */
		
		list.addMouseListener(new MouseAdapter() {
			
		
			public void mouseClicked(MouseEvent e) {
				int index = list.getSelectedIndex();
				
				btnChangeAccount.addActionListener(new ActionListener() {
					/**
					 * ChangeAccount button Listener - change the user to customer
					 */

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
