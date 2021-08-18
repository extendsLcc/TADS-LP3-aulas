package Exception.Entity;

public class Endereco {

    int id;
    String nomeRua;
    int numero;
    String complemento;
    Bairro bairro;

    public Endereco(int id, String nomeRua, int numero, String complemento, Bairro bairro) {
        this.id = id;
        this.nomeRua = nomeRua;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
    }

    @Override
    public String toString() {
        return "Endereco{" +
            "id=" + id +
            ", nomeRua='" + nomeRua + "'\n" +
            ", numero=" + numero +
            ", complemento='" + complemento + "'\n" +
            ", bairro=" + bairro +
            '}';
    }
}
