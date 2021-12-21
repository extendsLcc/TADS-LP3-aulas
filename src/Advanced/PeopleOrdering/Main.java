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
        System.out.println("SortBy Age, split algorithm");
        people.order(OrderingMethod.STREAM);
        people.show();

        System.out.println("SortBy Height");
        people.orderBy((Person personA, Person personB) -> Double.compare(personA.height, personB.height), OrderingMethod.BUBBLE);
        people.show();

        System.out.println("SortBy Age");
        people.orderBy((Person personA, Person personB) -> Integer.compare(personA.age, personB.age), OrderingMethod.BUBBLE);
        people.show();

        System.out.println("SortBy Name");
        people.orderBy((Person personA, Person personB) -> personA.name.compareTo(personB.name), OrderingMethod.BUBBLE);
        people.show();


        Group<Person> personGroup = new Group<>(Person.class);
        for (Person person : persons) {
            personGroup.add(person);
        }
        try {
            personGroup.orderBy("age");
            System.out.println(personGroup.group);
            personGroup.orderBy("height");
            System.out.println(personGroup.group);
            personGroup.orderBy("name");
            System.out.println(personGroup.group);
        } catch (NoSuchFieldException | NonComparableFieldType nonComparableFieldType) {
            nonComparableFieldType.printStackTrace();
        }

    }

}
