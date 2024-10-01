package com.edteam.service;

import com.edteam.model.Student;
import java.util.List;
import java.util.Optional;

public interface IStudentService {
    /*
    Método para registrar un nuevo estudiante.
Recibe como parámetro un objeto Student, que probablemente contiene la información del estudiante como nombre, edad, DNI, etc.
Es un método void, lo que significa que no devuelve ningún valor, solo realiza una acción (registrar el estudiante).
     */
    void registerStudent(Student student) ;
/*
Método que devuelve una lista de todos los estudiantes registrados.
List<Student> indica que devuelve una colección de objetos Student. Esto permite obtener un listado de todos los estudiantes almacenados en el sistema.
 */
    List<Student> listStudents();
    Optional<Student> findStudentByDni(String dni);
}
