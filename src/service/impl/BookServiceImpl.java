package service.impl;

import exception.*;
import model.Book;
import service.IBookService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BookServiceImpl implements IBookService {

    // Lista que almacena los libros registrados
    private final List<Book> books = new ArrayList<>();

    @Override
    public void registerBook(Book book) {
        // Verificar si ya existe un libro con el mismo ISBN
        boolean isDuplicateIsbn = books.stream()
                .anyMatch(existingBook -> existingBook.getIsbn().equals(book.getIsbn()));

        // Si hay un duplicado, lanzar excepción
        if (isDuplicateIsbn) {
            throw new DuplicateBookException(
                    ErrorMessages.DUPLICATE_BOOK.formatMessage(book.getTitle(), book.getIsbn())
            );
        }

        // Si no hay duplicados, agregar el libro a la lista
        books.add(book);
    }

    @Override
    public List<Book> getAllBooks() {
        // Devuelve la lista de todos los libros registrados
        return books;
    }

    @Override
    public Optional<Book> findBookByISBN(String isbn) {
        // Buscar un libro por su ISBN
        Optional<Book> optionalBook = books.stream()
                .filter(book -> book.getIsbn().equals(isbn))
                .findFirst();

        // Si no se encuentra el libro, lanzar excepción
        if (optionalBook.isEmpty()) {
            throw new BookNotFoundException(ErrorMessages.BOOK_NOT_FOUND.formatMessage(isbn));
        }

        return optionalBook;
    }
}
