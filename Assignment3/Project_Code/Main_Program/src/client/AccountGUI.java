package client;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import common.Define;
import common.Message;
import controllers.CustomerController;
import good_reading.Customer;
import good_reading.SystemUser;
import good_reading.Worker;

import javax.swing.border.LineBorder;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

@SuppressWarnings("serial")
public class AccountGUI extends JPanel
{
	@SuppressWarnings("unused")
	private ClientInterface clientInterface;
	
	public AccountGUI(ClientInterface clientInterface)
	{
		super();
		
		CustomerController.ValidateAccount(clientInterface, (Customer)clientInterface.user);
		
		Message msg = new Message("RefreshUser", "SystemUserController");
		msg.add(clientInterface.user.get_uid());
		
		try {
			clientInterface.client.openConnection();
			clientInterface.client.sendToServer(msg);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		clientInterface.waitForServer();
		clientInterface.user = (SystemUser)clientInterface.getMsgFromServer();
		
		setBackground(new Color(250, 240, 230));
		this.clientInterface = clientInterface;
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(20, 58, 390, 85);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblYourAccountType = new JLabel("Your account type is:");
		lblYourAccountType.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblYourAccountType.setBounds(10, 11, 156, 22);
		panel.add(lblYourAccountType);
		
		JLabel lblTimeLeftFor = new JLabel("Time left in account plan:");
		lblTimeLeftFor.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTimeLeftFor.setBounds(10, 47, 161, 22);
		panel.add(lblTimeLeftFor);
		
		JLabel lblAccountType = new JLabel("N/A");
		lblAccountType.setForeground(new Color(255, 0, 0));
		if (clientInterface.user instanceof Customer && ((Customer) clientInterface.user).get_waitingForChangeType() != Define.FROM_USER_TO_CUSTOMER )
		{
			int type = ((Customer)clientInterface.user).get_accountType();
			if (type == Define.ACCOUNT_PER_BOOK) lblAccountType.setText("PER BOOK");
			if (type == Define.ACCOUNT_MONTHLY) lblAccountType.setText("MONTHLY");
			if (type == Define.ACCOUNT_YEARLY) lblAccountType.setText("YEARLY");
			lblAccountType.setForeground(new Color(0, 100, 0));
		}
		lblAccountType.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblAccountType.setBounds(176, 11, 156, 20);
		panel.add(lblAccountType);
		
		JLabel lblTimeLeft = new JLabel("N/A");
		lblTimeLeft.setForeground(new Color(255, 0, 0));
		if (clientInterface.user instanceof Customer && ((Customer) clientInterface.user).get_waitingForChangeType() != Define.FROM_USER_TO_CUSTOMER )
		{
			Date endDate = ((Customer)clientInterface.user).get_endDate();
			Date today = new Date();
			if (endDate != null && (endDate.getTime() - today.getTime() > 0))
			{
				lblTimeLeft.setText("" + (endDate.getTime() - today.getTime())/(1000 * 60 * 60 * 24) + " Days");
				lblTimeLeft.setForeground(new Color(0, 100, 0));
			}
		}
		lblTimeLeft.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTimeLeft.setBounds(176, 47, 156, 20);
		panel.add(lblTimeLeft);
		
		JButton btnOpenAccount = new JButton("Open request for a new account");
		btnOpenAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				Message msg = new Message("OpenAccount", "SystemUserController");
				msg.add(clientInterface.user);
				try {
					clientInterface.client.openConnection();
					clientInterface.client.sendToServer(msg);
				} catch (IOException e) {
					e.printStackTrace();
				}
				clientInterface.waitForServer();
				Object result = clientInterface.getMsgFromServer();
				if (result != null)
				{
					clientInterface.user = (SystemUser) result;
        			JOptionPane.showMessageDialog(clientInterface.frame, "A librarian has been notified and will review your request shortly.");   
        			btnOpenAccount.setEnabled(false);
    				try {
    					clientInterface.client.openConnection();
    					clientInterface.client.sendToServer(new Message("NewAccount", "ServerMessage"));
    				} catch (IOException e) {
    					e.printStackTrace();
    				}
				}
				else JOptionPane.showMessageDialog(clientInterface.frame, "Something went wrong! Please contact tech support.");
			}
		});
		btnOpenAccount.setBounds(20, 154, 230, 41);
		add(btnOpenAccount);
		if (!(clientInterface.user instanceof Customer) && !(clientInterface.user instanceof Worker)) btnOpenAccount.setEnabled(true);
		else btnOpenAccount.setEnabled(false);
		
		String [] comboBoxOp = {"No change","Monthly","Annualy"};
		JComboBox comboBox = new JComboBox(comboBoxOp);
		comboBox.setBounds(420, 103, 107, 25);
		add(comboBox);
		if(!(clientInterface.user instanceof Customer))
			comboBox.setEnabled(false);
		
		JButton btnUpdateAccountType = new JButton("Purchase subsription");
		btnUpdateAccountType.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(((Customer)clientInterface.user).get_accountType() != Define.ACCOUNT_PER_BOOK)
					new PopUpMessageGUI(clientInterface.frame, "You already have an active subscription.", Define.Notice);
				else if(((Customer)clientInterface.user).get_waitingForChangeType() != Define.DO_NOT_CHANGE)
					new PopUpMessageGUI(clientInterface.frame, "Your previous request to update subscription is being handled.", Define.Notice);
				else
					CustomerController.WaitForAccountTypeChange(clientInterface, (Customer)clientInterface.user, comboBox.getSelectedIndex());
			}
		});
		btnUpdateAccountType.setBounds(420, 58, 173, 34);
		if(!(clientInterface.user instanceof Customer))
			btnUpdateAccountType.setEnabled(false);
		add(btnUpdateAccountType);
		
		
		
		
	}
}
