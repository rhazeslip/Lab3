import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;
import javax.swing.*;
import java.util.List;

public class ChartsPanel extends JPanel{
    public ChartsPanel(List<Employee> employees) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (Employee emp : employees) {
            dataset.addValue(emp.getSalary(), "Salary", emp.getName());
        }

        JFreeChart chart = ChartFactory.createBarChart(
                "Employee Salaries", "Employee", "Salary", dataset
        );
        add(new ChartsPanel(chart));
    }
}
