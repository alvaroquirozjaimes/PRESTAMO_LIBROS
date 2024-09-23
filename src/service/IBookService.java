package service;

import model.Book;

import java.util.List;
import java.util.Optional;

/**
 * Esta interfaz define cómo interactuar con un servicio que maneja libros,
 * proporcionando funciones para registrar, obtener y buscar libros.
 */
public interface IBookService {

    /**
     * Registra un nuevo libro en el sistema.
     * @param book objeto Book que contiene la información del libro (título, autor, ISBN, etc.).
     */
    void registerBook(Book book);

    /**
     * Devuelve una lista de todos los libros registrados en el sistema.
     * @return una colección de objetos Book.
     */
    List<Book> getAllBooks();

    /**
     * Busca un libro por su ISBN.
     * @param isbn el ISBN del libro a buscar.
     * @return un Optional<Book> que puede contener el libro encontrado o estar vacío si no se encuentra.
     */
    Optional<Book> findBookByISBN(String isbn);
}
