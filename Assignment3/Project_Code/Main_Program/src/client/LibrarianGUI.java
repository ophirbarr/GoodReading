package client;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JButton;
import good_reading.Worker;

import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LibrarianGUI extends JPanel
{
	private ClientInterface clientInterface;
	private JPanel menuPanel;
	private JPanel currentPanel;

	
	public LibrarianGUI(ClientInterface clientInterface)
	{
		super();
		this.clientInterface = clientInterface;
		setLayout(null);
		
		menuPanel = new JPanel();
		menuPanel.setBackground(new Color(32, 178, 170));
		menuPanel.setBounds(0, 0, 756, 99);
		add(menuPanel);
		menuPanel.setLayout(null);
		
		JButton btnApproveUser = new JButton("Approve new user");
		btnApproveUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				remove(currentPanel);
				currentPanel = new AddNewUserGUI(clientInterface);  // TODO replace with your class
				currentPanel.setBounds(176, 1, 724, 475);
				currentPanel.setBackground(new Color(250, 243, 232));
				add(currentPanel);
				currentPanel.setLayout(null);
				revalidate();
				repaint();
			}
		});
		btnApproveUser.setBounds(21, 11, 150, 23);
		menuPanel.add(btnApproveUser);
		
		JButton btnApproveCustomer = new JButton("Approve new customer");
		btnApproveCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				remove(currentPanel);
				currentPanel = new FromUserToCostumerGUI(clientInterface);
				currentPanel.setBounds(176, 1, 724, 475);
				currentPanel.setBackground(new Color(250, 243, 232));
				add(currentPanel);
				currentPanel.setLayout(null);
				revalidate();
				repaint();
			}
		});
		btnApproveCustomer.setBounds(21, 42, 150, 23);
		menuPanel.add(btnApproveCustomer);
		
		JButton btnNewButton_2 = new JButton("Edit existing account");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				remove(currentPanel);
				currentPanel = new EditCostumerAccountGUI(clientInterface);  // TODO replace with your class
				currentPanel.setBounds(176, 1, 724, 475);
				currentPanel.setBackground(new Color(250, 243, 232));
				add(currentPanel);
				currentPanel.setLayout(null);
				revalidate();
				repaint();
			}
		});
		btnNewButton_2.setBounds(239, 42, 156, 23);
		menuPanel.add(btnNewButton_2);
		
		if (clientInterface.user instanceof Worker)
		{
			JLabel lblLibrarianId = new JLabel("LIBRARIAN ID #" + ((Worker)clientInterface.user).get_wid());
			lblLibrarianId.setBounds(541, 4, 276, 37);
			menuPanel.add(lblLibrarianId);
			lblLibrarianId.setFont(new Font("Tahoma", Font.PLAIN, 11));
		}
		
		JButton btnEraseExistingUser = new JButton("Erase existing user");
		btnEraseExistingUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				remove(currentPanel);
				currentPanel = new EraseUserGUI(clientInterface);
				currentPanel.setBounds(176, 1, 724, 475);
				currentPanel.setBackground(new Color(250, 243, 232));
				add(currentPanel);
				currentPanel.setLayout(null);
				revalidate();
				repaint();
			}
		});
		btnEraseExistingUser.setBounds(239, 11, 156, 23);
		menuPanel.add(btnEraseExistingUser);
		
		currentPanel = new JPanel();
		currentPanel.setBackground(new Color(255, 245, 238));
		currentPanel.setBounds(0, 76, 799, 513);
		add(currentPanel);
		currentPanel.setLayout(null);
		
		JLabel lblChooseFromThe = new JLabel("Choose from the actions above.");
		lblChooseFromThe.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblChooseFromThe.setIcon(new ImageIcon(LibrarianGUI.class.getResource("/com/sun/javafx/scene/control/skin/caspian/images/capslock-icon.png")));
		lblChooseFromThe.setBounds(22, 29, 254, 29);
		currentPanel.add(lblChooseFromThe);
		
		JLabel label = new JLabel("");
		label.setBackground(new Color(255, 255, 224));
		label.setIcon(new ImageIcon(LibrarianGUI.class.getResource("/design/bookspile.png")));
		label.setBounds(66, 42, 520, 332);
		currentPanel.add(label);
	}
}
