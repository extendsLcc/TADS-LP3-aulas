package Threads.PhilosophersDinner;

public class Fork {

    TheSemaphore fork = new MySemaphore(1);

    public Fork() {
    }

    public boolean take() {
        return this.fork.tryAcquire();
    }

    public void release() {
        this.fork.release();
    }

}
