package Ejercicio02;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Curso01 {
    private String nombre;
    private String profesor;
    private int duracionHoras;
    private double costo;
    private String categoria;

    public Curso01() {
    }

    public Curso01(String nombre, String profesor, int duracionHoras, double costo, String categoria) {
        this.nombre = nombre;
        this.profesor = profesor;
        this.duracionHoras = duracionHoras;
        this.costo = costo;
        this.categoria = categoria;
    }

    public String getNombre() {
        return this.nombre;
    }

    public String getProfesor() {
        return this.profesor;
    }

    public int getDuracionHoras() {
        return this.duracionHoras;
    }

    public double getCosto() {
        return this.costo;
    }

    public String getCategoria() {
        return this.categoria;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setProfesor(String profesor) {
        this.profesor = profesor;
    }

    public void setDuracionHoras(int duracionHoras) {
        this.duracionHoras = duracionHoras;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return nombre + ", " + profesor + ", " + duracionHoras + ", " + costo + ", " + categoria;
    }
}

class Escuela01 {
    private String nombre;
    private List<Curso01> cursos;

    public Escuela01() {
        this.cursos = new ArrayList<>();
    }

    public Escuela01(String nombre, List<Curso01> cursos) {
        this.nombre = nombre;
        this.cursos = cursos;
    }

    public void agregarCurso(Curso01 curso) {
        cursos.add(curso);
    }

    public void mostrarCursos() {
        cursos.forEach(System.out::println);
    }

    public double obtenerPromedioCosto() {
        return cursos.stream()
                .mapToDouble(Curso01::getCosto)
                .average()
                .orElse(0);
    }
}

@FunctionalInterface
interface IEvaluadorCurso {
    boolean evaluar(Curso01 c);

    static List<Curso01> filtrarCursos(List<Curso01> cursos, IEvaluadorCurso evaluador) {
        return cursos.stream()
                .filter(evaluador::evaluar)
                .collect(Collectors.toList());
    }
}

class Caja<T> {
    private T contenido;

    public Caja(T contenido) {
        this.contenido = contenido;
    }

    public T getContenido() {
        return this.contenido;
    }
}

class TareaInscripcion implements Runnable {
    private String nombreCurso;

    public TareaInscripcion(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }

    @Override
    public void run() {
        System.out.println("Procesando inscripción del curso " + nombreCurso + "...");
    }
}

public class SolucionMain02 {
    public static void main(String[] args) {
        System.out.println("Crea una lista con al menos 8 cursos");
        List<Curso01> cursos = new ArrayList<>();
        cursos.add(new Curso01("Java básico", "Guadalupe", 60, 1000, "Programación"));
        cursos.add(new Curso01("Java Intermedio", "Ondina", 50, 2000, "Programación"));
        cursos.add(new Curso01("SQL", "Nicolas", 30, 3000, "Base de datos"));
        cursos.add(new Curso01("Python", "Omar", 30, 800, "Programación"));
        cursos.add(new Curso01("Redes", "Diego", 25, 6000, "Redes"));
        cursos.add(new Curso01("Linux", "Maria", 10, 1500, "Sistema Operativo"));
        cursos.add(new Curso01("Spring Boot", "Jose", 50, 5000, "Web"));
        cursos.add(new Curso01("Estructura de datos", "Baruc", 10, 500, "Programación"));

        System.out.println("\nMostrar todos los datos");
        cursos.forEach(System.out::println);

        System.out.println("\nOrdenar cursos por costo:");
        cursos.stream()
                .sorted(Comparator.comparing(Curso01::getCosto))
                .forEach(System.out::println);

        System.out.println("\nOrdenar cursos por nombre:");
        cursos.stream()
                .sorted(new Comparator<Curso01>() {
                    @Override
                    public int compare(Curso01 c1, Curso01 c2) {
                        return c1.getNombre().compareTo(c2.getNombre());
                    }
                })
                .forEach(System.out::println);

        System.out.println("\nFiltrar con interfaz funcional:");

        System.out.println("\n- Cursos de más de 40 horas");
        IEvaluadorCurso.filtrarCursos(cursos, c -> c.getDuracionHoras() > 40)
                .forEach(System.out::println);

        System.out.println("\n- Cursos con costo mayor a 2000");
        IEvaluadorCurso.filtrarCursos(cursos, c -> c.getCosto() > 2000)
                .forEach(System.out::println);

        System.out.println("\n- Cursos de categoría \"Programación\"");
        IEvaluadorCurso.filtrarCursos(cursos, c -> c.getCategoria().equals("Programación"))
                .forEach(System.out::println);

        System.out.println("\nStreams:");
        System.out.println("A) Obtener lista solo con nombres de cursos");
        List<String> nombres = cursos.stream()
                .map(Curso01::getNombre)
                .collect(Collectors.toList());
        nombres.forEach(System.out::println);

        System.out.println("\nB) Mostrar cursos con costo menor a 3000");
        cursos.stream()
                .filter(c -> c.getCosto() < 3000)
                .forEach(System.out::println);

        System.out.println("\nC) Calcular promedio de costo");
        double promedio = cursos.stream()
                .mapToDouble(Curso01::getCosto)
                .average()
                .orElse(0);
        System.out.printf("Promedio: %.2f%n", promedio);

        System.out.println("\nD) Contar cuántos cursos hay por categoría");
        cursos.stream()
                .collect(Collectors.groupingBy(Curso01::getCategoria, Collectors.counting()))
                .forEach((nombre, cantidad) ->
                        System.out.println("La categoría " + nombre + " tiene " + cantidad + " cursos"));

        System.out.println("\nAgrupar por categoría:");
        Map<String, List<Curso01>> cursosByCategoria = cursos.stream()
                .collect(Collectors.groupingBy(Curso01::getCategoria));

        cursosByCategoria.forEach((categoria, listaCursos) -> {
            System.out.println(" * " + categoria);
            listaCursos.stream()
                    .map(Curso01::getNombre)
                    .forEach(nombre -> System.out.println("     - " + nombre));
            System.out.println();
        });

        System.out.println("\nGenérico:");
        Caja<List<Curso01>> caja = new Caja<>(cursos);
        caja.getContenido().forEach(System.out::println);

        System.out.println("\nConcurrencia:");
        Thread t1 = new Thread(new TareaInscripcion("Java Intermedio"));
        Thread t2 = new Thread(new TareaInscripcion("Java básico"));

        t1.start();
        t2.start();

        System.out.println("\nReto extra:");
        System.out.println("El curso más caro es: " + cursoMasCaro(cursos));
    }

    public static String cursoMasCaro(List<Curso01> cursos) {
        return cursos.stream()
                .max(Comparator.comparing(Curso01::getCosto))
                .map(Curso01::getNombre)
                .orElse("No hay cursos");
    }
}
