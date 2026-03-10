import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Ejercicio0803_8 {
    public static void main(String[] args) {
        List<Persona1> personas = List.of(
                new Persona1("Mario", 28),
                new Persona1("Carlor", 30),
                new Persona1("Sofia", 35));

        List<Persona1> personas1 = personas.stream()
                .filter(p -> p.getEdad() >= 25)
                .sorted(Comparator.comparing(Persona1::getEdad))
                .collect(Collectors.toList());

        personas1.stream().forEach(System.out::println);
    }
}
