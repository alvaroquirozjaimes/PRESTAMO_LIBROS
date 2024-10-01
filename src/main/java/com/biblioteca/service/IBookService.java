package com.edteam.service;

import com.edteam.model.Book;

import java.util.List;
import java.util.Optional;
/*
Esta interfaz define cómo interactuar con un servicio que maneja libros, proporcionando tres funciones principales:

Registrar un nuevo libro.
Obtener todos los libros.
Buscar un libro por su ISBN.
 */
public interface IBookService {
    void registerBook(Book book); //Este método se utiliza para registrar un nuevo libro en el sistema.
                                  //El parámetro Book book representa un objeto Book que contiene toda la información del libro (como título, autor, ISBN, etc.).
                                  //void significa que el método no devuelve ningún valor, solo realiza una acción (registrar el libro).
    List<Book> getAllBooks(); //Este método devuelve una lista de todos los libros.
                                //List<Book> significa que devuelve una lista de objetos Book. Es una colección que contiene todos los libros registrados en el sistema.
    Optional<Book> findBookByISBN(String isbn);
}
