package com.edteam.service.impl;

import com.edteam.exception.*;
import com.edteam.model.Book;
import com.edteam.service.IBookService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BookServiceImpl implements IBookService {

    /*
    Esta lista almacena los objetos de tipo Book y está definida como final, lo que significa que no se puede cambiar la referencia de la lista, aunque sí se pueden agregar y quitar elementos dentro de ella.
     */
    private final List<Book> books = new ArrayList<>();

    /*
    books.stream(): Convierte la lista books en un stream, lo que permite operar sobre sus elementos de manera secuencial o paralela.
anyMatch(...): Este método examina cada libro en la lista y retorna true si al menos uno de ellos cumple con la condición dada. En este caso, la condición es que el ISBN del libro actual (existingBook.getIsbn()) coincida con el ISBN del libro que se está intentando registrar (book.getIsbn()).
     */
    @Override
    public void registerBook(Book book)  {
        // Verificar si ya existe un libro con el mismo ISBN
        boolean isDuplicateIsbn = books.stream()
                .anyMatch(existingBook -> existingBook.getIsbn().equals(book.getIsbn()));

        // Si hay un duplicado, lanzar excepción
        if (isDuplicateIsbn) {
            //throw new DuplicateStudentException("Book with ISBN " + book.getIsbn() + " already exists");
            throw new DuplicateBookException(
                    ErrorMessages.DUPLICATE_BOOK.formatMessage(book.getTitle(), book.getIsbn())
            );
        }

        // Si no hay duplicados, agregar el libro
        books.add(book);
    }

    @Override
    public List<Book> getAllBooks() {
        return books;
    }

    @Override
    public Optional<Book> findBookByISBN(String isbn)  {

//        return books.stream()
//                .filter(book -> book.getIsbn(isbn))
//                .findFirst()
//                //.orElseThrow(() -> new BookNotFoundException("Book with ISBN " + isbn + " not found"));
//                .orElseThrow(() -> new BookNotFoundException(ExceptionMessages.BOOK_NOT_FOUND.formatMessage(isbn)
//                ));

        Optional<Book> optionalBook = books.stream()
                .filter(book -> book.getIsbn().equals(isbn))
                .findFirst();

        if (optionalBook.isEmpty()) {
            //throw new BookNotFoundException("Book not found with ISBN: " + isbn);
            throw new BookNotFoundException(ErrorMessages.BOOK_NOT_FOUND.formatMessage(isbn));
        }

        return optionalBook;
    }


    //other alternativa
    /*public void registerBook(Book book) {
        validateDuplicateISBN(book.getIsbn());
        books.add(book);
    }

    public List<Book> listBooks() {
        return new ArrayList<>(books);
    }

    public Book findBookByISBN(String isbn) {
        return findBookByISBNInternal(isbn)
                .orElseThrow(() -> new BookNotFoundException("Book not found with ISBN: " + isbn));
    }

    private Optional<Book> findBookByISBNInternal(String isbn) {
        return books.stream()
                .filter(book -> book.getIsbn().equals(isbn))
                .findFirst();
    }

    private void validateDuplicateISBN(String isbn) {
        if (findBookByISBNInternal(isbn).isPresent()) {
            throw new DuplicateBookException("Book with ISBN " + isbn + " already exists.");
        }
    }*/

}
