package Threads.PhilosophersDinner;

public class Philosopher extends Thread {

    Debugger debugger;
    String name;
    Fork leftFork;
    Fork rightFork;
    long id;
    int eatAmount = 0;

    public Philosopher(String name, Fork leftFork, Fork rightFork) {
        this.name = name;
        this.leftFork = leftFork;
        this.rightFork = rightFork;
        this.debugger = new Debugger("Philosopher " + name);
    }

    private boolean takeForks() {
        debugger.debug(this.name + " is trying take forks" + this.getForksNames() + "...");
        if (this.leftFork.take()) {
            if (this.rightFork.take()) {
                return true;
            }
            debugger.debug("right fork( " + this.leftFork.forkName + " ) are already in use, " + this.name + " returns to sleep...");
            this.leftFork.release();
            return false;
        }
        debugger.debug("left fork( " + this.leftFork.forkName + " ) are already in use, " + this.name + " returns to sleep...");
        return false;
    }

    private void eat() {
        this.eatAmount++;
        debugger.threadSleepForRandomSeconds(5, this.name + " is eating...");
    }

    private boolean isStuffed() {
        return this.eatAmount >= 3;
    }

    @Override
    public void run() {
        this.id = Thread.currentThread().getId();
        debugger.threadSleepForRandomSeconds(5, this.name + " thread is running...");

        while (!this.isStuffed()) {
            debugger.threadSleepForRandomSeconds(5, this.name + " is sleeping...");
            if (this.takeForks()) {
                debugger.debug(  this.name + " taken both forks" + this.getForksNames() + ", begin to eat...");
                this.eat();
                leftFork.release();
                rightFork.release();
                debugger.debug( this.name + " put both forks" + this.getForksNames() + " back in table...");
            }
        }

        debugger.debug(this.name + " is already stuffed, and will not eat anymore");
    }

    private String getForksNames() {
        return "( L: " + this.leftFork.forkName + ", R: " + this.rightFork.forkName + " )";
    }
}
