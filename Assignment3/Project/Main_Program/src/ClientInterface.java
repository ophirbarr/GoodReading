import java.awt.EventQueue;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JPanel;
import good_reading.SystemUser;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.UIManager;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ClientInterface extends ClientConsole 
{

	private JFrame frame;
	private JPanel loginPanel;
	private MainGUI mainPanel;
	private static int port;
	private static String host = "";
	private SystemUser user;
	private JTextField fieldUsername;
	private JPasswordField fieldPassword;
	private JLabel lblGoodReading;
  //ChatClient client;  -- in super class


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) 
	{
		host = "";
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
		frame = new JFrame("Good Reading [CLIENT]");
		frame.setBackground(UIManager.getColor("InternalFrame.borderColor"));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        loginPanel = new JPanel();
        loginPanel.setOpaque(true);
        loginPanel.setBackground(new Color(153, 204, 255));

        frame.getContentPane().add(loginPanel);
        loginPanel.setLayout(null);
        
        fieldUsername = new JTextField();
        fieldUsername.setBounds(272, 212, 167, 20);
        loginPanel.add(fieldUsername);
        fieldUsername.setColumns(10);
        
        fieldPassword = new JPasswordField();
        fieldPassword.setBounds(272, 243, 167, 20);
        loginPanel.add(fieldPassword);
        
        JLabel lblUsername = new JLabel("Username:");
        lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblUsername.setBounds(197, 214, 90, 14);
        loginPanel.add(lblUsername);
        
        JLabel lblPassword = new JLabel("Password:");
        lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblPassword.setBounds(197, 245, 90, 14);
        loginPanel.add(lblPassword);
        
        lblGoodReading = new JLabel("Good Reading");
        lblGoodReading.setFont(new Font("Narkisim", Font.BOLD, 60));
        lblGoodReading.setBounds(183, 113, 508, 88);
        loginPanel.add(lblGoodReading);
        
        JButton btnLogin = new JButton("LOGIN");
        btnLogin.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) 
        	{
        		
        	}
        });
        btnLogin.setFont(new Font("Tahoma", Font.BOLD, 11));
        btnLogin.setIcon(new ImageIcon(ClientInterface.class.getResource("/com/sun/javafx/webkit/prism/resources/mediaPlayDisabled.png")));
        btnLogin.setBounds(453, 212, 90, 51);
        loginPanel.add(btnLogin);
        frame.setSize(900, 700);
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
	}
}
