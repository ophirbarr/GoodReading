package client;

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
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Rectangle;
/**
 * The main program class. Contains the main function and creates the first log-in frame. Extends ClientConsole.
 */
public class ClientInterface extends ClientConsole 
{

	@SuppressWarnings("unused")
	private static int port;
	private static String host = "";
	protected static ClientInterface clientInterface;
	
	
	// GUI fields
	public JFrame frame;
	public JPanel loginPanel;
	public MainGUI mainPanel;
	public SignUpGUI signUpPanel;
	private JTextField fieldUsername;
	private JPasswordField fieldPassword;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) 
	{
		host = (String)JOptionPane.showInputDialog(null, "Enter host address:", "GOOD READING", JOptionPane.QUESTION_MESSAGE, null, null, "localhost");
	    port = 0;  //The port number

	    if (host == null) System.exit(0);
	    /*
	    try
	    {
	      host = args[0];
	    }
	    catch(ArrayIndexOutOfBoundsException e)
	    {
	      host = "localhost";
	    }
	    */
	    	
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
		frame = new JFrame("Good Reading");
		frame.setBounds(250, 70, 900, 617);
		frame.setResizable(false);
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("src\\design\\g10628.png"));
		frame.setFont(new Font("AdamaMF", Font.PLAIN, 16));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBackground(UIManager.getColor("InternalFrame.borderColor"));
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) 
			{
				logOut();
			}
		});
		
        loginPanel = new JPanel();
        loginPanel.setBounds(new Rectangle(0, 0, 900, 617));
        loginPanel.setOpaque(true);
        loginPanel.setBackground(new Color(153, 204, 255));

        frame.getContentPane().add(loginPanel);
        loginPanel.setLayout(null);
        		
        fieldUsername = new JTextField();
        fieldUsername.setBounds(284, 349, 251, 36);
        loginPanel.add(fieldUsername);
        fieldUsername.setColumns(10);
        
        fieldPassword = new JPasswordField();
        fieldPassword.setBounds(284, 396, 251, 36);
        loginPanel.add(fieldPassword);
        
        JLabel lblUsername = new JLabel("User Name:");
        lblUsername.setFont(new Font("Courier New", Font.BOLD, 16));
        lblUsername.setBounds(173, 359, 101, 14);
        loginPanel.add(lblUsername);
        
        JLabel lblPassword = new JLabel("Password:");
        lblPassword.setFont(new Font("Courier New", Font.BOLD, 16));
        lblPassword.setBounds(184, 406, 90, 14);
        loginPanel.add(lblPassword);
        
        
        JButton btnLogin = new JButton("LOGIN");
        btnLogin.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) 
        	{
        		msgFromServer = null;

        		Message msg = new Message("LogIn", "SystemUserController");
        		msg.add(fieldUsername.getText());
        		msg.add(new String(fieldPassword.getPassword()));
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
        
        btnLogin.setFont(new Font("Courier New", Font.BOLD, 11));
        btnLogin.setIcon(new ImageIcon(ClientInterface.class.getResource("/com/sun/javafx/webkit/prism/resources/mediaPlayDisabled.png")));
        btnLogin.setBounds(592, 358, 90, 55);
        loginPanel.add(btnLogin);
        
        JLabel lblOrSignUp = new JLabel("or sign up");
        lblOrSignUp.setFont(new Font("Courier New", Font.BOLD, 16));
        lblOrSignUp.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent arg0) 
        	{
        		signUpPanel = new SignUpGUI(clientInterface);
    			frame.remove(loginPanel);
    			frame.getContentPane().add(signUpPanel);
    			frame.revalidate(); // For Java 1.7 or above.
    			// frame.getContentPane().validate(); // For Java 1.6 or below.
    			frame.repaint();
        	}
        	@Override
        	public void mouseEntered(MouseEvent e) {
        		lblOrSignUp.setFont(new Font("Courier New", Font.ITALIC, 16));
        	}
        	@Override
        	public void mouseExited(MouseEvent arg0) {
        		lblOrSignUp.setFont(new Font("Courier New", Font.BOLD, 16));
        	}
        });
        lblOrSignUp.setBounds(585, 415, 105, 20);
        loginPanel.add(lblOrSignUp);
        
        JLabel lblbackground = new JLabel("");
        lblbackground.setIcon(new ImageIcon(ClientInterface.class.getResource("/design/bitmap.png")));
        lblbackground.setBounds(0, 0, 894, 588);
        loginPanel.add(lblbackground);
	}
	

	// custom ClientInterface methods
	
	/**
	 * When this method is called, the client will wait until a message from the server is received.
	 */
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
	
	/**
	 * This method is called when user logs out or when program terminates.
	 * It sends a "LogOut" request to server.
	 */
	public void logOut()
	{
		if (user != null)
			if (user.get_userStatus() == 1)
			{
				try {
					client.openConnection();
					Message msg = new Message("LogOut", "SystemUserController");
					msg.add(user.get_userName());
					client.sendToServer(msg);
				} catch (IOException e1) {
					e1.printStackTrace();}
				
				user = null;
			}
	}
}
