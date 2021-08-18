package Exception.Entity;

public class Bairro {

    int id;
    String nome;

    public Bairro(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Bairro{" +
            "id=" + id +
            ", nome='" + nome + "'\n" +
            '}';
    }
}
