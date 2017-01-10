package common;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * 
 * A message object sent to server from client
 * For example:
 * 		Message msg = new Message("get_user_id");
 * 		msg.add(123);
 * 		client.handleMessageFromClientUI(msg);
 * 
 * @param action A string code through which the server knows what action to perform
 * @param controller A string code through which the server knows what controller the action is stored in
 * @param parameters The parameters of the above action
 *
 */
public class Message implements Serializable
{
	private String action;
	private String controller;
	private ArrayList<String> parameters;
	
	// constructor 
	public Message(String action, String controller)
	{
		parameters = new ArrayList<String>();
		this.action = action; 
		this.controller = controller;
	}
	
	// add parameters with this method
	public void add(String param)
	{
		parameters.add(param);
	}
	
	public String getAction()
	{
		return action;
	}
	
	public String getController()
	{
		return controller;
	}
	
	public ArrayList<String> getParameters()
	{
		return parameters;
	}
}

