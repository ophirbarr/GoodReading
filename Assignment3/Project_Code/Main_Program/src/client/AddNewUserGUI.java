package client;

import javax.swing.JPanel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JTable;

import common.Message;
import good_reading.SystemUser;

import javax.swing.JScrollPane;

public class AddNewUserGUI extends JPanel {
	private JTable table;
	private ClientInterface clientInterface;
	private SystemUser[] user ;   //a list of all awaiting approval users       
	private int size;   //number of awaiting approval users
	private DefaultListModel model;

	/**
	 * Create the panel.
	 */
	
	public AddNewUserGUI(ClientInterface clientInterface) {
		
		super();
		this.clientInterface = clientInterface;
		Message msg = (Message) clientInterface.getMsgFromServer();
		
		model = new DefaultListModel();
		setLayout(null);
		
		JButton btnAddUser = new JButton("Add");
		btnAddUser.setBounds(196, 88, 83, 44);
		add(btnAddUser);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(80, 167, 314, 205);
		add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		
		

	}
}
