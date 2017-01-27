package client;

import java.awt.Color;
import javax.swing.JPanel;
import good_reading.Book;
import good_reading.Book_Author;
import good_reading.Customer;
import good_reading.Subject;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.Font;
import javax.swing.SwingConstants;
import common.Define;
import common.Message;
import controllers.CustomerController;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;
import javax.swing.JTextField;
import javax.swing.JTextPane;
/**
 * @author yair, ophir
 * GUI class. Extends JPanel. Displays a book, all its details and different actions to do with it.
 */
@SuppressWarnings("serial")
public class ViewBookGUI extends JPanel {

	@SuppressWarnings("unused")
	private ClientInterface clientInterface;
	private JLabel lblTitle;
	private Message bookDetails;
	private JTextField textAuthors;
	private JTextField textSubjects;
	private JTextField textLanguage;
	
	/**
	 * Constructor that creates the panel.
	 * @param clientInterface The main class of the program.
	 * @param book The book which details are to be displayed.
	 */
	public ViewBookGUI(ClientInterface clientInterface, Book book) {
		super();
		setBounds(new Rectangle(10, -11, 727, 588));
		setBackground(new Color(250, 243, 232));
		this.clientInterface = clientInterface;
		setLayout(null);
		
		// get book details through Database controller
		try {
			Message msg1 = new Message("GetBookDetails", "DatabaseManagementController");
			msg1.add(book.get_bid());
			clientInterface.client.openConnection();
			clientInterface.client.sendToServer(msg1);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		clientInterface.waitForServer();
		bookDetails = (Message) clientInterface.getMsgFromServer();
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 727, 588);
		add(scrollPane);
		
		JPanel imagePanel = new JPanel();
		scrollPane.setViewportView(imagePanel);
		imagePanel.setBackground(new Color(250, 243, 232));
		imagePanel.setLayout(null);
		
		JPanel panelTitle = new JPanel();
		panelTitle.setBackground(new Color(250, 235, 215));
		panelTitle.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelTitle.setBounds(24, 16, 439, 65);
		imagePanel.add(panelTitle);
		panelTitle.setLayout(null);
		
		lblTitle = new JLabel(book.get_title());
		lblTitle.setBounds(10, 11, 419, 43);
		panelTitle.add(lblTitle);
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Aharoni", Font.BOLD, 24));
		
		JPanel panelPic = new JPanel();
		panelPic.setBackground(new Color(250, 235, 215));
		panelPic.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelPic.setBounds(488, 16, 204, 307);
		imagePanel.add(panelPic);
		panelPic.setLayout(null);
		
		JLabel lblBookpicture = new JLabel("");
		lblBookpicture.setBackground(new Color(255, 245, 238));
		lblBookpicture.setBounds(10, 11, 184, 285);
		panelPic.add(lblBookpicture);
		lblBookpicture.setIcon(Define.ResizeIcon(book.get_picPath(), lblBookpicture.getWidth(), lblBookpicture.getHeight()));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(250, 235, 215));
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel.setBounds(488, 334, 204, 121);
		imagePanel.add(panel);
		panel.setLayout(null);
		
		JButton btnReadReviews = new JButton("Display Reviews");
		btnReadReviews.setBackground(new Color(222, 184, 135));
		btnReadReviews.setHorizontalAlignment(SwingConstants.LEFT);
		btnReadReviews.setBounds(10, 11, 184, 25);
		panel.add(btnReadReviews);
		btnReadReviews.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clientInterface.mainPanel.remove(clientInterface.mainPanel.currentPanel);
				clientInterface.mainPanel.currentPanel = new ReadReviewGUI(clientInterface, book);
				clientInterface.mainPanel.currentPanel.setBounds(176, 1, 724, 475);
				clientInterface.mainPanel.currentPanel.setBackground(new Color(255, 255, 255));
				clientInterface.mainPanel.add(clientInterface.mainPanel.currentPanel);
				clientInterface.mainPanel.currentPanel.setLayout(null);
				clientInterface.mainPanel.currentPanel.revalidate();
				clientInterface.mainPanel.currentPanel.repaint();
			}
		});
		btnReadReviews.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JButton btnSubmitReview = new JButton("Write Review");
		if (!(clientInterface.user instanceof Customer) || (clientInterface.user instanceof Customer && ((Customer)clientInterface.user).get_waitingForChangeType() == Define.FROM_USER_TO_CUSTOMER)) 
			btnSubmitReview.setEnabled(false);
		btnSubmitReview.setHorizontalAlignment(SwingConstants.LEFT);
		btnSubmitReview.setBounds(10, 47, 184, 25);
		btnSubmitReview.setBackground(new Color(222, 184, 135));
		panel.add(btnSubmitReview);
		btnSubmitReview.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(clientInterface.user instanceof Customer)
				{
					clientInterface.mainPanel.remove(clientInterface.mainPanel.currentPanel);
					clientInterface.mainPanel.currentPanel = new SubmitReviewGUI(clientInterface, book);
					clientInterface.mainPanel.currentPanel.setBounds(176, 1, 724, 475);
					clientInterface.mainPanel.currentPanel.setBackground(new Color(255, 255, 255));
					clientInterface.mainPanel.add(clientInterface.mainPanel.currentPanel);
					clientInterface.mainPanel.currentPanel.setLayout(null);
					clientInterface.mainPanel.currentPanel.revalidate(); // For Java 1.7 or above.
					clientInterface.mainPanel.currentPanel.repaint();
				}
				else
					new PopUpMessageGUI(clientInterface.frame, "Please open an account in order to submit a review.", Define.Notice);
			}
		});
		btnSubmitReview.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JButton btnBuyNow = new JButton("Buy Now - $" + book.get_price());
		if (!(clientInterface.user instanceof Customer) || (clientInterface.user instanceof Customer && ((Customer)clientInterface.user).get_waitingForChangeType() == Define.FROM_USER_TO_CUSTOMER))
			btnBuyNow.setEnabled(false);
		btnBuyNow.setHorizontalAlignment(SwingConstants.LEFT);
		btnBuyNow.setBounds(10, 83, 184, 25);
		btnBuyNow.setBackground(new Color(222, 184, 135));
		panel.add(btnBuyNow);
		btnBuyNow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				if(clientInterface.user instanceof Customer)
				{
					if(CustomerController.BuyBook(clientInterface, (Customer)(clientInterface.user), book))
						new PopUpMessageGUI(clientInterface.frame, "Thank you for choosing GoodReading.<br>The book has been added to 'MyBooks'.", Define.Like);
				}
				else
					new PopUpMessageGUI(clientInterface.frame, "Please open an account in order to purchase a book.", Define.Notice);
			}
		});
		btnBuyNow.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblAuthors = new JLabel("Author(s):");
		lblAuthors.setBounds(24, 92, 68, 14);
		imagePanel.add(lblAuthors);
		
		textAuthors = new JTextField();
		textAuthors.setEditable(false);
		Book_Author[] authors = ((Book_Author[]) bookDetails.getParameters().get(0));
		if (authors.length > 0)
		{
			String authorStr = new String("");
			for (Book_Author a : authors)
				authorStr = authorStr + a.get_author() + ", ";
			authorStr = authorStr.substring(0, authorStr.length() - 2);
			textAuthors.setText(authorStr);
		}
		textAuthors.setBounds(101, 89, 362, 20);
		imagePanel.add(textAuthors);
		textAuthors.setColumns(10);
		
		JLabel lblSubjects = new JLabel("Subject(s):");
		lblSubjects.setBounds(24, 117, 68, 14);
		imagePanel.add(lblSubjects);
		
		textSubjects = new JTextField();
		textSubjects.setEditable(false);
		Subject[] subjects = ((Subject[]) bookDetails.getParameters().get(1));
		if (authors.length > 0)
		{
			String subjectStr = new String("");
			for (Subject s : subjects)
				subjectStr = subjectStr + s.get_name() + ", ";
			subjectStr = subjectStr.substring(0, subjectStr.length() - 2);
			textSubjects.setText(subjectStr);
		}
		textSubjects.setBounds(101, 114, 362, 20);
		imagePanel.add(textSubjects);
		textSubjects.setColumns(10);
		
		JLabel lblLanguage = new JLabel("Language:");
		lblLanguage.setBounds(24, 142, 68, 14);
		imagePanel.add(lblLanguage);
		
		textLanguage = new JTextField(book.get_language());
		textLanguage.setEditable(false);
		textLanguage.setBounds(101, 139, 362, 20);
		imagePanel.add(textLanguage);
		textLanguage.setColumns(10);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(24, 192, 439, 131);
		imagePanel.add(scrollPane_1);
		
		JTextPane textSummary = new JTextPane();
		scrollPane_1.setViewportView(textSummary);
		textSummary.setEditable(false);
		textSummary.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		textSummary.setText(book.get_summary());
		
		JLabel lblSummary = new JLabel("Summary:");
		lblSummary.setBounds(24, 167, 68, 14);
		imagePanel.add(lblSummary);
		
		JLabel lblTableOfContents = new JLabel("Table of Contents:");
		lblTableOfContents.setBounds(24, 334, 109, 14);
		imagePanel.add(lblTableOfContents);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(24, 359, 439, 96);
		imagePanel.add(scrollPane_2);
		
		JTextPane textToC = new JTextPane();
		textToC.setEditable(false);
		scrollPane_2.setViewportView(textToC);
		textToC.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		textToC.setText(book.get_TableOfContents());
	}
}
