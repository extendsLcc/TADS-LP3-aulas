package CSV;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        List<Iris> irisList = IrisCSVParser.parseFile("src/CSV/data.csv/iris.data.csv");
        System.out.println("Parsed CSV");
        System.out.println(irisList);
        List<Iris> leafWidthOrderedIrisList = irisList.stream()
            .sorted(Comparator.comparingDouble(Iris::getFolhaLargura))
            .toList();
        System.out.println("Ordered by leaf width");
        System.out.println(leafWidthOrderedIrisList);
        IrisCSVWriter.writeFile("src/CSV/data.csv/iris.data--ordenado.csv", leafWidthOrderedIrisList);
    }

}
