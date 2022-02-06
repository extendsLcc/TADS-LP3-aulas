package CSV;

import com.opencsv.CSVWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class IrisCSVWriter {

    public static void writeFile(String filePath, List<Iris> irisList) throws IOException {
        File file = new File(filePath);
        FileWriter fileWriter = new FileWriter(file);
        CSVWriter csvWriter = new CSVWriter(
            fileWriter,
            CSVWriter.DEFAULT_SEPARATOR,
            CSVWriter.NO_QUOTE_CHARACTER,
            CSVWriter.DEFAULT_QUOTE_CHARACTER,
            CSVWriter.DEFAULT_LINE_END
        );
        irisList.forEach(iris -> csvWriter.writeNext(IrisCSVWriter.convertIrisToRow(iris)));
        csvWriter.close();
    }

    private static String[] convertIrisToRow(Iris iris) {
        return new String[]{
            String.valueOf(iris.getFolhaComprimento()),
            String.valueOf(iris.getFolhaLargura()),
            String.valueOf(iris.getPetalaComprimento()),
            String.valueOf(iris.getPetalaLargura()),
            iris.getNomeFlor(),
        };
    }

}
