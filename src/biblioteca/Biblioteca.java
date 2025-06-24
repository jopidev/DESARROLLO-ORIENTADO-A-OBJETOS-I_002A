import java.util.*;

public class Biblioteca {
    private ArrayList<Libro> listaLibros;
    private HashMap<String, Usuario> mapaUsuarios;
    private HashSet<Libro> conjuntoLibrosUnicos;
    private TreeSet<Libro> catalogoOrdenado;

    public Biblioteca() {
        listaLibros = new ArrayList<>();
        mapaUsuarios = new HashMap<>();
        conjuntoLibrosUnicos = new HashSet<>();
        catalogoOrdenado = new TreeSet<>();
    }

    public void agregarLibro(Libro libro) {
        if (conjuntoLibrosUnicos.add(libro)) {
            listaLibros.add(libro);
            catalogoOrdenado.add(libro);
        }
    }

    public void agregarUsuario(Usuario usuario) {
        mapaUsuarios.putIfAbsent(usuario.getRut(), usuario);
    }

    public void prestarLibro(String titulo) throws LibroNoEncontradoException, LibroYaPrestadoException {
        Libro libro = buscarLibro(titulo);
        if (libro.isPrestado()) {
            throw new LibroYaPrestadoException("El libro ya está prestado.");
        } else {
            libro.setPrestado(true);
        }
    }

    public Libro buscarLibro(String titulo) throws LibroNoEncontradoException {
        for (Libro libro : listaLibros) {
            if (libro.getTitulo().equalsIgnoreCase(titulo)) {
                return libro;
            }
        }
        throw new LibroNoEncontradoException("Libro no encontrado en el sistema.");
    }

    public ArrayList<Libro> getLibros() {
        return listaLibros;
    }

    public TreeSet<Libro> getCatalogoOrdenado() {
        return catalogoOrdenado;
    }

    public HashMap<String, Usuario> getUsuarios() {
        return mapaUsuarios;
    }
} 


