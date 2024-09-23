import model.LoanReport;
import exception.BookNotFoundException;
import exception.DuplicateBookException;
import exception.DuplicateStudentException;
import exception.StudentNotFoundException;
import model.Book;
import model.Loan;
import model.Student;
import service.IBookService;
import service.ILoanService;
import service.IStudentService;
import service.impl.BookServiceImpl;
import service.impl.LoanServiceImpl;
import service.impl.StudentServiceImpl;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class Main {

    // BufferedReader para leer entrada del usuario desde la consola
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {
        boolean exit = false;  // Controlar el bucle principal
        // Inicialización de servicios
        IBookService bookService = new BookServiceImpl();
        IStudentService studentService = new StudentServiceImpl();
        ILoanService loanService = new LoanServiceImpl();

        // Bucle principal del programa
        do {
            // Mostrar menú de opciones
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

            // Obtener la opción seleccionada por el usuario
            int choice = getIntInput("Seleccione una opción: ");

            // Switch para manejar las diferentes opciones del menú
            switch (choice) {
                case 1:
                    // Opción para registrar un libro
                    try {
                        System.out.print("Enter book title: ");
                        String title = reader.readLine();  // Leer título del libro

                        System.out.print("Enter book author: ");
                        String author = reader.readLine();  // Leer autor del libro

                        System.out.print("Enter book year: ");
                        int year = Integer.parseInt(reader.readLine());  // Leer año de publicación

                        System.out.print("Enter book ISBN: ");
                        String isbn = reader.readLine();  // Leer ISBN del libro

                        // Crear y registrar un nuevo libro
                        Book newBook = new Book(title, author, year, isbn);
                        bookService.registerBook(newBook);
                        System.out.println("Book registered successfully!");  // Confirmación de registro

                    } catch (DuplicateBookException e) {
                        System.out.println(e.getMessage());  // Manejar excepción si el libro ya existe
                    } catch (IOException | NumberFormatException ex) {
                        System.out.println("Error en la entrada de datos. Por favor, ingrese datos válidos.");
                    }
                    break;

                case 2:
                    // Opción para listar todos los libros registrados
                    List<Book> books = bookService.getAllBooks();
                    System.out.println("List of Books:");
                    books.forEach(System.out::println);  // Imprimir cada libro en la lista
                    break;

                case 3:
                    // Opción para buscar un libro por ISBN
                    try {
                        System.out.print("Enter ISBN to find: ");
                        String isbnToFind = reader.readLine();  // Leer ISBN del libro a buscar

                        Optional<Book> foundBook = bookService.findBookByISBN(isbnToFind);  // Buscar libro por ISBN
                        System.out.println("Book found: " + foundBook.get());  // Mostrar el libro encontrado

                    } catch (BookNotFoundException e) {
                        System.out.println(e.getMessage());  // Manejar excepción si no se encuentra el libro
                    } catch (IOException | NumberFormatException ex) {
                        System.out.println("Error en la entrada de datos. Por favor, ingrese datos válidos.");
                    }
                    break;

                case 4:
                    // Opción para registrar un estudiante
                    try {
                        System.out.print("Enter student name: ");
                        String name = reader.readLine();  // Leer nombre del estudiante

                        System.out.print("Enter student DNI: ");
                        String dni = reader.readLine();  // Leer DNI del estudiante

                        // Crear y registrar un nuevo estudiante
                        Student studentNew = new Student(name, dni);
                        studentService.registerStudent(studentNew);
                        System.out.println("Student registered successfully!");  // Confirmación de registro

                    } catch (DuplicateStudentException e) {
                        System.out.println(e.getMessage());  // Manejar excepción si el estudiante ya existe
                    } catch (IOException | NumberFormatException ex) {
                        System.out.println("Error en la entrada de datos. Por favor, ingrese datos válidos.");
                    }
                    break;

                case 5:
                    // Opción para listar todos los estudiantes registrados
                    List<Student> students = studentService.listStudents();
                    System.out.println("List of Students:");
                    students.forEach(System.out::println);  // Imprimir cada estudiante en la lista
                    break;

                case 6:
                    // Opción para buscar un estudiante por DNI
                    try {
                        System.out.print("Enter DNI to find student: ");
                        String dniToFind = reader.readLine();  // Leer DNI del estudiante a buscar

                        Optional<Student> foundStudent = studentService.findStudentByDni(dniToFind);  // Buscar estudiante por DNI
                        System.out.println("Student found: " + foundStudent.get());  // Mostrar el estudiante encontrado

                    } catch (StudentNotFoundException e) {
                        System.out.println(e.getMessage());  // Manejar excepción si no se encuentra el estudiante
                    } catch (IOException | NumberFormatException ex) {
                        System.out.println("Error en la entrada de datos. Por favor, ingrese datos válidos.");
                    }
                    break;
                case 7:
                    // Opción para registrar un préstamo de libro
                    try {
                        System.out.println("Enter Book ISBN: ");
                        String bookISBN = reader.readLine();  // Leer ISBN del libro a prestar

                        // Buscar el libro antes de registrar el préstamo
                        Optional<Book> bookOptional = bookService.findBookByISBN(bookISBN);

                        if (bookOptional.isPresent()) {
                            Book book = bookOptional.get();

                            System.out.println("Enter Student DNI: ");
                            String studentDNI = reader.readLine();  // Leer DNI del estudiante que recibe el préstamo

                            // Buscar al estudiante antes de registrar el préstamo
                            Optional<Student> studentOptional = studentService.findStudentByDni(studentDNI);

                            if (studentOptional.isPresent()) {
                                Student student = studentOptional.get();

                                // Crear y registrar el préstamo
                                Loan newLoan = new Loan(book, student, true);
                                loanService.registerLoan(newLoan);
                                System.out.println("Loan registered successfully!");  // Confirmación de registro
                            } else {
                                System.out.println("Student not found with DNI: " + studentDNI);
                            }
                        } else {
                            System.out.println("Book not found with ISBN: " + bookISBN);
                        }

                    } catch (StudentNotFoundException | BookNotFoundException e) {
                        System.out.println(e.getMessage());  // Manejar excepciones de libro o estudiante no encontrados
                    } catch (IOException | NumberFormatException ex) {
                        System.out.println("Error en la entrada de datos. Por favor, ingrese datos válidos.");
                    }
                    break;

                case 8:
                    // Opción para listar préstamos por rango de fecha
                    try {
                        System.out.print("Enter start date (yyyy-MM-dd): ");
                        String startDateString = reader.readLine();  // Leer fecha de inicio

                        System.out.print("Enter end date (yyyy-MM-dd): ");
                        String endDateString = reader.readLine();  // Leer fecha de fin

                        // Convertir cadenas a LocalDate y obtener préstamos por rango de fecha
                        LocalDate startDate = LocalDate.parse(startDateString);
                        LocalDate endDate = LocalDate.parse(endDateString);

                        List<LoanReport> loansByDateRange = loanService.getLoansByDateRange(startDate, endDate);
                        System.out.println("List of Loans by Date Range:");
                        loansByDateRange.forEach(System.out::println);  // Imprimir préstamos en el rango

                    } catch (IOException | NumberFormatException ex) {
                        System.out.println("Error en la entrada de datos. Por favor, ingrese datos válidos.");
                    }
                    break;

                case 9:
                    // Opción para listar préstamos por estudiante
                    try {
                        System.out.print("Enter student DNI to find loans: ");
                        String studentDni = reader.readLine();  // Leer DNI del estudiante

                        // Obtener lista de préstamos por estudiante
                        List<Loan> loansByStudent = loanService.filterLoansByDniStudent(studentDni);
                        System.out.println("List of Loans by Student:");
                        loansByStudent.forEach(System.out::println);  // Imprimir préstamos del estudiante

                    } catch (StudentNotFoundException e) {
                        System.out.println(e.getMessage());  // Manejar excepción si el estudiante no se encuentra
                    } catch (IOException | NumberFormatException ex) {
                        System.out.println("Error en la entrada de datos. Por favor, ingrese datos válidos.");
                    }
                    break;

                case 0:
                    // Opción para salir del programa
                    exit = true;
                    System.out.println("Saliendo del programa. ¡Hasta luego!");
                    break;

                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
                    break;
            }
        } while (!exit);  // Continuar hasta que el usuario seleccione salir
    }

    // Método auxiliar para obtener entrada numérica del usuario
    private static int getIntInput(String message) {
        System.out.print(message);
        while (true) {
            try {
                return Integer.parseInt(reader.readLine());  // Leer entrada numérica
            } catch (IOException | NumberFormatException e) {
                System.out.println("Por favor, ingrese un número válido.");  // Manejar errores en la entrada
            }
        }
    }
}
