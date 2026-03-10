import java.util.List;

public class Ejercicio0903_10 {
    public static void main(String[] args) {
        List<Integer> l1 = List.of(1,2,3);
        List<Integer> l2 = List.of(4,5);
        List<Integer> l3 = List.of(6,7,8);
        List<List<Integer>> listaNumeros = List.of(
            l1,
            l2,
            l3
        );

        listaNumeros.stream()
            .flatMap(List::stream)
            .forEach(System.out::println);
    }
}
