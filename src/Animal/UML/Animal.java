package Animal.UML;

public class Animal {

    protected int legs;

    protected Animal(int legs) {
        this.legs = legs;
    }

    public void walk(){
        System.out.println("walking...");
    }

    public void eat(){
        System.out.println("eating...");
    }
}
