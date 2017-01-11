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

public class MessageToClientGUI extends JPanel {
	
	private ClientInterface clientInterface;
	private int rid;
	private String message;
	
	
	public MessageToClientGUI(ClientInterface clientInterface,int rid,String message){
		super();
		this.clientInterface = clientInterface;
		this.rid = rid;
		this.message = message;
		String temp;
		
		setLayout(null);
		if(message == "Publish") temp = "The Review was Published!";
		else if(message == "EraseReview") temp = "The Review was erased!";
		else temp = "The Review was Published partially!";
		PublishReview();
		JLabel lblTheReviewPublished = new JLabel(temp);
		lblTheReviewPublished.setForeground(Color.BLUE);
		lblTheReviewPublished.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblTheReviewPublished.setBounds(64, 36, 305, 80);
		add(lblTheReviewPublished);
		
		Button button = new Button("OK");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 15));
		button.setBounds(139, 131, 108, 45);
		add(button);
		
		
	}
	public void PublishReview(){
		
		Message msg = new Message(message, "BookInspectReview");
		msg.add(rid);
		clientInterface.msgFromServer = null;
		try {
			clientInterface.client.openConnection();
			clientInterface.client.sendToServer(msg);
			} catch (IOException e) {
				e.printStackTrace();
			}
		//System.out.println("debug1");
		clientInterface.waitForServer();
	//	System.out.println("debug2");
			
	}
}
