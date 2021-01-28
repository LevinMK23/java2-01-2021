package lesson5;

import java.util.concurrent.TimeUnit;

public class CustomThread extends Thread {

    int num;
    private boolean running;

    public CustomThread(int num) {
        this.num = num;
        running = true;
    }

    public void stopThread() {
        running = false;
    }

    @Override
    public void run() {
        while (running) {
            System.out.println(num);
            try {
                TimeUnit.MILLISECONDS.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void foo() {
        System.out.println("*");
    }
}
