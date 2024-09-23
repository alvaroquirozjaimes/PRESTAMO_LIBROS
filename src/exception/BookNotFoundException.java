package exception;

// Excepción personalizada que extiende RuntimeException.
public class BookNotFoundException extends RuntimeException {

    // Constructor que recibe un mensaje personalizado de error.
    public BookNotFoundException(String message) {
        super(message);
    }
}
