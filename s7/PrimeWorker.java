public class PrimeWorker extends Thread {
    private final PrimesList primesList;
    private final int start;
    private final int end;

    public PrimeWorker(PrimesList primesList, int start, int end) {
        this.primesList = primesList;
        this.start = start;
        this.end = end;
    }

    @Override
    public void run() {
        for (int i = start; i <= end; i++) {
            if (primesList.isPrime(i)) {
                synchronized (primesList) {
                    try {
                        primesList.add(i);
                        System.out.println("Thread " + getName() + " agregó el número primo: " + i);
                    } catch (IllegalArgumentException ignored) {
                        // Ya validado previamente, pero se ignora en caso de concurrencia
                    }
                }
            }
        }
    }
}

