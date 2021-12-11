package Advanced.PeopleOrdering;

public class Person {
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

}
