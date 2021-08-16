package Avaliacao;


import java.util.*;
import java.util.stream.Collectors;

/**
 * Exemplo: iterator
 */
class IterableStringQueue implements Iterator<String> {

    private List<String> stringQueue;

    public IterableStringQueue(String... strings) {

        this.stringQueue = new ArrayList<String>(Arrays.asList(strings));

    }

    @Override
    public boolean hasNext() {
        return !this.stringQueue.isEmpty();
    }

    @Override
    public String next() {
        // always remove the first element
        return this.stringQueue.remove(0);
    }

}

/**
 * Exemplo: Singleton
 */
class EnviromentRepository {

    private static EnviromentRepository enviromentRepository;

    private String javaVersion;
    private String javaVendor;
    private String osName;
    private String osArchitecture;
    private String userName;

    private EnviromentRepository() {

        this.javaVersion = System.getProperty("java.version");
        this.javaVendor = System.getProperty("java.vendor");
        this.osName = System.getProperty("os.name");
        this.osArchitecture = System.getProperty("os.arch");
        this.userName = System.getProperty("user.name");
        System.out.println("Imagine some expensive operations here!");

    }

    public static EnviromentRepository getEnvRepository() {
        if (EnviromentRepository.enviromentRepository == null) {
            EnviromentRepository.enviromentRepository = new EnviromentRepository();
        }
        return EnviromentRepository.enviromentRepository;
    }

    @Override
    public String toString() {
        return "EnviromentRepository{" +
            "javaVersion='" + javaVersion + '\'' +
            ", javaVendor='" + javaVendor + '\'' +
            ", osName='" + osName + '\'' +
            ", osArchitecture='" + osArchitecture + '\'' +
            ", userName='" + userName + '\'' +
            '}';
    }

}

/**
 * Exemplo: Facade
 */
class Database {

    public void insert(String table, Map<String, String> columnValuesPairs) {

        String columnNames = String.join(", ", columnValuesPairs.keySet());
        String columnValues = String.join(", ", columnValuesPairs.values());

        System.out.println("executing query:");
        System.out.printf("INSERT INTO %s ( %s ) VALUES ( %s );", table, columnNames, columnValues);
        System.out.println();

    }

    public void delete( String table, String idColumnName, String idToDelete ) {

        System.out.println("executing query:");
        System.out.printf("DELETE FROM %s WHERE %s = %s;", table, idColumnName, idToDelete);
        System.out.println();

    }

}


public class Questao13 {

    public static void main(String[] args) {

        // Exemplo iterator
        System.out.println("Exemplo iterator");
        IterableStringQueue stringQueue = new IterableStringQueue(
            "primeira interação",
            "segunda interação",
            "terceira interação"
        );

        while (stringQueue.hasNext()) {
            System.out.println(stringQueue.next());
        }

        System.out.println();

        // Exemplo Singleton
        System.out.println("Exemplo Singleton");
        EnviromentRepository envRepository = EnviromentRepository.getEnvRepository();
        EnviromentRepository envRepository2 = EnviromentRepository.getEnvRepository();
        if (envRepository.equals(envRepository2)) {
            System.out.println("They are the same object!");
            //System.out.println("They are the same picture!");
        }

        System.out.println();

        // Exemplo Facade
        System.out.println("Exemplo Facade");
        Database databaseFacade = new Database();

        databaseFacade.insert(
            "pessoa",
            Map.of(
                "nome", "John Doe",
                "email", "john.doe@mail.com",
                "password", "onetwothree"
            )
        );

        databaseFacade.delete( "pessoa", "id", "1" );

    }

}
