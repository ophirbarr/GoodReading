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
	
		
		/////////////////////////////////
		
		
		JPanel imagePanel = new JPanel();
		imagePanel.setBounds(0, 0, 727, 588);
		imagePanel.setBackground(new Color(250, 243, 232));
		add(imagePanel);
		imagePanel.setLayout(null);
		
		textField = new JLabel(book.get_title());
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setFont(new Font("Tahoma", Font.BOLD, 19));
		textField.setBounds(186, 48, 280, 51);
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
		lblPrice.setBounds(66, 304, 135, 38);
		imagePanel.add(lblPrice);
		
		JButton btnBuyNow = new JButton("Buy Now");
		btnBuyNow.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnBuyNow.setBounds(76, 353, 112, 29);
		imagePanel.add(btnBuyNow);
	}
}
