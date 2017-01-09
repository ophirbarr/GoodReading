package client;

import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BookreviewGUI extends JPanel {
	
	private ClientInterface clientInterface;
	
	
	public BookreviewGUI(ClientInterface clientInterface){
		super();
		this.clientInterface = clientInterface;
		setLayout(null);
		
		JButton btnReject = new JButton("Reject");
		btnReject.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnReject.setBounds(332, 79, 118, 23);
		add(btnReject);
		
		JButton btnPublish = new JButton("Publish");
		btnPublish.setBounds(332, 11, 118, 23);
		add(btnPublish);
		
		JButton btnPublish_partially = new JButton("Publish partially");
		btnPublish_partially.setBounds(332, 45, 118, 23);
		add(btnPublish_partially);
		
	}
}
