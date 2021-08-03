package DesignPatterns.Builder;

public class Main {

    public static void main(String[] args) {

        Builder pizzaBuilder = new PizzaBuilder();
        Director pizzaiolo = new Director();

        System.out.println(pizzaiolo.createPizzaMargerita(pizzaBuilder));
        System.out.println(pizzaiolo.createPizzaQuatroQueijos(pizzaBuilder));
        System.out.println(pizzaiolo.createPizzaAbobrinha(pizzaBuilder));
        System.out.println(pizzaiolo.createPizzaAlcachofrinha(pizzaBuilder));
        System.out.println(pizzaiolo.createPizzaFileComBacon(pizzaBuilder));
        System.out.println(pizzaiolo.createPizzaFrancesa(pizzaBuilder));

    }

}
