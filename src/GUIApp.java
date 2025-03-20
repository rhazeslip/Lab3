import org.jfree.chart.ChartPanel;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class GUIApp extends JFrame {
    private JComboBox<String> yearFilter;
    private JComboBox<String> countryFilter;
    private JTextField minForestFilter;
    private JButton applyFiltersButton;
    private List<Country> countries;
    private TablePanel tablePanel;
    private StatsPanel statsPanel;
    private ChartsPanel chartsPanel;
    private DetailsPanel detailsPanel;

    public GUIApp(List<Country> countries) {
        this.countries = countries;
        setTitle("Country Data Visualization"); //Title of the GUI
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        //Creates panels for all the different panels
        tablePanel = new TablePanel(countries);
        detailsPanel = new DetailsPanel();
        statsPanel = new StatsPanel(countries);
        ChartsPanel chartsPanel = new ChartsPanel(countries);

        //Create filter controls
        yearFilter = new JComboBox<>(new String[] {"All", "2005", "2010", "2021"});
        countryFilter = new JComboBox<>(getUniqueCountryNames(countries));
        countryFilter.insertItemAt("All", 0);
        countryFilter.setSelectedIndex(0);
        minForestFilter = new JTextField(5);
        applyFiltersButton = new JButton("ApplyFilters");

        //Listener for the filter button
        applyFiltersButton.addActionListener(e -> applyFilters());

        //Panel for filters
        JPanel filterPanel = new JPanel();
        filterPanel.add(new JLabel("Year:"));
        filterPanel.add(yearFilter);
        filterPanel.add(new JLabel("Country:"));
        filterPanel.add(countryFilter);
        filterPanel.add(new JLabel("Min Forest %:"));
        filterPanel.add(minForestFilter);
        filterPanel.add(applyFiltersButton);

        //Add listener to the table to update the details and chart panels when a row is selected
        tablePanel.getTable().getSelectionModel().addListSelectionListener(e -> {
            int selectedRow = tablePanel.getTable().getSelectedRow();
            if (selectedRow >= 0) {
                Country selectedCountry = tablePanel.getFilterCountries().get(selectedRow);
                detailsPanel.setDetails(selectedCountry.toString());
                chartsPanel.updateChart(selectedCountry);
            }
        });

        //Adds components to the frame
        JPanel southPanel = new JPanel();
        southPanel.add(statsPanel);
        southPanel.add(detailsPanel);
        southPanel.setLayout(new BoxLayout(southPanel, BoxLayout.Y_AXIS));

        add(tablePanel, BorderLayout.CENTER);
        add(filterPanel, BorderLayout.NORTH);
        add(southPanel, BorderLayout.SOUTH);
        add(chartsPanel, BorderLayout.EAST);

    }

    // Method to apply filters
    private void applyFilters() {
        String selectedYear = (String) yearFilter.getSelectedItem();
        String selectedCountry = (String) countryFilter.getSelectedItem();
        double minForest = minForestFilter.getText().isEmpty() ? 0 : Double.parseDouble(minForestFilter.getText());

        // Filter the data
        List<Country> filteredData = countries.stream()
                .filter(country -> selectedYear.equals("All") || country.getYear() == Integer.parseInt(selectedYear))
                .filter(country -> selectedCountry.equals("All") || country.getCountryName().equals(selectedCountry))
                .filter(country -> country.getForestPercentage() >= minForest)
                .collect(Collectors.toList());

        // Update panels with filtered data
        tablePanel.updateTable(filteredData);
        statsPanel.updateStats(filteredData);
        if (!filteredData.isEmpty()) {
            tablePanel.getTable().setRowSelectionInterval(0, 0);
            chartsPanel.updateChart(filteredData.get(0)); // Update chart with the first entry
            detailsPanel.setDetails(filteredData.get(0).toString()); // Update details with the first entry
        } else {
            chartsPanel.updateChart(null); // Clear chart if no data
            detailsPanel.setDetails("No data available."); // Clear details if no data
        }
    }
    //Method to get unique country names
    private String[] getUniqueCountryNames(List<Country> countries) {
        return countries.stream()
                .map(Country::getCountryName)
                .distinct()
                .toArray(String[]::new);
    }

    //Reads the file and launches the GUI
    public static void main(String[] args) {
        try {
            List<Country> countries = DataProcessing.readCountry("final_filtered_countries_cleaned.csv");
            SwingUtilities.invokeLater(() -> new GUIApp(countries).setVisible(true));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
