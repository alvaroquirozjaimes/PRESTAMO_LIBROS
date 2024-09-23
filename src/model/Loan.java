package model;

import java.time.LocalDate;
import java.util.UUID;

public class Loan {
    private String id; // Identificador único del préstamo
    private Book book; // Libro asociado al préstamo
    private Student student; // Estudiante que ha tomado prestado el libro
    private LocalDate loanDate; // Fecha en que se realizó el préstamo
    private LocalDate returnDate; // Fecha límite para la devolución del libro
    private boolean isLoan; // Indica si es un préstamo (true) o una devolución (false)

    // Constructor que inicializa el préstamo
    public Loan(Book book, Student student, boolean isLoan) {
        this.id = UUID.randomUUID().toString(); // Genera un ID único
        this.book = book; // Asocia el libro
        this.student = student; // Asocia el estudiante
        this.isLoan = isLoan; // Establece el estado del préstamo
        this.loanDate = LocalDate.now(); // Establece la fecha del préstamo a hoy
        this.returnDate = loanDate.plusDays(7); // Calcula la fecha de devolución (7 días después)
    }

    // Métodos getter para acceder a los atributos privados
    public String getId() {
        return id;
    }

    public Book getBook() {
        return book;
    }

    public Student getStudent() {
        return student;
    }

    public LocalDate getLoanDate() {
        return loanDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    // Método para establecer una nueva fecha de devolución
    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public boolean isLoan() {
        return isLoan; // Devuelve el estado del préstamo
    }

    // Método para representar el préstamo como cadena
    @Override
    public String toString() {
        return "Loan{" +
                "id='" + id + '\'' +
                ", book=" + book +
                ", student=" + student +
                ", loanDate=" + loanDate +
                ", returnDate=" + returnDate +
                ", isLoan=" + isLoan +
                '}';
    }
}
