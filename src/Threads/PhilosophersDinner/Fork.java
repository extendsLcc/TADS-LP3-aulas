package Threads.PhilosophersDinner;

public class Fork {

    TheSemaphore fork = new MySemaphore(1);
    String forkName;

    public Fork(String forkName) {
        this.forkName = forkName;
    }

    public boolean take() {
        return this.fork.tryAcquire();
    }

    public void release() {
        this.fork.release();
    }

}
