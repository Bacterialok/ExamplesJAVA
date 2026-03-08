package ProgramacionFuncional.InterfacesFuncionales.Consumer;

import java.util.List;
import java.util.function.Consumer;

// Consumer<T> accept(T t) consume datos
// Sirve para recibir algo y hacer algo con eso.
// forEach() usa Consumer.
public class EjemploConsumer1 {
    public static void main(String[] args) {
        Consumer<String> imprimir = s -> System.out.println(s);

        imprimir.accept("Hola desde Consumer");
        System.out.println();

        List<Integer> numeros = List.of(1,2,3,4,5,6,7);

        //Ejemplo con stram
        numeros.forEach(n -> System.out.println(n));

        System.out.println();
        //Ejemplo donde se implementa coon stream Predicate y Consumer
        numeros.stream()
        .filter(n -> n % 2 == 0)
        .forEach(n -> System.out.println(n));
    }
}
