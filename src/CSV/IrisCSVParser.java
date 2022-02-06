package CSV;

import com.opencsv.CSVReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class IrisCSVParser {

    public static List<Iris> parseFile(String filePath) throws FileNotFoundException {
        List<Iris> parsedIrisList = new ArrayList<>();
        CSVReader csvReader = new CSVReader(new FileReader("src/CSV/data.csv/iris.data.csv"));
        return parsedIrisList;
    }

    private static Iris parseLineToObject(String[] csvLine) {
        double leafLength = Double.parseDouble(csvLine[0]);
        double leafWidth = Double.parseDouble(csvLine[1]);
        double petalLength = Double.parseDouble(csvLine[2]);
        double petalWidth = Double.parseDouble(csvLine[3]);
        String flowerName = csvLine[4];
        return new Iris(leafLength, leafWidth, petalLength, petalWidth, flowerName);
    }

}
