package Exception.Entity;

import Exception.Exceptions.CargoInvalidoException;
import Exception.Exceptions.QuantidadeIndisponivelException;

import java.util.ArrayList;
import java.util.List;

public class Nota {

    private Pessoa cliente;
    private final List<NotaItem> notaItems = new ArrayList<>();
    private Funcionario vendedor;
    private Funcionario caixa;
    private double valor = 0;

    public Nota(Pessoa cliente) {
        this.cliente = cliente;
    }

    public Nota addItem(NotaItem notaItem) throws QuantidadeIndisponivelException {
        this.descontaEstoqueDoItem(notaItem);
        this.notaItems.add(notaItem);
        return this;
    }

    public List<NotaItem> getNotaItems() {
        return notaItems;
    }

    public Pessoa getCliente() {
        return cliente;
    }

    public Nota setCliente(Pessoa cliente) {
        this.cliente = cliente;
        return this;
    }

    public Funcionario getVendedor() {
        return vendedor;
    }

    public Nota setVendedor(Funcionario vendedor) throws CargoInvalidoException {

        if (!vendedor.tipoFuncionario.cargo.equalsIgnoreCase("vendedor")) {
            throw new CargoInvalidoException("O funcionário não é um vendedor!");
        }

        this.vendedor = vendedor;
        return this;
    }

    public Funcionario getCaixa() {
        return caixa;
    }

    public Nota setCaixa(Funcionario caixa) throws CargoInvalidoException {

        if (!caixa.tipoFuncionario.cargo.equalsIgnoreCase("caixa")) {
            throw new CargoInvalidoException("O funcionário não é um caixa");
        }

        this.caixa = caixa;
        return this;
    }

    public double getValor() {
        return valor;
    }

    private Nota setValor(double valor) {
        this.valor = valor;
        return this;
    }

    private void addValorOfItem(NotaItem notaItem) {

        this.setValor(this.getValor() + notaItem.getQuantidade() * notaItem.getQuantidade());

    }

    private void descontaEstoqueDoItem(NotaItem notaItem) throws QuantidadeIndisponivelException {

        Produto produto = notaItem.getProduto();
        int novaQuantidadeEmEstoque = produto.getQuantidadeEstoque() - notaItem.getQuantidade();

        if (novaQuantidadeEmEstoque < 0) {
            throw new QuantidadeIndisponivelException("Quantidade solicitada não disponivel em estoque!");
        }

        produto.setQuantidadeEstoque(novaQuantidadeEmEstoque);

    }

    @Override
    public String toString() {
        return "Nota{" +
            "cliente=" + cliente +
            ", notaItems=" + notaItems +
            ", vendedor=" + vendedor +
            ", caixa=" + caixa +
            ", valor=" + valor +
            '}';
    }

}
