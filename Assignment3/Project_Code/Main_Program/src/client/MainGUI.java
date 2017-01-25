package client;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import common.Define;
import common.Message;
import good_reading.Customer;
import good_reading.Worker;

import java.awt.Font;
import net.miginfocom.swing.MigLayout;

import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
/**
 * @author Yair
 * The main GUI class of the program after signing up. Extends JPanel.
 */
@SuppressWarnings("serial")
public class MainGUI extends JPanel {
	
	@SuppressWarnings("unused")
	private ClientInterface clientInterface;
	public JPanel currentPanel;

	/**
	 * Constructor that creates the panel.
	 * @param clientInterface The main class of the program.
	 */
	public MainGUI(ClientInterface clientInterface) 
	{
		super();
		this.clientInterface = clientInterface;

		setLayout(null);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(MainGUI.class.getResource("/design/g20543.png")));
		label.setBounds(0, 504, 900, 84);
		add(label);
		
		JPanel menu = new JPanel();
		menu.setBounds(0, 1, 176, 587);
		menu.setForeground(Color.BLACK);
		menu.setBackground(new Color(171, 201, 194));
		add(menu, BorderLayout.WEST);
		menu.setLayout(new MigLayout("", "[150px]", "[30px][23px][23px][23px][23px][][23px][23px][][][][][][][][][]"));
		
		
		JButton btnExit = new JButton("EXIT");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				clientInterface.logOut();
				System.exit(0);
			}
		});
		
		JButton btnLogout = new JButton("LOG-OUT");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				clientInterface.logOut();
					
				new PopUpMessageGUI(clientInterface.frame, "Thank you for using Good Reading!", Define.Like);

				clientInterface.frame.remove(clientInterface.mainPanel);
				clientInterface.frame.getContentPane().add(clientInterface.loginPanel);
				clientInterface.frame.revalidate(); // For Java 1.7 or above.
        		// frame.getContentPane().validate(); // For Java 1.6 or below.
				clientInterface.frame.repaint();

			}
		});
		
		JLabel lblGoodReading_1 = new JLabel("Good Reading");
		menu.add(lblGoodReading_1, "cell 0 0");
		lblGoodReading_1.setFont(new Font("Courier New", Font.BOLD, 16));
		lblGoodReading_1.setIcon(new ImageIcon(MainGUI.class.getResource("/design/g10628.png")));
		
		JButton btnSearchBook = new JButton("Search Book");
		btnSearchBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				remove(currentPanel);
				currentPanel = new SearchBookGUI(clientInterface);
				currentPanel.setBounds(176, 1, 724, 475);
				currentPanel.setBackground(new Color(250, 243, 232));
				add(currentPanel);
				currentPanel.setLayout(null);
				currentPanel.revalidate();
				currentPanel.repaint();
			}
		});
		
		
		JButton btnPermissionManagement = new JButton("Permission Management");
		btnPermissionManagement.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				remove(currentPanel);
				currentPanel = new PermissionManagementGUI(clientInterface);
				currentPanel.setBounds(176, 1, 724, 475);
				currentPanel.setBackground(new Color(250, 243, 232));
				add(currentPanel);
				currentPanel.setLayout(null);
				currentPanel.revalidate();
				currentPanel.repaint();
				
			}
		});

		menu.add(btnSearchBook, "cell 0 2,alignx center,aligny top");
		
		JButton MyBooks = new JButton("My Books");
		MyBooks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(clientInterface.user instanceof Customer)
				{
					remove(currentPanel);
					currentPanel = new MyBooksGUI(clientInterface, (Customer)clientInterface.user);
					currentPanel.setBounds(176, 1, 724, 475);
					currentPanel.setBackground(new Color(250, 243, 232));
					add(currentPanel);
					currentPanel.setLayout(null);
					currentPanel.revalidate();
					currentPanel.repaint();
				}
				else
					new PopUpMessageGUI(clientInterface.frame, "You may open an account to have your own book shelve.", Define.Like);
			}
		});
		menu.add(MyBooks, "flowx,cell 0 3,alignx center,aligny center");
		
		JButton btnManageDatabase = new JButton("Manage Database");
		btnManageDatabase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				remove(currentPanel);
				currentPanel = new ManageDatabaseGUI(clientInterface);
				currentPanel.setBounds(176, 1, 724, 475);
				currentPanel.setBackground(new Color(250, 243, 232));
				add(currentPanel);
				currentPanel.setLayout(null);
				currentPanel.revalidate();
				currentPanel.repaint();
			}
		});
		
		JButton btnMyAccount = new JButton("My Account");
		if((clientInterface.user instanceof Worker))btnMyAccount.setEnabled(false);
		btnMyAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				remove(currentPanel);
				currentPanel = new AccountGUI(clientInterface);
				currentPanel.setBounds(176, 1, 724, 475);
				currentPanel.setBackground(new Color(250, 243, 232));
				add(currentPanel);
				currentPanel.setLayout(null);
				currentPanel.revalidate();
				currentPanel.repaint();
			}
		});
		
		menu.add(btnMyAccount, "cell 0 4,alignx center,aligny center");
		
		
		JLabel StaffOnly = new JLabel("Staff Only:");
		StaffOnly.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JButton btnLibrarianActions = new JButton("Librarian Actions");
		btnLibrarianActions.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				remove(currentPanel);
				currentPanel = new LibrarianGUI(clientInterface);
				currentPanel.setBounds(176, 1, 724, 475);
				currentPanel.setBackground(new Color(250, 243, 232));
				add(currentPanel);
				currentPanel.setLayout(null);
				currentPanel.revalidate();
				currentPanel.repaint();
			}
		});
		
		JButton btnInspectReview = new JButton("Inspect Review");
		btnInspectReview.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				remove(currentPanel);
				currentPanel = new InspectReviewGUI(clientInterface);
				currentPanel.setBounds(176, 1, 724, 475);
				currentPanel.setBackground(new Color(250, 243, 232));
				add(currentPanel);
				currentPanel.setLayout(null);
				currentPanel.revalidate();
				currentPanel.repaint();
			}
		});

		JButton btnRequestReport = new JButton("Request Report");
		btnRequestReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				remove(currentPanel);
				currentPanel = new RequestReportGUI(clientInterface);
				currentPanel.setBounds(176, 1, 724, 475);
				currentPanel.setBackground(new Color(250, 243, 232));
				add(currentPanel);
				currentPanel.setLayout(null);
				currentPanel.revalidate();
				currentPanel.repaint();
			}
		});
		
		if(clientInterface.user instanceof Worker)
		{
			menu.add(StaffOnly, "cell 0 8");
	
			menu.add(btnInspectReview, "cell 0 9,alignx center");
			menu.add(btnManageDatabase, "cell 0 10,alignx center,aligny top");
		
			if(((Worker)clientInterface.user).get_role().equals("Librarian"))
			{
				menu.add(btnLibrarianActions, "cell 0 11,alignx center,aligny center");
			}
			
			if(((Worker)clientInterface.user).get_role().equals("Manager"))
			{
				menu.add(btnRequestReport, "cell 0 12,alignx center,aligny center");
				menu.add(btnPermissionManagement, "cell 0 13,alignx center,aligny center");
			}
		}
		
		menu.add(btnLogout, "cell 0 15,alignx center,aligny top");
		menu.add(btnExit, "cell 0 16,alignx center,aligny top");
		
		currentPanel = new JPanel();  // WELCOME SCREEN
		currentPanel.setBounds(176, 1, 724, 504);
		currentPanel.setBackground(new Color(255, 255, 255));
		add(currentPanel);
		currentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(250, 243, 232));
		panel.setBounds(0, 0, 915, 626);
		currentPanel.add(panel);
		panel.setLayout(null);
		
		JLabel lblWelcome = new JLabel("Welcome,");
		lblWelcome.setFont(new Font("Segoe Print", Font.BOLD, 45));
		lblWelcome.setBounds(79, 153, 265, 49);
		panel.add(lblWelcome);
		
		JLabel lblName = new JLabel(clientInterface.user.get_firstName() + " " + clientInterface.user.get_lastName());
		lblName.setForeground(new Color(0, 153, 0));
		lblName.setFont(new Font("Times New Roman", Font.BOLD, 26));
		lblName.setBounds(176, 208, 371, 21);
		panel.add(lblName);

	}
}
