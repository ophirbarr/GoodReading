package client;

import javax.swing.JPanel;

import javax.swing.border.EtchedBorder;

import common.Message;
import good_reading.BookReview;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;

/**
 * 
 * @author avihai
 *class GUI which displays all the review that pending approval 
 */


public class BookreviewGUI extends JPanel {
	//Class variables
	private ClientInterface clientInterface;
	private String nameBook;
	private String typeMessage;   //type action: publish || reject depending on the button pressed
	private JTextArea theReview;  //String of review
	private JButton btnEdit;
	
	/**
	 * constructor
	 * @param clientInterface User Object
	 * @param br The Review Object
	 * @param nameBook Title book for the review
	 */
	
	
	public BookreviewGUI(ClientInterface clientInterface,BookReview br,String nameBook){
		super();
		this.clientInterface = clientInterface;
		this.nameBook = nameBook;
		setLayout(null);
		
		
		
		JButton btnReject = new JButton("Reject");
		btnReject.addActionListener(new ActionListener() {
			/**
			 *Reject Listener button -  permanently erases the Review
			 */
			public void actionPerformed(ActionEvent e) {
				typeMessage= "RejectReview";
				clientInterface.mainPanel.remove(clientInterface.mainPanel.currentPanel);
				clientInterface.mainPanel.currentPanel = new MessageToClientGUI(clientInterface,br.get_rid(),typeMessage,theReview.getText());
				clientInterface.mainPanel.currentPanel.setBounds(176, 1, 724, 475);
				clientInterface.mainPanel.currentPanel.setBackground(new Color(250, 243, 232));
				clientInterface.mainPanel.add(clientInterface.mainPanel.currentPanel);
				clientInterface.mainPanel.currentPanel.setLayout(null);
				clientInterface.mainPanel.currentPanel.revalidate();
				clientInterface.mainPanel.currentPanel.repaint();
			}
		});
		btnReject.setBounds(332, 75, 135, 23);
		add(btnReject);
		
		JButton btnPublish = new JButton("Publish");
		btnPublish.addActionListener(new ActionListener() {
			/**
			 * Publish Listener button - publish the review
			 */
			public void actionPerformed(ActionEvent e) {
				typeMessage = "PublishReview";
				clientInterface.mainPanel.remove(clientInterface.mainPanel.currentPanel);
				clientInterface.mainPanel.currentPanel = new MessageToClientGUI(clientInterface,br.get_rid(),typeMessage,theReview.getText());
				clientInterface.mainPanel.currentPanel.setBounds(176, 1, 724, 475);
				clientInterface.mainPanel.currentPanel.setBackground(new Color(250, 243, 232));
				clientInterface.mainPanel.add(clientInterface.mainPanel.currentPanel);
				clientInterface.mainPanel.currentPanel.setLayout(null);
				clientInterface.mainPanel.currentPanel.revalidate();
				clientInterface.mainPanel.currentPanel.repaint();
			}
		});
		btnPublish.setBounds(332, 11, 135, 23);
		add(btnPublish);
		
		
		JLabel lblTheReviewWritten = new JLabel("The review written by:");
		lblTheReviewWritten.setForeground(Color.BLUE);
		lblTheReviewWritten.setBounds(10, 15, 152, 23);
		add(lblTheReviewWritten);
		
		JLabel lblForABook = new JLabel("For a book:");
		lblForABook.setForeground(Color.BLUE);
		lblForABook.setBounds(10, 60, 107, 14);
		add(lblForABook);
		
		JLabel lblTheReview = new JLabel("The review:");
		lblTheReview.setForeground(Color.BLUE);
		lblTheReview.setBounds(10, 98, 67, 14);
		add(lblTheReview);
		
		JLabel lblThewritten = new JLabel(br.get_costumerName());
		lblThewritten.setFont(new Font("Times New Roman", Font.ITALIC, 15));
		lblThewritten.setBounds(153, 12, 167, 27);
		add(lblThewritten);
		
		JLabel lblNamebook = new JLabel(nameBook);
		lblNamebook.setFont(new Font("Times New Roman", Font.ITALIC, 15));
		lblNamebook.setBounds(95, 53, 227, 27);
		add(lblNamebook);
		
		btnEdit = new JButton("Edit");
		btnEdit.addActionListener(new ActionListener() {
			/**
			 * Edit Listener button - go into edit mode so that it can delete parts review
			 */
			public void actionPerformed(ActionEvent e) {
				theReview.setEditable(true);
				btnEdit.setEnabled(false);
				
			}
		});
		btnEdit.setBounds(332, 45, 135, 23);
		add(btnEdit);
		
		theReview = new JTextArea();
		theReview.setText(br.get_review());
		theReview.setFont(new Font("Courier New", Font.ITALIC, 15));
		theReview.setEditable(false);
		theReview.setBounds(87, 109, 335, 239);
		add(theReview);
	
	}
}
