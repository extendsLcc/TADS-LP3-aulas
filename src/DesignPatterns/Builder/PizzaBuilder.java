package DesignPatterns.Builder;

import DesignPatterns.Builder.Entitys.Cheese;
import DesignPatterns.Builder.Entitys.Item;
import DesignPatterns.Builder.Entitys.Pizza;
import DesignPatterns.Builder.Entitys.Sauce;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PizzaBuilder implements Builder {

    private String name;
    private List<Cheese> cheeses = new ArrayList<>();
    private List<Item> items = new ArrayList<>();
    private List<Sauce> sauces = new ArrayList<>();

    @Override
    public Builder setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public Builder addCheese(String... cheese) {
        Arrays.stream(cheese)
            .forEach(cheeseName -> this.cheeses.add(new Cheese(cheeseName)));
        return this;
    }

    @Override
    public Builder addItem(String... item) {
        Arrays.stream(item)
            .forEach(itemName -> this.items.add(new Item(itemName)));
        return this;
    }

    @Override
    public Builder addSauce(String... sauce) {
        Arrays.stream(sauce)
            .forEach(sauceName -> this.sauces.add(new Sauce(sauceName)));
        return this;
    }

    @Override
    public Pizza build() {
        Pizza createdPizza = new Pizza(this.name, this.cheeses, this.items, this.sauces);
        this.clear();
        return createdPizza;
    }

    private void clear() {
        this.sauces.clear();
        this.items.clear();
        this.cheeses.clear();
        this.name = null;
    }

}
