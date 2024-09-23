package model;

import java.time.LocalDate;

// Clase para representar un informe de préstamo de un libro
public record LoanReport(
        String title,        // Título del libro
        String author,       // Autor del libro
        int year,           // Año de publicación del libro
        LocalDate loanDate,  // Fecha en que se realizó el préstamo
        LocalDate returnDate, // Fecha límite para la devolución del libro
        String studentName   // Nombre del estudiante que tomó prestado el libro
) {}
