// This file contains material supporting section 3.7 of the textbook:
// "Object Oriented Software Engineering" and is issued under the open-source
// license found at www.lloseng.com 

package client;

import ocsf.client.*;
import common.*;
import good_reading.Worker;

import java.io.*;

import javax.swing.JOptionPane;

/**
 * This class overrides some of the methods defined in the abstract
 * superclass in order to give more functionality to the client.
 *
 * @author Dr Timothy C. Lethbridge
 * @author Dr Robert Lagani&egrave;
 * @author Fran&ccedil;ois B&eacute;langer
 * @version July 2000
 */
public class ChatClient extends AbstractClient
{
  //Instance variables **********************************************
  
  /**
   * The interface type variable.  It allows the implementation of 
   * the display method in the client.
   */
  ChatIF clientUI; 

  
  //Constructors ****************************************************
  
  /**
   * Constructs an instance of the chat client.
   *
   * @param host The server to connect to.
   * @param port The port number to connect on.
   * @param clientUI The interface type variable.
   */
  
  public ChatClient(String host, int port, ChatIF clientUI) 
    throws IOException 
  {
    super(host, port); //Call the superclass constructor
    this.clientUI = clientUI;
    openConnection();
  }

  
  //Instance methods ************************************************
    
  /**
   * This method handles all data that comes in from the server.
   *
   * @param msg The message from the server.
   */
  public void handleMessageFromServer(Object msg) 
  {
	  if (msg instanceof Message && ((Message)msg).getController().equals("ServerMessage"))  // ((ClientConsole)clientUI).user instanceof Worker
	  {
		  switch (((String)((Message)msg).getAction()))
		  {
		  case "NewUser":
			  if (((ClientConsole)clientUI).user instanceof Worker && ((Worker)((ClientConsole)clientUI).user).get_role().equals("Librarian"))
				  JOptionPane.showMessageDialog(null, "A new user registration is awaiting approval.");
			  break;
		  case "NewAccount":
			  if (((ClientConsole)clientUI).user instanceof Worker && ((Worker)((ClientConsole)clientUI).user).get_role().equals("Librarian"))
				  JOptionPane.showMessageDialog(null, "A new account request is awaiting approval.");
			  break;
		  case "CustomerChangeType":
			  if (((ClientConsole)clientUI).user instanceof Worker && ((Worker)((ClientConsole)clientUI).user).get_role().equals("Librarian"))
				  JOptionPane.showMessageDialog(null, "A new subscription request is awaiting approval.");
			  break;
		  case "NewReview":
			  if (((ClientConsole)clientUI).user instanceof Worker && (((Worker)((ClientConsole)clientUI).user).get_role().equals("Librarian") || ((Worker)((ClientConsole)clientUI).user).get_role().equals("Certified Editor")))
				  JOptionPane.showMessageDialog(null, "A new book review is awaiting approval.");
			  break;
			  
		  }
		  System.out.println("DEBUG ---------- POPUP for worker");
	  }
	  else
	  {
		clientUI.setMsgFromServer(msg);
		clientUI.setMsgAvailable(true);
		System.out.println("DEBUG ---------- Message arrived from server");
	  }
  }

  /**
   * This method handles all data coming from the UI            
   *
   * @param message The message from the UI.    
   */
  public void handleMessageFromClientUI(String message)
  {
    try
    {
    	sendToServer(message);
    }
    catch(IOException e)
    {
      clientUI.display
        ("Could not send message to server.  Terminating client.");
      quit();
    }
  }
  
  /**
   * This method terminates the client.
   */
  public void quit()
  {
    try
    {
      closeConnection();
    }
    catch(IOException e) {}
    System.exit(0);
  }
}
//End of ChatClient class
