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

public class MainGUI extends JPanel {
	
	private ClientInterface clientInterface;

	/**
	 * Create the panel.
	 */
	public MainGUI(ClientInterface clientInterface) {
		this.clientInterface = clientInterface;
		
		setLayout(new BorderLayout(0, 0));
		
		JPanel menu = new JPanel();
		menu.setForeground(Color.BLACK);
		menu.setBackground(new Color(153, 204, 255));
		add(menu, BorderLayout.EAST);
		GridBagLayout gbl_menu = new GridBagLayout();
		gbl_menu.columnWidths = new int[] {110};
		gbl_menu.rowHeights = new int[] {40, 40, 40, 40, 40, 40, 40, 40, 0, 0, 0, 0};
		gbl_menu.columnWeights = new double[]{0.0};
		gbl_menu.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		menu.setLayout(gbl_menu);
		
		JButton btnNewButton_4 = new JButton("New button");
		GridBagConstraints gbc_btnNewButton_4 = new GridBagConstraints();
		gbc_btnNewButton_4.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_4.gridx = 0;
		gbc_btnNewButton_4.gridy = 0;
		menu.add(btnNewButton_4, gbc_btnNewButton_4);
		
		JButton btnNewButton = new JButton("New button");
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton.gridx = 0;
		gbc_btnNewButton.gridy = 1;
		menu.add(btnNewButton, gbc_btnNewButton);
		
		JButton btnNewButton_1 = new JButton("New button");
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_1.gridx = 0;
		gbc_btnNewButton_1.gridy = 2;
		menu.add(btnNewButton_1, gbc_btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("New button");
		GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
		gbc_btnNewButton_2.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_2.gridx = 0;
		gbc_btnNewButton_2.gridy = 3;
		menu.add(btnNewButton_2, gbc_btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("New button");
		GridBagConstraints gbc_btnNewButton_3 = new GridBagConstraints();
		gbc_btnNewButton_3.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_3.gridx = 0;
		gbc_btnNewButton_3.gridy = 4;
		menu.add(btnNewButton_3, gbc_btnNewButton_3);
		
		JButton btnLogout = new JButton("LOG-OUT");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
					try {
						clientInterface.client.openConnection();
						Message msg = new Message("LogOut");
						msg.add(clientInterface.user.get_userName());
						clientInterface.client.sendToServer(msg);
					} catch (IOException e1) {
						e1.printStackTrace();}
					
					clientInterface.user = null;
					
					clientInterface.frame.remove(clientInterface.mainPanel);
					clientInterface.frame.getContentPane().add(clientInterface.loginPanel);
					clientInterface.frame.revalidate(); // For Java 1.7 or above.
        			// frame.getContentPane().validate(); // For Java 1.6 or below.
					clientInterface.frame.repaint();

			}
		});
		GridBagConstraints gbc_btnLogout = new GridBagConstraints();
		gbc_btnLogout.insets = new Insets(0, 0, 5, 0);
		gbc_btnLogout.gridx = 0;
		gbc_btnLogout.gridy = 10;
		menu.add(btnLogout, gbc_btnLogout);
		
		JButton btnExit = new JButton("EXIT");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				try {
					clientInterface.client.openConnection();
					Message msg = new Message("LogOut");
					msg.add(clientInterface.user.get_userName());
					clientInterface.client.sendToServer(msg);
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				System.exit(0);
			}
		});
		GridBagConstraints gbc_btnExit = new GridBagConstraints();
		gbc_btnExit.gridx = 0;
		gbc_btnExit.gridy = 11;
		menu.add(btnExit, gbc_btnExit);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

	}
}
