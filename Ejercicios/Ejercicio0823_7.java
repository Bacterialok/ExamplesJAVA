import java.util.Comparator;
import java.util.List;

public class Ejercicio0823_7 {
    public static void main(String[] args) {
        List<Persona1> personas = List.of(
                new Persona1("Ana", 25),
                new Persona1("Luis", 20),
                new Persona1("Carlos", 30),
                new Persona1("Elena", 22),
                new Persona1("Mario", 28),
                new Persona1("Pedro", 19),
                new Persona1("Sofia", 35));

        personas.stream()
        .filter(p -> p.getEdad() > 25)
        .sorted(Comparator.comparing(Persona1::getEdad))
        .map(Persona1::getNombre)
        .forEach(System.out::println);
    }
}
