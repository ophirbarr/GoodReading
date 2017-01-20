package client;

import java.awt.Color;
import javax.swing.JPanel;
import good_reading.Book;
import javax.swing.JTree;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;



public class HistogramGUI extends JPanel{
	
	private Book book;
	
	public HistogramGUI(Book book){
		
		super();
		this.book = book;
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		
		String[] purchaseDate = book.get_purchaseLog().split(" ");
		String[] searchesDate = book.get_searchLog().split(" ");
		int countPurchase = 0;
		int countSearches = 0;
		
		for(int i=0;i<searchesDate.length;i++ )
		{
			if(i==searchesDate.length-1){   //last element
				countSearches++;
				dataset.setValue(countSearches, "Search", searchesDate[i]);
			}
			
			else {
				if(searchesDate[i].equals(searchesDate[i+1]))   //same date
					countSearches++;
				else{ 
					countSearches++;
					dataset.setValue(countSearches, "Search", searchesDate[i]);
					countSearches = 0;
					}
			}
		}
			
		
		for(int i=0;i<purchaseDate.length;i++ )
		{
			if(i==purchaseDate.length-1){   //last element
				countPurchase++;
				dataset.setValue(countPurchase, "Purchase", purchaseDate[i]);
			}
			
			else {
				if(purchaseDate[i].equals(purchaseDate[i+1]))   //same date
					countPurchase++;
				else{ 
					countPurchase++;
					dataset.setValue(countPurchase, "Purchase", purchaseDate[i]);
					countPurchase = 0;
					}
			}
		}
		
		
		
		
		JFreeChart chart = ChartFactory.createBarChart3D("Statistical Information", "Dates", "Amount", dataset);
		CategoryPlot p = chart.getCategoryPlot();
		p.setRangeGridlinePaint(Color.BLACK);
		ChartFrame frame = new ChartFrame("Statistical Information",chart);
		frame.setVisible(true);
		frame.setSize(550, 450);
		
	}
}
