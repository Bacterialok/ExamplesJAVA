package ProgramacionFuncional.MethodReferences.MetodoEstatico;

import java.util.List;

public class EjemploMetodoEstatico {
    public static void main(String[] args) {
        List<String> numeros = List.of("10", "20", "30");

        numeros.stream()    
                .map(Integer::parseInt) // map() usa Function
                .forEach(System.out::println);
    }
}
