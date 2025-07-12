import java.util.concurrent.locks.Lock;

public class PrimesThread implements Runnable {
    private final PrimesList primesList;
    private final Lock lock;
    private final PrimeQueueManager queueManager;
    private volatile boolean running = true;

    public PrimesThread(PrimesList primesList, Lock lock, PrimeQueueManager queueManager) {
        this.primesList = primesList;
        this.lock = lock;
        this.queueManager = queueManager;
    }

    public void detener() {
        running = false;
    }

    @Override
    public void run() {
        while (running) {
            try {
                int numero = queueManager.obtener();
                if (primesList.isPrime(numero)) {
                    lock.lock();
                    try {
                        primesList.add(numero);
                        System.out.println(Thread.currentThread().getName() + " agregó primo: " + numero);
                    } catch (IllegalArgumentException ignored) {
                    } finally {
                        lock.unlock();
                    }
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }
}


