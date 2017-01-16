package client;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import java.awt.Rectangle;
/**
 * 
 * @author yair
 *class GUI which displays message that the review published/rejected
 */
public class PopUpMessageGUI extends JFrame {
	
	private String Messagetext;
	
	/**
	 * constructor
	 * @param clientInterface User Object
	 * @param Messagetext String of the message to be displayed
	 */
	public PopUpMessageGUI(String messageText){
		super();
		setBounds(new Rectangle(500, 300, 431, 188));
		setAlwaysOnTop(true);
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(PopUpMessageGUI.class.getResource("/design/g10628.png")));
		this.Messagetext = messageText;
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);

		JLabel lblMessageText = new JLabel(messageText);
		lblMessageText.setBounds(46, 21, 334, 47);
		lblMessageText.setHorizontalAlignment(SwingConstants.CENTER);
		lblMessageText.setForeground(Color.DARK_GRAY);
		lblMessageText.setFont(new Font("Tahoma", Font.PLAIN, 18));
		getContentPane().add(lblMessageText);
		
		Button button = new Button("OK");
		button.setBounds(176, 104, 75, 30);
		button.addActionListener(new ActionListener() {
			/**
			 * OK button Listener - go to previous page
			 */
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		button.setFont(new Font("Dialog", Font.BOLD, 15));
		getContentPane().add(button);
		
		JLabel label = new JLabel("");
		label.setBounds(339, 51, 63, 63);
		label.setIcon(new ImageIcon("C:\\Users\\yair\\Downloads\\g5091.png"));
		getContentPane().add(label);
		
		
	}
}
