package exception;

// Excepción personalizada que indica que un estudiante duplicado fue encontrado.
public class DuplicateStudentException extends RuntimeException {

    // Constructor que recibe un mensaje personalizado de error.
    public DuplicateStudentException(String message) {
        super(message);
    }
}
