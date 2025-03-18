import java.io.IOException;
import java.util.List;

//Reads the countries from the file and output the 1st, 10th, total countries, and total entries of the file to the console.
public class ConsoleApp {
    public static void main(String[] args) {
        try {

            List<Country> countries = DataProcessing.readCountry("final_filtered_countries_cleaned.csv");

            System.out.println("First (1st) Country: " + countries.get(0));

            if (countries.size() >= 10) {
                System.out.println("Tenth (10th) Country: " + countries.get(9));
            }

            System.out.println("Total Countries " + (countries.size()/3));

            System.out.println("Total Entries: " + countries.size());

        } catch (IOException e) {
            //Handles any unable to read files
            e.printStackTrace();
        }
    }
}
