package MVC.Aula53;

import java.util.LinkedList;
import java.util.List;

public class Controller {

    View view;
    List<Person> persons;

    public Controller() {
        this.view = new View();
        this.persons = new LinkedList<Person>();
    }

    public void run() {
        do {
            int op = view.showMenu(); // digite uma opcao: 1, 2, 3...

            if (op == 0) break;

            if (op == 1) {
                String info = view.addStudent();
                this.addStudent(info);
                continue;
            }

            if (op == 2) {
                String info = view.addTeacher();
                this.addTeacher(info);
                continue;
            }

            if (op == 3) {
                view.listPeople(this.persons);
                continue;
            }

        } while (true);
    }

    public void addStudent(String info) {
        // info = "       teste        ";
        info = info.strip();

        // marcelo, pereira, 22, 33333, ...
        String[] arr = info.split(",");
        String nome, sobrenome;
        int idade, id, turma;

        nome = arr[0].strip();
        sobrenome = arr[1].strip();
        idade = Integer.parseInt(arr[2].strip());
        id = Integer.parseInt(arr[3].strip());
        turma = Integer.parseInt(arr[4].strip());

        Person estudante = new Student(nome, sobrenome, idade, id, turma);
        persons.add(estudante);
    }

    public void addTeacher(String info) {
        info = info.strip();

        String[] arr = info.split(",");
        String nome, sobrenome, classroom;
        int idade, salario;

        nome = arr[0].strip();
        sobrenome = arr[1].strip();
        idade = Integer.parseInt(arr[2].strip());
        classroom = arr[3].strip();
        salario = Integer.parseInt(arr[4].strip());

        Person teacher = new Teacher(nome, sobrenome, idade, classroom, salario);
        persons.add(teacher);
    }


    public static void main(String args[]) {
        Controller principal = new Controller();
        principal.run();
    }
}
