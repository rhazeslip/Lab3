import java.io.IOException;
import java.util.List;

public class ConsoleApp {
    public static void main(String[] args) {
        try {
            List<Country> countries = DataProcessing.readCountry("final_filtered_countries_cleaned.csv");

            System.out.println("First (1st) Country: " + countries.get(0));

            if (countries.size() >= 10) {
                System.out.println("Tenth (10th) Country: " + countries.get(9));
            }

            System.out.println("Total Countries: " + countries.size());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
