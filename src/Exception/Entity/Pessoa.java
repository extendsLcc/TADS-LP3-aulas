package Exception.Entity;

public class Pessoa {

    int idPessoa;
    String nome;
    String cpf;
    Endereco endereco;

    public Pessoa(int idPessoa, String nome, String cpf, Endereco endereco) {
        this.idPessoa = idPessoa;
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
            "idPessoa=" + idPessoa +
            ", nome='" + nome + "'\n" +
            ", cpf='" + cpf + "'\n" +
            ", endereco=" + endereco +
            '}';
    }
}
