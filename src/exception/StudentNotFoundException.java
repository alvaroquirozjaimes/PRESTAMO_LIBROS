package exception;

// Excepción personalizada que indica que un estudiante no fue encontrado.
public class StudentNotFoundException extends RuntimeException {

    // Constructor que recibe un mensaje personalizado de error.
    public StudentNotFoundException(String message) {
        super(message);
    }
}
