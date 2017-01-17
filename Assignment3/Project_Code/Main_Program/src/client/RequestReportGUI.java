package client;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class RequestReportGUI extends JPanel{
	
	//Class variables
		private ClientInterface clientInterface;
		private JLabel lblPleaseChooseThe;
		private JButton btnAbsoluteRating;
		private JButton btnRatingRelations;
		private JButton btnListAllCustomer;
		private JButton btnStatisticalInformationAbout;
		private JButton btnPopularityOfBook;
		private JLabel lblWhichReportsYou;
		
		public RequestReportGUI(ClientInterface clientInterface){
			super();
			this.clientInterface = clientInterface;
			setLayout(null);
			
			JLabel lblWhichReportsYou = new JLabel("Which reports do you like to get?");
			lblWhichReportsYou.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
			lblWhichReportsYou.setBounds(10, 11, 396, 37);
			add(lblWhichReportsYou);
			
			btnListAllCustomer = new JButton("List all customer orders");
			btnListAllCustomer.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					clientInterface.mainPanel.remove(clientInterface.mainPanel.currentPanel);
					clientInterface.mainPanel.currentPanel = new CustomerOrderGUI(clientInterface);
					clientInterface.mainPanel.currentPanel.setBounds(176, 1, 724, 475);
					clientInterface.mainPanel.currentPanel.setBackground(new Color(250, 243, 232));
					clientInterface.mainPanel.add(clientInterface.mainPanel.currentPanel);
					clientInterface.mainPanel.currentPanel.setLayout(null);
					clientInterface.mainPanel.currentPanel.revalidate();
					clientInterface.mainPanel.currentPanel.repaint();
				}
			});
			btnListAllCustomer.setFont(new Font("Tahoma", Font.PLAIN, 14));
			btnListAllCustomer.setBounds(10, 45, 256, 37);
			add(btnListAllCustomer);
			
			btnStatisticalInformationAbout = new JButton("Statistical information about book");
			btnStatisticalInformationAbout.setFont(new Font("Tahoma", Font.PLAIN, 14));
			btnStatisticalInformationAbout.setBounds(10, 93, 256, 43);
			add(btnStatisticalInformationAbout);
			
			
			
			JLabel lblPleaseChooseThe = new JLabel("Please choose the type rating:");
			lblPleaseChooseThe.setVisible(false);
			lblPleaseChooseThe.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblPleaseChooseThe.setBounds(10, 231, 256, 29);
			add(lblPleaseChooseThe);
			
			JButton btnAbsoluteRating = new JButton("Absolute Rating");
			btnAbsoluteRating.setVisible(false);
			btnAbsoluteRating.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			btnAbsoluteRating.setFont(new Font("Tahoma", Font.PLAIN, 14));
			btnAbsoluteRating.setBounds(221, 215, 152, 29);
			add(btnAbsoluteRating);
			btnAbsoluteRating.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
		
			JButton btnRatingRelations = new JButton("Rating Relations");
			btnRatingRelations.setVisible(false);
			btnRatingRelations.setFont(new Font("Tahoma", Font.PLAIN, 14));
			btnRatingRelations.setBounds(221, 249, 152, 29);
			add(btnRatingRelations);
		
			btnPopularityOfBook = new JButton("Popularity of book");
			btnPopularityOfBook.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					btnListAllCustomer.setEnabled(false);
					btnStatisticalInformationAbout.setEnabled(false);
					btnPopularityOfBook.setEnabled(false);
					lblWhichReportsYou.setEnabled(false);
					lblPleaseChooseThe.setVisible(true);
					btnAbsoluteRating.setVisible(true);
					btnRatingRelations.setVisible(true);
					
				}
			});
			btnPopularityOfBook.setFont(new Font("Tahoma", Font.PLAIN, 14));
			btnPopularityOfBook.setBounds(10, 147, 256, 37);
			add(btnPopularityOfBook);
			
		}

}
