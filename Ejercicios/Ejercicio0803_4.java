import java.util.List;

public class Ejercicio0803_4 {
    public static void main(String[] args) {
        List<Integer> numeros = List.of(3, 8, 12, 5, 20, 7, 16);

        numeros.stream()
        .filter(n -> n > 10)
        .map(n -> n * 3)
        .forEach(System.out::println);
    }
}
