package exception;

// Excepción personalizada que indica que un libro duplicado fue encontrado.
public class DuplicateBookException extends RuntimeException {

    // Constructor que recibe un mensaje personalizado de error.
    public DuplicateBookException(String message) {
        super(message);
    }
}
