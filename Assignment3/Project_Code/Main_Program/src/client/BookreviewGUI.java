package client;

import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;

public class BookreviewGUI extends JPanel {
	
	private ClientInterface clientInterface;
	
	
	public BookreviewGUI(ClientInterface clientInterface){
		super();
		this.clientInterface = clientInterface;
		setLayout(null);
		
		JButton btnReject = new JButton("Reject");
		btnReject.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnReject.setBounds(332, 79, 118, 23);
		add(btnReject);
		
		JButton btnPublish = new JButton("Publish");
		btnPublish.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnPublish.setBounds(332, 11, 118, 23);
		add(btnPublish);
		
		JButton btnPublish_partially = new JButton("Publish partially");
		btnPublish_partially.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnPublish_partially.setBounds(332, 45, 118, 23);
		add(btnPublish_partially);
		
		JLabel lblTheReviewWritten = new JLabel("The review written by:");
		lblTheReviewWritten.setBounds(10, 15, 152, 23);
		add(lblTheReviewWritten);
		
		JLabel lblForABook = new JLabel("For a book:");
		lblForABook.setBounds(10, 60, 107, 14);
		add(lblForABook);
		
		JLabel lblTheReview = new JLabel("The review:");
		lblTheReview.setBounds(10, 98, 67, 14);
		add(lblTheReview);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(126, 16, 152, 23);
		add(textArea);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBounds(84, 61, 180, 23);
		add(textArea_1);
		
		JTextArea textArea_2 = new JTextArea();
		textArea_2.setBounds(10, 123, 430, 152);
		add(textArea_2);
		
	}
}
