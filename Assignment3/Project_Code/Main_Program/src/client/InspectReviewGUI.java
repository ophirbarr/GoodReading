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
	private BookReview[] br ;
	private int size;
	private DefaultListModel model;
	
	
	public InspectReviewGUI(ClientInterface clientInterface) {
		super();
		this.clientInterface = clientInterface;
		InspectReview();
		br = (BookReview[]) clientInterface.msgFromServer;
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
				BookReview Review_selected = br[index];
				
				
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
