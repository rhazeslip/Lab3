import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class TablePanel extends JPanel{
    private JTable table;
    private DefaultTableModel model;

    public TablePanel(List<Country> countries){
        model = new DefaultTableModel();
        //Adding columns to the table for each section
        model.addColumn("Country");
        model.addColumn("Year");
        model.addColumn("Arable land %");
        model.addColumn("Forests %");
        model.addColumn("Crops %");

        //Adds the information to each row for each object
        for (Country country : countries) {
            model.addRow(new Object[]{
                country.getCountryName(), country.getYear(), country.getArableLandPercentage(), country.getForestPercentage(),
                    country.getCropPercentage()
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
