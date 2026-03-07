package ProgramacionFuncional.ClasesAnonimas;

import java.util.Scanner;

public class EjemploListener {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Runnable accion = new Runnable() {
            @Override
            public void run() {
                System.out.println("Accion ejecutada");
            }
        };

        accion.run();
    }
}
