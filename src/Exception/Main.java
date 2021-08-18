package Exception;

import Exception.Entity.*;
import Exception.Exceptions.CargoInvalidoException;
import Exception.Exceptions.QuantidadeIndisponivelException;
import Exception.Exceptions.QuantidadeItemInvalidoException;

public class Main {

    public static void main(String[] args) {

        Produto[] produtos = {
            new Produto(1, "Produto X", 1.5, 5),
            new Produto(2, "Produto Y", 2.5, 10),
            new Produto(3, "Produto Z", 3.5, 15),
        };
        Cidade cidade = new Cidade(1, "Umuarama", new Estado(1, "Paraná"));
        Funcionario vendedor = new Funcionario(
            1,
            "Vendedor X",
            "536.528.720-70",
            750.0,
            new TipoFuncionario(1, "vendedor"),
            new Endereco(
                1,
                "Rua X",
                1234,
                "complemnto X",
                new Bairro(1, "Bairro X")
            )
        );
        Funcionario caixa = new Funcionario(
            2,
            "Caixa Y",
            "920.786.470-39",
            950.0,
            new TipoFuncionario(2, "caixa"),
            new Endereco(
                2,
                "Rua Y",
                4321,
                "complemnto Y",
                new Bairro(2, "Bairro Y")
            )
        );
        Pessoa cliente = new Pessoa(
            3,
            "Cliente Z",
            "524.568.480-20",
            new Endereco(
                3,
                "Rua Z",
                9876,
                "complemnto Z",
                new Bairro(3, "Bairro Z")
            )
        );

        Nota nota = new Nota(cliente);

        try {
            nota.setVendedor(vendedor);
            nota.setCaixa(caixa);
            // nota.setCaixa(vendedor);
        } catch (CargoInvalidoException e) {
            System.out.println(e);
            return;
        }

        try {

            nota.addItem(new NotaItem(produtos[0], produtos[0].getValorUnitario() * 1.5, 5))
                .addItem(new NotaItem(produtos[1], produtos[1].getValorUnitario(), 5))
                //.addItem(new NotaItem(produtos[1], produtos[0].getValorUnitario(), 11))
            ;
            NotaItem notaItem = new NotaItem(produtos[2], produtos[2].getValorUnitario(), 2);
            notaItem.setQuantidade( 4 );
            //notaItem.setQuantidade( -1 );

        } catch (QuantidadeIndisponivelException | QuantidadeItemInvalidoException e) {
            System.out.println(e);
            return;
        }

        System.out.println(nota);

    }

}
