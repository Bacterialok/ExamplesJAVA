package Records.Ejemplos;

import java.util.List;

public class Ejercicio5 {
    public static void main(String[] args) {
        List<EmpleadoRecord2> empleados = List.of(
            new EmpleadoRecord2("Omar", 40000),
            new EmpleadoRecord2("Diego", 50000),
            new EmpleadoRecord2("Nicolas", 90000)
        );

        empleados.stream()
        .filter(e -> e.salario() > 45000)
        .forEach(System.out::println);
    }
}

record EmpleadoRecord2(String nombre, double salario) {}