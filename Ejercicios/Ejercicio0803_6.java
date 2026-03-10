import java.util.Comparator;
import java.util.List;

class Persona1 {
    private String nombre;
    private int edad;

    public Persona1(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    @Override
    public String toString() {
        return nombre + " " + edad;
    }
}

public class Ejercicio0803_6 {
    public static void main(String[] args) {
        List<Persona1> personas = List.of(
                new Persona1("Ana", 25),
                new Persona1("Luis", 20),
                new Persona1("Carlos", 30),
                new Persona1("Elena", 22),
                new Persona1("Mario", 28));

        /*
         * List<Persona1> personas = new ArrayList<>();
         * personas.add(new Persona1("Ana", 25));
         * personas.add(new Persona1("Luis", 20));
         * personas.add(new Persona1("Carlos", 30));
         * personas.add(new Persona1("Elena", 22));
         * personas.add(new Persona1("Mario", 28));
         */

        personas.stream()
                .sorted(Comparator.comparing(Persona1::getEdad))
                .forEach(System.out::println);
    }
}
