package Ejercicio02;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

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

    public void setNombre(int duracionHoras) {
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
        return nombre + ", " +
                profesor + ", " +
                duracionHoras + ", " +
                costo + ", " +
                categoria;
    }
}

class Escuela01 {
    private String nombre;
    private List<Curso01> cursos;

    public Escuela01() {

    }

    public Escuela01(String nombre, List<Curso01> cursos) {
        this.nombre = nombre;
        this.cursos = cursos;
    }

    public void agregarCurso(Curso01 curso) {
        cursos.add(curso);
    }

    public void mostrarCursos() {
        cursos.stream().forEach(System.out::println);
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

    public static List<Curso01> filtrarCursos(List<Curso01> cursos, IEvaluadorCurso evaluador) {
        return null;
    }
}

public class Main02 {
    public static void main(String[] args) {
        System.out.println("Crea una lista con al menos 8 cursos");
        List<Curso01> cursos = new ArrayList<Curso01>();
        cursos.add(new Curso01("Java basico", "Guadalupe", 60, 1000, "Programacion"));
        cursos.add(new Curso01("Java Intermedio", "Ondina", 50, 2000, "Programacion"));
        cursos.add(new Curso01("SQL", "Nicolas", 30, 3000, "Base de datos"));
        cursos.add(new Curso01("Python", "Omar", 30, 800, "Programacion"));
        cursos.add(new Curso01("Redes", "Diego", 25, 6000, "Redes"));
        cursos.add(new Curso01("Linux", "Maria", 10, 1500, "Sistema Operativo"));
        cursos.add(new Curso01("Spring Boot", "Jose", 50, 5000, "Web"));
        cursos.add(new Curso01("Estructura de datos", "Baruc", 10, 500, "Programacion"));

        System.out.println("\nMostrar todos los datos");
        cursos.stream().forEach(System.out::println);

        System.out.println("\nOrdenar cursos por costo: ");
        cursos.stream()
                .sorted(Comparator.comparing(Curso01::getCosto))
                .forEach(System.out::println);

        System.out.println("\nOrdenar cursos por nombre: ");
        cursos.sort(new Comparator<Curso01>() {
            @Override
            public int compare(Curso01 c1, Curso01 c2) {
                return c1.getNombre().compareTo(c2.getNombre());
            }          
        });

        cursos.stream().forEach(System.out::println);
        
        System.out.println("\nFiltrar con interfaz funcional: ");
        IEvaluadorCurso cursoMayorHrs = new IEvaluadorCurso() {
            @Override
            public boolean evaluar(Curso01 c) {
                return c.getDuracionHoras() > 40;
            }
        };

        System.out.println("\n- Cursos de más de 40 horas");
        cursos.stream().filter(cursoMayorHrs::evaluar).forEach(System.out::println);

        IEvaluadorCurso cursoMayorCosto = new IEvaluadorCurso() {
            @Override
            public boolean evaluar(Curso01 c) {
                return c.getCosto() > 2000;
            }
        };

        System.out.println("\n- Cursos con costo mayor a 2000");
        cursos.stream().filter(cursoMayorCosto::evaluar).forEach(System.out::println);

        IEvaluadorCurso cursoCategoriaP = new IEvaluadorCurso() {
            @Override
            public boolean evaluar(Curso01 c) {
                return c.getCategoria().equals("Programacion");
            }
        };
        
        System.out.println("\n- Cursos de categoría \"Programación\"");
        cursos.stream().filter(cursoCategoriaP::evaluar).forEach(System.out::println);

        System.out.println("\nStreams: ");
        System.out.println("A) Obtener lista solo con nombres de cursos");

        System.out.println("B) Mostrar cursos con costo menor a 3000");

        System.out.println("C) Calcular promedio de costo");

        System.out.println("D) Contar cuántos cursos hay por categoría");

        System.out.println("\nAgrupar por categoría: ");
    }
}
