package model;

// Clase que representa un libro.
public class Book {
    private String title;
    private String author;
    private int year;
    private String isbn; // Campo para el ISBN.

    // Constructor para inicializar los atributos del libro.
    public Book(String title, String author, int year, String isbn) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.isbn = isbn;
    }

    // Getters para acceder a las propiedades privadas.
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

    // Sobrescribe el método toString() para devolver una representación en cadena del libro.
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
