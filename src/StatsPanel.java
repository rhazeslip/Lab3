import javax.swing.*;
import java.text.DecimalFormat;
import java.util.List;

public class StatsPanel extends JPanel {
    private JLabel totalCountriesLabel;
    private JLabel avgForestLabel;
    private JLabel avgArableLabel;
    private JLabel avgCropLabel;

    public StatsPanel(List<Country> countries) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        //initial label names
        totalCountriesLabel = new JLabel("Total Countries: 0");
        avgForestLabel = new JLabel("Average Forest Percentage: 0.00%");
        avgArableLabel = new JLabel("Average Arable Land Percentage: 0.00%");
        avgCropLabel = new JLabel("Average Crop Percentage: 0.00%");

        //Adds the labels
        add(totalCountriesLabel);
        add(avgForestLabel);
        add(avgArableLabel);
        add(avgCropLabel);

        updateStats(countries);
    }

    //updates the stats data when a new entry is selected
    public void updateStats(List<Country> countries) {
        int totalCountries = countries.size();
        double totalForestPercentage = 0;
        double totalArableLandPercentage = 0;
        double totalCropPercentage = 0;

        //gets the total for all the entries for a column
        for (Country country : countries) {
            totalForestPercentage += country.getForestPercentage();
            totalArableLandPercentage += country.getArableLandPercentage();
            totalCropPercentage += country.getCropPercentage();
        }

        //computes the average for each column
        double avgForestPercentage = totalForestPercentage > 0 ? totalForestPercentage
                / totalCountries : 0;
        double avgArableLandPercentage = totalArableLandPercentage > 0 ? totalArableLandPercentage
                / totalCountries : 0;
        double avgCropPercentage = totalCropPercentage > 0 ? totalCropPercentage
                / totalCountries : 0;

        DecimalFormat df = new DecimalFormat("#.##");

        //Text label for the different data entries
        totalCountriesLabel.setText("Total Countries: " + (totalCountries/3));
        avgForestLabel.setText("Average Forest Percentage: " + df.format(avgForestPercentage) + "%");
        avgArableLabel.setText("Average Arable Land Percentage: " + df.format(avgArableLandPercentage) + "%");
        avgCropLabel.setText("Average Crop Percentage: " + df.format(avgCropPercentage) + "%");

    }
}

