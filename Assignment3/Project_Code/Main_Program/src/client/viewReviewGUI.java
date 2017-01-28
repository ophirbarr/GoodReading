package client;

import javax.swing.JPanel;

import good_reading.BookReview;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
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
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(61, 126, 366, 163);
		add(scrollPane);
		
		JTextPane theReview = new JTextPane();
		scrollPane.setViewportView(theReview);
		theReview.setEditable(false);
		theReview.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		theReview.setText(br.get_review());
		
		
		/*
		//Arrange rows review
		String[] review = br.get_review().split(" ");
		String str = "";
		int count = 0;    //The number of words in a row
		int flag = 0;     //The beginning of the line
		for(int i=0;i<review.length;i++,count++,flag++)
		{
			if(flag==0) str = str+review[i];
			else str = str+" "+review[i];
			if(count == 5)     //new row
			{
				count = -1;
				flag = -1;
				str = str +"\n";
			}
		}
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(61, 126, 399, 209);
		add(scrollPane);
		
		JTextArea theReview = new JTextArea(str);
		theReview.setFont(new Font("Monospaced", Font.PLAIN, 14));
		theReview.setEditable(false);
		scrollPane.setViewportView(theReview);
		*/
		
	}
}
