package client;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.border.EtchedBorder;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JScrollPane;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.event.ChangeListener;

import common.Message;
import controllers.BookController;
import good_reading.Book;
import good_reading.Domain;
import good_reading.Subject;

import javax.swing.event.ChangeEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.awt.event.ActionEvent;

public class ManageDatabaseGUI extends JPanel
{
	private ClientInterface clientInterface;
	private ArrayList<Object> result;
	private JTextField searchTitle;
	private JTextField searchAuthor;
	private JTextField searchLanguage;
	private JTextField searchPrice;
	private JTextField searchKeyword;
	private JTextField searchSubject;
	private JTextField searchDomain;
	private JButton btnAdd;
	private JButton btnEdit;
	private JButton btnDelete;
	
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
		scrollPane.setBounds(22, 274, 630, 152);
		add(scrollPane);
		
		DefaultListModel<String> listModel = new DefaultListModel<String>();
		JList<String> list = new JList<String>( listModel );
		list.setFont( new Font("monospaced", Font.PLAIN, 14) );
		scrollPane.setViewportView(list);
		
		JLabel lblResultTitle = new JLabel("ID            Title                                                                  Language            Price           Summary");
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
		chckbxTitle.setFont(new Font("Tahoma", Font.PLAIN, 11));
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
		chckbxAuthor.setFont(new Font("Tahoma", Font.PLAIN, 11));
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
		chckbxLanguage.setFont(new Font("Tahoma", Font.PLAIN, 11));
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
		chckbxPrice.setFont(new Font("Tahoma", Font.PLAIN, 11));
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
		chckbxKeyword.setFont(new Font("Tahoma", Font.PLAIN, 11));
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
		chckbxSubject.setFont(new Font("Tahoma", Font.PLAIN, 11));
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
		chckbxDomain.setFont(new Font("Tahoma", Font.PLAIN, 11));
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
	
		
		JButton btnDisplayBook = new JButton("DISPLAY BOOK");
		btnDisplayBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				if (list.getSelectedIndex() != -1 && !list.getSelectedValue().equals("There are no matching results to your query."))
				{
					int i = list.getSelectedIndex();
					BookController.ViewBook(clientInterface, (Book)result.get(i));
				}
			}
		});
		btnDisplayBook.setBounds(527, 437, 125, 23);
		add(btnDisplayBook);
		
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
		
		rdbtnBooks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				if (rdbtnBooks.isSelected())
				{
					rdbtnSubjects.setSelected(false);
					rdbtnDomains.setSelected(false);
					chckbxTitle.setEnabled(true); 		chckbxTitle.setSelected(true);
					chckbxAuthor.setEnabled(true);		chckbxAuthor.setSelected(false);
					chckbxLanguage.setEnabled(true);	chckbxLanguage.setSelected(false);
					chckbxPrice.setEnabled(true);		chckbxPrice.setSelected(false);
					chckbxKeyword.setEnabled(true);		chckbxKeyword.setSelected(false);
					chckbxSubject.setEnabled(true);		chckbxSubject.setSelected(false);
					chckbxDomain.setEnabled(true);		chckbxDomain.setSelected(false);
					btnDisplayBook.setEnabled(true);
					chckbxSubject.setFont(new Font("Tahoma", Font.PLAIN, 11));
					chckbxDomain.setFont(new Font("Tahoma", Font.PLAIN, 11));
					btnAdd.setText("ADD NEW BOOK");
					lblResultTitle.setText("ID            Title                                                                  Language            Price           Summary");
					listModel.clear();
				}
				else rdbtnBooks.setSelected(true);
			}
		});
		rdbtnSubjects.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				if (rdbtnSubjects.isSelected())
				{
					rdbtnBooks.setSelected(false);
					rdbtnDomains.setSelected(false);
					chckbxTitle.setEnabled(false); 		chckbxTitle.setSelected(false);
					chckbxAuthor.setEnabled(false);		chckbxAuthor.setSelected(false);
					chckbxLanguage.setEnabled(false);	chckbxLanguage.setSelected(false);
					chckbxPrice.setEnabled(false);		chckbxPrice.setSelected(false);
					chckbxKeyword.setEnabled(false);	chckbxKeyword.setSelected(false);
					chckbxSubject.setEnabled(false);	chckbxSubject.setSelected(true);
					chckbxDomain.setEnabled(false);		chckbxDomain.setSelected(false);
					btnDisplayBook.setEnabled(false);
					chckbxSubject.setFont(new Font("Tahoma", Font.BOLD, 12));
					chckbxDomain.setFont(new Font("Tahoma", Font.PLAIN, 11));
					btnAdd.setText("ADD NEW SUBJECT");
					lblResultTitle.setText("SID          Name                                  DID");
					listModel.clear();
				}
				else rdbtnSubjects.setSelected(true);
			}
		});
		rdbtnDomains.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				if (rdbtnDomains.isSelected())
				{
					rdbtnBooks.setSelected(false);
					rdbtnSubjects.setSelected(false);
					chckbxTitle.setEnabled(false); 		chckbxTitle.setSelected(false);
					chckbxAuthor.setEnabled(false);		chckbxAuthor.setSelected(false);
					chckbxLanguage.setEnabled(false);	chckbxLanguage.setSelected(false);
					chckbxPrice.setEnabled(false);		chckbxPrice.setSelected(false);
					chckbxKeyword.setEnabled(false);	chckbxKeyword.setSelected(false);
					chckbxSubject.setEnabled(false);	chckbxSubject.setSelected(false);
					chckbxDomain.setEnabled(false);		chckbxDomain.setSelected(true);
					btnDisplayBook.setEnabled(false);
					chckbxSubject.setFont(new Font("Tahoma", Font.PLAIN, 11));
					chckbxDomain.setFont(new Font("Tahoma", Font.BOLD, 12));
					btnAdd.setText("ADD NEW DOMAIN");
					lblResultTitle.setText("DID         Name");
					listModel.clear();
				}
				else rdbtnDomains.setSelected(true);
			}
		});
		
		btnAdd = new JButton("ADD NEW BOOK");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				int listIndex = list.getSelectedIndex();
				if (rdbtnBooks.isSelected())  // ADD BOOK
				{
					Message msg = new Message("AddBook", "DatabaseManagementController");
					try {
						clientInterface.client.openConnection();
						clientInterface.client.sendToServer(msg);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					clientInterface.waitForServer();
					Book book = (Book)clientInterface.getMsgFromServer();
					clientInterface.mainPanel.remove(clientInterface.mainPanel.currentPanel);
					clientInterface.mainPanel.currentPanel = new EditBookGUI(clientInterface, book);
					clientInterface.mainPanel.currentPanel.setBounds(176, 1, 724, 475);
					clientInterface.mainPanel.currentPanel.setBackground(new Color(250, 243, 232));
					clientInterface.mainPanel.add(clientInterface.mainPanel.currentPanel);
					clientInterface.mainPanel.currentPanel.setLayout(null);
					clientInterface.mainPanel.currentPanel.revalidate();
					clientInterface.mainPanel.currentPanel.repaint();
				}
				else if (rdbtnSubjects.isSelected())  // ADD SUBJECT
				{
					Message msg = new Message("GetAllDomains", "DatabaseManagementController");
					try {
						clientInterface.client.openConnection();
						clientInterface.client.sendToServer(msg);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					clientInterface.waitForServer();
					Domain[] domains = (Domain[]) clientInterface.getMsgFromServer();
					String[] domain_names;
					if (domains != null)
					{
						domain_names = new String[domains.length + 1];
						for (int i = 0; i < domains.length; i++)
							domain_names[i + 1] = domains[i].get_name();
					}
					else 
						domain_names = new String[1];
					domain_names[0] = "[NONE]";
						
				    JComboBox combo = new JComboBox(domain_names);
				    JTextField fieldEditName = new JTextField("New Subject");
				    JPanel panel = new JPanel(new GridLayout(0, 1));
				    panel.add(new JLabel("Subject name:"));
				    panel.add(fieldEditName);
				    panel.add(new JLabel("Choose domain for subject:"));
				    panel.add(combo);
				    if (JOptionPane.showConfirmDialog(null, panel, "Database Management", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE) == 0)
				    {
				    	int index = combo.getSelectedIndex();
				    	int did;
				    	if (index == 0 || domains == null) did = -1;
				    	else did = domains[index - 1].get_did();
				    	String name = fieldEditName.getText();
				    	
				    	msg = new Message("AddSubjectDomain", "DatabaseManagementController");
				    	msg.add(0);
				    	msg.add(did);
				    	msg.add(name);
				    	try {
				    		clientInterface.client.openConnection();
				    		clientInterface.client.sendToServer(msg);
						} catch (IOException e1) {
							e1.printStackTrace();
						}
				    }
					
				}
				else if (rdbtnDomains.isSelected())  // ADD DOMAIN
				{
					Message msg = new Message("AddSubjectDomain", "DatabaseManagementController");
					msg.add(1);
					String name = (String)JOptionPane.showInputDialog(null, "Domain name:", "Database Management", JOptionPane.QUESTION_MESSAGE, null, null, "New Domain");
			    	msg.add(name);
			    	if (name != null && !name.equals(""))
			    	{
			    		try {
				    		clientInterface.client.openConnection();
				    		clientInterface.client.sendToServer(msg);
						} catch (IOException e1) {
							e1.printStackTrace();
						}
			    	}		
				}
			}
		});
		btnAdd.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAdd.setBounds(240, 437, 156, 23);
		add(btnAdd);
		
		btnDelete = new JButton("DELETE");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				int listIndex = list.getSelectedIndex();
				Message msg = new Message("DeleteItem", "DatabaseManagementController");
				if (rdbtnBooks.isSelected() && listIndex != -1)  // DEELTE BOOK
				{
					msg.add(0);
					msg.add(((Book) result.get(listIndex)).get_bid());
				}
				else if (rdbtnSubjects.isSelected() && listIndex != -1)  // DELETE SUBJECT
				{
					msg.add(1);
					msg.add(((Subject) result.get(listIndex)).get_sid());
				}
				else if (rdbtnDomains.isSelected() && listIndex != -1)  // DELETE DOMAIN
				{
					msg.add(2);
					msg.add(((Domain) result.get(listIndex)).get_did());
				}
				else msg = null;
				
				if (msg != null)
				{
					try {
						clientInterface.client.openConnection();
						clientInterface.client.sendToServer(msg);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					clientInterface.waitForServer();
					
					if ((boolean) clientInterface.getMsgFromServer())
					{
						result.remove(listIndex);
						listModel.remove(listIndex);
					}
					else
					{
						if (rdbtnBooks.isSelected())
							JOptionPane.showMessageDialog(null, "Something went wrong!");
						else if (rdbtnDomains.isSelected())
							JOptionPane.showMessageDialog(null, "ERROR: Subject contains books and cannot be removed");
						else if (rdbtnSubjects.isSelected())
							JOptionPane.showMessageDialog(null, "ERROR: Domain contains subjects and cannot be removed");
					}
				}
				
			}
		});
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnDelete.setBounds(137, 437, 93, 23);
		add(btnDelete);
		
		btnEdit = new JButton("EDIT");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				if (rdbtnBooks.isSelected() && list.getSelectedIndex() != -1)  // EDIT BOOK
				{
					int i = list.getSelectedIndex();
					clientInterface.mainPanel.remove(clientInterface.mainPanel.currentPanel);
					clientInterface.mainPanel.currentPanel = new EditBookGUI(clientInterface, (Book)result.get(i));
					clientInterface.mainPanel.currentPanel.setBounds(176, 1, 724, 475);
					clientInterface.mainPanel.currentPanel.setBackground(new Color(250, 243, 232));
					clientInterface.mainPanel.add(clientInterface.mainPanel.currentPanel);
					clientInterface.mainPanel.currentPanel.setLayout(null);
					clientInterface.mainPanel.currentPanel.revalidate();
					clientInterface.mainPanel.currentPanel.repaint();
				}
				else if (rdbtnSubjects.isSelected() && list.getSelectedIndex() != -1)  // EDIT SUBJECT
				{
					int listIndex = list.getSelectedIndex();
					Message msg = new Message("GetAllDomains", "DatabaseManagementController");
					try {
						clientInterface.client.openConnection();
						clientInterface.client.sendToServer(msg);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					clientInterface.waitForServer();
					Domain[] domains = (Domain[]) clientInterface.getMsgFromServer();
					String[] domain_names;
					int defaultCombo = 0;
					if (domains != null)
					{
						domain_names = new String[domains.length + 1];
						for (int i = 0; i < domains.length; i++)
						{
							domain_names[i + 1] = domains[i].get_name();
							if (domains[i].get_did() == ((Subject) result.get(listIndex)).get_did())
								defaultCombo = i + 1;
						}
					}
					else 
						domain_names = new String[1];
					domain_names[0] = "[NONE]";
						
				    JComboBox combo = new JComboBox(domain_names);
				    combo.setSelectedIndex(defaultCombo);
				    JTextField fieldEditName = new JTextField(((Subject) result.get(listIndex)).get_name());
				    JPanel panel = new JPanel(new GridLayout(0, 1));
				    panel.add(new JLabel("Edit subject name:"));
				    panel.add(fieldEditName);
				    panel.add(new JLabel("Choose domain for subject:"));
				    panel.add(combo);
				    if (JOptionPane.showConfirmDialog(null, panel, "Database Management", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE) == 0)
				    {
				    	int index = combo.getSelectedIndex();
				    	int did;
				    	if (index == 0 || domains == null) did = -1;
				    	else did = domains[index - 1].get_did();
				    	String name = fieldEditName.getText();
				    	
				    	msg = new Message("EditSubjectDomain", "DatabaseManagementController");
				    	msg.add(0);
				    	msg.add(((Subject) result.get(listIndex)).get_sid());
				    	msg.add(did);
				    	msg.add(name);
				    	try {
				    		clientInterface.client.openConnection();
				    		clientInterface.client.sendToServer(msg);
						} catch (IOException e1) {
							e1.printStackTrace();
						}
				    	// update result and list
				    	((Subject) result.get(listIndex)).set_did(did);
				    	((Subject) result.get(listIndex)).set_name(name);
				    	listModel.set(listIndex, String.format("%-6d%-17s%d", ((Subject) result.get(listIndex)).get_sid(), ((Subject) result.get(listIndex)).get_name(), ((Subject) result.get(listIndex)).get_did()));
				    }
				}
				else if (rdbtnDomains.isSelected() && list.getSelectedIndex() != -1)  // EDIT DOMAIN
				{
					int listIndex = list.getSelectedIndex();
					Message msg = new Message("EditSubjectDomain", "DatabaseManagementController");
					String name = (String)JOptionPane.showInputDialog(null, "Edit domain name:", "Database Management", JOptionPane.QUESTION_MESSAGE, null, null, ((Domain) result.get(listIndex)).get_name());
			    	msg.add(1);
			    	msg.add(((Domain) result.get(listIndex)).get_did());
			    	msg.add(name);
			    	
			    	if (name != null && !name.equals(""))
			    	{
			    		try {
				    		clientInterface.client.openConnection();
				    		clientInterface.client.sendToServer(msg);
						} catch (IOException e1) {
							e1.printStackTrace();
						}
				    	// update result and list
				    	((Domain) result.get(listIndex)).set_name(name);
				    	listModel.set(listIndex, String.format("%-6d%-17s", ((Domain) result.get(listIndex)).get_did(), ((Domain) result.get(listIndex)).get_name()));
			    	}	
				}
			}
		});
		btnEdit.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnEdit.setBounds(22, 437, 100, 23);
		add(btnEdit);
		
		JButton btnSearch = new JButton("SEARCH");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				if (rdbtnBooks.isSelected())
				{
					String action = new String("SearchBooks");
					Message msg = new Message(action, "SystemUserController");
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
					msg.add(false); // search in entire DB
					try {
						clientInterface.client.openConnection();
						clientInterface.client.sendToServer(msg);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					clientInterface.waitForServer();
					//result = (Object[]) clientInterface.getMsgFromServer();
					result = new ArrayList<Object>(Arrays.asList((Object[])clientInterface.getMsgFromServer()));
					listModel.clear();
					for (Object book : result)
						listModel.addElement(String.format("%-6d%-28s%-11s%-8.2f%s", ((Book)book).get_bid(), ((Book)book).get_title(), ((Book)book).get_language(), ((Book)book).get_price(), ((Book)book).get_summary()));
					if (result.size() == 0) listModel.addElement("There are no matching results to your query.");
				}
				
				else if (rdbtnSubjects.isSelected() && !searchSubject.getText().equals(""))
				{
					Message msg = new Message("GetSubjects", "DatabaseManagementController");
					msg.add(searchSubject.getText());
					try {
						clientInterface.client.openConnection();
						clientInterface.client.sendToServer(msg);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					clientInterface.waitForServer();
					
					//result = (Object[]) clientInterface.getMsgFromServer();
					result = new ArrayList<Object>(Arrays.asList((Object[])clientInterface.getMsgFromServer()));

					listModel.clear();
					for (Object subject : result)
						listModel.addElement(String.format("%-6d%-17s%d", ((Subject) subject).get_sid(), ((Subject) subject).get_name(), ((Subject) subject).get_did()));
					if (result.size() == 0) listModel.addElement("There are no matching results to your query.");	
				}
				
				else if (rdbtnDomains.isSelected() && !searchDomain.getText().equals(""))
				{
					Message msg = new Message("GetDomains", "DatabaseManagementController");
					msg.add(searchSubject.getText());
					try {
						clientInterface.client.openConnection();
						clientInterface.client.sendToServer(msg);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					clientInterface.waitForServer();
					
					//result = (Object[]) clientInterface.getMsgFromServer();
					result = new ArrayList<Object>(Arrays.asList((Object[])clientInterface.getMsgFromServer()));
					listModel.clear();
					for (Object domain : result)
						listModel.addElement(String.format("%-6d%-17s", ((Domain) domain).get_did(), ((Domain) domain).get_name()));
					if (result.size() == 0) listModel.addElement("There are no matching results to your query.");	
				}
			}
		});
		btnSearch.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSearch.setBounds(339, 143, 100, 57);
		add(btnSearch);
		
		JButton btnShowAll = new JButton("SHOW ALL");
		btnShowAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				if (rdbtnBooks.isSelected())
				{
					Message msg = new Message("GetAllBooks", "SystemUserController");
					msg.add(false); // search in entire DB
					try {
						clientInterface.client.openConnection();
						clientInterface.client.sendToServer(msg);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					clientInterface.waitForServer();
					
					//result = (Book[])clientInterface.getMsgFromServer();
					result = new ArrayList<Object>(Arrays.asList((Object[])clientInterface.getMsgFromServer()));
					listModel.clear();
					for (Object book : result)
						listModel.addElement(String.format("%-6d%-28s%-11s%-8.2f%s", ((Book)book).get_bid(), ((Book)book).get_title(), ((Book)book).get_language(), ((Book)book).get_price(), ((Book)book).get_summary()));
				}
				
				else if (rdbtnSubjects.isSelected())
				{
					Message msg = new Message("GetAllSubjects", "DatabaseManagementController");
					try {
						clientInterface.client.openConnection();
						clientInterface.client.sendToServer(msg);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					clientInterface.waitForServer();
					
					//result = (Subject[])clientInterface.getMsgFromServer();
					result = new ArrayList<Object>(Arrays.asList((Object[])clientInterface.getMsgFromServer()));
					listModel.clear();
					for (Object subject : result)
						listModel.addElement(String.format("%-6d%-17s%d", ((Subject) subject).get_sid(), ((Subject) subject).get_name(), ((Subject) subject).get_did()));
					if (result.size() == 0) listModel.addElement("There are no matching results to your query.");	
				}
				
				else if (rdbtnDomains.isSelected())
				{
					Message msg = new Message("GetAllDomains", "DatabaseManagementController");
					try {
						clientInterface.client.openConnection();
						clientInterface.client.sendToServer(msg);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					clientInterface.waitForServer();
					
					//result = (Domain[])clientInterface.getMsgFromServer();
					result = new ArrayList<Object>(Arrays.asList((Object[])clientInterface.getMsgFromServer()));
					listModel.clear();
					for (Object domain : result)
						listModel.addElement(String.format("%-6d%-17s", ((Domain) domain).get_did(), ((Domain) domain).get_name()));
					if (result.size() == 0) listModel.addElement("There are no matching results to your query.");	
				}
			}
		});
		btnShowAll.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnShowAll.setBounds(339, 211, 100, 27);
		add(btnShowAll);
		
		JPanel imagePanel = new JPanel();
		imagePanel.setBackground(new Color(250, 243, 232));
		imagePanel.setBounds(-79, -25, 907, 649);
		add(imagePanel);
		
	}
}
