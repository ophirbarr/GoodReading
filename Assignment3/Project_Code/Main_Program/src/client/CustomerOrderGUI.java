package client;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.ScrollPaneConstants;

public class CustomerOrderGUI extends JPanel{
	//Class variables
	private ClientInterface clientInterface;
	private JTable table;
	
	
	public CustomerOrderGUI(ClientInterface clientInterface){
		super();
		this.clientInterface = clientInterface;
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(10, 86, 430, 203);
		add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
		
			},
			new String[] {
				"Customer Name", "ID", "Books ordered"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, Integer.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(105);
		table.getColumnModel().getColumn(1).setPreferredWidth(91);
		table.getColumnModel().getColumn(2).setPreferredWidth(105);
		scrollPane.setViewportView(table);
		
		
		
	}
}
