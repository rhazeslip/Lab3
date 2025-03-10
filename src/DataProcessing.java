import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DataProcessing {
    //Reading file
    public static List<Country> readCountry(String filePath) throws IOException {
        List<Country> countries = new ArrayList<>();
        try (Stream<String> lines = Files.lines(Paths.get(filePath))) { //opens file and reads the lines
            lines.skip(1).forEach(line -> { //skips the header line
                String[] parts = line.split(","); //splits each line by commas
                try {
                    String countryName = parts[0]; //country name
                    int year = Integer.parseInt(parts[1].trim()); //year
                    double arableLandPercentage = Double.parseDouble(parts[2].trim()); //arable land percentage
                    double forestPercentage = Double.parseDouble(parts[3].trim()); //forest percentage
                    double cropPercentage = Double.parseDouble(parts[4].trim()); //crop percentage

                    //adds the new item to the array
                    countries.add(new Country(countryName, year, arableLandPercentage, forestPercentage,
                                    cropPercentage));
                //Used to skip any lines that have invalid inputs in the section
                } catch (NumberFormatException e) {
                    System.err.println("Skipping invalid row: " + line);
                    e.printStackTrace();
                }

            });
        }
        return countries;
    }
}
