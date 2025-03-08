import java.io.IOException;
import java.util.List;

public class ConsoleApp {
    public static void main(String[] args) {
        try {
            List<Employee> employees = DataProcessing.readEmployees("data.csv");

            System.out.println("First Employee: " + employees.get(0));

            if (employees.size() >= 10) {
                System.out.println("10th Employee: " + employees.get(9));
            }

            System.out.println("Total Employees: " + employees.size());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
