package Advanced.PeopleOrdering;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class People {
    List<Person> personList = new ArrayList<>();

    public void add(Person person) {
        this.personList.add(person);
    }

    public void order() {

        this.personList = this.personList.stream()
            .sorted((personA, personB) -> Integer.compare(personA.age, personB.age))
            .collect(Collectors.toList());

    }

    public void show() {
        System.out.println("Printing person list...");
        for (Person person : this.personList) {
            System.out.println(person);
        }
    }

}
