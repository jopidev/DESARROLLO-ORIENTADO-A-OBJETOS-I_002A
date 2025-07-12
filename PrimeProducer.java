import java.util.Random;

public class PrimeProducer implements Runnable {
    private final PrimeQueueManager queueManager;
    private final int totalNumeros;
    
    public PrimeProducer(PrimeQueueManager queueManager, int totalNumeros) {
        this.queueManager = queueManager;
        this.totalNumeros = totalNumeros;
    }
    
    @Override
    public void run() {
        Random random = new Random();
        for (int i = 0; i < totalNumeros; i++) {
            int numero = 100 + random.nextInt(900);
            try {
                queueManager.agregar(numero);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }
}

