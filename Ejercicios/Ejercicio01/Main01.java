package Ejercicio01;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

// Clase Empleado
class Empleado01 {
    private String nombre;
    private int edad;
    private double salario;
    private String departamento;

    public Empleado01(String nombre, int edad, double salario, String departamento) {
        this.nombre = nombre;
        this.edad = edad;
        this.salario = salario;
        this.departamento = departamento;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public double getSalario() {
        return salario;
    }

    public String getDepartamento() {
        return departamento;
    }

    @Override
    public String toString() {
        return nombre + " " + edad + " " + salario + " " + departamento;
    }
}

class Empresa01 {
    private String nombre;
    private List<Empleado01> empleados;

    public Empresa01() {
        empleados = new ArrayList<Empleado01>();
    }

    public Empresa01(String nombre, List<Empleado01> empleados) {
        this.nombre = nombre;
        this.empleados = empleados;
    }

    public void agregarEmpleado(Empleado01 empleado) {
        empleados.add(empleado);
    }

    public void mostrarEmpleados() {
        empleados.stream().forEach(System.out::println);
    }

    public double obtenerPromedioSalario() {
        return empleados.stream()
                .mapToDouble(Empleado01::getSalario)
                .average()
                .orElse(0);
    }
}

// Interfaz funcional
@FunctionalInterface
interface IEvaluadorEmpleado {
    boolean evaluar(Empleado01 e);
}

class Caja<T> {
    private T algo;

    public Caja(T algo) {
        this.algo = algo;
    }

    public T obtener() {
        return algo;
    }

    public void imprimir() {
        algo.toString();
    }
}

class TareaReporte implements Runnable {
    private String departamento;

    public TareaReporte(String departamento) {
        this.departamento = departamento;
    }

    @Override
    public void run() {
        System.out.println("Generando reporte del departamento " + departamento + "...");
    }

}

public class Main01 {

    public static List<Empleado01> evaluadorEmpleado(List<Empleado01> empleados) {
        return empleados.stream()
                .filter(e -> e.getEdad() > 30 && e.getSalario() > 15000 && e.getDepartamento().equals("Sistemas"))
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {

        System.out.println("Lista principal de empleados");
        List<Empleado01> empleados = new ArrayList<Empleado01>();
        empleados.add(new Empleado01("Nicolas", 23, 38000, "Sistemas"));
        empleados.add(new Empleado01("Francisco", 39, 35000, "Sistemas"));
        empleados.add(new Empleado01("Rey", 31, 10000, "RH"));
        empleados.add(new Empleado01("Omar", 25, 20000, "Ventas"));
        empleados.add(new Empleado01("Irving", 40, 24589, "RH"));
        empleados.add(new Empleado01("Diego", 24, 40000, "Contabilidad"));
        empleados.add(new Empleado01("Luis", 34, 8000, "Contabilidad"));
        empleados.forEach(e -> System.out.println(e.toString()));

        System.out.println("Mostrar todos los empleados");
        List<Empleado01> empleadosBySalario = empleados.stream()
                .sorted(Comparator.comparing(Empleado01::getSalario))
                .collect(Collectors.toList());

        System.out.println("Ordenar empleados por salario");
        empleadosBySalario.forEach(System.out::println);

        System.out.println("Ordenar empleados por nombre");
        empleados.sort(new Comparator<Empleado01>() {
            @Override
            public int compare(Empleado01 e1, Empleado01 e2) {
                return e1.getNombre().compareTo(e2.getNombre());
            }
        });

        empleados.forEach(System.out::println);
        // empleados.stream().sorted(Comparator.comparing(Empleado01::getNombre)).forEach(System.out::println);

        System.out.println("Filtrar empleados con una interfaz funcional");
        evaluadorEmpleado(empleados).stream()
                .forEach(System.out::println);

        System.out.println("A) Obtener una lista solo con los nombres de los empleados.");
        empleados.stream()
                .forEach(e -> System.out.println(e.getNombre()));

        System.out.println("B) Obtener los empleados con salario mayor a 12000.");
        empleados.stream()
                .filter(e -> e.getSalario() > 12000)
                .forEach(e -> System.out.println(e.getNombre()));

        /*
         * mapToDouble()
         * convierte Empleado → double
         * 
         * average()
         * calcula el promedio
         * 
         * orElse(0)
         * por si la lista está vacía.
         */
        System.out.println("C) Calcular el promedio de salario.");
        double promedio = empleados.stream()
                .mapToDouble(e -> e.getSalario())
                .average()
                .orElse(0);
        System.out.printf("%.2f", promedio);

        System.out.println("D) Contar cuántos empleados hay en cada departamento.");
        empleados.stream()
                .collect(Collectors.groupingBy(
                        Empleado01::getDepartamento,
                        Collectors.counting()))
                .forEach((dep, cantidad) -> System.out.println(dep + ": " + cantidad));

        System.out.println("Agrupar empleados por departamento");
        Map<String, List<Empleado01>> empleadosByDepartamento = empleados.stream()
                .collect(Collectors.groupingBy(
                        Empleado01::getDepartamento));

        empleadosByDepartamento.forEach((departamento, lista) -> {
            System.out.println("Departamento: " + departamento);
            lista.forEach(e -> System.out.println("- " + e.getNombre()));
        });

        System.out.println("Genérico simple");
        Caja<List<Empleado01>> cajaEmpleado = new Caja(empleados);
        cajaEmpleado.obtener().stream().forEach(System.out::println);

        System.out.println("Concurrencia básica");
        TareaReporte tr1 = new TareaReporte("Sistemas");
        tr1.run();

        Thread h1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Sistemas");
            }
        });

        Thread h2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Ventas");
            }
        });

        h1.start();
        h2.start();

        System.out.println("Reto extra");
        Empresa01 empresa01 = new Empresa01("BBVA", empleados);
        empresa01.mostrarEmpleados();
        System.out.println();
        System.out.printf("%2f", empresa01.obtenerPromedioSalario());
    }
}
