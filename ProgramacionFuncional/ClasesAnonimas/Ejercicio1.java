package ProgramacionFuncional.ClasesAnonimas;

public class Ejercicio1 {
    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("Ejercicio 1 ejecutado");
            }
        };
    }
}
