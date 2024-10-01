package com.arqj;

import com.edteam.service.IStudentService;
import com.edteam.service.impl.BookServiceImpl;
import com.edteam.service.impl.LoanServiceImpl;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {
        boolean exit = false;
        IBookService bookService = new BookServiceImpl();
        IStudentService studentService = new StudentServiceImpl();
        ILoanService loanService = new LoanServiceImpl();

        do {
            System.out.println("Menú de Opciones:");
            System.out.println("1. Registrar Libro");
            System.out.println("2. Listar Libros");
            System.out.println("3. Buscar Libro por ISBN");
            System.out.println("4. Registrar Estudiante");
            System.out.println("5. Listar Estudiantes");
            System.out.println("6. Buscar Estudiante por DNI");
            System.out.println("7. Registrar Préstamo");
            System.out.println("8. Listar Préstamos por Rango de Fecha");
            System.out.println("9. Listar Préstamos por Estudiante");
            System.out.println("0. Salir");

            int choice = getIntInput("Seleccione una opción: ");

            switch (choice) {
                case 1:
                    try {
                        System.out.print("Enter book title: ");
                        String title = reader.readLine();

                        System.out.print("Enter book author: ");
                        String author = reader.readLine();

                        System.out.print("Enter book year: ");
                        int year = Integer.parseInt(reader.readLine());

                        System.out.print("Enter book ISBN: ");
                        String isbn = reader.readLine();

                        Book newBook = new Book(title, author, year, isbn);
                        bookService.registerBook(newBook);

