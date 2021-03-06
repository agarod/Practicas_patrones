import java.util.ArrayList;

import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class JFreeChartXY extends JFrame {

   private static final long serialVersionUID = 1L;

   public JFreeChartXY(String applicationTitle, String chartTitle,ArrayList<String[]> datos,String RedLine) {
        super(applicationTitle);

        // based on the dataset we create the chart
        JFreeChart pieChart = ChartFactory.createXYLineChart(chartTitle, "Category", "Score", createDataset( datos, RedLine),PlotOrientation.VERTICAL, true, true, false);

        // Adding chart into a chart panel
        ChartPanel chartPanel = new ChartPanel(pieChart);
      
        // settind default size
        chartPanel.setPreferredSize(new java.awt.Dimension(1500, 600));
      
        // add to contentPane
        setContentPane(chartPanel);
    }
  
   private XYDataset createDataset( ArrayList<String[]> datos,String RedLine ) {
     
	   //final XYSeries grafico = new XYSeries("Datos Lluvia");
	   final XYSeries grafico = new XYSeries(RedLine);
	   for( int i = 0 ; i < datos.size() ; i++ ){
		   
		   String[] aux = datos.get(i);
		 //  System.out.println(aux[2]);
		 //  System.out.println(aux[4]+"Trololo");
		 //  grafico.add( Float.parseFloat( aux[4] ) , Float.parseFloat( aux[5] ) );
		   grafico.add( Float.parseFloat( aux[3].replace( "*" , "" ) ) , Float.parseFloat( aux[6].replace( "*" , "" ) ) );
		   
	   }
	   
	   final XYSeriesCollection dataset = new XYSeriesCollection();
	   dataset.addSeries( grafico );
	   
	        
      return dataset;
     
  }

    
}