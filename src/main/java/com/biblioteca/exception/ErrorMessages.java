package com.edteam.exception;

public enum ErrorMessages {
    STUDENT_NOT_FOUND("Student with DNI %s not found"),
    DUPLICATE_STUDENT("Student with DNI %s and name %s already exists"),
    BOOK_NOT_FOUND("Book with ISBN %s not found"),
    DUPLICATE_BOOK("Book with ISBN %s and name %s already exists"),

    DUPLICATE_LOAN("Loan already exists for Book ID: %s and Student ID: %s"),
    LOAN_NOT_FOUND("Loan not found with ID: %s");


/*
Cada constante del enum tiene un atributo messageFormat que contiene el formato de mensaje de error, como "Student with DNI %s not found".
Es final, lo que significa que no puede ser modificado después de ser asignado en el constructor.
 */
    private final String messageFormat;

    /*
    El constructor toma un String que representa el formato del mensaje y lo asigna al atributo messageFormat.
Como se trata de un enum, el constructor es privado por defecto, y se utiliza solo dentro de la definición del enum para inicializar las constantes.
     */
    ErrorMessages(String messageFormat) {
        this.messageFormat = messageFormat;
    }
/*
Este método toma un número variable de argumentos (Object... args) y utiliza String.format para sustituir los placeholders (%s) en el mensaje con los valores que se pasan como argumentos.
String.format(messageFormat, args) reemplaza cada %s en el messageFormat con los valores pasados como parámetros.
 */
        public String formatMessage(Object... args) {
            return String.format(messageFormat, args);
        }
}
