package MVC.Aula53;

import java.util.List;
import java.util.Scanner;

public class View {
    Scanner teclado = new Scanner(System.in);

    public int showMenu() {
        System.out.println("\n---");
        System.out.println("0 - Sair");
        System.out.println("1 - Adicionar Estudante");
        System.out.println("2 - Adicionar Professor");
        System.out.println("3 - Listar todas pessoas");
        System.out.print("Digite uma opcao: " );
        int opcao = teclado.nextInt();
        return opcao;
    }

    public String addStudent() {
        String info;
        System.out.println("--\nDigite informacoes estudante:");
        System.out.println("Informacoes: <nome, sobrenome, idade, id_estudante, turma>");
        System.out.print("-- ");

        Scanner scanner = new Scanner(System.in);
        info = scanner.nextLine();
        return info;
    }

    public String addTeacher(){
        String info;
        System.out.println("--\nDigite informacoes professor:");
        System.out.println("Informacoes: <nome, sobrenome, idade, classrom, salario>");
        System.out.print("-- ");
        Scanner scanner = new Scanner(System.in);
        info = scanner.nextLine();
        return info;
    }

    public void listPeople(List<Person> pessoas) {
        System.out.println("\nListando pessoas:");
        for(Person p : pessoas) {
            System.out.println(p.toString());
        }
    }

}
