package common;

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
 * @param parameters The parameters of the above action
 *
 */
public class Message 
{
	private String action;
	private ArrayList<String> parameters;
	
	// constructor 
	public Message(String action)
	{
		parameters = new ArrayList<String>();
		this.action = action; 
	}
	
	// add parameters with this method
	public void add(String param)
	{
		parameters.add(param);
	}
}

