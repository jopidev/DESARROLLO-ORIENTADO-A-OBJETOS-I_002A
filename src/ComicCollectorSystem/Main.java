package src.ComicCollectorSystem;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Tienda tienda = new Tienda();
        Scanner scanner = new Scanner(System.in);

        try (BufferedReader br = new BufferedReader(new FileReader("comics.csv"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");
                if (partes.length == 3) {
                    tienda.agregarComic(new Comic(partes[0].trim(), partes[1].trim(), partes[2].trim()));
                }
            }
        } catch (IOException e) {
            System.out.println("Error cargando archivo de cómics.");
        }

        System.out.println("=== Bienvenido a ComicCollectorSystem ===");
        System.out.print("Ingrese su nombre completo: ");
        String nombre = scanner.nextLine().trim();

        String rut;
        while (true) {
            System.out.print("Ingrese su RUT (formato 12345678-9): ");
            rut = scanner.nextLine().trim();
            if (validarRutChileno(rut)) {
                break;
            } else {
                System.out.println("Formato inválido. Intente de nuevo.");
            }
        }

        Usuario usuario = new Usuario(nombre, rut);
        tienda.agregarUsuario(usuario);

        System.out.println("\n=== Catálogo de Cómics y Coleccionables ===");
        int index = 1;
        for (Comic comic : tienda.getCatalogoOrdenado()) {
            String estado = comic.isReservado() ? "Reservado" : "Disponible";
            System.out.printf("%2d. %-30s | %-15s | %-15s | %s\n",
                index++, comic.getNombre(), comic.getEditorial(), comic.getTipo(), estado);
        }

        boolean continuar = true;
        while (continuar) {
            System.out.print("\nIngrese el nombre (o parte) del cómic a reservar: ");
            String textoBusqueda = scanner.nextLine().trim();

            List<Comic> sugerencias = tienda.buscarComicsPorNombreParcial(textoBusqueda);

            if (sugerencias.isEmpty()) {
                System.out.println("No se encontraron cómics con ese nombre.");
                continue;
            } else if (sugerencias.size() == 1) {
                Comic candidato = sugerencias.get(0);
                System.out.println("Se encontró el cómic: " + candidato.getNombre());
                System.out.print("¿Desea reservar este cómic? (S/N): ");
                String confirmacion = scanner.nextLine().trim().toUpperCase();
                if (confirmacion.equals("S")) {
                    try {
                        tienda.reservarComic(candidato.getNombre());
                        System.out.println("¡Reserva exitosa de '" + candidato.getNombre() + "'!");
                        try (FileWriter fw = new FileWriter("reservas.txt", true)) {
                            fw.write("Comic: " + candidato.getNombre() + " | Usuario: " + nombre + " | RUT: " + rut + "\n");
                        } catch (IOException e) {
                            System.out.println("Error guardando reserva.");
                        }
                    } catch (ComicNoDisponibleException | ComicYaReservadoException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                } else {
                    System.out.println("Reserva cancelada.");
                }
            } else {
                System.out.println("Se encontraron varias coincidencias:");
                for (int i = 0; i < sugerencias.size(); i++) {
                    System.out.printf("%d. %s\n", i + 1, sugerencias.get(i).getNombre());
                }
                int opcion = -1;
                while (opcion < 1 || opcion > sugerencias.size()) {
                    System.out.print("Seleccione el número del cómic a reservar: ");
                    try {
                        opcion = Integer.parseInt(scanner.nextLine().trim());
                    } catch (NumberFormatException ex) {
                        opcion = -1;
                    }
                }
                Comic seleccionado = sugerencias.get(opcion - 1);
                try {
                    tienda.reservarComic(seleccionado.getNombre());
                    System.out.println("¡Reserva exitosa de '" + seleccionado.getNombre() + "'!");
                    try (FileWriter fw = new FileWriter("reservas.txt", true)) {
                        fw.write("Comic: " + seleccionado.getNombre() + " | Usuario: " + nombre + " | RUT: " + rut + "\n");
                    } catch (IOException e) {
                        System.out.println("Error guardando reserva.");
                    }
                } catch (ComicNoDisponibleException | ComicYaReservadoException e) {
                    System.out.println("Error: " + e.getMessage());
                }
            }

            String respuesta;
            do {
                System.out.print("¿Desea reservar otro cómic? (S/N): ");
                respuesta = scanner.nextLine().trim().toUpperCase();
            } while (!respuesta.equals("S") && !respuesta.equals("N"));

            if (respuesta.equals("N")) {
                continuar = false;
            }
        }

        System.out.println("\nGracias por usar ComicCollectorSystem. ¡Hasta luego!");
    }

    public static boolean validarRutChileno(String rut) {
        return Pattern.matches("^\\d{7,8}-[\\dkK]$", rut);
    }
}













