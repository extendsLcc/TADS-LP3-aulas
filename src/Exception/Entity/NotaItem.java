package Exception.Entity;

import Exception.Exceptions.QuantidadeItemInvalidoException;

public class NotaItem {

    private Produto produto;
    private double valorVenda;
    private int quantidade;

    public NotaItem(Produto produto, double valorVenda, int quantidade) {
        this.produto = produto;
        this.valorVenda = valorVenda;
        this.quantidade = quantidade;
    }

    public Produto getProduto() {
        return produto;
    }

    public NotaItem setProduto(Produto produto) {
        this.produto = produto;
        return this;
    }

    public double getValorVenda() {
        return valorVenda;
    }

    public NotaItem setValorVenda(double valorVenda) {
        this.valorVenda = valorVenda;
        return this;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public NotaItem setQuantidade(int quantidade) throws QuantidadeItemInvalidoException {

        if (quantidade <= 0) {
            throw new QuantidadeItemInvalidoException("Quantidade do item da nota deve ser 1 ou maior");
        }

        this.quantidade = quantidade;
        return this;
    }

    @Override
    public String toString() {
        return "NotaItem{" +
            "produto=" + produto +
            ", valorVenda=" + valorVenda +
            ", quantidade=" + quantidade +
            '}';
    }

}
