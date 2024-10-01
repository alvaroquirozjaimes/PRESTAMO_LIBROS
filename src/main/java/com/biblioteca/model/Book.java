package com.arqj;

// Clase para representar libros
public class Book { //Public significa que esta será accesible desde cualquier otra clase
    private String title;//Atributos o propiedades de la clase
    private String author;
    private int year;
    private String isbn; // Nuevo campo para el ISBN

    public Book(String title, String author, int year, String isbn) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.isbn = isbn;
    }

    //Getters: Son métodos públicos que permiten acceder a las variables privadas desde fuera de la clase.
    // Por ejemplo, getTitle() devuelve el título del libro, getAuthor() devuelve el nombre del autor, y así sucesivamente.
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    public String getIsbn() {
        return isbn;
    }


    //Override: Indica que el método toString() sobrescribe el método toString() de la clase Object (que es la clase base de todas las clases en Java).
    //toString(): Este método convierte los atributos del libro a una representación de cadena, que es útil cuando se quiere imprimir o mostrar la información de un libro en un formato legible.
    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", year=" + year +
                ", isbn='" + isbn + '\'' +
                '}';
    }
}
