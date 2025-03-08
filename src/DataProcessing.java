import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DataProcessing {
    public static List<Employee> readEmployees(String filePath) throws IOException {
        try (Stream<String> lines = Files.lines(Paths.get(filePath))) {
            return lines.skip(1).map(line -> {
                String[] parts = line.split(",");
                return new Employee(
                        Integer.parseInt(parts[0]),parts[1],
                        Interger.parseInt(parts[2]),Double.parseDouble(parts[3]),parts[4]
                );
            }).collect(collectors.toList());
        }
    }
}
