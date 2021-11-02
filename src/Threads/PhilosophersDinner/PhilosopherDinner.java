package Threads.PhilosophersDinner;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PhilosopherDinner {

    public static void main(String[] args) {

        Debugger debugger = new Debugger("Main");
        SilverwareDrawer silverwareDrawer = new SilverwareDrawer();
        Philosopher[] philosophers = {
            new Philosopher("Kant", silverwareDrawer.takeLeftFork(), silverwareDrawer.takeRightFork()),
            new Philosopher("Socrates", silverwareDrawer.takeLeftFork(), silverwareDrawer.takeRightFork()),
            new Philosopher("Plato", silverwareDrawer.takeLeftFork(), silverwareDrawer.takeRightFork()),
            new Philosopher("Nietzsche", silverwareDrawer.takeLeftFork(), silverwareDrawer.takeRightFork()),
            new Philosopher("Buddha", silverwareDrawer.takeLeftFork(), silverwareDrawer.takeRightFork()),
        };

        debugger.debug("Start application");

        for (Philosopher philosopher : philosophers) {
            philosopher.start();
        }

    }

    private static class SilverwareDrawer {

        private int currentPosition = 0;
        private final List<Fork> forkList = IntStream
            .range(0, 5)
            .mapToObj((i) -> new Fork("fork(" + i + ")"))
            .collect(Collectors.toList());

        public Fork takeLeftFork() {
            return this.forkList.get(++this.currentPosition % this.forkList.size());
        }

        /**
         * Will throws error if called after currentPosition reaches forkList size
         *
         * @return Fork
         */
        public Fork takeRightFork() {
            int rightForkPosition = this.currentPosition - 1;
            return this.forkList.get(rightForkPosition);
        }

    }

}
