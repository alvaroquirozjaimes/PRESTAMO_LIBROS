package service.impl;

import exception.DuplicateStudentException;
import exception.ErrorMessages;
import exception.StudentNotFoundException;
import model.Student;
import service.IStudentService;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class StudentServiceImpl implements IStudentService {

    // Lista que almacena los objetos de tipo Student registrados
    private List<Student> students = new ArrayList<>();

    @Override
    public void registerStudent(Student student) {
        // Verificar si ya existe un estudiante con el mismo DNI y nombre
        boolean isDuplicateStudent = students.stream()
                .anyMatch(existingStudent -> existingStudent.getDni().equals(student.getDni())
                        && existingStudent.getName().equals(student.getName()));

        // Si hay un duplicado, lanzar excepción
        if (isDuplicateStudent) {
            throw new DuplicateStudentException(
                    ErrorMessages.DUPLICATE_STUDENT.formatMessage(student.getDni(), student.getName())
            );
        }

        // Si no hay duplicados, agregar el estudiante
        students.add(student);
    }

    @Override
    public List<Student> listStudents() {
        // Devuelve la lista de todos los estudiantes registrados
        return students;
    }

    @Override
    public Optional<Student> findStudentByDni(String dni) {
        // Buscar el estudiante por DNI
        Optional<Student> optionalStudent = students.stream()
                .filter(student -> student.getDni().equals(dni))
                .findFirst();

        // Si no se encuentra el estudiante, lanzar excepción
        if (optionalStudent.isEmpty()) {
            throw new StudentNotFoundException(
                    ErrorMessages.STUDENT_NOT_FOUND.formatMessage(dni));
        }

        // Retornar el estudiante encontrado
        return optionalStudent;
    }
}
