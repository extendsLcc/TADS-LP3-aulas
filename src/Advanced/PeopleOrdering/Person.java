package Advanced.PeopleOrdering;

public class Person implements Comparable<Person> {
    String name;
    int age;
    double height;

    public Person(String name, int age, double height) {
        this.name = name;
        this.age = age;
        this.height = height;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
            "name='" + name + '\'' +
            ", age='" + age + '\'' +
            ", height=" + height +
            '}';
    }

    @Override
    public int compareTo(Person person) {
        return Integer.compare(this.age, person.age);
    }

}
