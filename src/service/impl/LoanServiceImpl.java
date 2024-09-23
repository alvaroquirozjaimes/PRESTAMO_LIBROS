package service.impl;

import model.LoanReport;
import exception.DuplicateLoanException;
import exception.ErrorMessages;
import exception.LoanNotFoundException;
import model.Loan;
import service.ILoanService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class LoanServiceImpl implements ILoanService {
    // Lista que almacena los préstamos registrados
    private List<Loan> loans = new ArrayList<>();

    @Override
    public void registerLoan(Loan loan) {
        // Verificar si ya existe un préstamo para el mismo libro y estudiante
        boolean isDuplicateLoan = loans.stream()
                .anyMatch(existingLoan -> existingLoan.getBook().equals(loan.getBook())
                        && existingLoan.getStudent().equals(loan.getStudent()));

        // Si hay un duplicado, lanzar excepción
        if (isDuplicateLoan) {
            throw new DuplicateLoanException(ErrorMessages.DUPLICATE_LOAN.formatMessage(
                    loan.getBook().getTitle(), loan.getStudent().getName()));
        }

        // Agregar el préstamo a la lista
        loans.add(loan);
    }

    @Override
    public List<Loan> listLoans() {
        // Devuelve la lista de todos los préstamos registrados
        return loans;
    }

    @Override
    public List<Loan> filterLoansByDateRange(LocalDate startDate, LocalDate endDate) {
        // Filtrar préstamos por rango de fechas
        return loans.stream()
                .filter(loan -> loan.getLoanDate().isAfter(startDate) && loan.getLoanDate().isBefore(endDate))
                .toList();
    }

    @Override
    public List<Loan> filterLoansByDniStudent(String studentDni) {
        // Filtrar préstamos por DNI del estudiante
        return loans.stream()
                .filter(loan -> loan.getStudent().getDni().equals(studentDni))
                .toList();
    }

    @Override
    public Loan findLoanById(String loanId) {
        // Buscar un préstamo por su ID
        return loans.stream()
                .filter(loan -> loan.getId().equals(loanId))
                .findFirst()
                .orElseThrow(() -> new LoanNotFoundException(
                        ErrorMessages.LOAN_NOT_FOUND.formatMessage(loanId)));
    }

    @Override
    public List<LoanReport> getLoansByDateRange(LocalDate startDate, LocalDate endDate) {
        // Filtrar y mapear préstamos en un rango de fechas a informes
        return loans.stream()
                .filter(loan -> (loan.getLoanDate().isEqual(startDate) || loan.getLoanDate().isAfter(startDate))
                        && (loan.getLoanDate().isEqual(endDate) || loan.getLoanDate().isBefore(endDate)))
                .map(loan -> new LoanReport(
                        loan.getBook().getTitle(),
                        loan.getBook().getAuthor(),
                        loan.getBook().getYear(),
                        loan.getLoanDate(),
                        loan.getReturnDate(),
                        loan.getStudent().getName()
                ))
                .toList();
    }
}
