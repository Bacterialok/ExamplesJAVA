package ProgramacionFuncional.InterfacesFuncionales;

@FunctionalInterface
interface Operacion  {
    int calcular(int a, int b);
}

public class Ejemplo1 {
    public static void main(String[] args) {
        Operacion suma = (a, b) -> a + b;

        System.out.println(suma.calcular(4, 5));
    }
}
