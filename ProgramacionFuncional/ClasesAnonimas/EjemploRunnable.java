package ProgramacionFuncional.ClasesAnonimas;

public class EjemploRunnable {
    public static void main(String[] args) {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hola desde clase anonima");
            }
        };

        r.run();
    }
}
