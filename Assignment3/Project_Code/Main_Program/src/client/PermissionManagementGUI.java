package client;

import javax.swing.JPanel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

import common.Define;
import common.Message;
import good_reading.SystemUser;

import javax.swing.JList;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;

public class PermissionManagementGUI extends JPanel{
	
	//Class variables
		private ClientInterface clientInterface;
		private DefaultListModel model;
		private JList list;
		private JScrollPane scrollPane;
		private JLabel lblSelectAUser;
		private SystemUser[] systemUsers;
		private JTextField uid;
		private JTextField ssn;
		private JTextField firstName;
		private JTextField lastName;
		private JTextField userName;
		private JTextField userStatus;
		private JLabel lblFollowingAreUser;
		private JLabel lblUid_1;
		private JLabel lblSsn;
		private JLabel lblFirstName;
		private JLabel lblLastName;
		private JLabel lblUserName;
		private JLabel lblUserStatus;
		private JLabel lblWhichStatusYou;
		private JComboBox comboBox;
		private int selectedIndex;
		
		
		public PermissionManagementGUI(ClientInterface clientInterface){
			super();
			this.clientInterface = clientInterface;
			setLayout(null);
			model = new DefaultListModel();
			
			
			
			
			scrollPane = new JScrollPane();
			scrollPane.setBounds(202, 73, 337, 154);
			add(scrollPane);
			
			
			
			
			JLabel lblUid = new JLabel("ID:                                   First Name:               Last Name:         ");
			scrollPane.setColumnHeaderView(lblUid);
			
			lblSelectAUser = new JLabel("Select a user to edit:");
			lblSelectAUser.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblSelectAUser.setBounds(10, 68, 171, 23);
			add(lblSelectAUser);
			lblSelectAUser.setVisible(false);
			
			
			lblFollowingAreUser = new JLabel("Following are User Details:");
			lblFollowingAreUser.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblFollowingAreUser.setBounds(10, 238, 342, 36);
			add(lblFollowingAreUser);
			lblFollowingAreUser.setVisible(false);
			
			lblUid_1 = new JLabel("Uid:");
			lblUid_1.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblUid_1.setBounds(10, 283, 75, 23);
			add(lblUid_1);
			lblUid_1.setVisible(false);
			
			lblSsn = new JLabel("SSN:");
			lblSsn.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblSsn.setBounds(10, 318, 46, 14);
			add(lblSsn);
			lblSsn.setVisible(false);
			
			lblFirstName = new JLabel("First Name:");
			lblFirstName.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblFirstName.setBounds(10, 343, 89, 39);
			add(lblFirstName);
			lblFirstName.setVisible(false);
			
			lblLastName = new JLabel("Last Name:");
			lblLastName.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblLastName.setBounds(10, 393, 89, 36);
			add(lblLastName);
			lblLastName.setVisible(false);
			
			lblUserName = new JLabel("User Name:");
			lblUserName.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblUserName.setBounds(236, 285, 89, 23);
			add(lblUserName);
			lblUserName.setVisible(false);
			
			lblUserStatus = new JLabel("User Status:");
			lblUserStatus.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblUserStatus.setBounds(235, 320, 107, 14);
			add(lblUserStatus);
			lblUserStatus.setVisible(false);
			
			uid = new JTextField();
			uid.setEditable(false);
			uid.setBounds(112, 283, 89, 23);
			add(uid);
			uid.setColumns(10);
			uid.setVisible(false);
			
			ssn = new JTextField();
			ssn.setEditable(false);
			ssn.setBounds(112, 315, 89, 23);
			add(ssn);
			ssn.setColumns(10);
			ssn.setVisible(false);
			
			firstName = new JTextField();
			firstName.setEditable(false);
			firstName.setBounds(112, 349, 89, 31);
			add(firstName);
			firstName.setColumns(10);
			firstName.setVisible(false);
			
			lastName = new JTextField();
			lastName.setEditable(false);
			lastName.setBounds(112, 399, 92, 29);
			add(lastName);
			lastName.setColumns(10);
			lastName.setVisible(false);
			
			userName = new JTextField();
			userName.setEditable(false);
			userName.setBounds(335, 286, 107, 20);
			add(userName);
			userName.setColumns(10);
			userName.setVisible(false);
			
			userStatus = new JTextField();
			userStatus.setEditable(false);
			userStatus.setBounds(335, 316, 107, 23);
			add(userStatus);
			userStatus.setColumns(10);
			userStatus.setVisible(false);
			
			list = new JList();
			list.addListSelectionListener(new ListSelectionListener() {
				public void valueChanged(ListSelectionEvent e) {
					selectedIndex = list.getSelectedIndex();
					comboBox.setVisible(true);
					lblWhichStatusYou.setVisible(true);
					lblFollowingAreUser.setVisible(true);
					lblUid_1.setVisible(true);
					lblSsn.setVisible(true);
					lblFirstName.setVisible(true);
					lblLastName.setVisible(true);
					lblUserName.setVisible(true);
					lblUserStatus.setVisible(true);
					uid.setVisible(true);
					ssn.setVisible(true);
					firstName.setVisible(true);
					lastName.setVisible(true);
					userName.setVisible(true);	
					userStatus.setVisible(true);
					String temp =""+systemUsers[selectedIndex].get_uid();
					uid.setText(temp);
					temp=""+systemUsers[selectedIndex].get_ssn();
					ssn.setText(temp);
					firstName.setText(systemUsers[selectedIndex].get_firstName());
					lastName.setText(systemUsers[selectedIndex].get_lastName());
					userName.setText(systemUsers[selectedIndex].get_userName());
					
					if(systemUsers[selectedIndex].get_userStatus() == 0) temp = "DISCONNECTED";
					if(systemUsers[selectedIndex].get_userStatus() == 1) temp = "CONNECTED";
					if(systemUsers[selectedIndex].get_userStatus() == 3) temp = "BLOCKED";
					userStatus.setText(temp);
					
					if(systemUsers[selectedIndex].get_userStatus()==0||systemUsers[selectedIndex].get_userStatus()==1)
						comboBox.removeItemAt(1);
					else if(systemUsers[selectedIndex].get_userStatus()==3)
							comboBox.removeItemAt(0);
				
				}
			});
			list.setFont(new Font("Monospaced", Font.BOLD | Font.ITALIC, 13));
			scrollPane.setViewportView(list);
			scrollPane.setVisible(false);
			
			
			JLabel lblWhatWouldYou = new JLabel("What would you like to edit?");
			lblWhatWouldYou.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblWhatWouldYou.setBounds(10, 23, 195, 31);
			add(lblWhatWouldYou);
			
			JButton btnAccount = new JButton("Account");
			btnAccount.setBounds(323, 29, 89, 23);
			add(btnAccount);
			
			JButton btnUsers = new JButton("Users");
			btnUsers.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				
					lblSelectAUser.setVisible(true);
					scrollPane.setVisible(true);
					GetAllUsers();
					systemUsers = (SystemUser[]) clientInterface.getMsgFromServer();
					for(int i=0;i<systemUsers.length;i++)  //additional the users to Jlist
						model.addElement(String.format("%-15s%-14s%-14s", systemUsers[i].get_ssn(),systemUsers[i].get_firstName(),systemUsers[i].get_lastName()));
					list.setModel(model);
					
				}
			});
			btnUsers.setBounds(211, 29, 89, 23);
			add(btnUsers);
			
			lblWhichStatusYou = new JLabel("Which status you want to modify?");
			lblWhichStatusYou.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblWhichStatusYou.setBounds(236, 370, 247, 31);
			add(lblWhichStatusYou);
			
			String[] forCombo = {"Disconnected","Blocked"}; 
			comboBox = new JComboBox(forCombo);
			comboBox.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					int index = comboBox.getSelectedIndex();
					UpDate(index,systemUsers[selectedIndex].get_uid());
					
				}
			});
			comboBox.setBounds(493, 377, 125, 24);
			add(comboBox);
			comboBox.setVisible(false);
			
			
			
			
			lblWhichStatusYou.setVisible(false);
			
			
			
		}
		
		
		public void GetAllUsers(){
			Message msg = new Message("GetAllUsers", "ManagerController");
			clientInterface.msgFromServer = null;
			try {
				clientInterface.client.openConnection();
				clientInterface.client.sendToServer(msg);
			} catch (IOException e) {
				e.printStackTrace();
			}
			clientInterface.waitForServer();  // Waiting for approval from the server
		}
		
		public void UpDate(int index,int uid){
			Message msg = new Message("UpDateStatusUser", "ManagerController");
			clientInterface.msgFromServer = null;
			msg.add(index);
			msg.add(uid);
			try {
				clientInterface.client.openConnection();
				clientInterface.client.sendToServer(msg);
			} catch (IOException e) {
				e.printStackTrace();
			}
		
		}
}
