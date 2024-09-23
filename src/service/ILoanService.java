package service;

import model.LoanReport;
import model.Loan;

import java.time.LocalDate;
import java.util.List;

/**
 * ILoanService define las operaciones clave para la gestión de préstamos en el sistema.
 * Las clases que implementen esta interfaz deben proporcionar la lógica específica para realizar estas tareas.
 */
public interface ILoanService {

    /**
     * Registra un nuevo préstamo.
     * @param loan objeto que contiene la información sobre el préstamo (estudiante, libro, fecha, etc.).
     */
    void registerLoan(Loan loan);

    /**
     * Devuelve una lista de todos los préstamos registrados.
     * @return una colección de objetos Loan.
     */
    List<Loan> listLoans();

    /**
     * Filtra y devuelve préstamos dentro de un rango de fechas.
     * @param startDate fecha de inicio del rango.
     * @param endDate fecha de fin del rango.
     * @return una lista de préstamos que caen dentro del rango de fechas especificado.
     */
    List<Loan> filterLoansByDateRange(LocalDate startDate, LocalDate endDate);

    /**
     * Filtra préstamos por el DNI del estudiante.
     * @param studentDni el DNI del estudiante cuyos préstamos se quieren recuperar.
     * @return una lista de préstamos asociados al estudiante especificado.
     */
    List<Loan> filterLoansByDniStudent(String studentDni);

    /**
     * Busca y devuelve un préstamo específico por su ID.
     * @param loanId el identificador único del préstamo.
     * @return el objeto Loan correspondiente al préstamo encontrado.
     */
    Loan findLoanById(String loanId);

    /**
     * Genera un informe de préstamos dentro de un rango de fechas.
     * @param startDate fecha de inicio del rango.
     * @param endDate fecha de fin del rango.
     * @return una lista de objetos LoanReport con información detallada sobre los préstamos en el periodo.
     */
    List<LoanReport> getLoansByDateRange(LocalDate startDate, LocalDate endDate);
}
