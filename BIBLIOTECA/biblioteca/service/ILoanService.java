package com.edteam.service;

import com.edteam.model.LoanReport;
import com.edteam.model.Loan;

import java.time.LocalDate;
import java.util.List;
/*
ILoanService es una interfaz que define las operaciones clave para la gestión de préstamos en un sistema, incluyendo registro, listado, filtrado y generación de informes de préstamos. Las clases que implementen esta interfaz deben proporcionar la lógica específica para realizar estas tareas.
 */
public interface ILoanService {
    void registerLoan(Loan loan); //Este método sirve para registrar un nuevo préstamo.
  //  El parámetro Loan loan es un objeto que contiene la información sobre el préstamo (como el estudiante, libro o fecha de préstamo).
   // El tipo void significa que este método no devuelve ningún valor; solo registra el préstamo.
    List<Loan> listLoans(); //Devuelve una lista de todos los préstamos registrados.
    //List<Loan> es una colección de objetos Loan, es decir, devolverá todos los préstamos realizados hasta el momento.
    List<Loan> filterLoansByDateRange(LocalDate startDate, LocalDate endDate);
    /*
    Devuelve una lista de todos los préstamos registrados.
List<Loan> es una colección de objetos Loan, es decir, devolverá todos los préstamos realizados hasta el momento.
     */
    List<Loan> filterLoansByDniStudent(String studentDni);
    /*
    Busca y devuelve un préstamo específico por su ID de préstamo.
Recibe un String loanId, que es el identificador único del préstamo.
Devuelve un objeto Loan correspondiente al préstamo encontrado.
     */
    Loan findLoanById(String loanId);
/*
Genera un informe o reporte de préstamos dentro de un rango de fechas.
Similar a filterLoansByDateRange, pero devuelve una lista de objetos LoanReport, que probablemente contiene información más detallada o resumida sobre los préstamos en ese periodo.
 */
    List<LoanReport> getLoansByDateRange(LocalDate startDate, LocalDate endDate);
}
