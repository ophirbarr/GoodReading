package client;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JButton;
import javax.swing.JToolBar;

import good_reading.Worker;

import java.awt.Font;
import javax.swing.ImageIcon;

public class LibrarianGUI extends JPanel
{
	private ClientInterface clientInterface;
	private JPanel menuPanel;
	private JPanel firstPanel;

	
	public LibrarianGUI(ClientInterface clientInterface)
	{
		super();
		this.clientInterface = clientInterface;
		setLayout(null);
		
		menuPanel = new JPanel();
		menuPanel.setBackground(new Color(210, 180, 140));
		menuPanel.setBounds(0, 0, 756, 76);
		add(menuPanel);
		menuPanel.setLayout(null);
		
		JButton btnNewButton = new JButton("Approve new user");
		btnNewButton.setBounds(21, 11, 150, 23);
		menuPanel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Setup new account");
		btnNewButton_1.setBounds(21, 42, 150, 23);
		menuPanel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Edit existing account");
		btnNewButton_2.setBounds(181, 42, 150, 23);
		menuPanel.add(btnNewButton_2);
		
		if (clientInterface.user instanceof Worker)
		{
			JLabel lblLibrarianId = new JLabel("LIBRARIAN ID #" + ((Worker)clientInterface.user).get_wid());
			lblLibrarianId.setBounds(541, 4, 276, 37);
			menuPanel.add(lblLibrarianId);
			lblLibrarianId.setFont(new Font("Tahoma", Font.PLAIN, 11));
		}
		
		JButton btnEraseExistingUser = new JButton("Erase existing user");
		btnEraseExistingUser.setBounds(181, 11, 150, 23);
		menuPanel.add(btnEraseExistingUser);
		
		firstPanel = new JPanel();
		firstPanel.setBackground(new Color(250, 243, 232));
		firstPanel.setBounds(0, 76, 799, 513);
		add(firstPanel);
		firstPanel.setLayout(null);
		
		JLabel lblChooseFromThe = new JLabel("Choose from the actions above.");
		lblChooseFromThe.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblChooseFromThe.setIcon(new ImageIcon(LibrarianGUI.class.getResource("/com/sun/javafx/scene/control/skin/caspian/images/capslock-icon.png")));
		lblChooseFromThe.setBounds(22, 29, 254, 29);
		firstPanel.add(lblChooseFromThe);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(LibrarianGUI.class.getResource("/design/g10629.png")));
		label.setBounds(32, 69, 478, 329);
		firstPanel.add(label);
	}
}
