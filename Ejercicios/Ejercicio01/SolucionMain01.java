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
        return nombre + " | " + edad + " | " + salario + " | " + departamento;
    }
}

class Empresa01 {
    private String nombre;
    private List<Empleado01> empleados;

    public Empresa01(String nombre) {
        this.nombre = nombre;
        this.empleados = new ArrayList<>();
    }

    public Empresa01(String nombre, List<Empleado01> empleados) {
        this.nombre = nombre;
        this.empleados = empleados;
    }

    public void agregarEmpleado(Empleado01 empleado) {
        empleados.add(empleado);
    }

    public void mostrarEmpleados() {
        empleados.forEach(System.out::println);
    }

    public double obtenerPromedioSalario() {
        return empleados.stream()
                .mapToDouble(Empleado01::getSalario)
                .average()
                .orElse(0);
    }
}

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
        System.out.println(algo);
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

public class SolucionMain01 {

    public static List<Empleado01> evaluadorEmpleado(List<Empleado01> empleados, IEvaluadorEmpleado evaluador) {
        return empleados.stream()
                .filter(evaluador::evaluar)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {

        System.out.println("Lista principal de empleados");
        List<Empleado01> empleados = new ArrayList<>();
        empleados.add(new Empleado01("Nicolas", 23, 38000, "Sistemas"));
        empleados.add(new Empleado01("Francisco", 39, 35000, "Sistemas"));
        empleados.add(new Empleado01("Rey", 31, 10000, "RH"));
        empleados.add(new Empleado01("Omar", 25, 20000, "Ventas"));
        empleados.add(new Empleado01("Irving", 40, 24589, "RH"));
        empleados.add(new Empleado01("Diego", 24, 40000, "Contabilidad"));
        empleados.add(new Empleado01("Luis", 34, 8000, "Contabilidad"));
        empleados.add(new Empleado01("Sofia", 29, 18000, "Ventas"));

        empleados.forEach(System.out::println);

        System.out.println("\nOrdenar empleados por salario");
        List<Empleado01> empleadosBySalario = empleados.stream()
                .sorted(Comparator.comparing(Empleado01::getSalario))
                .collect(Collectors.toList());
        empleadosBySalario.forEach(System.out::println);

        System.out.println("\nOrdenar empleados por nombre");
        empleados.sort(new Comparator<Empleado01>() {
            @Override
            public int compare(Empleado01 e1, Empleado01 e2) {
                return e1.getNombre().compareTo(e2.getNombre());
            }
        });
        empleados.forEach(System.out::println);

        System.out.println("\nFiltrar empleados con una interfaz funcional");

        System.out.println("Mayores de 30:");
        evaluadorEmpleado(empleados, e -> e.getEdad() > 30)
                .forEach(System.out::println);

        System.out.println("\nSalario mayor a 15000:");
        evaluadorEmpleado(empleados, e -> e.getSalario() > 15000)
                .forEach(System.out::println);

        System.out.println("\nDepartamento Sistemas:");
        evaluadorEmpleado(empleados, e -> e.getDepartamento().equals("Sistemas"))
                .forEach(System.out::println);

        System.out.println("\nA) Obtener una lista solo con los nombres de los empleados.");
        List<String> nombres = empleados.stream()
                .map(Empleado01::getNombre)
                .collect(Collectors.toList());
                
        nombres.forEach(System.out::println);

        System.out.println("\nB) Obtener los empleados con salario mayor a 12000.");
        empleados.stream()
                .filter(e -> e.getSalario() > 12000)
                .forEach(System.out::println);

        System.out.println("\nC) Calcular el promedio de salario.");
        double promedio = empleados.stream()
                .mapToDouble(Empleado01::getSalario)
                .average()
                .orElse(0);
        System.out.printf("Promedio salarial: %.2f%n", promedio);

        System.out.println("\nD) Contar cuántos empleados hay en cada departamento.");
        empleados.stream()
                .collect(Collectors.groupingBy(
                        Empleado01::getDepartamento,
                        Collectors.counting()))
                .forEach((dep, cantidad) -> System.out.println(dep + ": " + cantidad));

        System.out.println("\nAgrupar empleados por departamento");
        Map<String, List<Empleado01>> empleadosByDepartamento = empleados.stream()
                .collect(Collectors.groupingBy(Empleado01::getDepartamento));

        empleadosByDepartamento.forEach((departamento, lista) -> {
            System.out.println("Departamento: " + departamento);
            lista.forEach(e -> System.out.println("- " + e.getNombre()));
        });

        System.out.println("\nGenérico simple");
        Caja<List<Empleado01>> cajaEmpleado = new Caja<>(empleados);
        cajaEmpleado.imprimir();

        System.out.println("\nConcurrencia básica");
        Thread reporte1 = new Thread(new TareaReporte("Sistemas"));
        Thread reporte2 = new Thread(new TareaReporte("Ventas"));

        reporte1.start();
        reporte2.start();

        System.out.println("\nReto extra");
        Empresa01 empresa01 = new Empresa01("BBVA", empleados);
        empresa01.mostrarEmpleados();
        System.out.printf("Promedio empresa: %.2f%n", empresa01.obtenerPromedioSalario());
    }
}