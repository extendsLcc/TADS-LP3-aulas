package CSV;

public class Iris {

    private double folhaComprimento;
    private double folhaLargura;
    private double petalaComprimento;
    private double petalaLargura;
    private String nomeFlor;

    public Iris(double folhaComprimento, double folhaLargura, double petalaComprimento, double petalaLargura, String nomeFlor) {
        this.folhaComprimento = folhaComprimento;
        this.folhaLargura = folhaLargura;
        this.petalaComprimento = petalaComprimento;
        this.petalaLargura = petalaLargura;
        this.nomeFlor = nomeFlor;
    }

    public double getFolhaComprimento() {
        return folhaComprimento;
    }

    public double getFolhaLargura() {
        return folhaLargura;
    }

    public double getPetalaComprimento() {
        return petalaComprimento;
    }

    public double getPetalaLargura() {
        return petalaLargura;
    }

    public String getNomeFlor() {
        return nomeFlor;
    }
}
