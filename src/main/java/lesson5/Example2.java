package lesson5;

import java.util.concurrent.TimeUnit;

public class Example2 {
    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[4];
        Object monitor = new Object();
        long start = System.currentTimeMillis();
        for (int i = 0; i < 4; i++) {
            threads[i] = new Thread(new IncrementTask(monitor));
            System.out.println(threads[i].getName() + ": state " + threads[i].getState());
            threads[i].start();
            System.out.println(threads[i].getName() + ": state " + threads[i].getState());
        }

        boolean alive = true;
        while (alive) {
            boolean live = false;
            // 0 0 0 1 = 1
            // 0 0 0 0 = 0
            for (Thread thread : threads) {
                live |= thread.isAlive();
                System.out.println(thread.getName() + ": state " + thread.getState());
                TimeUnit.MILLISECONDS.sleep(200);
            }
            alive = live;
        }
        // TimeUnit.SECONDS.sleep(1);
        long end = System.currentTimeMillis();
        System.out.println(IncrementTask.counter + " time: " + (end - start));
    }

}
