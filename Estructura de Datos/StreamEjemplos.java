import java.util.List;

public class StreamEjemplos {
    public static void main(String[] args) {
        List<Integer> numeros = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        numeros.stream().filter(n -> n % 2 == 0).forEach(System.out::println);
    }
}
