// This file contains material supporting section 3.7 of the textbook:
// "Object Oriented Software Engineering" and is issued under the open-source
// license found at www.lloseng.com 

import java.io.*;
import org.orm.PersistentException;
import common.Message;
import controllers.BookController;
import controllers.CustomerController;
import good_reading.Book;
import good_reading.BookReview;
import good_reading.Customer;
import good_reading.SystemUser;
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
				client.sendToClient(controllers.SystemUserController.SearchBooks((boolean[])message.getParameters().get(0), (String[])message.getParameters().get(1), (boolean)message.getParameters().get(2)));
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			  break;
			  
		  case "GetAllBooks":
			  try {
				client.sendToClient(controllers.SystemUserController.GetAllBooks((boolean)message.getParameters().get(0)));
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
			  
		  case "ReadReviews":
			  try {
				client.sendToClient(controllers.SystemUserController.ReadReviews((int)((Book) message.getParameters().get(0)).get_bid()));
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			  break;
			  
		  case "OpenAccount":
			  try {
				client.sendToClient(controllers.SystemUserController.OpenAccount((SystemUser)message.getParameters().get(0)));
			} catch (IOException e2) {
				e2.printStackTrace();
			}
			  break;
			  
		  case "RefreshUser":
			  try {
					client.sendToClient(controllers.SystemUserController.RefreshUser((int)message.getParameters().get(0)));
				} catch (IOException e2) {
					e2.printStackTrace();
				}
			  break;
		  }
		  
		  break;
		  /**
		   * Inspect Review Controller
		   */
	  case "InspectReviewController":
		  switch(action)
		  {
		  case "InspectReviews":  //Sends to client a list of all awaiting approval reviews
			  try {
				client.sendToClient(controllers.InspectReviewController.InspectReviews());
				} catch (IOException e) {e.printStackTrace();} 
			  catch (PersistentException e) {e.printStackTrace();}
			  break;
		  case "RejectReview": //Getting the id review and delete it from database
				  try {
					  client.sendToClient(controllers.InspectReviewController.RejectReview((int)message.getParameters().get(0)));
						} catch (IOException e) {
							e.printStackTrace();
						}
				  break;
		  case "PublishReview":  //Getting the id review and text review and publishes it
			  try {
				client.sendToClient(controllers.InspectReviewController.PublishReview((int)message.getParameters().get(0),(String)message.getParameters().get(1)));
			} catch (IOException e) {
				e.printStackTrace();
			}
			  break;
		 
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
		  
		  
	  case "CustomerController":
		  switch(action)
		  {
		  case "SubmitReview":
			  CustomerController.SubmitReview((BookReview)message.getParameters().get(0));
			  break;
			  
		  case "AddBookToCustomer":
			  CustomerController.AddBookToCustomer((int)message.getParameters().get(0), (int)message.getParameters().get(1));
			  break;
		  
		  case "MyBooks":
			  try {
				client.sendToClient(CustomerController.MyBooks((Customer)message.getParameters().get(0)));
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			  break;
			  	  
		  case "DownloadBook":
			  try {
					client.sendToClient(CustomerController.DownloadBook((String)message.getParameters().get(0), (String)message.getParameters().get(1)));
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			  break;
			  
		  case "UpdateCustomer":
			  CustomerController.UpdateCustomer((Customer)message.getParameters().get(0));
			  break;
		  }
		  break;
		  		  
		  
	  case "DatabaseManagementController":
		  switch(action)
		  {
		  case "GetSubjects":
			  try {
				client.sendToClient(controllers.DatabaseManagementController.GetSubjects((String) message.getParameters().get(0)));
			} catch (IOException e) {
				e.printStackTrace();
			}
			  break;
			  
		  case "GetAllSubjects":
			  try {
				client.sendToClient(controllers.DatabaseManagementController.GetAllSubjects());
			} catch (IOException e) {
				e.printStackTrace();
			}
			  break;
			  
		  case "GetDomains":
			  try {
				client.sendToClient(controllers.DatabaseManagementController.GetDomains((String) message.getParameters().get(0)));
			} catch (IOException e) {
				e.printStackTrace();
			}
			  break;
			  
		  case "GetAllDomains":
			  try {
				client.sendToClient(controllers.DatabaseManagementController.GetAllDomains());
			} catch (IOException e) {
				e.printStackTrace();
			}
			  break;
			  
		  case "GetBookDetails":
			  try {
				  client.sendToClient(controllers.DatabaseManagementController.GetBookDetails((int) message.getParameters().get(0)));
			  } catch (IOException e) {
				  e.printStackTrace();
			  }
			  break;
			  
		  case "EditBook":
			  try {
				client.sendToClient(controllers.DatabaseManagementController.EditBook((Book) message.getParameters().get(0)));
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			  break;
			  
		  case "RemoveBookAssociation":
			  controllers.DatabaseManagementController.RemoveBookAssociation(message);
			  break;
			  
		  case "AddBookAssociation":
			  controllers.DatabaseManagementController.AddBookAssociation(message);
			  break;
			  
		  case "EditSubjectDomain":
			  controllers.DatabaseManagementController.EditSubjectDomain(message);
			  break;
			  
		  case "DeleteItem":
			  try {
				client.sendToClient(controllers.DatabaseManagementController.DeleteItem(message));
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			  break;
			  
		  case "AddBook":
			  try {
					client.sendToClient(controllers.DatabaseManagementController.AddBook());
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			  break;
			  
		  case "AddSubjectDomain":
			  controllers.DatabaseManagementController.AddSubjectDomain(message);
			  break;
			  
		  }
		  break;
		  
	  case "LibrarianController":
		  switch(action)
		  {
		  case "ViewUsersWithCondition":
			  try {
					client.sendToClient(controllers.LibrarianController.ViewUsersWithCondition((int)message.getParameters().get(0)));
					} catch (IOException e) {e.printStackTrace();} 
				  
			  break;
			  
		  case "AddNewUser": 
			  controllers.LibrarianController.AddNewUser((int)message.getParameters().get(0));
			  break;
			  
		  case "FromUserToCostumer": 
			  controllers.LibrarianController.FromUserToCostumer((int)message.getParameters().get(0));
			  break;
		  case "EditCostumerAccount": 
			  controllers.LibrarianController.EditCostumerAccount((int)message.getParameters().get(0));
			  break;
		  case "EraseUser": 
			  controllers.LibrarianController.EraseUser((int)message.getParameters().get(0));
			  break;
			  
		  }
	  case "ManagerController":
		  switch(action){
		  case "ManageCatalog": 
			  try {
				client.sendToClient(controllers.ManagerController.ManageCatalog());
			} catch (IOException e) {
				e.printStackTrace();
			}
		  break;
		  case "AddToCatalog":
			  controllers.ManagerController.AddToCatalog((int) message.getParameters().get(0));
		  break;
		  
		  case "RemoveFromCatalog":
			  controllers.ManagerController.RemoveFromCatalog((int) message.getParameters().get(0));
			  break;
			  
		  case "CustomerOrders":
			  try {
				client.sendToClient(controllers.ManagerController.CustomerOrders());
			} catch (IOException e) {
				e.printStackTrace();
			}
		  break;
		  case "GetCounterBooksPurchased":
			  try {
				client.sendToClient(controllers.ManagerController.GetCounterBooksPurchased());
			} catch (IOException e) {
				e.printStackTrace();
			}
			  break;
		  case "GetCounterBooksBySubject":
			  try {
				client.sendToClient(controllers.ManagerController.GetCounterBooksBySubject((Integer)message.getParameters().get(0)));
			} catch (IOException e) {
				e.printStackTrace();
			}
			  break;
		  case "GetAllUsers":
			  try {
				client.sendToClient(controllers.ManagerController.GetAllUsers());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			  break;
		  case "UpDateStatusUser":
			  controllers.ManagerController.UpDateStatusUser((int)message.getParameters().get(0), (int)message.getParameters().get(1));
			  break;
		  }
		  break;
		  
	  case "ServerMessage":
		  switch(action)
		  {
		  case "NewUser":
			  this.sendToAllClients(msg);
			  break;
			  
		  case "NewAccount":
			  this.sendToAllClients(msg);
			  break;
			  
		  case "CustomerChangeType":
			  this.sendToAllClients(msg);
			  break;
			  
		  case "NewReview":
			  this.sendToAllClients(msg);
			  break;
		  
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
