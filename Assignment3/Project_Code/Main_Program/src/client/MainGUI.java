package client;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;

import common.Message;
import java.awt.Font;
import net.miginfocom.swing.MigLayout;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;


public class MainGUI extends JPanel {
	
	private ClientInterface clientInterface;
	private JPanel currentPanel;

	/**
	 * Create the panel.
	 */
	public MainGUI(ClientInterface clientInterface) 
	{
		super();
		this.clientInterface = clientInterface;
		
		setLayout(null);
		
		File ImageFile = new File("src\\design\\g20543.png");
		BufferedImage myImage = null;
		try {
			myImage = ImageIO.read(ImageFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		ImagePanel barPanel = new ImagePanel(myImage);
		barPanel.setBounds(0, 475, 900, 84);
		add(barPanel);
		
		JPanel menu = new JPanel();
		menu.setBounds(0, 1, 176, 587);
		menu.setForeground(Color.BLACK);
		menu.setBackground(new Color(171, 201, 194));
		add(menu, BorderLayout.WEST);
		menu.setLayout(new MigLayout("", "[150px]", "[30px][23px][23px][23px][23px][23px][23px][][][][][][][]"));
		
		
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
				currentPanel.setBackground(new Color(255, 255, 255));
				add(currentPanel);
				currentPanel.setLayout(null);
				currentPanel.revalidate(); // For Java 1.7 or above.
        		// frame.getContentPane().validate(); // For Java 1.6 or below.
				currentPanel.repaint();
			}
		});
		menu.add(btnSearchBook, "cell 0 2,alignx center,aligny top");
		
		JButton btnNewButton_2 = new JButton("New button");
		menu.add(btnNewButton_2, "cell 0 3,alignx center,aligny top");
		
		JButton btnNewButton_3 = new JButton("New button");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		menu.add(btnNewButton_3, "cell 0 4,alignx center,aligny top");
		
		JButton btnNewButton_1 = new JButton("New button");
		menu.add(btnNewButton_1, "cell 0 5,alignx center,aligny top");
		menu.add(btnLogout, "cell 0 12,alignx center,aligny top");
		menu.add(btnExit, "cell 0 13,alignx center,aligny top");
		
		currentPanel = new JPanel();
		currentPanel.setBounds(176, 1, 832, 475);
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
		lblWelcome.setBounds(133, 188, 265, 49);
		panel.add(lblWelcome);
		
		JLabel lblName = new JLabel(clientInterface.user.get_firstName() + " " + clientInterface.user.get_lastName());
		lblName.setForeground(new Color(0, 153, 0));
		lblName.setFont(new Font("Narkisim", Font.BOLD, 26));
		lblName.setBounds(144, 238, 371, 21);
		panel.add(lblName);

	}
}
