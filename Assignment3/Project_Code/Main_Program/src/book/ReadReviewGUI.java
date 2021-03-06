package book;

import java.awt.Color;

import javax.swing.JPanel;

import good_reading.Book;
import good_reading.BookReview;
import good_reading.Customer;

import java.awt.Rectangle;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import client.ClientInterface;
import common.Define;
import common.Message;
import javax.swing.JLabel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JScrollPane;

/**
 * @author yair
 * GUI class. Extends JPanel. Displays all the approved reviews of a book.
 */
@SuppressWarnings("serial")
public class ReadReviewGUI extends JPanel {

	@SuppressWarnings("unused")
	private ClientInterface clientInterface;
	private JLabel textField;
	
	/**
	 * Constructor that creates the panel.
	 * @param clientInterface The main class of the program.
	 * @param book The book which reviews are to be displayed.
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
		lblBookpicture.setBounds(445, 101, 184, 270);
		lblBookpicture.setIcon(Define.ResizeIcon(book.get_picPath(), lblBookpicture.getWidth(), lblBookpicture.getHeight()));
		imagePanel.add(lblBookpicture);
		
		JButton btnSubmitReview = new JButton("Submit A Review");
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
					Define.PopUp("Please open an account in order to submit a review.", Define.Notice);
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
		scrollPane.setBounds(32, 101, 346, 354);
		imagePanel.add(scrollPane);
		
		DefaultListModel<String> listModel = new DefaultListModel<String>();
		
		JList<String> list = new JList<String>(listModel);
		list.setFont(new Font("Monospaced", Font.PLAIN, 11));
		
		scrollPane.setViewportView(list);
		
		JLabel lblResultTitle = new JLabel("Writen by:                       Review:");
		lblResultTitle.setFont(new Font("Tahoma", Font.BOLD, 11));
		scrollPane.setColumnHeaderView(lblResultTitle);
		
		Message msg = new Message("ReadReviews", "SystemUserController");
		msg.add(book);
		
		try {
			clientInterface.client.openConnection();
			clientInterface.client.sendToServer(msg);
		} catch (IOException e) {
			e.printStackTrace();
		}
		clientInterface.waitForServer();
		
		BookReview[] bookReview = (BookReview[])clientInterface.getMsgFromServer();
		listModel.clear();
		if (bookReview.length == 0) 
			listModel.addElement("There are no matching results to your query.");
		else
			for(int i=0; i< bookReview.length;i++)
			{
				listModel.addElement(String.format("%-18s%s", bookReview[i].get_costumerName(), bookReview[i].get_review()));
			}

		list.addListSelectionListener(new ListSelectionListener() { 
			/**
			 * Listener selected review - displays the review in detail
			 */
			public void valueChanged(ListSelectionEvent e) {
				int index = list.getSelectedIndex();   //index in the list of the selected review
				if (index != -1)
				{
					clientInterface.mainPanel.remove(clientInterface.mainPanel.currentPanel);
					clientInterface.mainPanel.currentPanel = new viewReviewGUI(clientInterface, bookReview[index]);
					clientInterface.mainPanel.currentPanel.setBounds(176, 1, 724, 475);
					clientInterface.mainPanel.currentPanel.setBackground(new Color(250, 243, 232));
					clientInterface.mainPanel.add(clientInterface.mainPanel.currentPanel);
					clientInterface.mainPanel.currentPanel.setLayout(null);
					clientInterface.mainPanel.currentPanel.revalidate();
					clientInterface.mainPanel.currentPanel.repaint();
				}
				
			}
		});
		
		
	}
}
