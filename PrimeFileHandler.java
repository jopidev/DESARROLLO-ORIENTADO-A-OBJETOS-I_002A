import java.io.*;
import java.util.List;

public class PrimeFileHandler {
    public static void guardarPrimos(List<Integer> primos, String archivo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo))) {
            for (Integer p : primos) {
                writer.write("Código Primo: " + p);
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error al guardar archivo: " + e.getMessage());
        }
    }

    public static void cargarDesdeCSV(String archivo, PrimesList lista) {
        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                try {
                    int n = Integer.parseInt(linea.trim());
                    lista.add(n);
                } catch (NumberFormatException ignored) {
                } catch (IllegalArgumentException ignored) {
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer archivo: " + e.getMessage());
        }
    }
}

