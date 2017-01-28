package client;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JPanel;
import good_reading.Book;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.plot.PlotOrientation;


/**
 * Class displays statistical information on book using a histogram
 * @author avihai
 *
 */

public class HistogramGUI {
	
	private Book book;
	private int purchaseDatesize;
	private int searchesDatesize;
	private String[] purchaseDate;
	private String[] searchesDate;
	private ClientInterface clientInterface;
	
	/**
	 * constructor
	 * @param book displayed
	 */
	public HistogramGUI(Book book){

		this.book = book;
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		
		if(book.get_purchaseLog() == null) purchaseDatesize = 0;
		else{ 
			purchaseDate = book.get_purchaseLog().split(" "); 
			purchaseDatesize = purchaseDate.length;}
		
		if(book.get_searchLog() == null) searchesDatesize = 0;
		else {
			searchesDate = book.get_searchLog().split(" ");
			searchesDatesize = searchesDate.length;
		}
		int countPurchase = 0;
		int countSearches = 0;
		
		for(int i=0;i<searchesDatesize;i++ )
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
			
		
		for(int i=0;i<purchaseDatesize;i++ )
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
		frame.setSize(750, 450);
	      
		
	}
}
