package Threads.PhilosophersDinner;

public class Philosopher extends Thread {

    Debugger debugger = new Debugger("Philosopher");
    Fork leftFork;
    Fork rightFork;
    long id;

    public Philosopher(Fork leftFork, Fork rightFork) {
        this.leftFork = leftFork;
        this.rightFork = rightFork;
    }

    private boolean takeForks() {
        debugger.debug("try take forks...");
        if (this.leftFork.take()) {
            if (this.rightFork.take()) {
                return true;
            }
            this.leftFork.release();
        }
        debugger.debug("forks are already in use, return to sleep...");
        return false;
    }

    private void eat() {
        debugger.threadSleepForRandomSeconds(5, "eating...");
    }

    @Override
    public void run() {
        this.id = Thread.currentThread().getId();
        debugger.threadSleepForRandomSeconds(5, "running...");

        while (true) {
            debugger.threadSleepForRandomSeconds(5, "sleeping");
            if (this.takeForks()) {
                this.eat();
                leftFork.release();
                rightFork.release();
            }
        }
    }
}
