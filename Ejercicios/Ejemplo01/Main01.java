package Ejemplo01;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main01 {
    public static void main(String[] args) {
        List<Empleado01> empleados = new ArrayList<Empleado01>();
        empleados.add(new Empleado01("Nicolas", 23, 38000, "Sistemas"));
        empleados.add(new Empleado01("Francisco", 29, 35000, "Sistemas"));
        empleados.add(new Empleado01("Rey", 31, 30000, "RH"));
        empleados.add(new Empleado01("Omar", 25, 20000, "Ventas"));
        empleados.add(new Empleado01("Irving", 40, 24589, "RH"));
        empleados.add(new Empleado01("Diego", 24, 40000, "Contabilidad"));
        empleados.add(new Empleado01("Luis", 34, 34000, "Contabilidad"));

        empleados.forEach(e -> System.err.println(e.toString()));
        System.out.println();

        List<Empleado01> empleadosBySalario = empleados.stream()
                .sorted(Comparator.comparing(Empleado01::getSalario))
                .collect(Collectors.toList());

        System.out.println();
        empleadosBySalario.forEach(System.out::println);

        System.out.println();
        empleados.sort(new Comparator<Empleado01>() {
            @Override
            public int compare(Empleado01 e1, Empleado01 e2) {
                return e1.getNombre().compareTo(e2.getNombre());
            }
        });

        // empleados.stream().sorted(Comparator.comparing(Empleado01::getNombre)).forEach(System.out::println);
    }
}
