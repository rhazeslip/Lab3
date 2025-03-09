import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.List;

public class GUIApp extends JFrame {
    public GUIApp(List<Employee> employees) {
        setTitle("Employee Data Visualization");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        TablePanel tablePanel = new TablePanel(employees);
        DetailsPanel detailsPanel = new DetailsPanel();
        StatsPanel statsPanel = new StatsPanel(employees);
        ChartsPanel chartsPanel = new ChartsPanel(employees);

        tablePanel.getTable().getSelectionModel().addListSelectionListener(e -> {
            int selectedRow = tablePanel.getTable().getSelectedRow();
            if (selectedRow >= 0) {
                Employee emp = employees.get(selectedRow);
                detailsPanel.setDetails(emp.toString());
            }
        });

        add(tablePanel, BorderLayout.CENTER);
        add(detailsPanel, BorderLayout.SOUTH);
        add(statsPanel, BorderLayout.EAST);
        add(chartsPanel, BorderLayout.WEST);
    }

    public static void main(String[] args) {
        try {
            List<Employee> employees = DataProcessing.readEmployees("data.csv");
            SwingUtilities.invokeLater(() -> new GUIApp(employees).setVisible(true));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
