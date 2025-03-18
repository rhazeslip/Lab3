import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.List;

public class GUIApp extends JFrame {
    public GUIApp(List<Country> countries) {
        setTitle("Country Data Visualization"); //Title of the GUI
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        //Creates panels for all the different panels
        TablePanel tablePanel = new TablePanel(countries);
        DetailsPanel detailsPanel = new DetailsPanel();
        StatsPanel statsPanel = new StatsPanel(countries);
        ChartsPanel chartsPanel = new ChartsPanel(countries);

        //Add listener to the table to update the details panel when a row is selected
        tablePanel.getTable().getSelectionModel().addListSelectionListener(e -> {
            int selectedRow = tablePanel.getTable().getSelectedRow();
            if (selectedRow >= 0) {
                Country selectedCountry = countries.get(selectedRow);
                detailsPanel.setDetails(selectedCountry.toString());
                chartsPanel.updateChart(selectedCountry);
            }
        });
        JPanel southPanel = new JPanel();
        southPanel.add(statsPanel);
        southPanel.add(detailsPanel);
        southPanel.setLayout(new BoxLayout(southPanel, BoxLayout.Y_AXIS));

        add(tablePanel, BorderLayout.CENTER);
        add(southPanel, BorderLayout.SOUTH);
        add(chartsPanel, BorderLayout.EAST);
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
