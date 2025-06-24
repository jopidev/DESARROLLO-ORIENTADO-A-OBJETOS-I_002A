// Excepción para cuando no se encuentra un libro al buscarlo.
public class LibroNoEncontradoException extends Exception {
    public LibroNoEncontradoException(String mensaje) {
        super(mensaje);
    }
}

