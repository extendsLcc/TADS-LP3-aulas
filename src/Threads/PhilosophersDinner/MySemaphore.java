package Threads.PhilosophersDinner;

public class MySemaphore implements TheSemaphore {

    int count = 0;
    int max = 1;

    public MySemaphore() {
    }

    public MySemaphore(int resources) {
        this.max = resources;
    }

    public MySemaphore(int resources, int max) {
        this.count = resources;
        this.max = max;
    }

    private void myWait() {
        try {
            this.wait();
        } catch (InterruptedException ignore) {
        }
    }

    public synchronized void acquire() {
        while (this.isFull()) {
            this.myWait();
        }
        this.count++;
        this.notifyAll();
    }

    public synchronized void release() {
        while (this.isEmpty()) {
            this.myWait();
        }
        this.count--;
        this.notifyAll();
    }

    public synchronized boolean isFull() {
        return this.count >= this.max;
    }

    public synchronized boolean isEmpty() {
        return this.count <= 0;
    }

    public synchronized boolean tryAcquire() {
        if (this.isFull()) {
            return false;
        }
        this.acquire();
        return true;
    }

    public synchronized boolean tryRelease() {
        if (this.isEmpty()) {
            return false;
        }
        this.release();
        return true;
    }

    public int available() {
        return this.max - this.count;
    }
}
