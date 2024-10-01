package com.edteam.model;

import java.time.LocalDate;
import java.util.UUID;

// Clase para representar préstamos y devoluciones
public class Loan {
    private String id;
    private Book book;
    private Student student;
    private LocalDate loanDate;
    private LocalDate returnDate;
    private boolean isLoan;

    public Loan(Book book, Student student, boolean isLoan) {
        //private String id;: Este campo almacena un identificador único para el préstamo, generado usando UUID.
        //private Book book;: Aquí se almacena el libro asociado al préstamo. La clase Book está definida en otro archivo.
        //private Student student;: Representa al estudiante que ha tomado prestado el libro. Se espera que la clase Student también esté definida en otro archivo.
        //private LocalDate loanDate;: Fecha en que se hizo el préstamo. Se usa LocalDate para manejar fechas sin tener que preocuparse por horas o zonas horarias.
        //private LocalDate returnDate;: Fecha límite en la que se espera que el libro sea devuelto.
        //private boolean isLoan;: Un indicador booleano que representa si la operación es un préstamo (true) o una devolución (false).

        this.id = UUID.randomUUID().toString();
        this.book = book;
        this.student = student;
        this.isLoan = isLoan;
        this.loanDate = LocalDate.now();
        this.returnDate = loanDate.plusDays(7);
    }

    //getId(), getBook(), getStudent(), etc.: Son métodos públicos que permiten acceder a las variables privadas desde fuera de la clase. Estos métodos devuelven los valores de los atributos.
    //setReturnDate(LocalDate returnDate): Este método permite modificar la fecha de devolución, por si se quiere extender el plazo del préstamo.
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

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public boolean isLoan() {
        return isLoan;
    }

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