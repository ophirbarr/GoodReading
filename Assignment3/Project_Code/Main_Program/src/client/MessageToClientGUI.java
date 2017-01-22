package client;

import java.awt.Color;

import javax.swing.JPanel;

import common.Message;

import javax.swing.JLabel;
import java.awt.Font;
import java.io.IOException;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/**
 * 
 * @author avihai
 *class GUI which displays message that the review published/rejected
 */
@SuppressWarnings("serial")
public class MessageToClientGUI extends JPanel {
	
	private ClientInterface clientInterface;
	private int rid;
	private String typeMessage;
	private String textReview;
	
	/**
	 * constructor
	 * @param clientInterface User Object
	 * @param rid review id
	 * @param typeMessage  type action: Publish || RejectReview
	 * @param textReview  String of the Review
	 */
	public MessageToClientGUI(ClientInterface clientInterface,int rid,String typeMessage,String textReview){
		super();
		this.clientInterface = clientInterface;
		this.rid = rid;
		this.typeMessage = typeMessage;
		this.textReview =textReview;
		String temp;    //the message appears on the screen
		
		setLayout(null);
		if(typeMessage == "PublishReview") temp = "The Review was Published!";
		else temp = "The Review was Rejected!";
		
		Publish_Reject_Review();
		JLabel lblTheReviewPublished = new JLabel(temp);
		lblTheReviewPublished.setForeground(Color.BLUE);
		lblTheReviewPublished.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblTheReviewPublished.setBounds(64, 36, 305, 80);
		add(lblTheReviewPublished);
		
		Button button = new Button("OK");
		button.addActionListener(new ActionListener() {
			/**
			 * OK button Listener - go to previous page
			 */
			public void actionPerformed(ActionEvent e) {
				clientInterface.mainPanel.remove(clientInterface.mainPanel.currentPanel);
				clientInterface.mainPanel.currentPanel = new InspectReviewGUI(clientInterface);
				clientInterface.mainPanel.currentPanel.setBounds(176, 1, 724, 475);
				clientInterface.mainPanel.currentPanel.setBackground(new Color(250, 243, 232));
				clientInterface.mainPanel.add(clientInterface.mainPanel.currentPanel);
				clientInterface.mainPanel.currentPanel.setLayout(null);
				clientInterface.mainPanel.currentPanel.revalidate();
				clientInterface.mainPanel.currentPanel.repaint();
			}
		});
		button.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 15));
		button.setBounds(139, 131, 108, 45);
		add(button);
		
		
	}
	/**
	 * Sends a request to the server 
	 * if typeMessage = RejectReview : erase the review
	 * if typeMessage = Publish : publish the review
	 */
	public void Publish_Reject_Review(){
		
		Message msg = new Message(typeMessage, "InspectReviewController");
		msg.add(rid);
		if(typeMessage == "PublishReview") msg.add(textReview);
		
		clientInterface.msgFromServer = null;
		try {
			clientInterface.client.openConnection();
			clientInterface.client.sendToServer(msg);
			} catch (IOException e) {
				e.printStackTrace();
			}
		
		clientInterface.waitForServer();   // Waiting for approval from the server
		
			
	}
}
