import javax.swing.*;
import java.text.DecimalFormat;
import java.util.List;

public class StatsPanel extends JPanel {
    public StatsPanel(List<Country> countries) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        int totalCountries = countries.size();
        double totalForestPercentage = 0;
        double totalArableLandPercentage = 0;

        for (Country country : countries) {
            totalForestPercentage += country.getForestPercentage();
            totalArableLandPercentage += country.getArableLandPercentage();
        }

        double avgForestPercentage = totalForestPercentage / totalCountries;
        double avgArableLandPercentage = totalArableLandPercentage / totalCountries;

        DecimalFormat df = new DecimalFormat("#.##");

        JLabel totalCountriesLabel = new JLabel("Total Countries: " + totalCountries);
        JLabel avgForestLabel = new JLabel("Average Forest Percentage: " + df.format(avgForestPercentage) + "%");
        JLabel avgArableLabel = new JLabel("Average Arable Land Percentage: " + df.format(avgArableLandPercentage) + "%");

        add(totalCountriesLabel);
        add(avgForestLabel);
        add(avgArableLabel);
    }
}
