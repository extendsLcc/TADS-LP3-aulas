package Advanced.PeopleOrdering;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class People {
    List<Person> personList = new ArrayList<>();

    public void add(Person person) {
        this.personList.add(person);
    }

    public void order(OrderingMethod orderingMethod) {

        switch (orderingMethod) {
            case STREAM -> this.personList = this.personList.stream()
                //.sorted((personA, personB) -> Integer.compare(personA.age, personB.age))
                .sorted(Person::compareTo)
                .collect(Collectors.toList());
            case SPLIT -> this.personList = this.splitSortPersonListByAge(personList);
        }

    }

    public void orderBy(Comparator<Person> comparator) {
        this.orderBy(comparator, OrderingMethod.BUBBLE);
    }

    public void orderBy(Comparator<Person> comparator, OrderingMethod orderingMethod) {

        switch (orderingMethod) {
            case STREAM -> this.personList = this.personList.stream()
                .sorted(comparator)
                .collect(Collectors.toList());
            case BUBBLE -> this.personList = this.bubbleSort(this.personList, comparator);
        }

    }

    public void show() {
        System.out.println("Printing person list...");
        for (Person person : this.personList) {
            System.out.println(person);
        }
    }

    /**
     * Order given person list by age
     *
     * @see | REFECENCE: https://www.youtube.com/watch?v=cVMKXKoGu_Y
     */
    private List<Person> splitSortPersonListByAge(List<Person> personList) {
        if (personList.size() > 1) {
            List<Person> lowerAgeList = new ArrayList<>();
            List<Person> higherAgeList = new ArrayList<>();
            int middleListIndex = personList.size() / 2;
            Person comparingReferencePerson = personList.remove(middleListIndex);

            for (Person person : personList) {
                if (person.age < comparingReferencePerson.age) {
                    lowerAgeList.add(person);
                } else {
                    higherAgeList.add(person);
                }
            }
            personList.clear();
            personList.addAll(this.splitSortPersonListByAge(lowerAgeList));
            personList.add(comparingReferencePerson);
            personList.addAll(this.splitSortPersonListByAge(higherAgeList));
            return personList;
        }
        return personList;
    }

    private List<Person> bubbleSort(List<Person> personList, Comparator<Person> personComparator) {
        boolean isSorted = false;

        while (!isSorted) {
            isSorted = true;

            for (int index = 0; index < personList.size() - 1; index++) {
                Person personA = personList.get(index);
                Person personB = personList.get(index + 1);

                if (personComparator.compare(personA, personB) > 0) {
                    personList.remove(index + 1);
                    personList.add(index, personB);
                    isSorted = false;
                }
            }
        }
        return personList;
    }

}

enum OrderingMethod {
    STREAM,
    SPLIT,
    BUBBLE,
}