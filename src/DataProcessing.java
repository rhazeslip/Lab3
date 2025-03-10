import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DataProcessing {
    public static List<Country> readCountry(String filePath) throws IOException {
        try (Stream<String> lines = Files.lines(Paths.get(filePath))) {
            return lines.skip(1)
                    .map(line -> {
                        String[] parts = line.split(",");
                        return new Country(
                            parts[0], //Country Name
                            Integer.parseInt(parts[1]), //year
                            Double.parseDouble(parts[2]), //Arable land percentage
                            Double.parseDouble(parts[3]), //Forest percentage
                            Double.parseDouble(parts[4])  //crop percentage
                    );
            }).collect(Collectors.toList());
        }
    }
}
