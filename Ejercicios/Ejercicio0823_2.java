import java.util.List;

public class Ejercicio0823_2 {
    public static void main(String[] args) {
        List<Integer> numeros = List.of(4, 7, 10, 15, 18, 21, 30);

        numeros.stream()
        .filter(n -> n % 2 == 0)
        .forEach(System.out::println);
    }
}
