package client;

import java.io.IOException;

import javax.swing.JPanel;
import common.Message;
import good_reading.BookReview;

import javax.swing.JToolBar;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JList;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import java.awt.Button;
import java.awt.ScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.AbstractListModel;


public class InspectReviewGUI extends JPanel  {
	
	private ClientInterface clientInterface;
	private BookReview[] br;
	
	
	public InspectReviewGUI(ClientInterface clientInterface) {
		super();
		this.clientInterface = clientInterface;
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(106, 57, 277, 212);
		add(scrollPane);
		
		JList list = new JList();
		list.addListSelectionListener(new ListSelectionListener() { 
			public void valueChanged(ListSelectionEvent e) {
				int index = list.getSelectedIndex();
				if(index == 1)
					System.out.println("row number 1 selected");
				else if(index==2)System.out.println("row number 2 selected");
				
			}
		});
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {"Review 1", "Review 2 "};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		scrollPane.setViewportView(list);
		
		JLabel lblTheReviewsThat = new JLabel("The Reviews that wait to approve:");
		lblTheReviewsThat.setFont(new Font("Tahoma", Font.ITALIC, 15));
		lblTheReviewsThat.setBounds(102, 11, 295, 26);
		add(lblTheReviewsThat);
		InspectReview();
	
	
}
public void InspectReview(){
		
	Message msg = new Message("getInspectReview", "BookInspectReview");
		clientInterface.msgFromServer = null;
		try {
			clientInterface.client.openConnection();
			clientInterface.client.sendToServer(msg);
		} catch (IOException e) {
			e.printStackTrace();
		}
		clientInterface.waitForServer();
		
}
}
