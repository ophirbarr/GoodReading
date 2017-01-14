package client;

import javax.swing.JPanel;
import java.awt.Color;

public class ManageDatabaseGUI extends JPanel
{
	private ClientInterface clientInterface;
	
	public ManageDatabaseGUI(ClientInterface clientInterface)
	{
		super();
		this.clientInterface = clientInterface;
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(250, 243, 232));
		panel.setBounds(-19, -19, 926, 674);
		add(panel);
	}
}
