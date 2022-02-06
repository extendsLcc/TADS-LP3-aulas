package CSV;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        List<Iris> irisList = IrisCSVParser.parseFile("src/CSV/data.csv/iris.data.csv");
        System.out.println("Parsed CSV");
        System.out.println(irisList);
        List<Iris> leafWidthOrderedIrisList = irisList.stream()
            .sorted((irisA, irisB) -> Double.compare(irisA.getFolhaLargura(), irisB.getFolhaLargura()))
            .toList();
        System.out.println("Ordered by leaf width");
        System.out.println(leafWidthOrderedIrisList);
    }

}
