package Animal.UML;

public class Spider extends Animal
{
    private static final int SPIDER_LEGS_COUNT = 8;

    public Spider() {
        super(Spider.SPIDER_LEGS_COUNT);
    }

    @Override
    public void eat() {
        System.out.println("Spider is ");
        super.eat();
    }
}
