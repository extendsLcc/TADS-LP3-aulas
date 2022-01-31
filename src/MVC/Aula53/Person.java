package MVC.Aula53;

public abstract class Person {
    String nome, sobrenome;
    int idade;

    public Person(String nome, String sobrenome, int idade) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.idade = idade;
    }

    public abstract String toString();

}
