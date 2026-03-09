import java.util.List;

public class Ejercicio0823_3 {
    public static void main(String[] args) {
        List<Integer> numeros = List.of(2, 4, 6, 8, 10);

        numeros.stream()
        .map(numero -> numero * 2)
        .forEach(System.out::println);
    }
}
