package exception;

// Excepción personalizada que indica que un préstamo no fue encontrado.
public class LoanNotFoundException extends RuntimeException {

    // Constructor que recibe un mensaje personalizado de error.
    public LoanNotFoundException(String message) {
        super(message);
    }
}
