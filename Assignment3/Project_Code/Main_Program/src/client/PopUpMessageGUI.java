package client;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

import com.sun.org.apache.bcel.internal.util.ClassPath;

import common.Define;

import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JDialog;

import java.awt.Rectangle;
/**
 * @author Yair
 * GUI class represents a pop up message. Extends JDialog.
 */
public class PopUpMessageGUI extends JDialog {
	
	private String Messagetext;
	
	/**
	 * Constructor that creates the frame.
	 * @param frame The main frame of the program.
	 * @param messageText String of the message to be displayed.
	 * @param Type The type of the message. May be: Error(0), Notice(1), Edit(2), Like(3), Build(4).

	 */
	public PopUpMessageGUI(JFrame frame, String messageText, int Type){
		super();
		setAlwaysOnTop(true);
		setResizable(false);
		setVisible(true);
		setBounds(new Rectangle(100, 50, 431, 188));
		setLocationRelativeTo(frame);
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(PopUpMessageGUI.class.getResource("/design/g10628.png")));
		this.Messagetext = messageText;
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);

		JLabel lblMessageText = new JLabel("<html><div style='text-align: center;'>"+messageText+"</div></html>");
		lblMessageText.setBounds(46, 21, 334, 47);
		lblMessageText.setHorizontalAlignment(SwingConstants.CENTER);
		lblMessageText.setForeground(Color.DARK_GRAY);
		lblMessageText.setFont(new Font("Tahoma", Font.PLAIN, 18));
		//lblMessageText.setLayout(new BorderLayout());
		lblMessageText.setHorizontalTextPosition(SwingConstants.CENTER);
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
		
		String path = "";
		switch(Type)
		{
		case Define.Error:
			path = "/design/g6643.png";
			break;
		case Define.Notice:
			path = "/design/g5067.png";
			break;
		case Define.Edit:
			path = "/design/g5022.png";
			break;
		case Define.Like:
			path = "/design/g5091.png";
			break;
		case Define.Build:
			path = "/design/g5046.png";
			break;
		}
				
		JLabel label = new JLabel("");
		label.setBounds(340, 71, 63, 63);
		label.setIcon(new ImageIcon(PopUpMessageGUI.class.getResource(path)));
		getContentPane().add(label);
	}
}
