package client;

import java.awt.Color;

import javax.swing.JPanel;

import good_reading.Book;
import java.awt.Rectangle;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
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
		setBounds(new Rectangle(0, 0, 727, 588));
		setBackground(Color.WHITE);
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
		textField.setBounds(66, 89, 226, 51);
		imagePanel.add(textField);
		
		JLabel lblBookpicture = new JLabel("book_picture");
		lblBookpicture.setIcon(new ImageIcon(ViewBookGUI.class.getResource("/design/harry_potter2.png")));
		lblBookpicture.setBounds(469, 149, 184, 270);
		imagePanel.add(lblBookpicture);
		
		JLabel lblIdLabel = new JLabel("ID: "+book.get_bid());
		lblIdLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblIdLabel.setBounds(66, 151, 58, 20);
		imagePanel.add(lblIdLabel);
		
		JLabel lblLanguage = new JLabel("Language: "+book.get_language());
		lblLanguage.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblLanguage.setBounds(66, 182, 184, 20);
		imagePanel.add(lblLanguage);
		
		JLabel lblPrice = new JLabel("Price: "+book.get_price()+" $");
		lblPrice.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrice.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPrice.setBounds(66, 402, 135, 38);
		imagePanel.add(lblPrice);
		
		JButton btnBuyNow = new JButton("Buy Now");
		btnBuyNow.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnBuyNow.setBounds(78, 451, 112, 29);
		imagePanel.add(btnBuyNow);
		
		JLabel lblSummary = new JLabel("Summary: ");
		lblSummary.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSummary.setBounds(66, 213, 184, 20);
		imagePanel.add(lblSummary);
		
		JTextArea textArea = new JTextArea(book.get_summary());
		textArea.setFont(new Font("Courier New", Font.PLAIN, 14));
		textArea.setEditable(false);
		textArea.setBounds(66, 244, 346, 38);
		imagePanel.add(textArea);
		
		JLabel lblTableOfContents = new JLabel("Table Of Contents: ");
		lblTableOfContents.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTableOfContents.setBounds(66, 293, 184, 20);
		imagePanel.add(lblTableOfContents);
		
		JTextArea textArea_1 = new JTextArea(book.get_TableOfContents());
		textArea_1.setFont(new Font("Courier New", Font.PLAIN, 14));
		textArea_1.setEditable(false);
		textArea_1.setBounds(66, 324, 346, 38);
		imagePanel.add(textArea_1);
		
		JButton btnReadReviews = new JButton("Read Reviews");
		btnReadReviews.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnReadReviews.setBounds(421, 474, 135, 29);
		imagePanel.add(btnReadReviews);
		
		JButton btnSubmitReview = new JButton("Submit Review");
		btnSubmitReview.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSubmitReview.setBounds(569, 474, 135, 29);
		imagePanel.add(btnSubmitReview);
	}
}
