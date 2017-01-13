package client;

import java.awt.Color;

import javax.swing.JPanel;

import good_reading.Book;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
		textField.setHorizontalAlignment(SwingConstants.LEFT);
		textField.setFont(new Font("Tahoma", Font.BOLD, 19));
		textField.setBounds(42, 41, 226, 51);
		imagePanel.add(textField);
		
		JLabel lblBookpicture = new JLabel("book_picture");
		lblBookpicture.setIcon(new ImageIcon(ViewBookGUI.class.getResource("/design/harry_potter2.png")));
		lblBookpicture.setBounds(445, 101, 184, 270);
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
		
		JTextArea textArea_1 = new JTextArea(book.get_TableOfContents());
		textArea_1.setFont(new Font("Courier New", Font.PLAIN, 14));
		textArea_1.setEditable(false);
		textArea_1.setBounds(42, 276, 346, 38);
		imagePanel.add(textArea_1);
		
		JButton btnReadReviews = new JButton("Read Reviews");
		btnReadReviews.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainGUI mainGUI = clientInterface.mainPanel;
				JPanel currentPanel = mainGUI.currentPanel;
				mainGUI.remove(currentPanel);
				currentPanel = new ReadReviewGUI(clientInterface, book);
				currentPanel.setBounds(176, 1, 724, 475);
				currentPanel.setBackground(new Color(255, 255, 255));
				mainGUI.add(currentPanel);
				currentPanel.setLayout(null);
				currentPanel.revalidate(); // For Java 1.7 or above.
				// frame.getContentPane().validate(); // For Java 1.6 or below.
				currentPanel.repaint();
			}
		});
		btnReadReviews.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnReadReviews.setBounds(397, 426, 135, 29);
		imagePanel.add(btnReadReviews);
		
		JButton btnSubmitReview = new JButton("Submit Review");
		btnSubmitReview.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MainGUI mainGUI = clientInterface.mainPanel;
				JPanel currentPanel = mainGUI.currentPanel;
				mainGUI.remove(currentPanel);
				currentPanel = new SubmitReviewGUI(clientInterface, book);
				currentPanel.setBounds(176, 1, 724, 475);
				currentPanel.setBackground(new Color(255, 255, 255));
				mainGUI.add(currentPanel);
				currentPanel.setLayout(null);
				currentPanel.revalidate(); // For Java 1.7 or above.
				// frame.getContentPane().validate(); // For Java 1.6 or below.
				currentPanel.repaint();
			}
		});
		btnSubmitReview.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSubmitReview.setBounds(545, 426, 135, 29);
		imagePanel.add(btnSubmitReview);
	}
}
