package client;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.border.EtchedBorder;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class ManageDatabaseGUI extends JPanel
{
	private ClientInterface clientInterface;
	private JTextField searchTitle;
	private JTextField searchAuthor;
	private JTextField searchLanguage;
	private JTextField searchPrice;
	private JTextField searchKeyword;
	private JTextField searchSubject;
	private JTextField searchDomain;
	
	public ManageDatabaseGUI(ClientInterface clientInterface)
	{
		super();
		this.clientInterface = clientInterface;
		setLayout(null);
		
		
		
		JLabel lblSearchType = new JLabel("Search type");
		lblSearchType.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSearchType.setBounds(339, 13, 116, 23);
		add(lblSearchType);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 274, 520, 152);
		add(scrollPane);
		
		JList list = new JList();
		scrollPane.setViewportView(list);
		
		JLabel lblResultTitle = new JLabel("ID        Title                           Language        Price          Summary");
		lblResultTitle.setFont(new Font("Tahoma", Font.BOLD, 11));
		scrollPane.setColumnHeaderView(lblResultTitle);
		
		JLabel lblResults = new JLabel("Results:");
		lblResults.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblResults.setBounds(22, 249, 100, 14);
		add(lblResults);
		
		JPanel categoryPanel = new JPanel();
		categoryPanel.setLayout(null);
		categoryPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		categoryPanel.setBounds(22, 42, 282, 196);
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
		searchTitle.setColumns(10);
		searchTitle.setBounds(105, 8, 158, 20);
		categoryPanel.add(searchTitle);
		
		searchAuthor = new JTextField();
		searchAuthor.setEnabled(false);
		searchAuthor.setColumns(10);
		searchAuthor.setBounds(105, 34, 158, 20);
		categoryPanel.add(searchAuthor);
		
		searchLanguage = new JTextField();
		searchLanguage.setEnabled(false);
		searchLanguage.setColumns(10);
		searchLanguage.setBounds(105, 60, 158, 20);
		categoryPanel.add(searchLanguage);
		
		searchPrice = new JTextField();
		searchPrice.setEnabled(false);
		searchPrice.setColumns(10);
		searchPrice.setBounds(105, 87, 158, 20);
		categoryPanel.add(searchPrice);
		
		searchKeyword = new JTextField();
		searchKeyword.setEnabled(false);
		searchKeyword.setColumns(10);
		searchKeyword.setBounds(105, 113, 158, 20);
		categoryPanel.add(searchKeyword);
		
		searchSubject = new JTextField();
		searchSubject.setEnabled(false);
		searchSubject.setColumns(10);
		searchSubject.setBounds(105, 139, 158, 20);
		categoryPanel.add(searchSubject);
		
		searchDomain = new JTextField();
		searchDomain.setEnabled(false);
		searchDomain.setColumns(10);
		searchDomain.setBounds(105, 165, 158, 20);
		categoryPanel.add(searchDomain);
		
		JLabel lblSearchParameters = new JLabel("Search parameters");
		lblSearchParameters.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSearchParameters.setBounds(22, 11, 187, 27);
		add(lblSearchParameters);
		
		JButton btnSearch = new JButton("SEARCH");
		btnSearch.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSearch.setBounds(339, 143, 100, 57);
		add(btnSearch);
		
		JButton btnShowAll = new JButton("SHOW ALL");
		btnShowAll.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnShowAll.setBounds(339, 211, 100, 27);
		add(btnShowAll);
		
		JButton btnDisplayBook = new JButton("DISPLAY BOOK");
		btnDisplayBook.setBounds(417, 437, 125, 23);
		add(btnDisplayBook);
		
		JButton btnAdd = new JButton("ADD NEW BOOK");
		btnAdd.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAdd.setBounds(240, 437, 156, 23);
		add(btnAdd);
		
		JButton btnEdit = new JButton("EDIT");
		btnEdit.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnEdit.setBounds(22, 437, 100, 23);
		add(btnEdit);
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnDelete.setBounds(137, 437, 93, 23);
		add(btnDelete);
		
		JPanel typePanel = new JPanel();
		typePanel.setLayout(null);
		typePanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		typePanel.setBounds(339, 42, 100, 90);
		add(typePanel);
		
		JRadioButton rdbtnBooks = new JRadioButton("books");
		rdbtnBooks.setSelected(true);
		rdbtnBooks.setBounds(6, 7, 88, 23);
		typePanel.add(rdbtnBooks);
		
		JRadioButton rdbtnSubjects = new JRadioButton("subjects");
		rdbtnSubjects.setBounds(6, 33, 88, 23);
		typePanel.add(rdbtnSubjects);
		
		JRadioButton rdbtnDomains = new JRadioButton("domains");
		rdbtnDomains.setBounds(6, 60, 88, 23);
		typePanel.add(rdbtnDomains);
		
		JPanel imagePanel = new JPanel();
		imagePanel.setBackground(new Color(250, 243, 232));
		imagePanel.setBounds(-12, -12, 907, 649);
		add(imagePanel);
		
		rdbtnBooks.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) 
			{
				if (rdbtnBooks.isSelected())
				{
					rdbtnSubjects.setSelected(false);
					rdbtnDomains.setSelected(false);
					chckbxTitle.setEnabled(true); 				chckbxTitle.setSelected(true);
					chckbxAuthor.setEnabled(true);				chckbxAuthor.setSelected(false);
					chckbxLanguage.setEnabled(true);			chckbxLanguage.setSelected(false);
					chckbxPrice.setEnabled(true);				chckbxPrice.setSelected(false);
					chckbxKeyword.setEnabled(true);				chckbxKeyword.setSelected(false);
					chckbxSubject.setEnabled(true);				chckbxSubject.setSelected(false);
					chckbxDomain.setEnabled(true);				chckbxDomain.setSelected(false);
					btnDisplayBook.setEnabled(true);
					btnAdd.setText("ADD NEW BOOK");
					lblResultTitle.setText("ID        Title                           Language        Price          Summary");
				}
			}
		});
		rdbtnSubjects.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) 
			{
				if (rdbtnSubjects.isSelected())
				{
					rdbtnBooks.setSelected(false);
					rdbtnDomains.setSelected(false);
					chckbxTitle.setEnabled(false); 				chckbxTitle.setSelected(false);
					chckbxAuthor.setEnabled(false);				chckbxAuthor.setSelected(false);
					chckbxLanguage.setEnabled(false);			chckbxLanguage.setSelected(false);
					chckbxPrice.setEnabled(false);				chckbxPrice.setSelected(false);
					chckbxKeyword.setEnabled(false);			chckbxKeyword.setSelected(false);
					chckbxSubject.setEnabled(false);			chckbxSubject.setSelected(true);
					chckbxDomain.setEnabled(false);				chckbxDomain.setSelected(false);
					btnDisplayBook.setEnabled(false);
					btnAdd.setText("ADD NEW SUBJECT");
					lblResultTitle.setText("SID          Name                         DID");
				}
			}
		});
		rdbtnDomains.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) 
			{
				if (rdbtnDomains.isSelected())
				{
					rdbtnBooks.setSelected(false);
					rdbtnSubjects.setSelected(false);
					chckbxTitle.setEnabled(false); 				chckbxTitle.setSelected(false);
					chckbxAuthor.setEnabled(false);				chckbxAuthor.setSelected(false);
					chckbxLanguage.setEnabled(false);			chckbxLanguage.setSelected(false);
					chckbxPrice.setEnabled(false);				chckbxPrice.setSelected(false);
					chckbxKeyword.setEnabled(false);			chckbxKeyword.setSelected(false);
					chckbxSubject.setEnabled(false);			chckbxSubject.setSelected(false);
					chckbxDomain.setEnabled(false);				chckbxDomain.setSelected(true);
					btnDisplayBook.setEnabled(false);
					btnAdd.setText("ADD NEW DOMAIN");
					lblResultTitle.setText("DID          Name");
				}
			}
		});
	}
}
