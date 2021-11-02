package Threads.Semaphore;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class Debugger {

    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss.SSSS");
    Random random = new Random();
    String owner;

    public Debugger(String owner) {
        this.owner = owner;
    }

    public void debug(String message) {
        String time = LocalDateTime.now().format(dateTimeFormatter);
        long tid = Thread.currentThread().getId();
        String formattedMessage = String.format("%s, %s:%d, %s", time, owner, tid, message);
        System.out.println(formattedMessage);
    }

    public void threadSleep() {
        this.debug("doing something...");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }
    }

    public void threadSleep(int maxRandom) {
        int secondsToSleep = random.nextInt(maxRandom) + 1;
        this.debug("doing something...waiting for " + secondsToSleep + " second(s).");
        try {
            Thread.sleep(secondsToSleep * 1000);
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }
    }

    public void newLine() {
        System.out.println();
    }

}
