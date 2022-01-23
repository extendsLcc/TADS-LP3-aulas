package Animal.UML;

public class Main {

    public static void main(String[] args) {
        Cat cat = new Cat("Neko");
        cat.play();
        cat.walk();

        Pet fish = new Fish();
        fish.play();

        Animal spider = new Spider();
        spider.walk();
        spider.eat();
    }

}
