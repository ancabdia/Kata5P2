package view;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;

import model.*;

public class HistogramDisplay extends ApplicationFrame {
    
    private final Histogram<String> histogram;
    
    public HistogramDisplay(Histogram<String> histogram) {
        super("Histograma");
        this.histogram = histogram;
        setContentPane(createPanel());
        pack(); 
    }   
    
    public void execute(){
        setVisible(true);
    }
    
    private JPanel createPanel(){
        ChartPanel chartPanel = new ChartPanel(createChart(createDataset()));
        chartPanel.setPreferredSize(new Dimension(500,400));
        return chartPanel;
    }
    
    private JFreeChart createChart(DefaultCategoryDataset dataSet){       
        JFreeChart chart = ChartFactory.createBarChart(
                "Histograma JFreeChart", 
                "Dominios email", "Nº de emails", dataSet, 
                PlotOrientation.VERTICAL, false, false, 
                rootPaneCheckingEnabled);
        chart.setBackgroundPaint(Color.ORANGE);
        chart.getCategoryPlot().setBackgroundPaint(Color.GREEN);
        return chart;
    }
    
    private DefaultCategoryDataset createDataset(){
        DefaultCategoryDataset dataSet = new DefaultCategoryDataset();
        for (String key : histogram.keySet()) {
            dataSet.setValue(histogram.get(key), "", key);
        }
        return dataSet;
    }
}
