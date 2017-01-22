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
import good_reading.SystemUser;

public class EraseUserGUI extends JPanel {
	
	private ClientInterface clientInterface;
	private SystemUser[] Allusers ;   //a list of all users         
	private DefaultListModel model;	
	private final JScrollPane scrollPane = new JScrollPane();

	
	/**
	 * constructor
	 * @param clientInterface
	 */

	public EraseUserGUI(ClientInterface clientInterface) {
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
			listModel.addElement(String.format("%-9s%-9s%s",Allusers[i].get_firstName(),Allusers[i].get_lastName(),Allusers[i].get_uid()));
			}
		}
		
		JLabel lblTheReviewsThat = new JLabel("All Users Of GoodReading");
		lblTheReviewsThat.setBounds(41, 95, 281, 29);
		lblTheReviewsThat.setFont(new Font("Tahoma", Font.ITALIC, 15));
		add(lblTheReviewsThat);
		
		JButton btnEraseUser = new JButton("EraseUser");
		btnEraseUser.setBounds(156, 137, 116, 45);
		add(btnEraseUser);
		
		
		list.addListSelectionListener(new ListSelectionListener() {
			
		
			public void valueChanged(ListSelectionEvent e) {
				int index = list.getSelectedIndex();
				
				btnEraseUser.addActionListener(new ActionListener() {

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
					}
					
				});
				
				
			} 	
			
		});

	}

}