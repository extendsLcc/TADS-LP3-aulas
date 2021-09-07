package DataAccessLayer.DAL;

class ProdutoDTO {

    int id;
    String nome;
    double valorUnitario;

    @Override
    public String toString() {
        return "ProdutoDAO{" +
            "id=" + id +
            ", nome='" + nome + '\'' +
            ", valorUnitario=" + valorUnitario +
            '}';
    }

}

public class Produto extends ProdutoDTO{
}
