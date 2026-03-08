package ProgramacionFuncional.InterfacesFuncionales.Function;

import java.util.List;
import java.util.function.Function;

// Sirve para transformar un valor en otro.
// Function<T,R> apply(T t) transforma datos
// map() usa Function.
public class EjemploFuction1 {
    public static void main(String[] args) {
        Function<String, Integer> longitud = s -> s.length();

        System.out.println(longitud.apply("Holasssss"));

        // Ejemplo con stream
        List<String> nombres = List.of("Ana", "Luis", "Carlos");

        nombres.stream()
                .map(s -> s.length())
                .forEach(System.out::println);
    }
}