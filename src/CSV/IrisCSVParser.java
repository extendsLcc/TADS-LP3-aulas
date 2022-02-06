package CSV;

import com.opencsv.CSVReader;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class IrisCSVParser {

    public static List<Iris> parseFile(String filePath) throws IOException {
        List<Iris> parsedIrisList = new ArrayList<>();
        CSVReader csvReader = new CSVReader(new FileReader(filePath));
        csvReader.forEach(csvRow -> parsedIrisList.add(IrisCSVParser.parseRowToObject(csvRow)));
        csvReader.close();
        return parsedIrisList;
    }

    private static Iris parseRowToObject(String[] csvRow) {
        double leafLength = Double.parseDouble(csvRow[0]);
        double leafWidth = Double.parseDouble(csvRow[1]);
        double petalLength = Double.parseDouble(csvRow[2]);
        double petalWidth = Double.parseDouble(csvRow[3]);
        String flowerName = csvRow[4];
        return new Iris(leafLength, leafWidth, petalLength, petalWidth, flowerName);
    }

}
