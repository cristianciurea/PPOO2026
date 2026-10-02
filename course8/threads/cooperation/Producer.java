package ase.course8.threads.cooperation;

public class Producer extends Thread {

    private final Buffer buffer;

    public Producer(Buffer buffer) {
        this.buffer = buffer;
    }

    public void run() {
        for (int i = 1; i <= 5; i++) {
            buffer.produce(i);
            try {
                Thread.sleep(500); // simulare timp de producție
            } catch (InterruptedException e) {

            }
        }
    }
}
