package client;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import common.Message;

import javax.swing.ScrollPaneConstants;
import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import java.awt.Font;
import java.io.IOException;
import java.util.ArrayList;

public class CustomerOrderGUI extends JPanel{
	//Class variables
	private ClientInterface clientInterface;
	private ArrayList<String> Customers_name;
	private ArrayList<String> books_name;
	private ArrayList<Integer> id;
	
	public CustomerOrderGUI(ClientInterface clientInterface){
		super();
		this.clientInterface = clientInterface;
		setLayout(null);
		customer_order();
		Message message = (Message) clientInterface.getMsgFromServer();
		this.Customers_name = (ArrayList<String>) message.getParameters().get(0);
		this.id = (ArrayList<Integer>) message.getParameters().get(1);
		this.books_name = (ArrayList<String>) message.getParameters().get(2);
		
		
		DefaultListModel model = new DefaultListModel();
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 86, 691, 300);
		add(scrollPane);
		
		JList list = new JList();
		list.setFont(new Font("Monospaced", Font.ITALIC, 14));
		scrollPane.setViewportView(list);
		
		JLabel lblCustomerNameId = new JLabel("Customer Name:                                 ID:                                               Books ordered:");
		scrollPane.setColumnHeaderView(lblCustomerNameId);
		String temp="";
		if(Customers_name.size()==0) model.addElement("Empty Database!" ); 
		else for(int i=0;i<Customers_name.size();i++)  //additional the reviews to Jlist
				{temp = ""+id.get(i);
					model.addElement(String.format("%-20s%-20s%-15s",Customers_name.get(i),temp,books_name.get(i) ));
				}
				list.setModel(model);
		
	}
	public void customer_order(){
		Message msg = new Message("CustomerOrders", "ManagerController");
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
