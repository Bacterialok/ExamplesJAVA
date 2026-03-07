package Concurrencia.Runnable;

public class Ejemplo3Lambda {
    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            System.out.println("Hola desde lambda");
        });

        t.start();
    }
}
