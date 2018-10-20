import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

import java.util.List;

public class Chart extends ApplicationFrame {
    public Chart(String applicationTitle , String chartTitle, List<Double> predictions,Double[] currency) {
        super(applicationTitle);
        JFreeChart lineChart = ChartFactory.createLineChart(
                chartTitle,
                "Tanggal","Prediksi",
                createDataset(predictions,currency),
                PlotOrientation.VERTICAL,
                true,true,false);
        ChartPanel chartPanel = new ChartPanel( lineChart );
        chartPanel.setPreferredSize( new java.awt.Dimension( 560 , 367 ) );
        setContentPane( chartPanel );
    }

    private DefaultCategoryDataset createDataset( List<Double> predictions,Double[] currency) {
        int i = 0;
        DefaultCategoryDataset dataset = new DefaultCategoryDataset( );
        while (i<predictions.size()){
            dataset.addValue(currency[i],"Real Value",Integer.toString(i));
            dataset.addValue(predictions.get(i),"Prediction",Integer.toString(i));
                i++;
            }
        return dataset;
    }
    public void runChart(Chart chart){
        chart.pack( );
        RefineryUtilities.centerFrameOnScreen( chart );
        chart.setVisible( true );
    }
}
