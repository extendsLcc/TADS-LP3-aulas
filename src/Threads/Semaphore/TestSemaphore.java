package Threads.Semaphore;


class MyThread extends Thread {

    Debugger debugger = new Debugger("MyThread");
    TheSemaphore semaphore;

    public MyThread(TheSemaphore semaphore) {
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        this.debugger.threadSleep();
        this.semaphore.acquire();
        this.debugger.debug("rodando algo dentro do adcquire");
        this.semaphore.release();
    }
}

public class TestSemaphore {

    public static void main(String[] args) throws InterruptedException {
        Debugger debugger = new Debugger("MAIN");
        TheSemaphore semaphore = new MySemaphore(1);
        MyThread thread = new MyThread(semaphore);

        semaphore.acquire();
        thread.start();
        debugger.threadSleep(5);

        debugger.debug("liberando recurso");
        semaphore.release();

        thread.join();
    }

}
