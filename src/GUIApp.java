import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.List;

public class GUIApp extends JFrame {
    public GUIApp(List<Country> countries) {
        setTitle("Country Data Visualization");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        TablePanel tablePanel = new TablePanel(countries);
        DetailsPanel detailsPanel = new DetailsPanel();
        StatsPanel statsPanel = new StatsPanel(countries);
        //ChartsPanel chartsPanel = new ChartsPanel(countries);

        tablePanel.getTable().getSelectionModel().addListSelectionListener(e -> {
            int selectedRow = tablePanel.getTable().getSelectedRow();
            if (selectedRow >= 0) {
                Country con = countries.get(selectedRow);
                detailsPanel.setDetails(con.toString());
            }
        });

        add(tablePanel, BorderLayout.CENTER);
        add(detailsPanel, BorderLayout.SOUTH);
        add(statsPanel, BorderLayout.EAST);
        //add(chartsPanel, BorderLayout.WEST);
    }

    public static void main(String[] args) {
        try {
            List<Country> countries = DataProcessing.readCountry("final_filtered_countries_cleaned.csv");
            SwingUtilities.invokeLater(() -> new GUIApp(countries).setVisible(true));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
