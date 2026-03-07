package Concurrencia.ConcurrenciaAvanzada.RaceCondition;

import java.util.concurrent.atomic.AtomicInteger;

class Contador {
    //int valor = 0;

    // synchronized: Java permite bloquear acceso a un recurso.
    // Ahora solo un thread a la vez puede ejecutar el método.
    /* 
    public synchronized void incrementar() {
        valor++;
    }
    */

    // No siempre quieres bloquear todo el método.
    // Esto bloquea solo esa parte del código.
    /* 
    public void incrementar() {
        synchronized(this) {
            valor++;
        }
    }
    */

    // Esto es mucho más eficiente que synchronized.
    AtomicInteger valor = new AtomicInteger(0);
    public void incrementar() {
        valor.incrementAndGet();
    }
}

public class Ejemplo1 {
    public static void main(String[] args) throws InterruptedException {
        //Eso es un Race Condition.
        Contador contador = new Contador();

        Runnable tarea = () -> {
            for (int i = 0; i < 100000; i++) {
                contador.incrementar();
            }
        };

        Thread t1 = new Thread(tarea);
        Thread t2 = new Thread(tarea);

        t1.start();
        t2.start();;

        t1.join();
        t2.join();

        System.out.println(contador.valor);
        /* Salidas:
        * 187543
        * 193221
        * 199002
        */
    }
}
