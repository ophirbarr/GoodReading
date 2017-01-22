package client;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

import common.Define;
import common.Message;
import good_reading.Book;

import javax.swing.JList;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;


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
		private JScrollPane scrollPane;
		private JLabel lblPleaseSelectBook;
		private DefaultListModel model;
		private JList list;
		private Book[] book;
		private String action;
		
		public RequestReportGUI(ClientInterface clientInterface){
			super();
			this.clientInterface = clientInterface;
			setLayout(null);
			DefaultListModel model = new DefaultListModel();
			
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
			
			
			
			
			JLabel lblPleaseChooseThe = new JLabel("Please choose the type rating:");
			lblPleaseChooseThe.setVisible(false);
			lblPleaseChooseThe.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblPleaseChooseThe.setBounds(269, 151, 256, 29);
			add(lblPleaseChooseThe);
			
			JButton btnAbsoluteRating = new JButton("Absolute Rating");
			btnAbsoluteRating.setVisible(false);
			btnAbsoluteRating.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					action="Absolute Rating";
					MessgaeToServer("GetAllBooks",0,"SystemUserController");
					book =(Book[]) clientInterface.getMsgFromServer();
					for(int i=0; i<book.length;i++)
						model.addElement(String.format("%-9s%s",book[i].get_bid(),book[i].get_title()));
					
					list.setModel(model);
					scrollPane.setVisible(true);
				}
			});
			btnAbsoluteRating.setFont(new Font("Tahoma", Font.PLAIN, 14));
			btnAbsoluteRating.setBounds(504, 133, 152, 29);
			add(btnAbsoluteRating);
			
		
			JButton btnRatingRelations = new JButton("Rating Relations");
			btnRatingRelations.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					action="Rating Relations";
					MessgaeToServer("GetAllBooks",0,"SystemUserController");
					book =(Book[]) clientInterface.getMsgFromServer();
					for(int i=0; i<book.length;i++)
						model.addElement(String.format("%-9s%s",book[i].get_bid(),book[i].get_title()));
					
					list.setModel(model);
					scrollPane.setVisible(true);
				}
			});
			btnRatingRelations.setVisible(false);
			btnRatingRelations.setFont(new Font("Tahoma", Font.PLAIN, 14));
			btnRatingRelations.setBounds(504, 175, 152, 29);
			add(btnRatingRelations);
		
			
			
			scrollPane = new JScrollPane();
			scrollPane.setBounds(34, 220, 357, 242);
			add(scrollPane);
			scrollPane.setVisible(false);
			
			list = new JList();
			list.addListSelectionListener(new ListSelectionListener() {
				public void valueChanged(ListSelectionEvent e) {
					int index = list.getSelectedIndex();
					int counter;
					
					if(action.equals("Statistical information about book" ))new HistogramGUI(book[index]);
					else if(action.equals("Absolute Rating")){
						MessgaeToServer("GetCounterBooksPurchased",0,"ManagerController");
						counter = (int) clientInterface.getMsgFromServer();
						
						new PopUpMessageGUI(clientInterface.frame,"The popularity of "+book[index].get_title() +" relative to all library books is: "+String.format("%.1f",(book[index].get_purchaseCount()/(double)counter)*100)+"%",Define.Notice);
					}
					else {    //action == Rating Relations
						MessgaeToServer("GetCounterBooksBySubject",book[index].get_bid(),"ManagerController");
						counter = (int) clientInterface.getMsgFromServer();
						new PopUpMessageGUI(clientInterface.frame,"The popularity of "+book[index].get_title() +" relative to all the books at his subject is: "+String.format("%.1f",(book[index].get_purchaseCount()/(double)counter)*100)+"%",Define.Notice);
					}
				}
			});
			list.setFont(new Font("Monospaced", Font.BOLD, 14));
			scrollPane.setViewportView(list);
			
			JLabel lblTittleAuthor = new JLabel("ID:                          Tittle:  ");
			scrollPane.setColumnHeaderView(lblTittleAuthor);
			
			lblPleaseSelectBook = new JLabel("Please Select book about him you want get statistical information:");
			lblPleaseSelectBook.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
			lblPleaseSelectBook.setBounds(34, 191, 471, 29);
			add(lblPleaseSelectBook);
			lblPleaseSelectBook.setVisible(false);
			
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
			
			btnStatisticalInformationAbout = new JButton("Statistical information about book");
			btnStatisticalInformationAbout.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					action ="Statistical information about book";
					btnListAllCustomer.setEnabled(false);
					btnStatisticalInformationAbout.setEnabled(false);
					btnPopularityOfBook.setEnabled(false);
					lblWhichReportsYou.setEnabled(false);
					lblPleaseChooseThe.setVisible(false);
					btnAbsoluteRating.setVisible(false);
					btnRatingRelations.setVisible(false);
					scrollPane.setVisible(true);
					lblPleaseSelectBook.setVisible(true);
					MessgaeToServer("GetAllBooks",0,"SystemUserController");
					book =(Book[]) clientInterface.getMsgFromServer();
					for(int i=0; i<book.length;i++)
						model.addElement(String.format("%-9s%s",book[i].get_bid(),book[i].get_title()));
					
					list.setModel(model);
					
				}
			});
			btnStatisticalInformationAbout.setFont(new Font("Tahoma", Font.PLAIN, 14));
			btnStatisticalInformationAbout.setBounds(10, 93, 256, 43);
			add(btnStatisticalInformationAbout);
			
		}
		public void MessgaeToServer(String action,int bid,String controller){
			Message msg = new Message(action, controller);
			if(action.equals("GetAllBooks"))msg.add(false); // get all books
			else if(action.equals("GetCounterBooksBySubject"))msg.add(bid);
			try {
				clientInterface.client.openConnection();
				clientInterface.client.sendToServer(msg);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			clientInterface.waitForServer();
			
		}
	
		
}
