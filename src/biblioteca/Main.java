import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        Scanner scanner = new Scanner(System.in);

        mostrarEncabezado();

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
            while (true) {
                System.out.print("Ingrese su RUT (formato 12345678-9): ");
                rut = scanner.nextLine();
                if (validarRutChileno(rut)) {
                    break;
                } else {
                    System.out.println("Formato de RUT inv\u00e1lido. Intente nuevamente.");
                }
            }

            Usuario usuario = new Usuario(nombre, rut);
            biblioteca.agregarUsuario(usuario);
            System.out.println("\nUsuario registrado exitosamente.\n");

            mostrarCatalogoOrdenado(biblioteca);

            boolean continuar = true;
            while (continuar) {
                System.out.println("PR\u00c9STAMO DE LIBROS");
                System.out.print("Ingrese el t\u00edtulo del libro a buscar y prestar: ");
                String titulo = scanner.nextLine();

                try {
                    biblioteca.prestarLibro(titulo);
                    System.out.println("Libro prestado correctamente.\n");

                    try (FileWriter fw = new FileWriter("prestamos.txt", true)) {
                        fw.write("Libro prestado: " + titulo + " a " + nombre + " (RUT: " + rut + ")\n");
                    } catch (IOException e) {
                        System.out.println("No se pudo guardar el pr\u00e9stamo en archivo.");
                    }

                    mostrarResumenFinal(nombre, rut, titulo);

                } catch (LibroNoEncontradoException | LibroYaPrestadoException e) {
                    System.out.println(e.getMessage());
                }

                System.out.print("\u00bfDesea prestar otro libro? (S/N): ");
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

    public static boolean validarRutChileno(String rut) {
        return Pattern.matches("^\\d{7,8}-[\\dkK]$", rut);
    }

    public static void mostrarEncabezado() {
        System.out.println("===============================================");
        System.out.println("  SISTEMA DE ADMINISTRACI\u00d3N DE BIBLIOTECA");
        System.out.println("               DUOC UC - JAVA");
        System.out.println("===============================================\n");
    }

    public static void mostrarCatalogoOrdenado(Biblioteca biblioteca) {
        System.out.println("CAT\u00c1LOGO ORDENADO DE LIBROS DISPONIBLES:");
        System.out.println("-------------------------------------------");
        if (biblioteca.getCatalogoOrdenado().isEmpty()) {
            System.out.println("No hay libros disponibles.");
        } else {
            for (Libro libro : biblioteca.getCatalogoOrdenado()) {
                String estado = libro.isPrestado() ? "Prestado" : "Disponible";
                System.out.printf("T\u00edtulo: %s | Autor: %s | Estado: %s\n",
                                  libro.getTitulo(), libro.getAutor(), estado);
            }
        }
        System.out.println("-------------------------------------------\n");
    }

    public static void mostrarResumenFinal(String nombre, String rut, String tituloLibro) {
        System.out.println("===============================================");
        System.out.println("               RESUMEN DEL PR\u00c9STAMO");
        System.out.println("Usuario: " + nombre);
        System.out.println("RUT: " + rut);
        System.out.println("Libro prestado: " + tituloLibro);
        System.out.println("Estado: Confirmado y registrado");
        System.out.println("===============================================\n");
    }
}








