// This file contains material supporting section 3.7 of the textbook:
// "Object Oriented Software Engineering" and is issued under the open-source
// license found at www.lloseng.com 

import java.io.*;
import org.orm.PersistentException;
import common.Message;
import controllers.BookController;
import controllers.CostumerController;
import good_reading.Book;
import good_reading.BookReview;
import ocsf.server.*;

/**
 * This class overrides some of the methods in the abstract 
 * superclass in order to give more functionality to the server.
 *
 * @author Dr Timothy C. Lethbridge
 * @author Dr Robert Lagani&egrave;re
 * @author Fran&ccedil;ois B&eacute;langer
 * @author Paul Holden
 * @version July 2000
 */
public class EchoServer extends AbstractServer 
{
  //Class variables *************************************************
  
  /**
   * The default port to listen on.
   */
  final public static int DEFAULT_PORT = 5555;
  
  //Constructors ****************************************************
  
  /**
   * Constructs an instance of the echo server.
   *
   * @param port The port number to connect on.
   */
  public EchoServer(int port) 
  {
    super(port);
  }

  
  //Instance methods ************************************************
  
  /**
   * This method handles any messages received from the client.
   *
   * @param msg The message received from the client.
   * @param client The connection from which the message originated.
   */
  public void handleMessageFromClient(Object msg, ConnectionToClient client)
  {
	  //System.out.println("Message received: " + msg + " from " + client);
	  //this.sendToAllClients(msg);
	  
	  Message message = (Message)msg;
	  String action = message.getAction();
	  String controller = message.getController();
	  
	  switch(controller)
	  {
	  
	  case "SystemUserController":
		  switch(action)
		  {
		  case "LogIn":
			  try {
				client.sendToClient(controllers.SystemUserController.LogIn((String)message.getParameters().get(0), (String)message.getParameters().get(1)));
				} catch (IOException e) {e.printStackTrace();}
			  break;
			  
		  case "LogOut":
			  controllers.SystemUserController.LogOut((String)message.getParameters().get(0));
			  break;
			  
		  case "SearchBooks":
			  try {
				client.sendToClient(controllers.SystemUserController.SearchBooks((boolean[])message.getParameters().get(0), (String[])message.getParameters().get(1)));
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			  break;
			  
		  case "GetAllBooks":
			  try {
				client.sendToClient(controllers.SystemUserController.GetAllBooks());
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			  break;
			  
		  case "SignUp":
			  try {
				client.sendToClient(controllers.SystemUserController.SignUp(message.getParameters()));
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			  break;
			  
		  }
		  
		  break;
		  
	  case "BookInspectReview":
		  switch(action)
		  {
		  case "getInspectReview":
			  try {
				client.sendToClient(controllers.BookInspectReview.getInspectReview());
				} catch (IOException e) {e.printStackTrace();} 
			  catch (PersistentException e) {e.printStackTrace();}
			  break;
		  case "EraseReview":
			  try {
				client.sendToClient(controllers.BookInspectReview.EraseReview((int)message.getParameters().get(0)));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			  break;
		  case "Publish":
			  try {
				client.sendToClient(controllers.BookInspectReview.Publish((int)message.getParameters().get(0),(String)message.getParameters().get(1)));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			  break;
		 /* case "PublishPartially":
			  controllers.BookInspectReview.PublishPartially((Integer)message.getParameters().get(0),(String)message.getParameters().get(1));
			  break;*/
		  }

		break;
		
	  case "BookController":
		  switch(action)
		  {
		  case "AddToSearchLog":
			  BookController.AddToSearchLog((Book)message.getParameters().get(0));
			  break;
			  
		  case "AddToPurchaseLog":
			  BookController.AddToPurchaseLog((Book)message.getParameters().get(0));
			  break;
		  }
		  break;
		  
		  
	  case "CostumerController":
		  switch(action)
		  {
		  case "SubmitReview":
			  CostumerController.SubmitReview((BookReview)message.getParameters().get(0));
		  }
		  break;
	  }
  }

    
  /**
   * This method overrides the one in the superclass.  Called
   * when the server starts listening for connections.
   */
  protected void serverStarted()
  {
    System.out.println
      ("Server listening for connections on port " + getPort());
  }
  
  /**
   * This method overrides the one in the superclass.  Called
   * when the server stops listening for connections.
   */
  protected void serverStopped()
  {
    System.out.println
      ("Server has stopped listening for connections.");
  }
  
  //Class methods ***************************************************
  
  /**
   * This method is responsible for the creation of 
   * the server instance (there is no UI in this phase).
   *
   * @param args[0] The port number to listen on.  Defaults to 5555 
   *          if no argument is entered.
   */
  public static void main(String[] args) 
  {
    int port = 0; //Port to listen on

    try
    {
      port = Integer.parseInt(args[0]); //Get port from command line
    }
    catch(Throwable t)
    {
      port = DEFAULT_PORT; //Set port to 5555
    }
	
    EchoServer sv = new EchoServer(port);
    
    try 
    {
      sv.listen(); //Start listening for connections
    } 
    catch (Exception ex) 
    {
      System.out.println("ERROR - Could not listen for clients!");
    }
  }
}
//End of EchoServer class
