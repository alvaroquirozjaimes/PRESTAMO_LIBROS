package service;

import model.Student;
import java.util.List;
import java.util.Optional;

public interface IStudentService {
    /**
     * Método para registrar un nuevo estudiante.
     * Recibe un objeto Student que contiene la información del estudiante.
     * Este método no devuelve ningún valor, solo registra el estudiante.
     */
    void registerStudent(Student student);

    /**
     * Método que devuelve una lista de todos los estudiantes registrados.
     * @return una colección de objetos Student.
     */
    List<Student> listStudents();

    /**
     * Método para buscar un estudiante por su DNI.
     * @param dni el DNI del estudiante a buscar.
     * @return un Optional que puede contener el estudiante encontrado o estar vacío.
     */
    Optional<Student> findStudentByDni(String dni);
}
