package ProgramacionFuncional.MethodReferences;

import java.util.List;

public class EjercicioMR1 {
    public static void main(String[] args) {
        List<String> palabras = List.of("java","python","c","javascript","go");

        palabras.stream()
        .filter(palabra -> palabra.length() >= 3)
        .map(String::toUpperCase)
        .sorted()
        .forEach(System.out::println);
    }
}
