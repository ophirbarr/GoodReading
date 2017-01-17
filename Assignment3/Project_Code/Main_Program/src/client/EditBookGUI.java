package client;

import javax.swing.JPanel;
import good_reading.Book;
import good_reading.Worker;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.io.IOException;
import javax.swing.border.LineBorder;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import common.Message;
import javax.swing.JList;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EditBookGUI extends JPanel
{
	private ClientInterface clientInterface;
	private Book book;
	private JTextField textId;
	private JTextField textTitle;
	private JTextField textLanguage;
	private JTextField textSummary;
	private JTextField textToC;
	private JTextField textPrice;
	private JTextField textDownloadPath;
	
	public EditBookGUI(ClientInterface clientInterface, Book book)
	{
		super();
		setBackground(new Color(253, 245, 230));
		this.clientInterface = clientInterface;
		this.book = book;
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(10, 29, 496, 434);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblId = new JLabel("ID:");
		lblId.setBounds(10, 11, 61, 14);
		panel.add(lblId);
		
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
		
		textId = new JTextField();
		textId.setEditable(false);
		textId.setBounds(117, 8, 225, 20);
		panel.add(textId);
		textId.setColumns(10);
		
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
		if (((Worker)clientInterface.user).get_role() != "Manager") chckbxCataloged.setEnabled(false);
		chckbxCataloged.setBounds(117, 185, 97, 23);
		panel.add(chckbxCataloged);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		tabbedPane.setBounds(10, 219, 332, 202);
		panel.add(tabbedPane);
		
		JList listAuthors = new JList();
		tabbedPane.addTab("Authors", null, listAuthors, null);
		
		JList listSubjects = new JList();
		tabbedPane.addTab("Subjects", null, listSubjects, null);
		
		JList listKeywords = new JList();
		tabbedPane.addTab("Keywords", null, listKeywords, null);
		
		JButton btnApply = new JButton("APPLY");
		btnApply.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnApply.setBounds(352, 7, 104, 73);
		panel.add(btnApply);
		
		JButton btnAdd = new JButton("Add Author");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAdd.setBounds(352, 364, 121, 23);
		panel.add(btnAdd);
		
		JButton btnRemove = new JButton("Remove Author");
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnRemove.setBounds(352, 398, 121, 23);
		panel.add(btnRemove);
		
		JLabel lblBookProperties = new JLabel("BOOK PROPERTIES");
		lblBookProperties.setBounds(10, 11, 119, 14);
		add(lblBookProperties);
		lblBookProperties.setFont(new Font("Tahoma", Font.BOLD, 11));
	}
}
