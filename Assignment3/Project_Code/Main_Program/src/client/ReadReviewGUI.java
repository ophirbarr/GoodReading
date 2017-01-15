package client;

import java.awt.Color;

import javax.swing.JPanel;

import good_reading.Book;
import good_reading.BookReview;

import java.awt.Rectangle;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;

import common.Message;
import controllers.CostumerController;

import javax.swing.JLabel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JScrollPane;

public class ReadReviewGUI extends JPanel {

	private ClientInterface clientInterface;
	private JLabel textField;
	
	/**
	 * Create the panel.
	 */
	public ReadReviewGUI(ClientInterface clientInterface, Book book) {
		super();
		setBounds(new Rectangle(10, -11, 727, 588));
		setBackground(Color.WHITE);
		this.clientInterface = clientInterface;
		setLayout(null);
		
		JPanel imagePanel = new JPanel();
		imagePanel.setBounds(0, 0, 727, 588);
		imagePanel.setBackground(new Color(250, 243, 232));
		add(imagePanel);
		imagePanel.setLayout(null);
		
		textField = new JLabel(book.get_title());
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setFont(new Font("Tahoma", Font.BOLD, 19));
		textField.setBounds(423, 39, 226, 51);
		imagePanel.add(textField);
		
		JLabel lblBookpicture = new JLabel("book_picture");
		lblBookpicture.setIcon(new ImageIcon(ReadReviewGUI.class.getResource("/design/harry_potter2.png")));
		lblBookpicture.setBounds(445, 101, 184, 270);
		imagePanel.add(lblBookpicture);
		
		JButton btnSubmitReview = new JButton("Submit A Review");
		btnSubmitReview.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				clientInterface.mainPanel.remove(clientInterface.mainPanel.currentPanel);
				clientInterface.mainPanel.currentPanel = new SubmitReviewGUI(clientInterface, book);
				clientInterface.mainPanel.currentPanel.setBounds(176, 1, 724, 475);
				clientInterface.mainPanel.currentPanel.setBackground(new Color(255, 255, 255));
				clientInterface.mainPanel.add(clientInterface.mainPanel.currentPanel);
				clientInterface.mainPanel.currentPanel.setLayout(null);
				clientInterface.mainPanel.currentPanel.revalidate(); // For Java 1.7 or above.
				// frame.getContentPane().validate(); // For Java 1.6 or below.
				clientInterface.mainPanel.currentPanel.repaint();
			}
		});
		btnSubmitReview.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSubmitReview.setBounds(471, 426, 135, 29);
		imagePanel.add(btnSubmitReview);
		
		JLabel lblBookReview = new JLabel("Read Book Review: ");
		lblBookReview.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblBookReview.setBounds(32, 56, 184, 20);
		imagePanel.add(lblBookReview);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(104, 155, 23, 20);
		imagePanel.add(scrollPane);
		
		//TODO
		////////////////////////////////////////////
		DefaultListModel<String> listModel = new DefaultListModel<String>();
		
		JList<String> list = new JList<String>(listModel);
		scrollPane.setViewportView(list);
		
		Message msg = new Message("SystemUserController","ReadReviews");
		msg.add(book);
		
		try {
			clientInterface.client.openConnection();
			clientInterface.client.sendToServer(msg);
		} catch (IOException e) {
			e.printStackTrace();
		}
		clientInterface.waitForServer();
		
		Object[] result = (Object[])clientInterface.getMsgFromServer();
		listModel.clear();
		
		if (result.length == 0) 
			listModel.addElement("There are no matching results to your query.");
		else
			for (Object review : result)
			{
				listModel.addElement(String.format("%-30s%-15s", (((BookReview)review)).get_review(), ((BookReview)review).get_costumerName()));
			}
		////////////////////////////////////////////////////
	}
}
