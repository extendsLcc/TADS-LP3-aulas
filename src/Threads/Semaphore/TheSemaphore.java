package Threads.Semaphore;

public interface TheSemaphore {

    void acquire();

    void release();

    boolean isFull();

    boolean isEmpty();

    boolean tryAcquire();

    boolean tryRelease();

    int available();

}
