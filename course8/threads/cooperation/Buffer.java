package ase.course8.threads.cooperation;

public class Buffer {
    private int data;
    private boolean available = false;

    // Producătorul pune date în buffer
    public synchronized void produce(int value) {
        while (available) { // dacă deja e ceva în buffer, așteaptă
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        data = value;
        available = true;
        System.out.println("Producătorul a produs: " + value);
        notify(); // notifică consumatorul
    }

    // Consumatorul ia date din buffer
    public synchronized int consume() {
        while (!available) { // dacă bufferul e gol, așteaptă
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        available = false;
        System.out.println("Consumatorul a consumat: " + data);
        notify(); // notifică producătorul
        return data;
    }
}
