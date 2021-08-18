package Exception.Entity;

public class TipoFuncionario {

    int id;
    String cargo;

    public TipoFuncionario(int id, String cargo) {
        this.id = id;
        this.cargo = cargo;
    }

    @Override
    public String toString() {
        return "TipoFuncionario{" +
            "id=" + id +
            ", cargo='" + cargo + "'\n" +
            '}';
    }
}
