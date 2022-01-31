package MVC.Aula53;

public class Teacher extends Person {

    private String classroom;
    private Integer salary;

    public Teacher(String nome, String sobrenome, int idade, String classroom, Integer salary) {
        super(nome, sobrenome, idade);
        this.classroom = classroom;
        this.salary = salary;
    }

    public String getClassroom() {
        return classroom;
    }

    public Integer getSalary() {
        return salary;
    }

    public void happyBirthday() {
        System.out.println("Happy birthday to " + this.nome);
    }

    @Override
    public String toString() {
        return "Teacher{" +
            "nome='" + nome + '\'' +
            ", sobrenome='" + sobrenome + '\'' +
            ", idade=" + idade +
            ", classroom='" + classroom + '\'' +
            ", salary=" + salary +
            '}';
    }
}
