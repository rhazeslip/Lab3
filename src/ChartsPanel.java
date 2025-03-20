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

    public ChartsPanel(List<Country> countries) {
        setLayout (new BorderLayout());

        dataset = new DefaultPieDataset();
        //Creates the initial blank chart with title
        pieChart = ChartFactory.createPieChart("No Entry Selected", dataset, true,
                true, false);

        //sets the size of chart and adds it
        ChartPanel chartPanel = new ChartPanel(pieChart);
        chartPanel.setPreferredSize(new Dimension(300, 150));
        add(chartPanel, BorderLayout.CENTER);
    }

    //Method to update chart after entry selected
    public void updateChart(Country country) {

        if (country != null) {
            //grabs data for the country
            double arable = country.getArableLandPercentage();
            double forest = country.getForestPercentage();
            double crops = country.getCropPercentage();
            double unmarked = 100 - (arable + forest + crops);

            //Updates values in chart
            dataset.setValue("Arable Land %", arable);
            dataset.setValue("Forest %", forest);
            dataset.setValue("Crops %", crops);
            dataset.setValue("Unmarked %", unmarked);

            //Updates title
            pieChart.setTitle("Land Usage Distribution for " + country.getCountryName() + " " + country.getYear());
        }

        else {
            pieChart.setTitle("No Entry Selected");
        }
    }
}





