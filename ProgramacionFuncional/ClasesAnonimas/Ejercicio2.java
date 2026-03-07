package ProgramacionFuncional.ClasesAnonimas;

abstract class Operacion {
    public abstract void calcular(int a, int b);
}

public class Ejercicio2 {
    public static void main(String[] args) {
        Operacion operacion = new Operacion() {
            @Override
            public void calcular(int a, int b) {
                System.out.println(a + b);
            }
        };

        operacion.calcular(3, 4);
    }
}
