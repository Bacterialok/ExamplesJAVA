package Concurrencia.Runnable;
//Imprime dos contadores al mismo tiempo.
    
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Contador implements Runnable{
    private String letra;

    public Contador(String letra) {
        this.letra = letra;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            //System.out.println("Contador " + letra + ": " + i);

            //Propuesto Por ChatGPT
            System.out.println(Thread.currentThread().getName() + " -> Contador " + letra + ": " + i);
            /*  Salida
                Thread-0 -> Contador A: 1
T               Thread-1 -> Contador B: 1
            */

        }
    }

    public String getLetra() {
        return this.letra;
    }
}

public class Ejercicio1{
    public static void main(String[] args) {
        //Ejemplo con Thread y Runnable
        Thread t1 = new Thread(new Contador("A"));
        Thread t2 = new Thread(new Contador("B"));
        
        t1.start();
        t2.start();
        
        //Ejemplo con ExcecutorService
        ExecutorService executor = Executors.newFixedThreadPool(2);
        executor.submit(new Contador("C"));
        executor.submit(new Contador("D"));

        executor.submit(() -> {
            for (int i = 0; i < 20; i++) {
                System.out.println("Contador E: " + i);
            }
        });

        executor.submit(() -> {
            for (int i = 0; i < 20; i++) {
                System.out.println("Contador F: " + i);
            }
        });

        executor.shutdown();
    }
}
