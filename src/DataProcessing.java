import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DataProcessing {
    public static List<Country> readCountry(String filePath) throws IOException {
        List<Country> countries = new ArrayList<>();
        try (Stream<String> lines = Files.lines(Paths.get(filePath))) {
            lines.skip(1).forEach(line -> {
                String[] parts = line.split(",");
                try {
                    String countryName = parts[0];
                    int year = Integer.parseInt(parts[1].trim());
                    double arableLandPercentage = Integer.parseInt(parts[2].trim());
                    double forestPercentage = Integer.parseInt(parts[3].trim());
                    double cropPercentage = Integer.parseInt(parts[4].trim());

                    countries.add(new Country(countryName, year, arableLandPercentage, forestPercentage,
                                    cropPercentage));
                } catch (NumberFormatException e) {
                    System.err.println("Skipping invalid row: " + line);
                    e.printStackTrace();
                }

            });
        }
        return countries;
    }
}
