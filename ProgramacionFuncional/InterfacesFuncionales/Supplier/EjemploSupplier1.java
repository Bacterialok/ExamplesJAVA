package ProgramacionFuncional.InterfacesFuncionales.Supplier;

import java.util.function.Supplier;

// Sirve para generar valores.
// Supplier<T> T get() Genera datos
public class EjemploSupplier1 {
    public static void main(String[] args) {
        Supplier<Double> random = () -> Math.random();

        System.out.println(random.get());
        System.out.println();

        Supplier<String> saludo = () -> "Hola";
        System.out.println(saludo.get());
    }
}
