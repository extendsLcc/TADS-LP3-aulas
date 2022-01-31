package MVC.Aula53;

public class Student extends Person {
    int id, turma;

    public Student(String nome, String sobrenome, int idade, int id,
                   int turma ) {
        super(nome, sobrenome, idade);
        this.id = id;
        this.turma = turma;
    }

    @Override
    public String toString() {
        return "Student{" +
            "nome='" + nome + '\'' +
            ", sobrenome='" + sobrenome + '\'' +
            ", idade=" + idade +
            ", id=" + id +
            ", turma=" + turma +
            '}';
    }
}
