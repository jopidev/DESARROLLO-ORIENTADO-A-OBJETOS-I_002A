package src.ComicCollectorSystem;
import java.util.Objects;

public class Comic implements Comparable<Comic> {
    private String nombre;
    private String editorial;
    private String tipo;
    private boolean reservado;

    public Comic(String nombre, String editorial, String tipo) {
        this.nombre = nombre;
        this.editorial = editorial;
        this.tipo = tipo;
        this.reservado = false;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEditorial() {
        return editorial;
    }

    public String getTipo() {
        return tipo;
    }

    public boolean isReservado() {
        return reservado;
    }

    public void setReservado(boolean reservado) {
        this.reservado = reservado;
    }

    @Override
    public int compareTo(Comic otro) {
        return this.nombre.compareToIgnoreCase(otro.nombre);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comic comic = (Comic) o;
        return nombre.equalsIgnoreCase(comic.nombre) && editorial.equalsIgnoreCase(comic.editorial);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre.toLowerCase(), editorial.toLowerCase());
    }
}

