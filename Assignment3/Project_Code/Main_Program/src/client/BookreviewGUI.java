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

public class BookreviewGUI extends JPanel {
	
	private ClientInterface clientInterface;
	private String nameBook;
	private String message;
	
	public BookreviewGUI(ClientInterface clientInterface,BookReview br,String nameBook){
		super();
		this.clientInterface = clientInterface;
		this.nameBook = nameBook;
		setLayout(null);
		
		JButton btnReject = new JButton("Erase");
		btnReject.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				message= "EraseReview";
				clientInterface.mainPanel.remove(clientInterface.mainPanel.currentPanel);
				clientInterface.mainPanel.currentPanel = new MessageToClientGUI(clientInterface,br.get_rid(),message);
				clientInterface.mainPanel.currentPanel.setBounds(176, 1, 724, 475);
				clientInterface.mainPanel.currentPanel.setBackground(new Color(250, 243, 232));
				clientInterface.mainPanel.add(clientInterface.mainPanel.currentPanel);
				clientInterface.mainPanel.currentPanel.setLayout(null);
				clientInterface.mainPanel.currentPanel.revalidate();
				clientInterface.mainPanel.currentPanel.repaint();
			}
		});
		btnReject.setBounds(332, 79, 135, 23);
		add(btnReject);
		
		JButton btnPublish = new JButton("Publish");
		btnPublish.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				message = "Publish";
				clientInterface.mainPanel.remove(clientInterface.mainPanel.currentPanel);
				clientInterface.mainPanel.currentPanel = new MessageToClientGUI(clientInterface,br.get_rid(),message);
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
		
		JButton btnPublish_partially = new JButton("Publish partially");
		btnPublish_partially.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				message = "Publish_partially";
			}
		});
		btnPublish_partially.setBounds(332, 45, 135, 23);
		add(btnPublish_partially);
		
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
		
		JTextArea wirttenBy = new JTextArea();
		wirttenBy.setFont(new Font("David", Font.ITALIC, 15));
		wirttenBy.setBounds(143, 16, 152, 23);
		add(wirttenBy);
		wirttenBy.setText(br.get_costumerName());
		
		JTextArea bookName = new JTextArea();
		bookName.setFont(new Font("David", Font.ITALIC, 15));
		bookName.setBounds(98, 61, 180, 23);
		add(bookName);
		bookName.setText(nameBook);
		
		JTextArea Review = new JTextArea();
		Review.setFont(new Font("David", Font.ITALIC, 15));
		Review.setBounds(10, 123, 430, 152);
		add(Review);
		Review.setText(br.get_review());
		
	}
}
