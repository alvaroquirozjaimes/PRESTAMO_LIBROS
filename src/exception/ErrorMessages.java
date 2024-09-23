package exception;

public enum ErrorMessages {
    STUDENT_NOT_FOUND("Student with DNI %s not found"),
    DUPLICATE_STUDENT("Student with DNI %s and name %s already exists"),
    BOOK_NOT_FOUND("Book with ISBN %s not found"),
    DUPLICATE_BOOK("Book with ISBN %s and name %s already exists"),
    DUPLICATE_LOAN("Loan already exists for Book ID: %s and Student ID: %s"),
    LOAN_NOT_FOUND("Loan not found with ID: %s");

    // Formato del mensaje de error.
    private final String messageFormat;

    // Constructor para inicializar el formato del mensaje.
    ErrorMessages(String messageFormat) {
        this.messageFormat = messageFormat;
    }

    // Método para formatear el mensaje con los argumentos dados.
    public String formatMessage(Object... args) {
        return String.format(messageFormat, args);
    }
}
