package model;

public class Student {
    private String name;  // Nombre del estudiante
    private String dni;   // DNI del estudiante

    // Constructor que inicializa el nombre y el DNI del estudiante
    public Student(String name, String dni) {
        this.name = name;
        this.dni = dni;
    }

    // Método para obtener el nombre del estudiante
    public String getName() {
        return name;
    }

    // Método para obtener el DNI del estudiante
    public String getDni() {
        return dni;
    }

    // Método que devuelve una representación en cadena del estudiante
    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", dni='" + dni + '\'' +
                '}';
    }
}
