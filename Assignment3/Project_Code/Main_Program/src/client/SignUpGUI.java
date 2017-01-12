package client;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;

import common.Message;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class SignUpGUI extends JPanel 
{
	private ClientInterface clientInterface;
	private JTextField fieldUsername;
	private JTextField fieldFirstName;
	private JTextField fieldLastName;
	private JTextField fieldSSN;
	private JPasswordField fieldPassword2;
	private JPasswordField fieldPassword1;
	
	public SignUpGUI(ClientInterface clientInterface)
	{
		super();
		this.clientInterface = clientInterface;
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBackground(new Color(255, 250, 250));
		panel.setBounds(137, 78, 598, 394);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblThankYouFor = new JLabel("Thank you for choosing to sign up!");
		lblThankYouFor.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblThankYouFor.setBounds(158, 11, 275, 26);
		panel.add(lblThankYouFor);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				clientInterface.frame.remove(clientInterface.signUpPanel);
				clientInterface.frame.getContentPane().add(clientInterface.loginPanel);
				clientInterface.frame.revalidate();
				clientInterface.frame.repaint();
			}
		});
		btnBack.setBounds(10, 360, 89, 23);
		panel.add(btnBack);
		
		JButton btnSignUp = new JButton("SIGN UP");
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				Message msg = new Message("SignUp", "SystemUserController");
				String pass1 = new String(fieldPassword1.getPassword());
				String pass2 = new String(fieldPassword2.getPassword());
				if (fieldUsername.getText().equals("") || pass1.equals("") || !pass1.equals(pass2) || fieldFirstName.getText().equals("") || fieldLastName.getText().equals("") || fieldSSN.getText().equals("") || !fieldSSN.getText().matches("[0-9]+"))
				{
					JOptionPane.showMessageDialog(clientInterface.frame, "One or more fields are invalid.");  
					return;
				}
			
				msg.add(fieldUsername.getText());				// 0 username
				msg.add(pass1);									// 1 password
				msg.add(fieldFirstName.getText());				// 2 first name
				msg.add(fieldLastName.getText());				// 3 last name
				msg.add(Integer.parseInt(fieldSSN.getText()));	// 4 SSN
				
				try {
					clientInterface.client.openConnection();
					clientInterface.client.sendToServer(msg);
					clientInterface.waitForServer();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
				if ((boolean)clientInterface.getMsgFromServer())
				{
					JOptionPane.showMessageDialog(clientInterface.frame, "Success!");  
					clientInterface.frame.remove(clientInterface.signUpPanel);
					clientInterface.frame.getContentPane().add(clientInterface.loginPanel);
					clientInterface.frame.revalidate();
					clientInterface.frame.repaint();
				}
				else 
					JOptionPane.showMessageDialog(clientInterface.frame, "User-Name or SSN are already registered in our system.");  
			}
		});
		btnSignUp.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSignUp.setBounds(499, 360, 89, 23);
		panel.add(btnSignUp);
		
		JLabel lblUsername = new JLabel("User-Name:");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUsername.setBounds(101, 103, 129, 14);
		panel.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPassword.setBounds(101, 128, 129, 14);
		panel.add(lblPassword);
		
		JLabel lblReenterPassword = new JLabel("Re-enter password:");
		lblReenterPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblReenterPassword.setBounds(101, 153, 146, 14);
		panel.add(lblReenterPassword);
		
		JLabel lblFirstName = new JLabel("First Name:");
		lblFirstName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFirstName.setBounds(101, 178, 110, 14);
		panel.add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last Name:");
		lblLastName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblLastName.setBounds(101, 203, 110, 14);
		panel.add(lblLastName);
		
		JLabel lblSocialsecuritynumber = new JLabel("Social-Security-Number:");
		lblSocialsecuritynumber.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSocialsecuritynumber.setBounds(101, 228, 176, 14);
		panel.add(lblSocialsecuritynumber);
		
		fieldUsername = new JTextField();
		fieldUsername.setBounds(275, 103, 158, 20);
		panel.add(fieldUsername);
		fieldUsername.setColumns(10);
		
		fieldFirstName = new JTextField();
		fieldFirstName.setBounds(275, 178, 158, 20);
		panel.add(fieldFirstName);
		fieldFirstName.setColumns(10);
		
		fieldLastName = new JTextField();
		fieldLastName.setBounds(275, 203, 158, 20);
		panel.add(fieldLastName);
		fieldLastName.setColumns(10);
		
		fieldSSN = new JTextField();
		fieldSSN.setBounds(275, 228, 158, 20);
		panel.add(fieldSSN);
		fieldSSN.setColumns(10);
		
		fieldPassword2 = new JPasswordField();
		fieldPassword2.setBounds(275, 153, 158, 19);
		panel.add(fieldPassword2);
		
		fieldPassword1 = new JPasswordField();
		fieldPassword1.setBounds(275, 128, 158, 19);
		panel.add(fieldPassword1);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(SignUpGUI.class.getResource("/design/bitmap.png")));
		label.setBounds(0, 0, 894, 588);
		add(label);
		
	}
}
