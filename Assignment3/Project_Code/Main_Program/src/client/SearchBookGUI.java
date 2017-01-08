package client;
import javax.swing.JPanel;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.border.EtchedBorder;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.JScrollPane;
import java.awt.Color;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class SearchBookGUI extends JPanel
{
	private ClientInterface clientInterface;
	
	JRadioButton rdbtnBook;
	JRadioButton rdbtnReview;
	private final JScrollPane scrollPane = new JScrollPane();
	private JTextField textField;

	
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
		lblIWantTo.setBounds(22, 24, 141, 14);
		add(lblIWantTo);
		scrollPane.setBounds(22, 198, 520, 195);
		add(scrollPane);
		
		JList list = new JList();
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {"1            MyTitle        Hebrew                59.99          Author1, Author2, Author3", "1            MyTitle        Hebrew                59.99          Author1, Author2, Author3", "1            MyTitle        Hebrew                59.99          Author1, Author2, Author3", "1            MyTitle        Hebrew                59.99          Author1, Author2, Author3", "1            MyTitle        Hebrew                59.99          Author1, Author2, Author3", "1            MyTitle        Hebrew                59.99          Author1, Author2, Author3", "1            MyTitle        Hebrew                59.99          Author1, Author2, Author3", "1            MyTitle        Hebrew                59.99          Author1, Author2, Author3", "1            MyTitle        Hebrew                59.99          Author1, Author2, Author3", "1            MyTitle        Hebrew                59.99          Author1, Author2, Author3", "1            MyTitle        Hebrew                59.99          Author1, Author2, Author3", "1            MyTitle        Hebrew                59.99          Author1, Author2, Author3", "1            MyTitle        Hebrew                59.99          Author1, Author2, Author3", "1            MyTitle        Hebrew                59.99          Author1, Author2, Author3", "1            MyTitle        Hebrew                59.99          Author1, Author2, Author3", "1            MyTitle        Hebrew                59.99          Author1, Author2, Author3", "1            MyTitle        Hebrew                59.99          Author1, Author2, Author3", "1            MyTitle        Hebrew                59.99          Author1, Author2, Author3", "1            MyTitle        Hebrew                59.99          Author1, Author2, Author3", "1            MyTitle        Hebrew                59.99          Author1, Author2, Author3"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		scrollPane.setViewportView(list);
		
		JLabel lblFghfghfg = new JLabel("ID          Title           Language          Price          Authors");
		lblFghfghfg.setFont(new Font("Tahoma", Font.BOLD, 11));
		scrollPane.setColumnHeaderView(lblFghfghfg);
		
		JLabel lblResults = new JLabel("Results:");
		lblResults.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblResults.setBounds(22, 173, 100, 14);
		add(lblResults);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBounds(174, 49, 191, 64);
		add(panel);
		
		JCheckBox chckbxTitle = new JCheckBox("Title");
		chckbxTitle.setBounds(6, 7, 74, 23);
		panel.add(chckbxTitle);
		
		JCheckBox chckbxAuthor = new JCheckBox("Author");
		chckbxAuthor.setBounds(6, 33, 74, 23);
		panel.add(chckbxAuthor);
		
		JCheckBox chckbxLanguage = new JCheckBox("Language");
		chckbxLanguage.setBounds(82, 7, 103, 23);
		panel.add(chckbxLanguage);
		
		JCheckBox chckbxPrice = new JCheckBox("Price");
		chckbxPrice.setBounds(82, 33, 103, 23);
		panel.add(chckbxPrice);
		
		textField = new JTextField();
		textField.setBounds(22, 124, 240, 23);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblByCategory = new JLabel("By category...");
		lblByCategory.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblByCategory.setBounds(173, 18, 131, 27);
		add(lblByCategory);
		
		JButton btnSearch = new JButton("SEARCH");
		btnSearch.setBounds(272, 124, 93, 23);
		add(btnSearch);
		
	}
}
