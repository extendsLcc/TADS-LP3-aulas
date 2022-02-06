package CSV;

import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        IrisCSVParser.parseFile("src/CSV/data.csv/iris.data.csv");

    }

}
