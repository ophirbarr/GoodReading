package client;

import javax.swing.JPanel;

import good_reading.BookReview;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
/**
 * 
 * @author avihai
 *class GUI which displays selected review in detail
 */
@SuppressWarnings("serial")
public class viewReviewGUI extends JPanel{
	//Class variable
	@SuppressWarnings("unused")
	private ClientInterface clientInterface;
	
	/**
	 * constructor
	 * @param clientInterface User Object
	 * @param br The Review Object
	 */
	public viewReviewGUI(ClientInterface clientInterface, BookReview br){
		super();
		setBackground(new Color(250, 243, 232));
		this.clientInterface = clientInterface;
		setLayout(null);
		
		JLabel lblWrittenBy = new JLabel("Written by:");
		lblWrittenBy.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblWrittenBy.setBounds(61, 46, 110, 29);
		add(lblWrittenBy);
		
		
		JLabel lblTheReview = new JLabel("The Review:");
		lblTheReview.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTheReview.setBounds(61, 86, 100, 29);
		add(lblTheReview);
		
		JLabel theWirtten = new JLabel(br.get_costumerName());
		theWirtten.setFont(new Font("Tahoma", Font.ITALIC, 15));
		theWirtten.setBounds(168, 40, 260, 36);
		add(theWirtten);
		
		
		JLabel theReview = new JLabel(br.get_review());
		theReview.setVerticalAlignment(SwingConstants.TOP);
		theReview.setFont(new Font("Tahoma", Font.ITALIC, 15));
		theReview.setBounds(61, 126, 399, 209);
		add(theReview);
		
		
	}


}
