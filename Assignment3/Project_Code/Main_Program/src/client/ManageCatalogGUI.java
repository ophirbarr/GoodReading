package client;

import java.io.IOException;

import javax.swing.DefaultListModel;
import javax.swing.JPanel;

import common.Message;
import good_reading.Book;
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import java.awt.Font;

public class ManageCatalogGUI extends JPanel{
	//Class variables
	private ClientInterface clientInterface;
	private Book[] books;
	
	public ManageCatalogGUI(ClientInterface clientInterface){
		
		super();
		this.clientInterface = clientInterface;
		ManageCatalog();
		Message msg = (Message) clientInterface.getMsgFromServer();   //Query Results
		books = (Book[]) msg.getParameters().get(0);
		DefaultListModel model = new DefaultListModel();
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(49, 93, 364, 196);
		add(scrollPane);
		
		JList list = new JList();
		list.setFont(new Font("Monospaced", Font.BOLD | Font.ITALIC, 14));
		scrollPane.setViewportView(list);
		
		JLabel lblTitle = new JLabel("Title:                                                                       Author:");
		scrollPane.setColumnHeaderView(lblTitle);
		
		JLabel lblNewLabel = new JLabel("Following are the books that appear in the catalog:");
		lblNewLabel.setFont(new Font("David", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel.setBounds(55, 11, 358, 32);
		add(lblNewLabel);
		
		
	}
	
	public void ManageCatalog(){
		
		Message msg = new Message("ManegerController", "ManageCatalog");
		clientInterface.msgFromServer = null;
		try {
			clientInterface.client.openConnection();
			clientInterface.client.sendToServer(msg);
		} catch (IOException e) {
			e.printStackTrace();
		}
		clientInterface.waitForServer();  // Waiting for approval from the server
		
	}
}
