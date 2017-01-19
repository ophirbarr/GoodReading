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
	ClientInterface clientInterface;
	
	public HistogramGUI(ClientInterface clientInterface){
		
		super();
		this.clientInterface = clientInterface;
		
		
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		dataset.setValue(1, "Purchase", "1/1/17");
		dataset.setValue(5, "Purchase", "2/1/17");
		dataset.setValue(3, "Purchase", "3/1/17");
		
		dataset.setValue(10, "Search", "1/1/17");
		dataset.setValue(11, "Search", "2/1/17");
		dataset.setValue(7, "Search", "3/1/17");
		
		
		JFreeChart chart = ChartFactory.createBarChart3D("Statistical Information", "Dates", "Amount", dataset);
		CategoryPlot p = chart.getCategoryPlot();
		p.setRangeGridlinePaint(Color.BLACK);
		ChartFrame frame = new ChartFrame("Statistical Information",chart);
		frame.setVisible(true);
		frame.setSize(550, 450);
		
		//ChartPanel cp = new ChartPanel(chart);
		//removeAll();
		///clientInterface.mainPanel.add(cp);
		//validate();
		
		
		
	}
}
