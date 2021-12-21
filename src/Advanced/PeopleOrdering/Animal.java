package Advanced.PeopleOrdering;

public class Animal {
    String name;
    int age;
    double weight;
    Race race;

    public Animal(String name, int age, double weight, Race race) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.race = race;
    }

    @Override
    public String toString() {
        return "Animal{" +
            "age=" + age +
            ", weight=" + weight +
            ", name='" + name + '\'' +
            ", race=" + race +
            '}';
    }
}

class Race implements Comparable<Race> {
    String name;

    public Race(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Race{" +
            "name='" + name + '\'' +
            '}';
    }

    @Override
    public int compareTo(Race race) {
        return this.name.compareTo(race.name);
    }
}