package ase.course8.threads.cooperation;

public class Consumer extends Thread {

    private final Buffer buffer;

    public Consumer(Buffer buffer) {
        this.buffer = buffer;
    }

    public void run() {
        for (int i = 1; i <= 5; i++) {
            buffer.consume();
            try {
                Thread.sleep(800); // simulare timp de consum
            } catch (InterruptedException e) {

            }
        }
    }
}
