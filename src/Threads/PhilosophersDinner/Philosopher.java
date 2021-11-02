package Threads.PhilosophersDinner;

public class Philosopher extends Thread {

    Debugger debugger;
    String name;
    Fork leftFork;
    Fork rightFork;
    long id;

    public Philosopher(String name, Fork leftFork, Fork rightFork) {
        this.name = name;
        this.leftFork = leftFork;
        this.rightFork = rightFork;
        this.debugger = new Debugger("Philosopher " + name);
    }

    private boolean takeForks() {
        debugger.debug(this.name + " is trying take forks...");
        if (this.leftFork.take()) {
            if (this.rightFork.take()) {
                return true;
            }
            this.leftFork.release();
        }
        debugger.debug("forks are already in use, " + this.name + " returns to sleep...");
        return false;
    }

    private void eat() {
        debugger.threadSleepForRandomSeconds(5, this.name + " is eating...");
    }

    @Override
    public void run() {
        this.id = Thread.currentThread().getId();
        debugger.threadSleepForRandomSeconds(5, this.name + " thread is running...");

        while (true) {
            debugger.threadSleepForRandomSeconds(5, this.name + " is sleeping...");
            if (this.takeForks()) {
                this.eat();
                leftFork.release();
                rightFork.release();
            }
        }
    }
}
