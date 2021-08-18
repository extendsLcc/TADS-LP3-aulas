package Exception.Entity;

public class Estado {

    int id;
    String nomeEstado;

    public Estado(int id, String nomeEstado) {
        this.id = id;
        this.nomeEstado = nomeEstado;
    }

    @Override
    public String toString() {
        return "Estado{" +
            "id=" + id +
            ", nomeEstado='" + nomeEstado + "'\n" +
            '}';
    }
}
