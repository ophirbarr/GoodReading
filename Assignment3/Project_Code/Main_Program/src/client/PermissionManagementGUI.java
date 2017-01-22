package client;

import javax.swing.JPanel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

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
		private JTextField password;
		private JTextField userStatus;
		private JTextField accountType;
		private JTextField endDate;
		private JTextField accountStatus;
		private JTextField wfcat;
		private JTextField role;
		private JTextField email;
		private JTextField department;
		private JTextField discriminator;
		private JLabel lblFollowingAreUser;
		private JLabel lblUid_1;
		private JLabel lblSsn;
		private JLabel lblFirstName;
		private JLabel lblLastName;
		private JLabel lblUserName;
		private JLabel lblPassword;
		private JLabel lblUserStatus;
		private JLabel lblRole;
		private JLabel lblEmail;
		private JLabel lblAccountType;
		private JLabel lblEndDateAccunt;
		private JLabel lblAccountStatus;
		private JLabel lblWaitingForChange;
		private JLabel lblDepartment;
		private JLabel lblDisctiminator;
		
		
		public PermissionManagementGUI(ClientInterface clientInterface){
			super();
			this.clientInterface = clientInterface;
			setLayout(null);
			model = new DefaultListModel();
			
			GetAllUsers();
			systemUsers = (SystemUser[]) clientInterface.getMsgFromServer();
			for(int i=0;i<systemUsers.length;i++)  //additional the users to Jlist
				model.addElement(String.format("%-15s%-14s%-14s", systemUsers[i].get_ssn(),systemUsers[i].get_firstName(),systemUsers[i].get_lastName()));
			
			
			scrollPane = new JScrollPane();
			scrollPane.setBounds(185, 16, 337, 211);
			add(scrollPane);
			
			
			
			
			JLabel lblUid = new JLabel("ID:                             First Name:                       Last Name:         ");
			scrollPane.setColumnHeaderView(lblUid);
			
			lblSelectAUser = new JLabel("Select a user to edit:");
			lblSelectAUser.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblSelectAUser.setBounds(10, 11, 337, 23);
			add(lblSelectAUser);
			
			
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
			lblUserName.setBounds(11, 440, 89, 23);
			add(lblUserName);
			lblUserName.setVisible(false);
			
			lblPassword = new JLabel("Password:");
			lblPassword.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblPassword.setBounds(211, 444, 97, 14);
			add(lblPassword);
			lblPassword.setVisible(false);
			
			lblUserStatus = new JLabel("User Status:");
			lblUserStatus.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblUserStatus.setBounds(211, 285, 107, 14);
			add(lblUserStatus);
			lblUserStatus.setVisible(false);
			
			lblRole = new JLabel("Role:");
			lblRole.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblRole.setBounds(472, 395, 46, 14);
			add(lblRole);
			lblRole.setVisible(false);
			
			lblEmail = new JLabel("Email:");
			lblEmail.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblEmail.setBounds(472, 287, 67, 14);
			add(lblEmail);
			lblEmail.setVisible(false);
			
			lblAccountType = new JLabel("Account Type:");
			lblAccountType.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblAccountType.setBounds(212, 313, 128, 25);
			add(lblAccountType);
			lblAccountType.setVisible(false);
			
			lblEndDateAccunt = new JLabel("End Date Accunt:");
			lblEndDateAccunt.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblEndDateAccunt.setBounds(211, 360, 151, 14);
			add(lblEndDateAccunt);
			lblEndDateAccunt.setVisible(false);
			
			lblAccountStatus = new JLabel("Account Status:");
			lblAccountStatus.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblAccountStatus.setBounds(211, 409, 128, 14);
			add(lblAccountStatus);
			lblAccountStatus.setVisible(false);
			
			lblWaitingForChange = new JLabel("Waiting For Change Account Type:");
			lblWaitingForChange.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblWaitingForChange.setBounds(420, 437, 268, 25);
			add(lblWaitingForChange);
			lblWaitingForChange.setVisible(false);
			
			lblDepartment = new JLabel("Department:");
			lblDepartment.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblDepartment.setBounds(472, 320, 120, 23);
			add(lblDepartment);
			lblDepartment.setVisible(false);
			
			lblDisctiminator = new JLabel("Discriminator:");
			lblDisctiminator.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblDisctiminator.setBounds(472, 359, 120, 14);
			add(lblDisctiminator);
			lblDisctiminator.setVisible(false);
			
			uid = new JTextField();
			uid.setEditable(false);
			uid.setBounds(58, 285, 97, 23);
			add(uid);
			uid.setColumns(10);
			uid.setVisible(false);
			
			ssn = new JTextField();
			ssn.setEditable(false);
			ssn.setBounds(58, 317, 89, 23);
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
			lastName.setBounds(109, 400, 92, 29);
			add(lastName);
			lastName.setColumns(10);
			lastName.setVisible(false);
			
			userName = new JTextField();
			userName.setBounds(107, 443, 95, 20);
			add(userName);
			userName.setColumns(10);
			userName.setVisible(false);
			
			password = new JTextField();
			password.setBounds(303, 443, 107, 20);
			add(password);
			password.setColumns(10);
			password.setVisible(false);
			
			userStatus = new JTextField();
			userStatus.setBounds(313, 285, 107, 23);
			add(userStatus);
			userStatus.setColumns(10);
			userStatus.setVisible(false);
			
			accountType = new JTextField();
			accountType.setBounds(323, 316, 115, 23);
			add(accountType);
			accountType.setColumns(10);
			accountType.setVisible(false);
			
			endDate = new JTextField();
			endDate.setBounds(349, 356, 92, 26);
			add(endDate);
			endDate.setColumns(10);
			endDate.setVisible(false);
			
			accountStatus = new JTextField();
			accountStatus.setBounds(343, 406, 97, 23);
			add(accountStatus);
			accountStatus.setColumns(10);
			accountStatus.setVisible(false);
			
			wfcat = new JTextField();
			wfcat.setBounds(676, 442, 46, 23);
			add(wfcat);
			wfcat.setColumns(10);
			wfcat.setVisible(false);
			
			role = new JTextField();
			role.setBounds(528, 393, 128, 23);
			add(role);
			role.setColumns(10);
			role.setVisible(false);
			
			email = new JTextField();
			email.setBounds(534, 285, 128, 23);
			add(email);
			email.setColumns(10);
			email.setVisible(false);
			
			department = new JTextField();
			department.setBounds(577, 318, 107, 26);
			add(department);
			department.setColumns(10);
			department.setVisible(false);
			
			discriminator = new JTextField();
			discriminator.setBounds(595, 359, 115, 23);
			add(discriminator);
			discriminator.setColumns(10);
			discriminator.setVisible(false);
			
			list = new JList();
			list.addListSelectionListener(new ListSelectionListener() {
				public void valueChanged(ListSelectionEvent e) {
					int index = list.getSelectedIndex();
					lblFollowingAreUser.setVisible(true);
					lblUid_1.setVisible(true);
					lblSsn.setVisible(true);
					lblFirstName.setVisible(true);
					lblLastName.setVisible(true);
					lblUserName.setVisible(true);
					lblPassword.setVisible(true);
					lblUserStatus.setVisible(true);
					lblRole.setVisible(true);
					lblEmail.setVisible(true);
					lblAccountType.setVisible(true);
					lblEndDateAccunt.setVisible(true);
					lblAccountStatus.setVisible(true);
					lblWaitingForChange.setVisible(true);
					lblDepartment.setVisible(true);
					lblDisctiminator.setVisible(true);
					uid.setVisible(true);
					ssn.setVisible(true);
					firstName.setVisible(true);
					lastName.setVisible(true);
					userName.setVisible(true);
					password.setVisible(true);
					userStatus.setVisible(true);
					accountType.setVisible(true);
					endDate.setVisible(true);
					accountStatus.setVisible(true);
					wfcat.setVisible(true);
					role.setVisible(true);
					email.setVisible(true);
					department.setVisible(true);
					discriminator.setVisible(true);
					
					
					String temp =""+systemUsers[index].get_uid();
					uid.setText(temp);
					temp=""+systemUsers[index].get_ssn();
					ssn.setText(temp);
					firstName.setText(systemUsers[index].get_firstName());
					lastName.setText(systemUsers[index].get_lastName());
					userName.setText(systemUsers[index].get_userName());
					temp=""+systemUsers[index].get_password();
					password.setText(temp);
					temp=""+systemUsers[index].get_userStatus();
					userStatus.setText(temp);
				//	accountType.setText(systemUsers[index].get);
					
				}
			});
			list.setFont(new Font("Monospaced", Font.BOLD | Font.ITALIC, 13));
			scrollPane.setViewportView(list);
			list.setModel(model);
			
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
}
