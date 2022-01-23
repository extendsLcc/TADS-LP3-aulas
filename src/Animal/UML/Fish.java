package Animal.UML;

public class Fish extends Animal implements Pet{

    private static final int FISH_LEGS_COUNT = 0;
    private String name;

    public Fish() {
        super(Fish.FISH_LEGS_COUNT);
    }

    public Fish(String name) {
        super(Fish.FISH_LEGS_COUNT);
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
    public void walk() {
        System.out.println("Fish cannot walk");
    }

    @Override
    public void play() {
        System.out.println("Fish is playing...");
    }

    @Override
    public void eat() {
        System.out.println("Fish is ");
        super.eat();
    }

}
