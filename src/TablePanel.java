import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class TablePanel extends JPanel{
    private JTable table;
    private DefaultTableModel model;

    public TablePanel(List<Employee> employees){
        model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Name");
        model.addColumn("Age");
        model.addColumn("Salary");
        model.addColumn("Department");

        for (Employee emp : employees) {
            model.addRow(new Object[]{
                emp.getID(), emp.getName(), emp.getAge(), emp.getSalary(), emp.getDepartment()
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
