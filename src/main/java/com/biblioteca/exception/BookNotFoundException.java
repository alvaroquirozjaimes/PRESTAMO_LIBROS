package com.edteam.exception;

/*
BookNotFoundException es una clase de excepción personalizada que extiende RuntimeException y se utiliza para señalar que un libro no fue encontrado en el sistema. Al lanzar esta excepción, se proporciona un mensaje específico, lo que ayuda a entender el problema exacto cuando se captura la excepción en otras partes del código.
 */

/*
Esta línea declara la clase BookNotFoundException como una subclase de RuntimeException. Esto significa que BookNotFoundException hereda todas las funcionalidades de las excepciones en tiempo de ejecución de Java.
Al extender RuntimeException, esta excepción es no verificada, lo que significa que no es obligatorio capturarla o declararla en los métodos con throws. Se lanza solo en tiempo de ejecución si ocurre un error.
 */
public class BookNotFoundException extends RuntimeException {
    /*
    Este es un constructor de la clase BookNotFoundException.
Recibe como parámetro un String message, que contiene un mensaje personalizado de error (por ejemplo, "El libro con ISBN XXX no fue encontrado").
Utiliza super(message) para pasar ese mensaje a la clase base (RuntimeException), lo que permitirá que el mensaje se imprima o se registre cuando la excepción sea capturada.
     */
    public BookNotFoundException(String message) {
        super(message);
    }
}