package client;

import java.awt.Color;
import java.awt.Font;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.border.EtchedBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import common.Define;
import common.Message;
import good_reading.Book;
import good_reading.Customer;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * GUI class. Extends JPanel. Displays all the customer's purchased books.
 * @author yair
 */
@SuppressWarnings("serial")
public class MyBooksGUI extends JPanel {

	@SuppressWarnings("unused")
	private ClientInterface clientInterface;
	
	/**
	 * Constructor that creates the panel.
	 * @param clientInterface The main class of the program.
	 * @param customer The customer using the program.
	 */
	public MyBooksGUI(ClientInterface clientInterface, Customer customer) {
		super();
		setBackground(Color.WHITE);
		this.clientInterface = clientInterface;
		setLayout(null);
		
		JPanel imagePanel = new JPanel();
		imagePanel.setBounds(0, 0, 727, 579);
		imagePanel.setBackground(new Color(250, 243, 232));
		add(imagePanel);
		imagePanel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(23, 101, 520, 354);
		imagePanel.add(scrollPane);
		
		DefaultListModel<String> listModel = new DefaultListModel<String>();
		
		JList<String> list = new JList<String>(listModel);
		
		scrollPane.setViewportView(list);
		
		JLabel lblResultTitle = new JLabel("ID            Title                                                       Language            Price           Summary");
		lblResultTitle.setFont(new Font("Tahoma", Font.BOLD, 11));
		scrollPane.setColumnHeaderView(lblResultTitle);
		
		Message msg = new Message("MyBooks", "CustomerController");
		msg.add(customer);
		
		try {
			clientInterface.client.openConnection();
			clientInterface.client.sendToServer(msg);
		} catch (IOException e) {
			e.printStackTrace();
		}
		clientInterface.waitForServer();
		
		Book[] myBooks = (Book[])clientInterface.getMsgFromServer();
		listModel.clear();
		
		if (myBooks == null) 
			listModel.addElement("There are no matching results to your query.");
		else
			for(int i=0; i< myBooks.length;i++)
			{
				listModel.addElement(String.format("%-6d%-24s%-11s%-8.2f%s", myBooks[i].get_bid(), myBooks[i].get_title(), myBooks[i].get_language(), myBooks[i].get_price(), myBooks[i].get_summary()));
			}
		
		list.addListSelectionListener(new ListSelectionListener() { 
			/**
			 * Listener selected review - displays the review in detail
			 */
			public void valueChanged(ListSelectionEvent e) {
				list.setSelectionBackground(Color.gray);
			}
		});
		
		JButton btnViewBook = new JButton("View Book");
		btnViewBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = list.getSelectedIndex();
				if(index != -1 && !(list.getSelectedValue().equals("There are no matching results to your query.")))
				{
					clientInterface.mainPanel.remove(clientInterface.mainPanel.currentPanel);
					clientInterface.mainPanel.currentPanel = new ViewBookGUI(clientInterface, myBooks[index]);
					clientInterface.mainPanel.currentPanel.setBounds(176, 1, 724, 475);
					clientInterface.mainPanel.currentPanel.setBackground(new Color(250, 243, 232));
					clientInterface.mainPanel.add(clientInterface.mainPanel.currentPanel);
					clientInterface.mainPanel.currentPanel.setLayout(null);
					clientInterface.mainPanel.currentPanel.revalidate();
					clientInterface.mainPanel.currentPanel.repaint();
				}
			}
		});
		btnViewBook.setBounds(568, 294, 118, 30);
		imagePanel.add(btnViewBook);
		
		JLabel lblMyBooks = new JLabel("My Books");
		lblMyBooks.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblMyBooks.setBounds(245, 42, 90, 30);
		imagePanel.add(lblMyBooks);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(MyBooksGUI.class.getResource("/design/g27726.png")));
		label.setBounds(600, 355, 61, 100);
		imagePanel.add(label);
		
		JPanel typePanel = new JPanel();
		typePanel.setBounds(578, 152, 100, 90);
		imagePanel.add(typePanel);
		typePanel.setLayout(null);
		typePanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		
		JRadioButton rdbtnPDF = new JRadioButton("PDF");
		rdbtnPDF.setSelected(true);
		rdbtnPDF.setBounds(6, 7, 88, 23);
		typePanel.add(rdbtnPDF);
		
		JRadioButton rdbtnDOC = new JRadioButton("DOC");
		rdbtnDOC.setBounds(6, 33, 88, 23);
		typePanel.add(rdbtnDOC);
		
		JRadioButton rdbtnFB2 = new JRadioButton("FB2");
		rdbtnFB2.setBounds(6, 60, 88, 23);
		typePanel.add(rdbtnFB2);
		
		rdbtnPDF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (rdbtnPDF.isSelected())
				{
					rdbtnDOC.setSelected(false);
					rdbtnFB2.setSelected(false);
				}
			}
		});
		
		rdbtnDOC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rdbtnDOC.isSelected())
				{
					rdbtnPDF.setSelected(false);
					rdbtnFB2.setSelected(false);
				}
			}
		});
		
		rdbtnFB2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rdbtnFB2.isSelected())
				{
					rdbtnPDF.setSelected(false);
					rdbtnDOC.setSelected(false);
				}
			}
		});
		
		
		JButton lblDownloadBook = new JButton("Download Book");
		lblDownloadBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String format = null;
				int index = list.getSelectedIndex();
				
				if(index != -1 && !(list.getSelectedValue().equals("There are no matching results to your query.")))
				{
					String path = System.getProperty("user.home") + "\\" + myBooks[index].get_title();
					
					if(rdbtnPDF.isSelected())
					{
						format = "PDF";
						path = path + ".pdf";
					}
					
					else if(rdbtnDOC.isSelected())
					{
						format = "DOC";
						path = path + ".doc";
					}
					
					else if(rdbtnFB2.isSelected())
					{
						format = "FB2";
						path = path + ".fb2";
					}
				
				
					Message msg = new Message("DownloadBook", "CustomerController");
					msg.add(format);
					msg.add(myBooks[index].get_bookFormat());

					try {
						clientInterface.client.openConnection();
						clientInterface.client.sendToServer(msg);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					clientInterface.waitForServer();
					
					byte [] bytearray = (byte[])clientInterface.getMsgFromServer();
					FileOutputStream fos;
					try {
						fos = new FileOutputStream(path);
						BufferedOutputStream bos = new BufferedOutputStream(fos); 
						bos.write(bytearray, 0 , bytearray.length); 
						bos.flush(); 
						bos.close();
					} catch (IOException e1) {
						e1.printStackTrace();
					} 
				}
				else
					new PopUpMessageGUI(clientInterface.frame, "You need to choose a book first.", Define.Error);
			}
		});
		lblDownloadBook.setBounds(568, 253, 118, 30);
		imagePanel.add(lblDownloadBook);
		
	}
}
