import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeSet;

public class Biblioteca {
    // Aquí guardo la lista completa de libros en orden de carga.
    private ArrayList<Libro> listaLibros;

    // Uso este mapa para almacenar usuarios por su RUT, que es único.
    private HashMap<String, Usuario> mapaUsuarios;

    // Este conjunto me ayuda a evitar libros duplicados al agregar, por título y autor.
    private HashSet<Libro> conjuntoLibrosUnicos;

    // Este TreeSet mantiene el catálogo ordenado alfabéticamente por título para mostrar al usuario.
    private TreeSet<Libro> catalogoOrdenado;

    public Biblioteca() {
        listaLibros = new ArrayList<>();
        mapaUsuarios = new HashMap<>();
        conjuntoLibrosUnicos = new HashSet<>();
        catalogoOrdenado = new TreeSet<>();
    }

    // Agrego un libro sólo si no está ya en el conjunto, así evito duplicados.
    // Cuando agrego uno nuevo, lo pongo también en la lista y en el catálogo ordenado.
    public void agregarLibro(Libro libro) {
        if (conjuntoLibrosUnicos.add(libro)) {
            listaLibros.add(libro);
            catalogoOrdenado.add(libro);
        }
    }

    // Registro usuarios usando su RUT como clave, para búsquedas rápidas y evitar duplicados.
    public void agregarUsuario(Usuario usuario) {
        mapaUsuarios.putIfAbsent(usuario.getRut(), usuario);
    }

    // Método para prestar un libro por título. Lanza excepciones si no lo encuentra o ya está prestado.
    public void prestarLibro(String titulo) throws LibroNoEncontradoException, LibroYaPrestadoException {
        Libro libro = buscarLibro(titulo);
        if (libro.isPrestado()) {
            throw new LibroYaPrestadoException("El libro ya está prestado.");
        } else {
            libro.setPrestado(true);
        }
    }

    // Busca un libro por título recorriendo la lista. Si no existe, lanza excepción.
    public Libro buscarLibro(String titulo) throws LibroNoEncontradoException {
        for (Libro libro : listaLibros) {
            if (libro.getTitulo().equalsIgnoreCase(titulo)) {
                return libro;
            }
        }
        throw new LibroNoEncontradoException("Libro no encontrado en el sistema.");
    }

    // Devuelvo la lista completa de libros, aunque uso otras colecciones para evitar duplicados y orden.
    public ArrayList<Libro> getLibros() {
        return listaLibros;
    }

    // Devuelvo el catálogo ordenado para mostrarlo bonito al usuario.
    public TreeSet<Libro> getCatalogoOrdenado() {
        return catalogoOrdenado;
    }

    // Devuelvo el mapa de usuarios, que es rápido para buscar y gestionar.
    public HashMap<String, Usuario> getUsuarios() {
        return mapaUsuarios;
    }
}



