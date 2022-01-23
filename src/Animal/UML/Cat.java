package Animal.UML;

public class Cat extends Animal implements Pet{

    private static final int CAT_LEGS_COUNT = 4;
    private String name;

    public Cat() {
        super(Cat.CAT_LEGS_COUNT);
    }

    public Cat(String name) {
        super(Cat.CAT_LEGS_COUNT);
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void play() {
        System.out.println("Cat is playing...");
    }

    @Override
    public void eat() {
        System.out.println("Cat is ");
        super.eat();
    }
}
