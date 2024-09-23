package exception;

// Excepción personalizada que indica que un préstamo duplicado fue encontrado.
public class DuplicateLoanException extends RuntimeException {

    // Constructor que recibe un mensaje personalizado de error.
    public DuplicateLoanException(String message) {
        super(message);
    }
}
