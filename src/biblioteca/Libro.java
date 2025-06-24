import java.util.Objects;

// La clase Libro representa cada libro con título, autor y estado de préstamo.
public class Libro implements Comparable<Libro> {
    private String titulo;
    private String autor;
    private boolean prestado;

    public Libro(String titulo, String autor) {
        this.titulo = titulo;
        this.autor = autor;
        this.prestado = false; // Por defecto, el libro está disponible.
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public boolean isPrestado() {
        return prestado;
    }

    public void setPrestado(boolean prestado) {
        this.prestado = prestado;
    }

    // Para ordenar libros por título de forma alfabética, ignorando mayúsculas/minúsculas.
    @Override
    public int compareTo(Libro otro) {
        return this.titulo.compareToIgnoreCase(otro.titulo);
    }

    // Dos libros son iguales si tienen mismo título y autor, sin importar mayúsculas.
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Libro libro = (Libro) o;
        return titulo.equalsIgnoreCase(libro.titulo) && autor.equalsIgnoreCase(libro.autor);
    }

    // Hashcode consistente con equals, para que HashSet y otras colecciones funcionen bien.
    @Override
    public int hashCode() {
        return Objects.hash(titulo.toLowerCase(), autor.toLowerCase());
    }
}


