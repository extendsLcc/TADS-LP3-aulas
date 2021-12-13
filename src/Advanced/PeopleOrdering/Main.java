package Advanced.PeopleOrdering;

public class Main {

    public static void main(String[] args) {
        Person[] persons = {
            new Person("Person X", 30, 1.65),
            new Person("Person Y", 20, 1.70),
            new Person("Person Z", 40, 1.50),
        };

        People people = new People();

        for (Person person : persons) {
            people.add(person);
        }

        people.show();
        people.order(OrderingMethod.STREAM);
        people.show();

    }

}
