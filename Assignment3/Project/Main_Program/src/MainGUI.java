import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;

import common.Message;
import java.awt.Font;
import net.miginfocom.swing.MigLayout;

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
		
		setLayout(new BorderLayout(0, 0));
		
		JPanel menu = new JPanel();
		menu.setForeground(Color.BLACK);
		menu.setBackground(new Color(153, 204, 255));
		add(menu, BorderLayout.WEST);
		menu.setLayout(new MigLayout("", "[105px]", "[30px][23px][23px][23px][23px][23px][23px][][][][][][][]"));
		
		JLabel lblGoodReading = new JLabel("Good Reading");
		lblGoodReading.setFont(new Font("Narkisim", Font.BOLD, 16));
		menu.add(lblGoodReading, "cell 0 0,alignx left,aligny top");
		
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
		
		JButton btnSearchBook = new JButton("Search Book");
		btnSearchBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				remove(currentPanel);
				currentPanel = new SearchBookGUI(clientInterface);
				add(currentPanel);
				currentPanel.revalidate(); // For Java 1.7 or above.
        		// frame.getContentPane().validate(); // For Java 1.6 or below.
				currentPanel.repaint();
			}
		});
		menu.add(btnSearchBook, "cell 0 1,alignx center,aligny top");
		
		JButton btnNewButton_1 = new JButton("New button");
		menu.add(btnNewButton_1, "cell 0 2,alignx center,aligny top");
		
		JButton btnNewButton_2 = new JButton("New button");
		menu.add(btnNewButton_2, "cell 0 3,alignx center,aligny top");
		
		JButton btnNewButton_3 = new JButton("New button");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		menu.add(btnNewButton_3, "cell 0 4,alignx center,aligny top");
		menu.add(btnLogout, "cell 0 12,alignx center,aligny top");
		menu.add(btnExit, "cell 0 13,alignx center,aligny top");
		
		currentPanel = new SearchBookGUI(clientInterface);
		currentPanel.setBackground(new Color(255, 255, 255));
		add(currentPanel, BorderLayout.CENTER);
		currentPanel.setLayout(null);

	}
}
