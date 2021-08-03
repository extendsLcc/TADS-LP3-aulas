package DesignPatterns.Builder.Entitys;

public abstract class Ingredient {

    String name;

    public Ingredient(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

}
