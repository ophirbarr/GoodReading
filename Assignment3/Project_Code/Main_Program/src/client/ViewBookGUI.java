package client;

import java.awt.Color;

import javax.swing.JPanel;

import good_reading.Book;
import good_reading.Customer;
import good_reading.SystemUser;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;

import common.Define;
import common.Message;
import controllers.CustomerController;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextPane;

public class ViewBookGUI extends JPanel {

	private ClientInterface clientInterface;
	private JLabel textField;
	
	/**
	 * Create the panel.
	 */
	public ViewBookGUI(ClientInterface clientInterface, Book book) {
		super();
		setBounds(new Rectangle(10, -11, 727, 588));
		setBackground(new Color(250, 243, 232));
		this.clientInterface = clientInterface;
		setLayout(null);
		
		JPanel imagePanel = new JPanel();
		imagePanel.setBounds(0, 0, 727, 588);
		imagePanel.setBackground(new Color(250, 243, 232));
		add(imagePanel);
		imagePanel.setLayout(null);
		
		textField = new JLabel(book.get_title());
		textField.setHorizontalAlignment(SwingConstants.LEFT);
		textField.setFont(new Font("Tahoma", Font.BOLD, 19));
		textField.setBounds(42, 41, 226, 51);
		imagePanel.add(textField);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(ViewBookGUI.class.getResource("/design/g7642.png")));
		lblNewLabel.setBounds(411, 276, 269, 123);
		imagePanel.add(lblNewLabel);
		
		JLabel lblBookpicture = new JLabel("book_picture");
		//TODO get book picture from data base
		lblBookpicture.setIcon(new ImageIcon(ViewBookGUI.class.getResource("/design/harry_potter2.png")));
		lblBookpicture.setBounds(448, 103, 184, 270);
		imagePanel.add(lblBookpicture);
		
		JLabel lblIdLabel = new JLabel("ID: "+book.get_bid());
		lblIdLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblIdLabel.setBounds(42, 103, 58, 20);
		imagePanel.add(lblIdLabel);
		
		JLabel lblLanguage = new JLabel("Language: "+book.get_language());
		lblLanguage.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblLanguage.setBounds(42, 134, 184, 20);
		imagePanel.add(lblLanguage);
		
		JLabel lblPrice = new JLabel("Price: "+book.get_price()+" $");
		lblPrice.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrice.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPrice.setBounds(42, 354, 135, 38);
		imagePanel.add(lblPrice);
		
		JButton btnBuyNow = new JButton("Buy Now");
		btnBuyNow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				if(clientInterface.user instanceof Customer)
				{
					if(CustomerController.BuyBook(clientInterface, (Customer)(clientInterface.user), book))
						new PopUpMessageGUI(clientInterface.frame, "Thank you for choosing GoodReading.\nThe book had been added to 'MyBooks'.", Define.Like);
				}
				else
					new PopUpMessageGUI(clientInterface.frame, "Please open an account in order to purchase a book.", Define.Notice);
			}
		});
		btnBuyNow.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnBuyNow.setBounds(54, 403, 112, 29);
		imagePanel.add(btnBuyNow);
		
		JLabel lblSummary = new JLabel("Summary: ");
		lblSummary.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSummary.setBounds(42, 165, 184, 20);
		imagePanel.add(lblSummary);
		
		JTextArea textArea = new JTextArea(book.get_summary());
		textArea.setFont(new Font("Courier New", Font.PLAIN, 14));
		textArea.setEditable(false);
		textArea.setBounds(42, 196, 346, 38);
		imagePanel.add(textArea);
		
		JLabel lblTableOfContents = new JLabel("Table Of Contents: ");
		lblTableOfContents.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTableOfContents.setBounds(42, 245, 184, 20);
		imagePanel.add(lblTableOfContents);
		
		JTextArea textArea_1 = new JTextArea((String)book.get_TableOfContents());
		textArea_1.setFont(new Font("Courier New", Font.PLAIN, 14));
		textArea_1.setEditable(false);
		textArea_1.setBounds(42, 276, 346, 38);
		imagePanel.add(textArea_1);
		
		JButton btnReadReviews = new JButton("Read Reviews");
		btnReadReviews.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clientInterface.mainPanel.remove(clientInterface.mainPanel.currentPanel);
				clientInterface.mainPanel.currentPanel = new ReadReviewGUI(clientInterface, book);
				clientInterface.mainPanel.currentPanel.setBounds(176, 1, 724, 475);
				clientInterface.mainPanel.currentPanel.setBackground(new Color(255, 255, 255));
				clientInterface.mainPanel.add(clientInterface.mainPanel.currentPanel);
				clientInterface.mainPanel.currentPanel.setLayout(null);
				clientInterface.mainPanel.currentPanel.revalidate(); // For Java 1.7 or above.
				// frame.getContentPane().validate(); // For Java 1.6 or below.
				clientInterface.mainPanel.currentPanel.repaint();
			}
		});
		btnReadReviews.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnReadReviews.setBounds(397, 426, 135, 29);
		imagePanel.add(btnReadReviews);
		
		JButton btnSubmitReview = new JButton("Submit Review");
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
		btnSubmitReview.setBounds(545, 426, 135, 29);
		imagePanel.add(btnSubmitReview);
	}
}
