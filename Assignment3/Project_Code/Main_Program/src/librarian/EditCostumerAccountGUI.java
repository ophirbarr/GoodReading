package librarian;

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

import client.ClientInterface;
import common.Message;
import good_reading.Customer;

public class EditCostumerAccountGUI extends JPanel {
	
	private ClientInterface clientInterface;
	private Customer[] customerAccount ;   //a list of all awaiting customers that want to edit their account       
	private int size;  
	private DefaultListModel model;	
	private final JScrollPane scrollPane = new JScrollPane();

	/**
	 * constructor
	 * @param clientInterface The main class of the program.
	 */
	
	public EditCostumerAccountGUI(ClientInterface clientInterface) {
		
		super();
		this.clientInterface = clientInterface;
		setLayout(null);
		scrollPane.setBounds(22, 210, 410, 155);
		add(scrollPane);

		DefaultListModel<String> listModel = new DefaultListModel<String>();
		
		JLabel ResultTitle = new JLabel("Name                                  LastName                          ID");
		ResultTitle.setFont(new Font("Tahoma", Font.BOLD, 11));
		scrollPane.setColumnHeaderView(ResultTitle);
		JList<String> list = new JList<String>( listModel );
		scrollPane.setViewportView(list);
		list.setFont( new Font("monospaced", Font.PLAIN, 14) );
		
		Message msg = new Message("ViewUsersWithCondition", "LibrarianController");
		msg.add(3);

		
		try {
			clientInterface.client.openConnection();
			clientInterface.client.sendToServer(msg);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		clientInterface.waitForServer();  // Waiting for approval from the server
		

		customerAccount = (Customer[])clientInterface.getMsgFromServer();

			
		if(customerAccount.length==0) listModel.addElement("There is no customers that waiting for a update account!" );
		else
		{
			for(int i=0;i<customerAccount.length;i++)  
			{
			listModel.addElement(String.format("%-17s%-17s%s",customerAccount[i].get_firstName(),customerAccount[i].get_lastName(),customerAccount[i].get_uid()));
			}
		}
		
		JLabel lblTheReviewsThat = new JLabel("Customers waiting for updating account:");
		lblTheReviewsThat.setBounds(41, 95, 274, 28);
		lblTheReviewsThat.setFont(new Font("Tahoma", Font.ITALIC, 15));
		add(lblTheReviewsThat);
		
		JButton btnChangeAccount = new JButton("Edit Account");
		btnChangeAccount.setBounds(141, 135, 155, 55);
		add(btnChangeAccount);
		
		
		list.addMouseListener(new MouseAdapter() {
			
		
			public void mouseClicked(MouseEvent e) {
				int index = list.getSelectedIndex();
				
				btnChangeAccount.addActionListener(new ActionListener() {

					public void actionPerformed(ActionEvent arg0) {
						
						try {
							Message msg = new Message("EditCostumerAccount", "LibrarianController");
							msg.add(customerAccount[index].get_uid());
							clientInterface.client.openConnection();
							clientInterface.client.sendToServer(msg);
						} catch (IOException e) {
							e.printStackTrace();
						}
						
						//clientInterface.waitForServer();
						JOptionPane.showMessageDialog(null, "The User Account Type Changed");
						listModel.clear();
						
						Message msg = new Message("ViewUsersWithCondition", "LibrarianController");
						msg.add(3);

						
						try {
							clientInterface.client.openConnection();
							clientInterface.client.sendToServer(msg);
						} catch (IOException e) {
							e.printStackTrace();
						}
						
						clientInterface.waitForServer();  // Waiting for approval from the server
						

						customerAccount = (Customer[])clientInterface.getMsgFromServer();

							
						if(customerAccount.length==0) listModel.addElement("There is no customers that waiting for a update account!" );
						else
						{
							for(int i=0;i<customerAccount.length;i++)  
							{
							listModel.addElement(String.format("%-17s%-17s%s",customerAccount[i].get_firstName(),customerAccount[i].get_lastName(),customerAccount[i].get_uid()));
							}
						}
						
						
						
					}
					
				});
				
				
			} 				
		});
		
		
		

	}

}
