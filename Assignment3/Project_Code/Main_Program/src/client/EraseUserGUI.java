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
import good_reading.SystemUser;
/**
 * 
 * @author Inna
 *Class GUI which displays all the users for the librarian
 */
public class EraseUserGUI extends JPanel {
	
	private ClientInterface clientInterface;
	private SystemUser[] Allusers ;   //a list of all users         
	private DefaultListModel model;	
	private final JScrollPane scrollPane = new JScrollPane();

	
	/**
	 * constructor that creates the panel.
	 * @param clientInterface The main class of the program.
	 */

	public EraseUserGUI(ClientInterface clientInterface) {
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
		msg.add(4);
		
		try {
			clientInterface.client.openConnection();
			clientInterface.client.sendToServer(msg);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		clientInterface.waitForServer();  // Waiting for approval from the server

		
		Allusers = (SystemUser[])clientInterface.getMsgFromServer();
		
		if(Allusers.length==0) listModel.addElement("There is no users" );
		else
		{
			for(int i=0;i<Allusers.length;i++)  
			{
			listModel.addElement(String.format("%-17s%-17s%s",Allusers[i].get_firstName(),Allusers[i].get_lastName(),Allusers[i].get_uid()));
			}
		}
		
		JLabel lblallUsers = new JLabel("All Users Of GoodReading");
		lblallUsers.setBounds(41, 95, 281, 29);
		lblallUsers.setFont(new Font("Tahoma", Font.ITALIC, 15));
		add(lblallUsers);
		
		JButton btnEraseUser = new JButton("EraseUser");
		btnEraseUser.setBounds(156, 137, 116, 45);
		add(btnEraseUser);
		
		/**
		 * ListSelectionListener to know which user is selected
		 */
			
		list.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {

				int index = list.getSelectedIndex();
				
				btnEraseUser.addActionListener(new ActionListener() {
					
					/**
					 * btnEraseUser button Listener - erase the user to from the system
					 */

					public void actionPerformed(ActionEvent arg0) {
						
						try {
							Message msg = new Message("EraseUser", "LibrarianController");
							msg.add(Allusers[index].get_uid());
							clientInterface.client.openConnection();
							clientInterface.client.sendToServer(msg);
						} catch (IOException e) {
							e.printStackTrace();
						}
						
						//clientInterface.waitForServer();
						JOptionPane.showMessageDialog(null, "The user is deleted from the system");
						listModel.clear();
						
						Message msg = new Message("ViewUsersWithCondition", "LibrarianController");
						msg.add(4);
						
						try {
							clientInterface.client.openConnection();
							clientInterface.client.sendToServer(msg);
						} catch (IOException e) {
							e.printStackTrace();
						}
						
						clientInterface.waitForServer();  // Waiting for approval from the server

						
						Allusers = (SystemUser[])clientInterface.getMsgFromServer();
						
						if(Allusers.length==0) listModel.addElement("There is no users" );
						else
						{
							for(int i=0;i<Allusers.length;i++)  
							{
							listModel.addElement(String.format("%-17s%-17s%s",Allusers[i].get_firstName(),Allusers[i].get_lastName(),Allusers[i].get_uid()));
							}
						}
						
						
					}
					
				});
				
				
			} 	
			
		});

	}

}
