// Excepción para cuando un libro ya está prestado y no se puede prestar de nuevo.
public class LibroYaPrestadoException extends Exception {
    public LibroYaPrestadoException(String mensaje) {
        super(mensaje);
    }
}


