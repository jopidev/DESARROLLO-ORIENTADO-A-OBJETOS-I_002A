public class Main {
    public static void main(String[] args) {
        PrimesList primes = new PrimesList();

        PrimeWorker hilo1 = new PrimeWorker(primes, 1, 500);
        PrimeWorker hilo2 = new PrimeWorker(primes, 501, 1000);

        hilo1.start();
        hilo2.start();

        try {
            hilo1.join();
            hilo2.join();
        } catch (InterruptedException e) {
            System.out.println("Error al esperar los hilos: " + e.getMessage());
        }

        System.out.println("Cantidad total de códigos primos almacenados: " + primes.getPrimesCount());
        System.out.println("Códigos primos encontrados:");
        System.out.println(primes);
    }
}

