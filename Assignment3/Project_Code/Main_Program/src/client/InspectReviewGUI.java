package client;

import java.io.IOException;

import javax.swing.JPanel;
import common.Message;
import javax.swing.JToolBar;
import javax.swing.JList;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JComboBox;
import java.awt.Button;
import java.awt.ScrollPane;
public class InspectReviewGUI extends JPanel {
	
	private ClientInterface clientInterface;
	
	public InspectReviewGUI(ClientInterface clientInterface) throws IOException{
		super();
		this.clientInterface = clientInterface;
		setLayout(null);
		
		JLabel lblTitleBookname = new JLabel("Title                             BookName   ");
		lblTitleBookname.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblTitleBookname.setBounds(126, 32, 277, 14);
		add(lblTitleBookname);
		
		JList list = new JList();
		list.setBounds(104, 57, 299, 221);
		add(list);
		
		Button button = new Button("Open");
		button.setFont(new Font("Dialog", Font.ITALIC, 12));
		button.setBounds(212, 259, 69, 19);
		add(button);
		Message msg = new Message("getInspectReview", "BookInspectReview");
		
		try {
			clientInterface.client.openConnection();
			clientInterface.client.sendToServer(msg);
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			clientInterface.client.wait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
