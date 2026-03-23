package Records.Ejemplos;

public class Ejercicio3 {
    public record EstudianteRecord1(String nombre, double promedio) {}

    public static void main(String[] args) {
        EstudianteRecord1 e = new EstudianteRecord1("Luis", 9.5);
        System.out.println(e);
    }
}
