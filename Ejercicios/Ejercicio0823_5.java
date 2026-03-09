import java.util.List;

public class Ejercicio0823_5 {
    public static void main(String[] args) {
        List<Integer> numeros = List.of(9, 2, 15, 4, 7, 20, 1);

        numeros.stream()
        .sorted()
        .forEach(System.out::println);
    }
}
