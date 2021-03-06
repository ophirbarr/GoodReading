package systemUser;

import javax.swing.JPanel;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.border.EtchedBorder;
import javax.swing.event.ChangeListener;

import book.viewReviewGUI;
import client.ClientInterface;
import common.Define;
import common.Message;
import controllers.BookController;
import good_reading.Book;
import good_reading.BookReview;
import javax.swing.event.ChangeEvent;
import javax.swing.JScrollPane;
import java.awt.Color;
import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

/**
 * GUI class for searching either books or reviews.
 * @author ophir
 *
 */
public class SearchBookGUI extends JPanel
{
	private ClientInterface clientInterface;
	
	JRadioButton rdbtnBook;
	JRadioButton rdbtnReview;
	private final JScrollPane scrollPane = new JScrollPane();
	private Object[] result;
	private ArrayList<BookReview[]> reviewsArr;
	private JTextField searchTitle;
	private JTextField searchAuthor;
	private JTextField searchLanguage;
	private JTextField searchPrice;
	private JTextField searchKeyword;
	private JTextField searchSubject;
	private JTextField searchDomain;
	private JLabel lblResultTitle;
	private JButton btnDisplay;
	private DefaultListModel<String> listModel;

	
	public SearchBookGUI(ClientInterface clientInterface)
	{
		super();
		setBackground(Color.WHITE);
		this.clientInterface = clientInterface;
		
		setLayout(null);
		
		JPanel radioPanel = new JPanel();
		radioPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		radioPanel.setBounds(331, 49, 100, 64);
		add(radioPanel);
		radioPanel.setLayout(null);
		
		rdbtnBook = new JRadioButton("books");
		rdbtnBook.setSelected(true);
		rdbtnBook.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) 
			{
				if (rdbtnBook.isSelected() && rdbtnReview.isSelected())
				{
					rdbtnReview.setSelected(false);
					lblResultTitle.setText("ID            Title                                                                  Language            Price           Summary");
					btnDisplay.setText("DISPLAY BOOK");
					searchAll();
				}
				else if (!rdbtnBook.isSelected() && !rdbtnReview.isSelected())
				{
					rdbtnBook.setSelected(true);
				}
			}
		});
		rdbtnBook.setBounds(6, 7, 72, 23);
		radioPanel.add(rdbtnBook);
		
		rdbtnReview = new JRadioButton("reviews");
		rdbtnReview.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) 
			{
				if (rdbtnBook.isSelected() && rdbtnReview.isSelected())
				{
					rdbtnBook.setSelected(false);
					lblResultTitle.setText("ID            Title                                                       Reviewer's Name");
					btnDisplay.setText("DISPLAY REVIEW");
					searchAll();
				}
				else if (!rdbtnBook.isSelected() && !rdbtnReview.isSelected())
				{
					rdbtnReview.setSelected(true);
				}
			}
		});
		rdbtnReview.setBounds(6, 33, 72, 23);
		radioPanel.add(rdbtnReview);
		
		JLabel lblIWantTo = new JLabel("Display...");
		lblIWantTo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblIWantTo.setBounds(331, 20, 93, 23);
		add(lblIWantTo);
		
		scrollPane.setBounds(23, 275, 608, 152);
		add(scrollPane);

		listModel = new DefaultListModel<String>();
		JList<String> list = new JList<String>( listModel );
		list.setFont( new Font("monospaced", Font.PLAIN, 14) );
		scrollPane.setViewportView(list);
		
		lblResultTitle = new JLabel("ID            Title                                                                  Language            Price           Summary");
		lblResultTitle.setFont(new Font("Tahoma", Font.BOLD, 11));
		scrollPane.setColumnHeaderView(lblResultTitle);
		
		JLabel lblResults = new JLabel("Results:");
		lblResults.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblResults.setBounds(23, 250, 100, 14);
		add(lblResults);
		
		JPanel categoryPanel = new JPanel();
		categoryPanel.setLayout(null);
		categoryPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		categoryPanel.setBounds(23, 49, 282, 196);
		add(categoryPanel);
		
		JCheckBox chckbxTitle = new JCheckBox("Title");
		chckbxTitle.setSelected(true);
		chckbxTitle.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) 
			{
				if (chckbxTitle.isSelected()) searchTitle.setEnabled(true);
				else searchTitle.setEnabled(false);
			}
		});
		chckbxTitle.setBounds(6, 7, 74, 23);
		categoryPanel.add(chckbxTitle);
		
		JCheckBox chckbxAuthor = new JCheckBox("Author");
		chckbxAuthor.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) 
			{
				if (chckbxAuthor.isSelected()) searchAuthor.setEnabled(true);
				else searchAuthor.setEnabled(false);
			}
		});
		chckbxAuthor.setBounds(6, 33, 74, 23);
		categoryPanel.add(chckbxAuthor);
		
		JCheckBox chckbxLanguage = new JCheckBox("Language");
		chckbxLanguage.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) 
			{
				if (chckbxLanguage.isSelected()) searchLanguage.setEnabled(true);
				else searchLanguage.setEnabled(false);
			}
		});
		chckbxLanguage.setBounds(6, 59, 86, 23);
		categoryPanel.add(chckbxLanguage);
		
		JCheckBox chckbxPrice = new JCheckBox("Price");
		chckbxPrice.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) 
			{
				if (chckbxPrice.isSelected()) searchPrice.setEnabled(true);
				else searchPrice.setEnabled(false);
			}
		});
		chckbxPrice.setBounds(6, 86, 65, 23);
		categoryPanel.add(chckbxPrice);
		
		JCheckBox chckbxKeyword = new JCheckBox("Keyword");
		chckbxKeyword.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) 
			{
				if (chckbxKeyword.isSelected()) searchKeyword.setEnabled(true);
				else searchKeyword.setEnabled(false);
			}
		});
		chckbxKeyword.setBounds(6, 112, 86, 23);
		categoryPanel.add(chckbxKeyword);
		
		JCheckBox chckbxSubject = new JCheckBox("Subject");
		chckbxSubject.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) 
			{
				if (chckbxSubject.isSelected()) searchSubject.setEnabled(true);
				else searchSubject.setEnabled(false);
			}
		});
		chckbxSubject.setBounds(6, 138, 74, 23);
		categoryPanel.add(chckbxSubject);
		
		JCheckBox chckbxDomain = new JCheckBox("Domain");
		chckbxDomain.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) 
			{
				if (chckbxDomain.isSelected()) searchDomain.setEnabled(true);
				else searchDomain.setEnabled(false);
			}
		});
		chckbxDomain.setBounds(6, 164, 97, 23);
		categoryPanel.add(chckbxDomain);
		
		searchTitle = new JTextField();
		searchTitle.setBounds(105, 8, 158, 20);
		categoryPanel.add(searchTitle);
		searchTitle.setColumns(10);
		
		searchAuthor = new JTextField();
		searchAuthor.setEnabled(false);
		searchAuthor.setBounds(105, 34, 158, 20);
		categoryPanel.add(searchAuthor);
		searchAuthor.setColumns(10);
		
		searchLanguage = new JTextField();
		searchLanguage.setEnabled(false);
		searchLanguage.setBounds(105, 60, 158, 20);
		categoryPanel.add(searchLanguage);
		searchLanguage.setColumns(10);
		
		searchPrice = new JTextField();
		searchPrice.setEnabled(false);
		searchPrice.setBounds(105, 87, 158, 20);
		categoryPanel.add(searchPrice);
		searchPrice.setColumns(10);
		
		searchKeyword = new JTextField();
		searchKeyword.setEnabled(false);
		searchKeyword.setBounds(105, 113, 158, 20);
		categoryPanel.add(searchKeyword);
		searchKeyword.setColumns(10);
		
		searchSubject = new JTextField();
		searchSubject.setEnabled(false);
		searchSubject.setBounds(105, 139, 158, 20);
		categoryPanel.add(searchSubject);
		searchSubject.setColumns(10);
		
		searchDomain = new JTextField();
		searchDomain.setEnabled(false);
		searchDomain.setBounds(105, 165, 158, 20);
		categoryPanel.add(searchDomain);
		searchDomain.setColumns(10);
		
		JLabel lblByCategory = new JLabel("Search by category...");
		lblByCategory.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblByCategory.setBounds(22, 18, 187, 27);
		add(lblByCategory);
		
		JButton btnSearch = new JButton("SEARCH");
		btnSearch.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				Message msg = new Message("SearchBooks", "SystemUserController");
				boolean[] chkbx = new boolean[7]; 
				String[] searchString = new String[7];
				if (chckbxTitle.isSelected() && !searchTitle.getText().equals("")){
					chkbx[0] = true;
					searchString[0] = searchTitle.getText();
				}
				if (chckbxLanguage.isSelected() && !searchLanguage.getText().equals("")){
					chkbx[1] = true;
					searchString[1] = searchLanguage.getText();
				}
				if (chckbxPrice.isSelected() && !searchPrice.getText().equals("")){
					chkbx[2] = true;
					searchString[2] = searchPrice.getText();
				}
				if (chckbxAuthor.isSelected() && !searchAuthor.getText().equals("")){
					chkbx[3] = true;
					searchString[3] = searchAuthor.getText();
				}
				if (chckbxKeyword.isSelected() && !searchKeyword.getText().equals("")){
					chkbx[4] = true;
					searchString[4] = searchKeyword.getText();
				}
				if (chckbxSubject.isSelected() && !searchSubject.getText().equals("")){
					chkbx[5] = true;
					searchString[5] = searchSubject.getText();
				}
				if (chckbxDomain.isSelected() && !searchDomain.getText().equals("")){
					chkbx[6] = true;
					searchString[6] = searchDomain.getText();
				}
				msg.add(chkbx);
				msg.add(searchString);
				msg.add(true); // search in catalog	
				try {
					clientInterface.client.openConnection();
					clientInterface.client.sendToServer(msg);
				} catch (IOException e) {
					e.printStackTrace();
				}
				clientInterface.waitForServer();
				result = (Object[]) clientInterface.getMsgFromServer();
				
				if (rdbtnBook.isSelected())
				{
					listModel.clear();
					for (Object book : result)
						listModel.addElement(String.format("%-6d%-28s%-11s%-8.2f%s", ((Book)book).get_bid(), ((Book)book).get_title(), ((Book)book).get_language(), ((Book)book).get_price(), ((Book)book).get_summary()));
					if (result.length == 0) listModel.addElement("There are no matching results to your query.");
				}
				else if (rdbtnReview.isSelected())
				{
					reviewsArr = new ArrayList<BookReview[]>();
					for (int i = 0; i < result.length ; i++)
					{
						msg = new Message("ReadReviews", "SystemUserController");
						msg.add(result[i]);
						try {
							clientInterface.client.openConnection();
							clientInterface.client.sendToServer(msg);
						} catch (IOException e) {
							e.printStackTrace();
						}
						clientInterface.waitForServer();
						reviewsArr.add((BookReview[]) clientInterface.getMsgFromServer());
					}
					listModel.clear();
					for (int i = 0; i < result.length ; i++)
					{
						for (BookReview review : reviewsArr.get(i))
							listModel.addElement(String.format("%-6d%-24s%-11s", review.get_rid(), ((Book) result[i]).get_title(), review.get_costumerName()));
					}
					if (result.length == 0 || listModel.size() == 0) listModel.addElement("There are no matching results to your query.");

				}
			}
		});
		btnSearch.setBounds(331, 124, 100, 57);
		add(btnSearch);
		
		JButton btnShowAll = new JButton("SHOW ALL");
		btnShowAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				searchAll();
			}
		});
		btnShowAll.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnShowAll.setBounds(331, 192, 100, 27);
		add(btnShowAll);
		
		btnDisplay = new JButton("DISPLAY BOOK");
		btnDisplay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				if (list.getSelectedIndex() != -1 && rdbtnBook.isSelected() && !list.getSelectedValue().equals("There are no matching results to your query."))
				{
					int i = list.getSelectedIndex();
						
					// -- ADD TO SEARCH LOG --
					Message msg = new Message("AddToSearchLog", "BookController");
					msg.add(result[i]);
					try {
						clientInterface.client.openConnection();
						clientInterface.client.sendToServer(msg);
					} catch (IOException e) {
						e.printStackTrace();
					}
					// -- ADD TO SEARCH LOG --
						
					BookController.ViewBook(clientInterface, (Book)result[i]);

				}
				else if (list.getSelectedIndex() != -1 && rdbtnReview.isSelected() && !list.getSelectedValue().equals("There are no matching results to your query."))
				{
					BookReview review = null;
					int i = list.getSelectedIndex();
					int rid = Integer.parseInt(list.getSelectedValue().split("\\s+")[0]);
					boolean flag = false;
					for (BookReview[] reviews : reviewsArr)
					{
						for (BookReview r : reviews)
							if (r.get_rid() == rid)
							{
								review = r;
								flag = true;
								break;
							}
						if (flag) break;
					}
					
					if (list.getSelectedIndex() != -1)
					{
						clientInterface.mainPanel.remove(clientInterface.mainPanel.currentPanel);
						clientInterface.mainPanel.currentPanel = new viewReviewGUI(clientInterface, review);
						clientInterface.mainPanel.currentPanel.setBounds(176, 1, 724, 475);
						clientInterface.mainPanel.currentPanel.setBackground(new Color(250, 243, 232));
						clientInterface.mainPanel.add(clientInterface.mainPanel.currentPanel);
						clientInterface.mainPanel.currentPanel.setLayout(null);
						clientInterface.mainPanel.currentPanel.revalidate();
						clientInterface.mainPanel.currentPanel.repaint();
					}

				}
			}
		});
		btnDisplay.setBounds(23, 438, 140, 23);
		add(btnDisplay);
		
		
		JPanel imagePanel = new JPanel();
		imagePanel.setBounds(0, 0, 731, 597);
		imagePanel.setBackground(new Color(250, 243, 232));
		add(imagePanel);
		imagePanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(475, 63, 192, 149);
		imagePanel.add(lblNewLabel);
		lblNewLabel.setIcon(Define.ResizeIcon(SearchBookGUI.class.getResource("/design/g490.png").getPath(), lblNewLabel.getWidth(), lblNewLabel.getHeight()));
		
		searchAll();
	}
	
	// Get all books (or reviews) from catalog
	private void searchAll()
	{
		Message msg = new Message("GetAllBooks", "SystemUserController");
		msg.add(true); // search in catalog
		try {
			clientInterface.client.openConnection();
			clientInterface.client.sendToServer(msg);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		clientInterface.waitForServer();
		result = (Book[])clientInterface.getMsgFromServer();
		listModel.clear();
		
		if (rdbtnBook.isSelected())
		{
			for (Object book : result)
				listModel.addElement(String.format("%-6d%-28s%-11s%-8.2f%s", ((Book)book).get_bid(), ((Book)book).get_title(), ((Book)book).get_language(), ((Book)book).get_price(), ((Book)book).get_summary()));
			if (result.length == 0) listModel.addElement("There are no matching results to your query.");
		}
		else if (rdbtnReview.isSelected())
		{
			// searchAllReviews();
			reviewsArr = new ArrayList<BookReview[]>();
			for (int i = 0; i < result.length ; i++)
			{
				msg = new Message("ReadReviews", "SystemUserController");
				msg.add(result[i]);
				try {
					clientInterface.client.openConnection();
					clientInterface.client.sendToServer(msg);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				clientInterface.waitForServer();
				reviewsArr.add((BookReview[]) clientInterface.getMsgFromServer());
			}
			listModel.clear();
			for (int i = 0; i < result.length ; i++)
			{
				for (BookReview review : reviewsArr.get(i))
					listModel.addElement(String.format("%-6d%-24s%-11s", review.get_rid(), ((Book) result[i]).get_title(), review.get_costumerName()));
			}
			if (result.length == 0 || listModel.size() == 0) listModel.addElement("There are no matching results to your query.");
		}
	}

}
