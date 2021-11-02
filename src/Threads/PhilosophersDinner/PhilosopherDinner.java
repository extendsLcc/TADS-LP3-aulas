package Threads.PhilosophersDinner;

public class PhilosopherDinner {

    public static void main(String[] args) {
        Fork forkOne = new Fork();
        Fork forkTwo = new Fork();

        Philosopher socrates = new Philosopher(forkOne, forkTwo);
        Philosopher kant = new Philosopher(forkTwo, forkOne);

        socrates.start();
        kant.start();

    }

}
