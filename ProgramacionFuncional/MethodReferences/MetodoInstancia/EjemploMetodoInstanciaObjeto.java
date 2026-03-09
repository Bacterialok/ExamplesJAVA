package ProgramacionFuncional.MethodReferences.MetodoInstancia;

import java.util.function.Consumer;

public class EjemploMetodoInstanciaObjeto {
    public static void main(String[] args) {
        Consumer<String> imprimir = System.out::println;

        imprimir.accept("Hola");
    }
}
