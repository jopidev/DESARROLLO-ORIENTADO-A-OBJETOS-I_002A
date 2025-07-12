import java.util.Scanner;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) {
        PrimesList lista = new PrimesList();
        Lock lock = new ReentrantLock();
        PrimeQueueManager queueManager = new PrimeQueueManager(10);
        Scanner scanner = new Scanner(System.in);

        Thread productor = null;
        Thread consumidor1 = null;
        Thread consumidor2 = null;

        boolean salir = false;

        while (!salir) {
            System.out.println("\nSafeVoteSystem - Menú Principal");
            System.out.println("1. Cargar números primos desde archivo");
            System.out.println("2. Ejecutar generación concurrente de primos (Productor-Consumidor)");
            System.out.println("3. Guardar números primos en archivo");
            System.out.println("4. Mostrar cantidad de números primos");
            System.out.println("5. Salir");
            System.out.print("Elija una opción: ");

            String opcion = scanner.nextLine();

            switch (opcion) {
                case "1":
                    PrimeFileHandler.cargarDesdeCSV("primos.csv", lista);
                    System.out.println("Archivo cargado con éxito.");
                    break;

                case "2":
                    if (productor == null || !productor.isAlive()) {
                        productor = new Thread(new PrimeProducer(queueManager, 100));
                        consumidor1 = new Thread(new PrimesThread(lista, lock, queueManager));
                        consumidor2 = new Thread(new PrimesThread(lista, lock, queueManager));

                        productor.start();
                        consumidor1.start();
                        consumidor2.start();

                        try {
                            productor.join();
                            // Esperar un momento para que consumidores procesen todo
                            Thread.sleep(500);
                            consumidor1.interrupt();
                            consumidor2.interrupt();

                            consumidor1.join();
                            consumidor2.join();
                        } catch (InterruptedException e) {
                            System.out.println("Error en los hilos.");
                        }

                        System.out.println("Generación concurrente finalizada.");
                    } else {
                        System.out.println("El proceso ya está en ejecución.");
                    }
                    break;

                case "3":
                    PrimeFileHandler.guardarPrimos(lista, "resultados.txt");
                    System.out.println("Archivo guardado en resultados.txt");
                    break;

                case "4":
                    System.out.println("Cantidad de códigos primos: " + lista.getPrimesCount());
                    break;

                case "5":
                    salir = true;
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }
        }

        scanner.close();
    }
}


