import java.util.ArrayList;
import java.util.List;

public class Ejercicio0803_1 {
    public static void main(String[] args) {
        List<Integer> numeros = new ArrayList<Integer>();

        numeros.add(5);
        numeros.add(12);
        numeros.add(3);
        numeros.add(8);
        numeros.add(21);
        numeros.add(1);

        numeros.stream().forEach(numero -> System.out.println(numero));
        // Lo mismo que arriba pero mas elegante
        numeros.forEach(System.out::println);
    }
}
