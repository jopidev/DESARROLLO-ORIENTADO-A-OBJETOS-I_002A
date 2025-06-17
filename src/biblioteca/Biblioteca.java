import java.util.ArrayList;
import java.util.HashMap;

public class Biblioteca {
    private ArrayList<Libro> libros;
    private HashMap<String, Usuario> usuarios;

    public Biblioteca() {
        this.libros = new ArrayList<>();
        this.usuarios = new HashMap<>();
    }

    public ArrayList<Libro> getLibros() {
        return libros;
    }

    public void agregarLibro(Libro libro) {
        libros.add(libro);
    }

    public void agregarUsuario(Usuario usuario) {
        usuarios.put(usuario.getRut(), usuario);
    }

    public void prestarLibro(String titulo) throws LibroNoEncontradoException, LibroYaPrestadoException {
        for (Libro libro : libros) {
            if (libro.getTitulo().equalsIgnoreCase(titulo)) {
                if (libro.isPrestado()) {
                    throw new LibroYaPrestadoException("El libro '" + titulo + "' ya está prestado.");
                } else {
                    libro.setPrestado(true);
                    return;
                }
            }
        }
        throw new LibroNoEncontradoException("No se encontró el libro con título: " + titulo);
    }
}

