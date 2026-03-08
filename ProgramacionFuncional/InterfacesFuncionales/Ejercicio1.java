package ProgramacionFuncional.InterfacesFuncionales;

@FunctionalInterface
interface OperacionMatematica {
    double operar(double a, double b);
}

public class Ejercicio1 {
    public static void main(String[] args) {
        OperacionMatematica suma = (a, b) -> a + b;
        OperacionMatematica multiplicacion = (a, b) -> a * b;
        OperacionMatematica division = (a, b) -> a / b;

        System.out.println(suma.operar(10, 10));
        System.out.println(multiplicacion.operar(9, 10));
        System.out.println(division.operar(3, 3));
    }
}
