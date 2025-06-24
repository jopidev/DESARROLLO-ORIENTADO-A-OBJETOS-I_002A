import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        Scanner scanner = new Scanner(System.in);

        mostrarEncabezado();

        // Cargo los libros desde un archivo CSV para no tener que ingresar todo manual.
        try (BufferedReader br = new BufferedReader(new FileReader("libros.csv"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");
                if (partes.length == 2) {
                    biblioteca.agregarLibro(new Libro(partes[0], partes[1]));
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo de libros: " + e.getMessage() + "\n");
        }

        try {
            System.out.println("REGISTRO DE USUARIO");
            System.out.print("Ingrese su nombre completo: ");
            String nombre = scanner.nextLine();

            String rut;
            // Validamos el formato del RUT chileno antes de aceptar.
            while (true) {
                System.out.print("Ingrese su RUT (formato 12345678-9): ");
                rut = scanner.nextLine();
                if (validarRutChileno(rut)) {
                    break;
                } else {
                    System.out.println("Formato de RUT inválido. Intente nuevamente.");
                }
            }

            Usuario usuario = new Usuario(nombre, rut);
            biblioteca.agregarUsuario(usuario);
            System.out.println("\nUsuario registrado exitosamente.\n");

            // Muestro el catálogo ordenado sólo después de registrar al usuario.
            mostrarCatalogoOrdenado(biblioteca);

            boolean continuar = true;
            while (continuar) {
                System.out.println("PRÉSTAMO DE LIBROS");
                System.out.print("Ingrese el título del libro a buscar y prestar: ");
                String titulo = scanner.nextLine();

                try {
                    biblioteca.prestarLibro(titulo);
                    System.out.println("Libro prestado correctamente.\n");

                    // Guardamos el préstamo en un archivo para registro.
                    try (FileWriter fw = new FileWriter("prestamos.txt", true)) {
                        fw.write("Libro prestado: " + titulo + " a " + nombre + " (RUT: " + rut + ")\n");
                    } catch (IOException e) {
                        System.out.println("No se pudo guardar el préstamo en archivo.");
                    }

                    mostrarResumenFinal(nombre, rut, titulo);

                } catch (LibroNoEncontradoException | LibroYaPrestadoException e) {
                    System.out.println(e.getMessage());
                }

                System.out.print("¿Desea prestar otro libro? (S/N): ");
                String respuesta = scanner.nextLine().trim().toUpperCase();
                if (!respuesta.equals("S")) {
                    continuar = false;
                } else {
                    mostrarCatalogoOrdenado(biblioteca);
                }
            }

        } catch (InputMismatchException e) {
            System.out.println("Error en los datos ingresados.");
        } catch (Exception e) {
            System.out.println("Error inesperado: " + e.getMessage());
        }

        System.out.println("\nGracias por utilizar el sistema de biblioteca de DUOC UC.");
        System.out.println("Fin del programa.");
    }

    // Valida que el RUT siga el formato chileno básico con guión y dígito verificador.
    public static boolean validarRutChileno(String rut) {
        return Pattern.matches("^\\d{7,8}-[\\dkK]$", rut);
    }

    // Encabezado bonito para dar contexto al programa.
    public static void mostrarEncabezado() {
        System.out.println("===============================================");
        System.out.println("  SISTEMA DE ADMINISTRACIÓN DE BIBLIOTECA");
        System.out.println("               DUOC UC - JAVA");
        System.out.println("===============================================\n");
    }

    // Muestra el catálogo ordenado, indicando título, autor y si está prestado o disponible.
    public static void mostrarCatalogoOrdenado(Biblioteca biblioteca) {
        System.out.println("CATÁLOGO ORDENADO DE LIBROS DISPONIBLES:");
        System.out.println("-------------------------------------------");
        if (biblioteca.getCatalogoOrdenado().isEmpty()) {
            System.out.println("No hay libros disponibles.");
        } else {
            for (Libro libro : biblioteca.getCatalogoOrdenado()) {
                String estado = libro.isPrestado() ? "Prestado" : "Disponible";
                System.out.printf("Título: %s | Autor: %s | Estado: %s\n",
                                  libro.getTitulo(), libro.getAutor(), estado);
            }
        }
        System.out.println("-------------------------------------------\n");
    }

    // Muestra un resumen simple después de cada préstamo para que el usuario confirme.
    public static void mostrarResumenFinal(String nombre, String rut, String tituloLibro) {
        System.out.println("===============================================");
        System.out.println("               RESUMEN DEL PRÉSTAMO");
        System.out.println("Usuario: " + nombre);
        System.out.println("RUT: " + rut);
        System.out.println("Libro prestado: " + tituloLibro);
        System.out.println("Estado: Confirmado y registrado");
        System.out.println("===============================================\n");
    }
}









