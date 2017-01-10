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
	private JTextField fieldSearch;
	private Object[] result;

	
	public SearchBookGUI(ClientInterface clientInterface)
	{
		super();
		setBackground(Color.WHITE);
		this.clientInterface = clientInterface;
		
		setLayout(null);
		
		JPanel radioPanel = new JPanel();
		radioPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		radioPanel.setBounds(22, 49, 100, 64);
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
		
		JLabel lblIWantTo = new JLabel("I am looking for...");
		lblIWantTo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblIWantTo.setBounds(22, 20, 141, 23);
		add(lblIWantTo);
		scrollPane.setBounds(22, 183, 520, 245);
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
		lblResults.setBounds(22, 158, 100, 14);
		add(lblResults);
		
		JPanel categoryPanel = new JPanel();
		categoryPanel.setLayout(null);
		categoryPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		categoryPanel.setBounds(174, 49, 268, 64);
		add(categoryPanel);
		
		JCheckBox chckbxTitle = new JCheckBox("Title");
		chckbxTitle.setBounds(6, 7, 74, 23);
		categoryPanel.add(chckbxTitle);
		
		JCheckBox chckbxAuthor = new JCheckBox("Author");
		chckbxAuthor.setBounds(6, 33, 74, 23);
		categoryPanel.add(chckbxAuthor);
		
		JCheckBox chckbxLanguage = new JCheckBox("Language");
		chckbxLanguage.setBounds(82, 7, 81, 23);
		categoryPanel.add(chckbxLanguage);
		
		JCheckBox chckbxPrice = new JCheckBox("Price");
		chckbxPrice.setBounds(82, 33, 65, 23);
		categoryPanel.add(chckbxPrice);
		
		JCheckBox chckbxKeyword = new JCheckBox("Keyword");
		chckbxKeyword.setBounds(164, 7, 86, 23);
		categoryPanel.add(chckbxKeyword);
		
		JCheckBox chckbxSubject = new JCheckBox("Subject");
		chckbxSubject.setBounds(164, 33, 74, 23);
		categoryPanel.add(chckbxSubject);
		
		fieldSearch = new JTextField();
		fieldSearch.setBounds(22, 124, 240, 23);
		add(fieldSearch);
		fieldSearch.setColumns(10);
		
		JLabel lblByCategory = new JLabel("By category...");
		lblByCategory.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblByCategory.setBounds(173, 18, 131, 27);
		add(lblByCategory);
		
		JButton btnSearch = new JButton("SEARCH");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				String searchString = new String(fieldSearch.getText());
				String action = rdbtnBook.isSelected() ? new String("SearchBooks") : new String("SearchReviews");
				Message msg = new Message("SystemUserController", action);
				msg.add(searchString);
				
				boolean[] chkbx = new boolean[6]; 
				if (chckbxTitle.isSelected())
					chkbx[0] = true;
				if (chckbxLanguage.isSelected())
					chkbx[1] = true;
				if (chckbxPrice.isSelected())
					chkbx[2] = true;
				if (chckbxAuthor.isSelected())
					chkbx[3] = true;
				if (chckbxKeyword.isSelected())
					chkbx[4] = true;
				if (chckbxSubject.isSelected())
					chkbx[5] = true;
				msg.add(chkbx);
				
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
		btnSearch.setBounds(272, 124, 93, 23);
		add(btnSearch);
		
		
		JPanel imagePanel = new JPanel();
		imagePanel.setBounds(-15, 0, 731, 599);
		imagePanel.setBackground(new Color(250, 243, 232));
		add(imagePanel);
		
	}
}
