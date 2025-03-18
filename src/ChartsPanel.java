import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import javax.swing.*;
import java.awt.*;
import java.util.List;

public class ChartsPanel extends JPanel{
    private DefaultPieDataset dataset;
    private JFreeChart pieChart;

    public ChartsPanel() {
        setLayout (new BorderLayout());

        dataset = new DefaultPieDataset();
        pieChart = ChartFactory.createPieChart("Land Usage Distribution",
                dataset, true, true, false);

        ChartPanel chartPanel = new ChartPanel(pieChart);
        add(chartPanel, BorderLayout.CENTER);
    }

    public void updateChart(Country country) {
        dataset.clear();

        dataset.setValue("Arable Land", country.getArableLandPercentage());
        dataset.setValue("Forest", country.getForestPercentage());
        dataset.setValue("Crops", country.getCropPercentage());

        pieChart.setTitle("Land Usage Distribution for " + country.getCountryName());
    }
}


