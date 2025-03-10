import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class TablePanel extends JPanel{
    private JTable table;
    private DefaultTableModel model;

    public TablePanel(List<Country> countries){
        model = new DefaultTableModel();
        model.addColumn("Country");
        model.addColumn("Year");
        model.addColumn("Arable land %");
        model.addColumn("Forests %");
        model.addColumn("Crops %");

        for (Country con : countries) {
            model.addRow(new Object[]{
                con.getCountryName(), con.getYear(), con.getArableLandPercentage(), con.getForestPercentage(),
                    con.getCropPercentage()
            });
        }

        table = new JTable(model);
        table.setAutoCreateRowSorter(true);
        add(new JScrollPane(table));
    }
    public JTable getTable(){
        return table;
    }
}
