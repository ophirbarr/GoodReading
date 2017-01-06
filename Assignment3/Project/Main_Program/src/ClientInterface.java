import java.awt.EventQueue;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.JPanel;
import good_reading.SystemUser;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.UIManager;

import common.Message;

import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ClientInterface extends ClientConsole 
{

	private static int port;
	private static String host = "";
	protected static ClientInterface clientInterface;
	
	// GUI fields
	protected JFrame frame;
	protected JPanel loginPanel;
	protected MainGUI mainPanel;
	private JTextField fieldUsername;
	private JPasswordField fieldPassword;
	private JLabel lblGoodReading;


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
					clientInterface = new ClientInterface(host, DEFAULT_PORT);
					clientInterface.frame.setVisible(true);
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
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) 
			{
				if (user != null)
					if (user.get_userStatus() == 1)
					{
						try {
							clientInterface.client.openConnection();
							Message msg = new Message("LogOut");
							msg.add(clientInterface.user.get_userName());
							clientInterface.client.sendToServer(msg);
						} catch (IOException e1) {
							e1.printStackTrace();}
						
						clientInterface.user = null;
					}
			}
		});
		frame.setBackground(UIManager.getColor("InternalFrame.borderColor"));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        loginPanel = new JPanel();
        loginPanel.setOpaque(true);
        loginPanel.setBackground(new Color(153, 204, 255));

        frame.getContentPane().add(loginPanel);
        loginPanel.setLayout(null);
        
        fieldUsername = new JTextField();
        fieldUsername.setBounds(313, 328, 173, 26);
        loginPanel.add(fieldUsername);
        fieldUsername.setColumns(10);
        
        fieldPassword = new JPasswordField();
        fieldPassword.setBounds(313, 357, 173, 26);
        loginPanel.add(fieldPassword);
        
        JLabel lblUsername = new JLabel("Username:");
        lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblUsername.setBounds(226, 332, 90, 14);
        loginPanel.add(lblUsername);
        
        JLabel lblPassword = new JLabel("Password:");
        lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblPassword.setBounds(226, 361, 90, 14);
        loginPanel.add(lblPassword);
        
        lblGoodReading = new JLabel("Good Reading");
        lblGoodReading.setFont(new Font("Narkisim", Font.BOLD, 65));
        lblGoodReading.setBounds(203, 239, 508, 88);
        loginPanel.add(lblGoodReading);
        
        
        JButton btnLogin = new JButton("LOGIN");
        btnLogin.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) 
        	{
        		msgFromServer = null;

        		Message msg = new Message("LogIn");
        		msg.add(fieldUsername.getText());
        		msg.add(fieldPassword.getText());
        		try {
        			client.openConnection();
					client.sendToServer(msg);
				} catch (IOException e) {
					e.printStackTrace();
				}
        		

        		waitForServer();
        		System.out.println("DEBUG ---------- (login) Read message from server");
        		
        		
        		user = (SystemUser)msgFromServer;
        		if (user != null)
        		{
        			mainPanel = new MainGUI(clientInterface);
        			frame.remove(loginPanel);
        			frame.getContentPane().add(mainPanel);
        			frame.revalidate(); // For Java 1.7 or above.
        			// frame.getContentPane().validate(); // For Java 1.6 or below.
        			frame.repaint();
        		}
        		else // login failed
        		{
        			JOptionPane.showMessageDialog(frame, "Login failed. Please contact technical support.");        		}
        		
        	}
        });
        btnLogin.setFont(new Font("Tahoma", Font.BOLD, 11));
        btnLogin.setIcon(new ImageIcon(ClientInterface.class.getResource("/com/sun/javafx/webkit/prism/resources/mediaPlayDisabled.png")));
        btnLogin.setBounds(496, 328, 90, 55);
        loginPanel.add(btnLogin);
        frame.setSize(900, 700);
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
	}
	

	public void waitForServer()
	{
		while (!isMsgAvailable())
		{
			try {
				TimeUnit.MILLISECONDS.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		setMsgAvailable(false);
	}
}
