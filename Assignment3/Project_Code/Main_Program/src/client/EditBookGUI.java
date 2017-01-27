package client;

import javax.swing.JPanel;
import good_reading.Book;
import good_reading.Book_Author;
import good_reading.Book_Keywords;
import good_reading.Subject;
import good_reading.Worker;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.swing.border.LineBorder;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import common.Message;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * GUI class for editing a book. Accessed through database management screen.
 * @author ophir
 *
 */
public class EditBookGUI extends JPanel
{
	private ClientInterface clientInterface;
	private Book book;
	private Message bookDetails;
	private JTextField textBid;
	private JTextField textTitle;
	private JTextField textLanguage;
	private JTextField textSummary;
	private JTextField textToC;
	private JTextField textPrice;
	private JTextField textDownloadPath;
	private JTabbedPane tabbedPane;
	private JButton btnAdd;
	private JButton btnRemove;
	private JList<String> listAuthors;
	private JList<String> listSubjects;
	private JList<String> listKeywords;
	DefaultListModel<String> listAuthorsModel;
	DefaultListModel<String> listSubjectsModel;
	DefaultListModel<String> listKeywordsModel;
	private JTextField textPicPath;
	
	public EditBookGUI(ClientInterface clientInterface, Book book)
	{
		super();
		setBackground(new Color(253, 245, 230));
		this.clientInterface = clientInterface;
		this.book = book;
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(10, 29, 353, 438);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblBid = new JLabel("BID:");
		lblBid.setBounds(10, 11, 61, 14);
		panel.add(lblBid);
		
		JLabel lblTitle = new JLabel("Title:");
		lblTitle.setBounds(10, 36, 61, 14);
		panel.add(lblTitle);
		
		JLabel lblLanguage = new JLabel("Language");
		lblLanguage.setBounds(10, 61, 61, 14);
		panel.add(lblLanguage);
		
		JLabel lblSummary = new JLabel("Summary:");
		lblSummary.setBounds(10, 86, 61, 14);
		panel.add(lblSummary);
		
		JLabel lblTableOfContents = new JLabel("Table of Contents:");
		lblTableOfContents.setBounds(10, 111, 104, 14);
		panel.add(lblTableOfContents);
		
		JLabel lblPrice = new JLabel("Price:");
		lblPrice.setBounds(10, 136, 46, 14);
		panel.add(lblPrice);
		
		JLabel lblDownloadPath = new JLabel("Download Path:");
		lblDownloadPath.setBounds(10, 161, 91, 14);
		panel.add(lblDownloadPath);
		
		textBid = new JTextField();
		textBid.setEditable(false);
		textBid.setBounds(117, 8, 225, 20);
		panel.add(textBid);
		textBid.setColumns(10);
		
		textTitle = new JTextField();
		textTitle.setBounds(117, 33, 225, 20);
		panel.add(textTitle);
		textTitle.setColumns(10);
		
		textLanguage = new JTextField();
		textLanguage.setBounds(117, 58, 225, 20);
		panel.add(textLanguage);
		textLanguage.setColumns(10);
		
		textSummary = new JTextField();
		textSummary.setBounds(117, 83, 225, 20);
		panel.add(textSummary);
		textSummary.setColumns(10);
		
		textToC = new JTextField();
		textToC.setBounds(117, 108, 225, 20);
		panel.add(textToC);
		textToC.setColumns(10);
		
		textPrice = new JTextField();
		textPrice.setBounds(117, 133, 225, 20);
		panel.add(textPrice);
		textPrice.setColumns(10);
		
		textDownloadPath = new JTextField();
		textDownloadPath.setBounds(117, 158, 225, 20);
		panel.add(textDownloadPath);
		textDownloadPath.setColumns(10);
		
		JCheckBox chckbxCataloged = new JCheckBox("Cataloged");
		chckbxCataloged.setEnabled(false);
		if ((clientInterface.user instanceof Worker) && ((Worker)clientInterface.user).get_role().equals("Manager")) chckbxCataloged.setEnabled(true);
		chckbxCataloged.setSelected(book.get_viewStatus());
		chckbxCataloged.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) 
			{
				Message msg;
				if (chckbxCataloged.isSelected()) 
					msg = new Message("AddToCatalog", "ManagerController");
				else 
					msg = new Message("RemoveFromCatalog", "ManagerController");
				msg.add(book.get_bid());
				
				try {
					clientInterface.client.openConnection();
					clientInterface.client.sendToServer(msg);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
		chckbxCataloged.setBounds(10, 207, 97, 23);
		panel.add(chckbxCataloged);
		
		JLabel lblBookProperties = new JLabel("BOOK PROPERTIES");
		lblBookProperties.setBounds(10, 11, 119, 14);
		add(lblBookProperties);
		lblBookProperties.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) 
			{
				if (tabbedPane.getSelectedIndex() == 0)
				{
					btnAdd.setText("Add Author");
					btnRemove.setText("Remove Author");
				}
				else if (tabbedPane.getSelectedIndex() == 1)
				{
					btnAdd.setText("Add Subject");
					btnRemove.setText("Remove Subject");
				}
				else if (tabbedPane.getSelectedIndex() == 2)
				{
					btnAdd.setText("Add Keyword");
					btnRemove.setText("Remove Keyword");
				}
			}
		});
		tabbedPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		tabbedPane.setBounds(9, 251, 332, 149);
		panel.add(tabbedPane);
		
		JLabel label = new JLabel("___________________________________________________________________________________");
		label.setBounds(-25, 226, 507, 14);
		panel.add(label);
		
		btnAdd = new JButton("Add Author");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				Message msg = new Message("AddBookAssociation", "DatabaseManagementController");
				int listIndex = tabbedPane.getSelectedIndex();
				if (listIndex == 0) // add author
				{
					msg.add(0);
					msg.add(JOptionPane.showInputDialog("Enter author name:"));
					msg.add(book.get_bid());
				}
				else if (listIndex == 1) // add subject
				{
					msg.add(1);
					msg.add(JOptionPane.showInputDialog("Enter subject name (MUST be an exsiting subject):"));
					msg.add(book.get_bid());
				}
				else if (listIndex == 2) // remove keyword
				{
					msg.add(2);
					msg.add(JOptionPane.showInputDialog("Enter keyword:"));
					msg.add(book.get_bid());
				}

				if (msg.getParameters().get(1) != null && !msg.getParameters().get(1).equals(""))  // send message and update bookDetails and list
				{
					try {
						clientInterface.client.openConnection();
						clientInterface.client.sendToServer(msg);
						TimeUnit.MILLISECONDS.sleep(100);
						Message msg1 = new Message("GetBookDetails", "DatabaseManagementController");
						msg1.add(book.get_bid());
						clientInterface.client.openConnection();
						clientInterface.client.sendToServer(msg1);
					} catch (IOException | InterruptedException e1) {
						e1.printStackTrace();
					}
					clientInterface.waitForServer();
					bookDetails = (Message) clientInterface.getMsgFromServer();
					
					if (listIndex == 0)
					{
						listAuthorsModel.clear();
						for (Book_Author book_author : (Book_Author[])bookDetails.getParameters().get(0))
							listAuthorsModel.addElement(book_author.get_author());
					}
					else if (listIndex == 1)
					{
						listSubjectsModel.clear();
						for (Subject subject : (Subject[])bookDetails.getParameters().get(1))
							listSubjectsModel.addElement(subject.get_name());
					}
					else if (listIndex == 2)
					{
						listKeywordsModel.clear();
						for (Book_Keywords book_keyword : (Book_Keywords[])bookDetails.getParameters().get(2))
							listKeywordsModel.addElement(book_keyword.get_keyword());
					}
				}

			}
		});
		btnAdd.setBounds(9, 405, 138, 23);
		panel.add(btnAdd);
		
		btnRemove = new JButton("Remove Author");
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				Message msg = new Message("RemoveBookAssociation", "DatabaseManagementController");
				int listIndex = tabbedPane.getSelectedIndex();
				if (listIndex == 0 && listAuthors.getSelectedIndex() != -1) // remove author
				{
					msg.add(0);
					msg.add(((Book_Author[])bookDetails.getParameters().get(0))[listAuthors.getSelectedIndex()]);
				}
				else if (listIndex == 1 && listSubjects.getSelectedIndex() != -1) // remove subject
				{
					msg.add(1);
					msg.add(((Subject[])bookDetails.getParameters().get(1))[listSubjects.getSelectedIndex()]);
					msg.add(book.get_bid());
				}
				else if (listIndex == 2 && listKeywords.getSelectedIndex() != -1) // remove keyword
				{
					msg.add(2);
					msg.add(((Book_Keywords[])bookDetails.getParameters().get(2))[listKeywords.getSelectedIndex()]);
				}
				else msg = null;

				if (msg != null)  // send message and update bookDetails and list
				{
					try {
						clientInterface.client.openConnection();
						clientInterface.client.sendToServer(msg);
						TimeUnit.MILLISECONDS.sleep(100);
						Message msg1 = new Message("GetBookDetails", "DatabaseManagementController");
						msg1.add(book.get_bid());
						clientInterface.client.openConnection();
						clientInterface.client.sendToServer(msg1);
					} catch (IOException | InterruptedException e1) {
						e1.printStackTrace();
					}
					clientInterface.waitForServer();
					bookDetails = (Message) clientInterface.getMsgFromServer();
					
					if (listIndex == 0)
					{
						listAuthorsModel.clear();
						for (Book_Author book_author : (Book_Author[])bookDetails.getParameters().get(0))
							listAuthorsModel.addElement(book_author.get_author());
					}
					else if (listIndex == 1)
					{
						listSubjectsModel.clear();
						for (Subject subject : (Subject[])bookDetails.getParameters().get(1))
							listSubjectsModel.addElement(subject.get_name());
					}
					else if (listIndex == 2)
					{
						listKeywordsModel.clear();
						for (Book_Keywords book_keyword : (Book_Keywords[])bookDetails.getParameters().get(2))
							listKeywordsModel.addElement(book_keyword.get_keyword());
					}
					
				}
				
				
			}
		});
		btnRemove.setBounds(198, 405, 144, 23);
		panel.add(btnRemove);
		
		listAuthorsModel = new DefaultListModel<String>();
		listAuthors = new JList<String>( listAuthorsModel );
		tabbedPane.addTab("Authors", null, listAuthors, null);
		
		listSubjectsModel = new DefaultListModel<String>();
		listSubjects = new JList<String>( listSubjectsModel );
		tabbedPane.addTab("Subjects", null, listSubjects, null);
		
		listKeywordsModel = new DefaultListModel<String>();
		listKeywords = new JList<String>( listKeywordsModel );
		tabbedPane.addTab("Keywords", null, listKeywords, null);
		
		JButton btnExit = new JButton("EXIT");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				clientInterface.mainPanel.remove(clientInterface.mainPanel.currentPanel);
				clientInterface.mainPanel.currentPanel = new ManageDatabaseGUI(clientInterface);
				clientInterface.mainPanel.currentPanel.setBounds(176, 1, 724, 475);
				clientInterface.mainPanel.currentPanel.setBackground(new Color(250, 243, 232));
				clientInterface.mainPanel.add(clientInterface.mainPanel.currentPanel);
				clientInterface.mainPanel.currentPanel.setLayout(null);
				clientInterface.mainPanel.currentPanel.revalidate();
				clientInterface.mainPanel.currentPanel.repaint();
			}
		});
		btnExit.setBounds(251, 206, 91, 24);
		panel.add(btnExit);
		
		JButton btnApply = new JButton("APPLY");
		btnApply.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				Message msg = new Message("EditBook", "DatabaseManagementController");
				book.set_title(textTitle.getText());
				book.set_language(textLanguage.getText());
				book.set_summary(textSummary.getText());
				book.set_TableOfContents(textToC.getText());
				book.set_price(Float.parseFloat(textPrice.getText()));
				book.set_bookFormat(textDownloadPath.getText());
				book.set_picPath(textPicPath.getText());
				msg.add(book);
				
				try {
					clientInterface.client.openConnection();
					clientInterface.client.sendToServer(msg);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				clientInterface.waitForServer();
				if ((boolean)clientInterface.getMsgFromServer())
					JOptionPane.showMessageDialog(clientInterface.frame, "Done.");
				else JOptionPane.showMessageDialog(clientInterface.frame, "Something went wrong!");
			}
		});
		btnApply.setBounds(158, 206, 85, 24);
		panel.add(btnApply);
		btnApply.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		textPicPath = new JTextField();
		textPicPath.setBounds(117, 183, 225, 20);
		panel.add(textPicPath);
		textPicPath.setColumns(10);
		
		Message msg = new Message("GetBookDetails", "DatabaseManagementController");
		msg.add(book.get_bid());
		try {
			clientInterface.client.openConnection();
			clientInterface.client.sendToServer(msg);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		clientInterface.waitForServer();
		bookDetails = (Message) clientInterface.getMsgFromServer();
		
		textBid.setText("" + book.get_bid());
		textTitle.setText(book.get_title());
		textLanguage.setText(book.get_language());
		textSummary.setText(book.get_summary());
		textToC.setText(book.get_TableOfContents());
		textPrice.setText("" + book.get_price());
		textDownloadPath.setText(book.get_bookFormat());
		textPicPath.setText(book.get_picPath());
		
		JLabel lblPicPath = new JLabel("Pic Path:");
		lblPicPath.setBounds(10, 186, 91, 14);
		panel.add(lblPicPath);
		
		for (Book_Author book_author : (Book_Author[])bookDetails.getParameters().get(0))
			listAuthorsModel.addElement(book_author.get_author());
		for (Subject subject : (Subject[])bookDetails.getParameters().get(1))
			listSubjectsModel.addElement(subject.get_name());
		for (Book_Keywords book_keyword : (Book_Keywords[])bookDetails.getParameters().get(2))
			listKeywordsModel.addElement(book_keyword.get_keyword());
	}
}
