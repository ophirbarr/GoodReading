package book;

import java.awt.Color;
import javax.swing.JPanel;
import good_reading.Book;
import good_reading.BookReview;
import java.awt.Rectangle;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import client.ClientInterface;
import common.Define;
import common.Message;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
/**
 * @author Yair
 * GUI class. Extends JPanel. Displays a window to submit a new book review. 
 */
@SuppressWarnings("serial")
public class SubmitReviewGUI extends JPanel {

	@SuppressWarnings("unused")
	private ClientInterface clientInterface;
	private JLabel textField;
	private JTextPane textArea;
	
	/**
	 * Constructor that creates the panel.
	 * @param clientInterface The main class of the program.
	 * @param book The book to submit a new review for.
	 */
	public SubmitReviewGUI(ClientInterface clientInterface, Book book) {
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
		
		JLabel lblBookpicture = new JLabel("");
		lblBookpicture.setBounds(445, 101, 184, 270);
		imagePanel.add(lblBookpicture);
		lblBookpicture.setIcon(Define.ResizeIcon(book.get_picPath(), lblBookpicture.getWidth(), lblBookpicture.getHeight()));

		
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
		btnReadReviews.setBounds(471, 426, 135, 29);
		imagePanel.add(btnReadReviews);
		
		JButton btnSubmitReview = new JButton("Submit Review");
		btnSubmitReview.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				BookReview review = new BookReview();
				review.set_bid(book.get_bid());
				review.set_review(textArea.getText());
				review.set_costumerName(clientInterface.user.get_userName());
				review.set_approved(false);
	
				Message msg = new Message("SubmitReview", "CustomerController");
				msg.add(review);
				try {
					clientInterface.client.openConnection();
					clientInterface.client.sendToServer(msg);
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				msg = new Message("ServerMessage", "NewReview");
				msg.add(review);
				try {
					clientInterface.client.openConnection();
					clientInterface.client.sendToServer(msg);
				} catch (IOException e) {
					e.printStackTrace();
				}
				Define.PopUp("Your review has been submited. Thank you!", Define.Edit);
			    
				clientInterface.mainPanel.remove(clientInterface.mainPanel.currentPanel);
				clientInterface.mainPanel.currentPanel = new ViewBookGUI(clientInterface, book);
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
		btnSubmitReview.setBounds(145, 426, 135, 29);
		imagePanel.add(btnSubmitReview);
		
		JLabel lblBookReview = new JLabel("Submit Book Review: ");
		lblBookReview.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblBookReview.setBounds(32, 56, 184, 20);
		imagePanel.add(lblBookReview);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(32, 122, 382, 264);
		imagePanel.add(scrollPane);
		
		textArea = new JTextPane();
		textArea.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		scrollPane.setViewportView(textArea);
		
	}
}
