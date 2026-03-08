package ProgramacionFuncional.InterfacesFuncionales.Predicate;

import java.util.List;
import java.util.function.Predicate;

// Sirve para preguntas o condiciones.
// Predicate<T> test(T t) devuelve boolean
// Aquí filter() usa un Predicate.
public class EjemploPredicate1 {
    public static void main(String[] args) {
        Predicate<Integer> esPar = n -> n % 2 == 0;
        System.out.println(esPar.test(4));

        //Ejemplo con stream
        List<Integer> numeros = List.of(1, 2, 3, 4, 5, 6);

        numeros.stream()
                .filter(n -> n % 2 == 0)
                .forEach(System.out::println);
    }
}
