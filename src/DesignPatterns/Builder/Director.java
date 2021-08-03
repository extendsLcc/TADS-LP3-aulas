package DesignPatterns.Builder;

import DesignPatterns.Builder.Entitys.Pizza;

public class Director {

    public Pizza createPizzaMargerita(Builder builder) {
        return builder
            .setName("Marguerita")
            .addCheese("mozzarela")
            .addSauce("manjericão")
            .build();

    }

    public Pizza createPizzaQuatroQueijos(Builder builder) {
        return builder
            .setName("Quatro-queijos")
            .addCheese(
                "mozzarela",
                "parmesão",
                "gorgonzola",
                "minas frascal"
            )
            .addSauce("orégano")
            .build();
    }

    public Pizza createPizzaFileComBacon(Builder builder) {
        return builder
            .setName("Filé com Bacon")
            .addCheese(
                "mozzarella",
                "cheddar"
            )
            .addItem(
                "filé",
                "bacon crocante"
            )
            .build();
    }

    public Pizza createPizzaFrancesa(Builder builder) {
        return builder
            .setName("Francesa")
            .addCheese("catupiry")
            .addItem(
                "shitake",
                "shimeji",
                "champignon"
            )
            .build();
    }

    public Pizza createPizzaAbobrinha(Builder builder) {
        return builder
            .setName("Abobrinha")
            .addCheese(
                "muçarela",
                "catupiry",
                "parmesão"
            )
            .addItem("abobrinha")
            .build();
    }

    public Pizza createPizzaAlcachofrinha(Builder builder) {
        return builder
            .setName("Alcachofrinha")
            .addCheese("muçarela de búfula")
            .addItem(
                "azeitonas fatiadas",
                "alcachofra"
            )
            .build();
    }

}
