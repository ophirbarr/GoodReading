package client;

import javax.swing.JPanel;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.border.EtchedBorder;
import javax.swing.event.ChangeListener;

import common.Message;
import good_reading.Book;

import javax.swing.event.ChangeEvent;
import javax.swing.JScrollPane;
import java.awt.Color;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class SearchBookGUI extends JPanel
{
	private ClientInterface clientInterface;
	
	JRadioButton rdbtnBook;
	JRadioButton rdbtnReview;
	private final JScrollPane scrollPane = new JScrollPane();
	private Object[] result;
	private JTextField searchTitle;
	private JTextField searchAuthor;
	private JTextField searchLanguage;
	private JTextField searchPrice;
	private JTextField searchKeyword;
	private JTextField searchSubject;

	
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
		scrollPane.setBounds(22, 252, 520, 178);
		add(scrollPane);
		
		JList list = new JList();
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {"1            MyTitle        Hebrew                59.99          Author1, Author2, Author3", "2            MyTitle        Hebrew                59.99          Author1, Author2, Author3"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		scrollPane.setViewportView(list);
		
		JLabel lblResultTitle = new JLabel("ID          Title           Language          Price          Authors");
		lblResultTitle.setFont(new Font("Tahoma", Font.BOLD, 11));
		scrollPane.setColumnHeaderView(lblResultTitle);
		
		JLabel lblResults = new JLabel("Results:");
		lblResults.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblResults.setBounds(22, 227, 100, 14);
		add(lblResults);
		
		JPanel categoryPanel = new JPanel();
		categoryPanel.setLayout(null);
		categoryPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		categoryPanel.setBounds(23, 49, 282, 171);
		add(categoryPanel);
		
		JCheckBox chckbxTitle = new JCheckBox("Title");
		chckbxTitle.setSelected(true);
		chckbxTitle.setBounds(6, 7, 74, 23);
		categoryPanel.add(chckbxTitle);
		
		JCheckBox chckbxAuthor = new JCheckBox("Author");
		chckbxAuthor.setBounds(6, 33, 74, 23);
		categoryPanel.add(chckbxAuthor);
		
		JCheckBox chckbxLanguage = new JCheckBox("Language");
		chckbxLanguage.setBounds(6, 59, 86, 23);
		categoryPanel.add(chckbxLanguage);
		
		JCheckBox chckbxPrice = new JCheckBox("Price");
		chckbxPrice.setBounds(6, 86, 65, 23);
		categoryPanel.add(chckbxPrice);
		
		JCheckBox chckbxKeyword = new JCheckBox("Keyword");
		chckbxKeyword.setBounds(6, 112, 86, 23);
		categoryPanel.add(chckbxKeyword);
		
		JCheckBox chckbxSubject = new JCheckBox("Subject");
		chckbxSubject.setBounds(6, 138, 74, 23);
		categoryPanel.add(chckbxSubject);
		
		searchTitle = new JTextField();
		searchTitle.setBounds(105, 8, 158, 20);
		categoryPanel.add(searchTitle);
		searchTitle.setColumns(10);
		
		searchAuthor = new JTextField();
		searchAuthor.setBounds(105, 34, 158, 20);
		categoryPanel.add(searchAuthor);
		searchAuthor.setColumns(10);
		
		searchLanguage = new JTextField();
		searchLanguage.setBounds(105, 60, 158, 20);
		categoryPanel.add(searchLanguage);
		searchLanguage.setColumns(10);
		
		searchPrice = new JTextField();
		searchPrice.setBounds(105, 87, 158, 20);
		categoryPanel.add(searchPrice);
		searchPrice.setColumns(10);
		
		searchKeyword = new JTextField();
		searchKeyword.setBounds(105, 113, 158, 20);
		categoryPanel.add(searchKeyword);
		searchKeyword.setColumns(10);
		
		searchSubject = new JTextField();
		searchSubject.setBounds(105, 139, 158, 20);
		categoryPanel.add(searchSubject);
		searchSubject.setColumns(10);
		
		JLabel lblByCategory = new JLabel("Search by category...");
		lblByCategory.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblByCategory.setBounds(22, 18, 187, 27);
		add(lblByCategory);
		
		JButton btnSearch = new JButton("SEARCH");
		btnSearch.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				String action = rdbtnBook.isSelected() ? new String("SearchBooks") : new String("SearchReviews");
				Message msg = new Message(action, "SystemUserController");
				boolean[] chkbx = new boolean[6]; 
				String[] searchString = new String[6];
				if (chckbxTitle.isSelected())
				{
					chkbx[0] = true;
					searchString[0] = searchTitle.getText();
				}
				if (chckbxLanguage.isSelected())
				{
					chkbx[1] = true;
					searchString[1] = searchLanguage.getText();
				}
				if (chckbxPrice.isSelected())
				{
					chkbx[2] = true;
					searchString[2] = searchPrice.getText();

				}
				if (chckbxAuthor.isSelected())
				{
					chkbx[3] = true;
					searchString[3] = searchAuthor.getText();
				}
				if (chckbxKeyword.isSelected())
				{
					chkbx[4] = true;
					searchString[4] = searchKeyword.getText();
				}
				if (chckbxSubject.isSelected())
				{
					chkbx[5] = true;
					searchString[5] = searchSubject.getText();
				}
				msg.add(chkbx);
				msg.add(searchString);
				
				try {
					clientInterface.client.openConnection();
					clientInterface.client.sendToServer(msg);
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				clientInterface.waitForServer();
				
				result = (Object[]) clientInterface.msgFromServer;
				
				


			}
		});
		btnSearch.setBounds(331, 124, 100, 57);
		add(btnSearch);
		
		JButton btnShowAll = new JButton("SHOW ALL");
		btnShowAll.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnShowAll.setBounds(331, 192, 100, 27);
		add(btnShowAll);
		
		
		JPanel imagePanel = new JPanel();
		imagePanel.setBounds(-17, 11, 731, 599);
		imagePanel.setBackground(new Color(250, 243, 232));
		add(imagePanel);
		
	}
}
