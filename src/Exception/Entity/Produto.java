package Exception.Entity;

public class Produto {

    private int id;
    private String nome;
    private double valorUnitario;
    private int quantidadeEstoque;

    public Produto(int id, String nome, double valorUnitario, int quantidadeEstoque) {
        this.id = id;
        this.nome = nome;
        this.valorUnitario = valorUnitario;
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public int getId() {
        return id;
    }

    public Produto setId(int id) {
        this.id = id;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public Produto setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public double getValorUnitario() {
        return valorUnitario;
    }

    public Produto setValorUnitario(double valorUnitario) {
        this.valorUnitario = valorUnitario;
        return this;
    }

    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public Produto setQuantidadeEstoque(int quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
        return this;
    }

    @Override
    public String toString() {
        return "Produto{" +
            "id=" + id +
            ", nome='" + nome + "'\n" +
            ", valorUnitario=" + valorUnitario +
            ", quantidadeEstoque=" + quantidadeEstoque +
            '}';
    }
}
