package ProgramacionFuncional.MethodReferences.MetodoInstanciaTipo;

import java.util.List;

public class EjemploMetodoInstanciaTipo {
    public static void main(String[] args) {
        List<String> nombres = List.of("Ana", "Luis", "Carlos");

        nombres.stream()
        .map(String::length)
        .forEach(System.out::println);
    }
}
