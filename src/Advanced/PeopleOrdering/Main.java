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


        Race[] races = {
            new Race("Dog"),
            new Race("Bird"),
        };
        Animal[] animals = {
            new Animal("Naylon", 5, 1.2, races[0]),
            new Animal("Feathers", 15, 0.3, races[1]),
            new Animal("Cait", 2, 0.8, races[1]),
        };

        Group<Animal> animalGroup = new Group<>(Animal.class);
        for (Animal animal : animals) {
            animalGroup.add(animal);
        }
        try {
            animalGroup.orderBy("name");
            System.out.println(animalGroup.group);
            animalGroup.orderBy("age");
            System.out.println(animalGroup.group);
            animalGroup.orderBy("weight");
            System.out.println(animalGroup.group);
            animalGroup.orderBy("race");
            System.out.println(animalGroup.group);
        } catch (NoSuchFieldException | NonComparableFieldType nonComparableFieldType) {
            nonComparableFieldType.printStackTrace();
        }

    }

}
