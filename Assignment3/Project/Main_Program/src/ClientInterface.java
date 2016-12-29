import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;

public class ClientInterface extends ClientConsole 
{

	private JFrame frame;
	private static int port;
	private static String host = "";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) 
	{
		//host = "";
	    port = 0;  //The port number

	    try
	    {
	      host = args[0];
	    }
	    catch(ArrayIndexOutOfBoundsException e)
	    {
	      host = "localhost";
	    }
	    //ClientInterface clientInterface = new ClientInterface(host, DEFAULT_PORT);
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClientInterface window = new ClientInterface(host, DEFAULT_PORT);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ClientInterface(String host, int port) {
		super(host, port);
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 743, 568);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblJlabel = new JLabel("blue JLabel");
		lblJlabel.setForeground(Color.BLUE);
		lblJlabel.setBackground(Color.WHITE);
		lblJlabel.setBounds(109, 62, 80, 47);
		frame.getContentPane().add(lblJlabel);
	}
}
