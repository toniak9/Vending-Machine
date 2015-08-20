/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectvendingmachine;

/**
 *
 * @author Sruti
 */

 


import java.awt.Font;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

/**
 * A simple demonstration application showing how to create a pie chart using 
 * data from a {@link DefaultPieDataset}.
 */
public class PieChart extends ApplicationFrame {

   int snackCount, beverageCount, candyCount;
   
   
    /**
     * Default constructor.
     *
     * @param title  the frame title.
     */
  
    public PieChart(String title) {
        super(title);
       // piechartValues();
        
    }
    public void piechartValues(int snackCount, int beverageCount, int candyCount) {
        
        this.snackCount = snackCount;
        this.beverageCount = beverageCount;
        this.candyCount = candyCount;
        setContentPane(createDemoPanel());
    }
    /**
     * Creates a sample dataset.
     * 
     * @return A sample dataset.
     */
    private PieDataset createDataset() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Snacks", new Integer(snackCount));
        dataset.setValue("Beverages", new Integer(beverageCount));
        dataset.setValue("Candies", new Integer(candyCount));
      //  dataset.setValue("Four", new Double(17.5));
      //  dataset.setValue("Five", new Double(11.0));
      //  dataset.setValue("Six", new Double(19.4));
        return dataset;        
    }
    
    /**
     * Creates a chart.
     * 
     * @param dataset  the dataset.
     * 
     * @return A chart.
     */
    private static JFreeChart createChart(PieDataset dataset) {
        
        JFreeChart chart = ChartFactory.createPieChart(
            "Statistics",  // chart title
            dataset,             // data
            true,               // include legend
            true,
            false
        );

        PiePlot plot = (PiePlot) chart.getPlot();
        plot.setLabelFont(new Font("SansSerif", Font.PLAIN, 12));
        plot.setNoDataMessage("No data available");
        plot.setCircular(false);
        plot.setLabelGap(0.02);
        return chart;
        
    }
    
    /**
     * Creates a panel for the demo (used by SuperDemo.java).
     * 
     * @return A panel.
     */
    public JPanel createDemoPanel() {
        JFreeChart chart = createChart(createDataset());
        return new ChartPanel(chart);
    }
    
    /**
     * Starting point for the demonstration application.
     *
     * @param args  ignored.
     */
 /*   public static void main(String[] args) {

        PieChart demo = new PieChart("Pie Chart");
        demo.pack();
        RefineryUtilities.centerFrameOnScreen(demo);
        demo.setVisible(true);

    }*/

}

