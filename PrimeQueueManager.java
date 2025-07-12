import java.util.LinkedList;
import java.util.Queue;

public class PrimeQueueManager {
    private final Queue<Integer> queue = new LinkedList<>();
    private final int capacity;
    
    public PrimeQueueManager(int capacity) {
        this.capacity = capacity;
    }
    
    public synchronized void agregar(int numero) throws InterruptedException {
        while (queue.size() == capacity) {
            wait();
        }
        queue.offer(numero);
        notifyAll();
    }
    
    public synchronized Integer obtener() throws InterruptedException {
        while (queue.isEmpty()) {
            wait();
        }
        int numero = queue.poll();
        notifyAll();
        return numero;
    }
    
    public synchronized boolean estaVacia() {
        return queue.isEmpty();
    }
}

