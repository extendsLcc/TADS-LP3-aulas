package Exception.Entity;

public class Cidade {

    int id;
    String nome;
    Estado estado;

    public Cidade(int id, String nome, Estado estado) {
        this.id = id;
        this.nome = nome;
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Cidade{" +
            "id=" + id +
            ", nome='" + nome + "'\n" +
            ", estado=" + estado +
            '}';
    }
}
