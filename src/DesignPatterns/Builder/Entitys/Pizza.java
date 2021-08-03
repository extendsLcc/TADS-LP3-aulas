package DesignPatterns.Builder.Entitys;

import java.util.ArrayList;
import java.util.List;

public class Pizza {

    private final String nome;
    private final List<Cheese> cheeses = new ArrayList<>();
    private final List<Item> items = new ArrayList<>();
    private final List<Sauce> sauces = new ArrayList<>();

    public Pizza(String nome, List<Cheese> cheeses, List<Item> items, List<Sauce> sauces) {
        this.nome = nome;
        this.cheeses.addAll(cheeses);
        this.items.addAll(items);
        this.sauces.addAll(sauces);
    }

    @Override
    public String toString() {
        return "Pizza{" +
            "nome='" + nome + '\'' +
            ", cheeses=" + cheeses +
            ", items=" + items +
            ", sauces=" + sauces +
            '}';
    }

}
