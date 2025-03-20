import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class TablePanel extends JPanel{
    private JTable table;
    private DefaultTableModel model;
    private List<Country> filterCountries; //List to store filtered data

    public TablePanel(List<Country> countries){
        filterCountries = countries;
        model = new DefaultTableModel();
        //Adding columns to the table for each section
        model.addColumn("Country");
        model.addColumn("Year");
        model.addColumn("Arable land %");
        model.addColumn("Forests %");
        model.addColumn("Crops %");

        updateTable(countries);

        table = new JTable(model);
        table.setAutoCreateRowSorter(true);
        add(new JScrollPane(table));
    }

    //Method to update the table
    public void updateTable(List<Country> countries){
        filterCountries = countries;
        model.setRowCount(0);
        //Adds the information to each row for each object
        for (Country country : countries) {
            model.addRow(new Object[]{
                    country.getCountryName(), country.getYear(), country.getArableLandPercentage(), country.getForestPercentage(),
                    country.getCropPercentage()
            });
        }
    }

    public JTable getTable(){
        return table;
    }

    //Gets the current filtered data
    public List<Country> getFilterCountries(){ return filterCountries; }
}
