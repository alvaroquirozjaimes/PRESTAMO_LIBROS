package com.edteam;

import com.edteam.model.LoanReport;
import com.edteam.exception.BookNotFoundException;
import com.edteam.exception.DuplicateBookException;
import com.edteam.exception.DuplicateStudentException;
import com.edteam.exception.StudentNotFoundException;
import com.edteam.model.Book;
import com.edteam.model.Loan;
import com.edteam.model.Student;
import com.edteam.service.IBookService;
import com.edteam.service.ILoanService;
import com.edteam.service.IStudentService;
import com.edteam.service.impl.BookServiceImpl;
import com.edteam.service.impl.LoanServiceImpl;
import com.edteam.service.impl.StudentServiceImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args)  {
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
            //System.out.println("10. Reporte de Préstamos");
            System.out.println("0. Salir");

            int choice = getIntInput("Seleccione una opción: ");

            switch (choice) {
                case 1:
                    // Registro de libro
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
                        System.out.println("Book registered successfully!");
                    } catch (DuplicateBookException e) {
                        System.out.println(e.getMessage());
                    } catch (IOException | NumberFormatException ex) {
                        System.out.println("Error en la entrada de datos. Por favor, ingrese datos válidos.");
                    }

                    break;
                case 2:
                    // Listar todos los libros
                    List<Book> books = bookService.getAllBooks();
                    System.out.println("List of Books:");
                    books.forEach(System.out::println);
                    break;
                case 3:
                    // Buscar libro por ISBN
                    try {

                        System.out.print("Enter ISBN to find: ");
                        String isbnToFind = reader.readLine();

/*
Se utiliza un bloque try-catch para manejar posibles excepciones que puedan ocurrir al leer la entrada del usuario o al buscar un libro. Excepciones como BookNotFoundException, IOException y NumberFormatException se gestionan en este bloque.
System.out.print("Enter ISBN to find: ");:

Imprime en la consola el mensaje solicitando al usuario que ingrese el ISBN del libro que desea buscar.
String isbnToFind = reader.readLine();:

reader.readLine(): Lee la entrada del usuario desde la consola, que debería ser un número ISBN, y almacena esta entrada en la variable isbnToFind.
isbnToFind es una cadena que contiene el ISBN que el usuario desea buscar.
Optional<Book> foundBook = bookService.findBookByISBN(isbnToFind);:

bookService.findBookByISBN(isbnToFind): Llama al método findBookByISBN() del servicio de libros (bookService) y le pasa el ISBN que el usuario ingresó. Este método busca un libro en el sistema que coincida con el ISBN.
Este método devuelve un Optional<Book>, lo que significa que podría devolver un libro encontrado o bien un objeto vacío si no se encuentra ningún libro con ese ISBN.
Optional<Book> foundBook: Es una instancia de la clase Optional, que es una envoltura que contiene un valor que puede estar presente o no.
System.out.println("Book found: " + foundBook.get());:

foundBook.get(): Obtiene el valor del Optional si está presente. Si no se encuentra un libro y foundBook está vacío, esto lanzaría una excepción NoSuchElementException. Sin embargo, dado que el manejo de la excepción BookNotFoundException está en el try-catch, la lógica asume que si se llega a este punto, el libro ha sido encontrado.
Impresión: Si se encuentra un libro, se imprime la información del libro encontrado en la consola.
 */
                        Optional<Book> foundBook = bookService.findBookByISBN(isbnToFind);
                        System.out.println("Book found: " + foundBook.get());
//                        if (foundBook.isPresent()) {
//                            System.out.println("Book found: " + foundBook.get());
//                        } else {
//                            System.out.println("Book not found with ISBN: " + isbnToFind);
//                        }
                    } catch (BookNotFoundException e) {
                        System.out.println(e.getMessage());


                        /*
                        Aquí se capturan dos posibles excepciones:
IOException: Si ocurre un error de entrada/salida al leer la entrada del usuario.
NumberFormatException: Si el usuario ingresa algo que no es válido o no tiene el formato correcto.
Si ocurre alguna de estas excepciones, se imprime un mensaje de error indicando que los datos ingresados no son válidos.
                         */
                    }catch (IOException | NumberFormatException ex) {
                        System.out.println("Error en la entrada de datos. Por favor, ingrese datos válidos.");
                    }


                    break;
                case 4:
                    // Lógica para registrar estudiante
                    try {
                        System.out.print("Enter student name: ");
                        String name = reader.readLine();

                        System.out.print("Enter student DNI: ");
                        String dni = reader.readLine();

                        Student studentNew = new Student(name, dni);
                        studentService.registerStudent(studentNew);

                        System.out.println("Student registered successfully!");
                    }  catch (DuplicateStudentException e) {
                        System.out.println(e.getMessage());
                    } catch (IOException | NumberFormatException ex) {
                        System.out.println("Error en la entrada de datos. Por favor, ingrese datos válidos.");
                    }
                    break;
                case 5:
                    // Lógica para listar estudiantes
                    List<Student> students = studentService.listStudents();
                    System.out.println("List of Students:");
                    students.forEach(System.out::println);
                    break;
                case 6:
                    // Lógica para buscar estudiante por DNI
                    try {

                        System.out.print("Enter DNI to find student: ");
                        String dniToFind = reader.readLine();


                        Optional<Student> foundStudent = studentService.findStudentByDni(dniToFind);

                        System.out.println("Student found: " + foundStudent);
                    } catch (StudentNotFoundException e) {
                        System.out.println(e.getMessage());
                    } catch (IOException | NumberFormatException ex) {
                        System.out.println("Error en la entrada de datos. Por favor, ingrese datos válidos.");
                    }
                    break;
                case 7:
                    // Lógica para registrar préstamo
                    try {
                        System.out.println("Enter Book ISBN: ");
                        String bookISBN = reader.readLine();

                        // Buscar el libro por ISBN antes de registrar el préstamo
                        Optional<Book> bookOptional = bookService.findBookByISBN(bookISBN);

                        if (bookOptional.isPresent()) {
                            Book book = bookOptional.get();

                            System.out.println("Enter Student DNI: ");
                            String studentDNI = reader.readLine();

                            // Buscar al estudiante por DNI antes de registrar el préstamo
                            Optional<Student> studentOptional = studentService.findStudentByDni(studentDNI);

                            if (studentOptional.isPresent()) {
                                Student student = studentOptional.get();

                                // Solicitar fechas para el préstamo
//                                System.out.println("Enter loan date (yyyy-MM-dd): ");
//                                String loanDateString = reader.readLine();
//                                LocalDate loanDate = LocalDate.parse(loanDateString);

//                                System.out.println("Enter return date (yyyy-MM-dd): ");
//                                String returnDateString = reader.readLine();
//                                LocalDate returnDate = LocalDate.parse(returnDateString);

                                // Crear el objeto Loan y registrar el préstamo
                                //Loan newLoan = new Loan(book, student, loanDate, returnDate, true);
                                Loan newLoan = new Loan(book, student, true);
                                loanService.registerLoan(newLoan);

                                System.out.println("Loan registered successfully!");
                            } else {
                                System.out.println("Student not found with DNI: " + studentDNI);
                            }
                        } else {
                            System.out.println("Book not found with ISBN: " + bookISBN);
                        }
                    }catch (StudentNotFoundException  | BookNotFoundException e) {
                        System.out.println(e.getMessage());
                    }
                    catch (IOException | NumberFormatException ex) {
                        System.out.println("Error en la entrada de datos. Por favor, ingrese datos válidos.");
                    }
                    break;

                case 8:
                    // Lógica para listar préstamos por rango de fecha
                    try {
                    System.out.print("Enter start date (yyyy-MM-dd): ");
                    String startDateString = reader.readLine();

                    System.out.print("Enter end date (yyyy-MM-dd): ");
                    String endDateString = reader.readLine();


                        // Convertir las cadenas de fecha a objetos LocalDate y luego llamar al servicio
                        LocalDate startDate = LocalDate.parse(startDateString);
                        LocalDate endDate = LocalDate.parse(endDateString);

                        List<LoanReport> loansByDateRange = loanService.getLoansByDateRange(startDate, endDate);
                        System.out.println("List of Loans by Date Range:");
                        loansByDateRange.forEach(System.out::println);
                    } catch (IOException | NumberFormatException ex) {
                        System.out.println("Error en la entrada de datos. Por favor, ingrese datos válidos.");
                    }
                    break;
                case 9:
                    // Lógica para listar préstamos por estudiante
                    try {
                    System.out.print("Enter student DNI to find loans: ");
                    String studentDni = reader.readLine();


                        // Llamar al servicio para obtener la lista de préstamos por estudiante
                        List<Loan> loansByStudent = loanService.filterLoansByDniStudent(studentDni);
                        System.out.println("List of Loans by Student:");
                        loansByStudent.forEach(System.out::println);
                    }catch (StudentNotFoundException e) {
                        System.out.println(e.getMessage());
                    }
                    catch (IOException | NumberFormatException ex) {
                        System.out.println("Error en la entrada de datos. Por favor, ingrese datos válidos.");
                    }
                    break;
//                case 10:
//                    // Lógica para generar reporte de préstamos
//                    break;
                case 0:
                    exit = true;
                    System.out.println("Saliendo del programa. ¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
                    break;
            }
        } while (!exit);
    }

    private static int getIntInput(String message) {
        System.out.print(message);
        while (true) {
            try {
                return Integer.parseInt(reader.readLine());
            } catch (IOException | NumberFormatException e) {
                System.out.println("Por favor, ingrese un número válido.");
            }
        }
    }
}
