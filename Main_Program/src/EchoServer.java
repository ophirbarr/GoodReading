// This file contains material supporting section 3.7 of the textbook:
// "Object Oriented Software Engineering" and is issued under the open-source
// license found at www.lloseng.com 

import java.io.*;
import java.util.ArrayList;

import ocsf.server.*;
import org.orm.*;
import personnel.Worker;
import org.hibernate.*;

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
  /*
  public void handleMessageFromClient
    (Object msg, ConnectionToClient client)
  {
	    System.out.println("Message received: " + msg + " from " + client);
	    this.sendToAllClients(msg);   
  }
  */
  
  /**
   * This method handles any messages received from the client.
   *
   * @param msg The message received from the client in a form of an arraylist.
   * @param client The connection from which the message originated.
   */
  public void handleMessageFromClient(Object msg, ConnectionToClient client)
  {
	  ArrayList<String> arrMsg = (ArrayList<String>) msg;
	  System.out.println("##Message received: " + msg + " from " + client);
	  
	  switch(arrMsg.get(0))
	  {
	  case "1": // get worker details //
		try {
			client.sendToClient(getWorkerDetails(Integer.parseInt(arrMsg.get(1))));
		} catch (IOException e) {
			e.printStackTrace();
		}
		  break;
	    	
	  case "2": // set worler's department
		  try {
			client.sendToClient(updateDepartmentForWorker(Integer.parseInt(arrMsg.get(1)), arrMsg.get(2)));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		  break;
	    	
	  default: 
		  try {
			client.sendToClient("Invalid command.\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
	  }
	    
  }
/**
 * Use hibernate to read worker details from database.
 * 
 * @param id key of worker
 * @return string of object worker
 */
  public String getWorkerDetails(int id)
  {
	  PersistentSession con;
	  Worker w;
	  
	  try 
	  {
		con = personnel.GoodReadingPersistentManager.instance().getSession();
		w = personnel.Worker.loadWorkerByORMID(con, id);
		return w.toString();
	  } 
	  catch (PersistentException e) 
	  {
		e.printStackTrace();
		return "Worker #" + id + " was not found in database.\n";
	  }
  }
  
  /**
   * update the department field of a worker
   * @param id key of worker
   * @param dep new department name
   * @return feedback string
   */
  public String updateDepartmentForWorker(int id, String dep)
  {
	  PersistentSession connection;
	  PersistentTransaction transaction;
	  Worker w;
	try {
		connection = personnel.GoodReadingPersistentManager.instance().getSession();
		transaction = connection.beginTransaction();
		w = personnel.Worker.loadWorkerByORMID(connection, id);
		w.setDepartment(dep);

		connection.update(w);
		transaction.commit();
		connection.close();
		return "Done.\n";
		
	} catch (PersistentException e) {
		e.printStackTrace();
		return "Worker #" + id + " was not found in database.\n";
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
