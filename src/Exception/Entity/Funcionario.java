package Exception.Entity;

public class Funcionario extends Pessoa {

    double valorSalario;
    TipoFuncionario tipoFuncionario;

    public Funcionario(int idPessoa, String nome, String cpf, double valorSalario, TipoFuncionario tipoFuncionario, Endereco endereco) {
        super(idPessoa, nome, cpf, endereco);
        this.valorSalario = valorSalario;
        this.tipoFuncionario = tipoFuncionario;
    }

    @Override
    public String toString() {
        return "Funcionario{" +
            "valorSalario=" + valorSalario +
            ", tipoFuncionario=" + tipoFuncionario +
            ", idPessoa=" + idPessoa +
            ", nome='" + nome + "'\n" +
            ", cpf='" + cpf + "'\n" +
            ", endereco=" + endereco +
            '}';
    }
}
