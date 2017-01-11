package client;

import java.io.IOException;
import java.util.ArrayList;

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
import java.awt.Color;
import java.awt.ScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.AbstractListModel;


public class InspectReviewGUI extends JPanel  {
	
	private ClientInterface clientInterface;
	private BookReview[] br ;
	private int size;
	private DefaultListModel model;
	private String[] name_book;
		
	
	
	public InspectReviewGUI(ClientInterface clientInterface) {
		super();
		this.clientInterface = clientInterface;
		InspectReview();
		
		//br = (BookReview[]) ((Message) clientInterface.getMsgFromServer()).getParameters().get(0);
		
		Message msg = (Message) clientInterface.getMsgFromServer();
		//ArrayList<Object> arr = (ArrayList<Object>) ((Message) msg).getParameters();
		br = (BookReview[])msg.getParameters().get(0);
		name_book = (String[]) msg.getParameters().get(1);
		size = br.length;
		
		model = new DefaultListModel();
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(106, 63, 277, 212);
		add(scrollPane);
		JList list = new JList();
		if(size==0) model.addElement("There is no reviews that waiting for approval!" ); 
		else for(int i=0;i<size;i++)
				model.addElement(br[i].get_review());
		
		list.setModel(model);
		
		list.addListSelectionListener(new ListSelectionListener() { 
			public void valueChanged(ListSelectionEvent e) {
				int index = list.getSelectedIndex();
				clientInterface.mainPanel.remove(clientInterface.mainPanel.currentPanel);
				clientInterface.mainPanel.currentPanel = new BookreviewGUI(clientInterface,br[index],name_book[index]);
				clientInterface.mainPanel.currentPanel.setBounds(176, 1, 724, 475);
				clientInterface.mainPanel.currentPanel.setBackground(new Color(250, 243, 232));
				clientInterface.mainPanel.add(clientInterface.mainPanel.currentPanel);
				clientInterface.mainPanel.currentPanel.setLayout(null);
				clientInterface.mainPanel.currentPanel.revalidate();
				clientInterface.mainPanel.currentPanel.repaint();
				
			}
		});
		
	
		
		scrollPane.setViewportView(list);
		
		JLabel lblTheReviewsThat = new JLabel("The Reviews that waiting for approve:");
		lblTheReviewsThat.setFont(new Font("Tahoma", Font.ITALIC, 15));
		lblTheReviewsThat.setBounds(106, 11, 295, 26);
		add(lblTheReviewsThat);
		
	
	
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
