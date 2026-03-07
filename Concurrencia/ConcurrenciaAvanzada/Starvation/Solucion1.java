package Concurrencia.ConcurrenciaAvanzada.Starvation;

import java.util.concurrent.locks.ReentrantLock;

/* Starvation (inanición) ocurre cuando:
* Un thread nunca obtiene CPU o recursos porque otros threads siempre tienen prioridad.
* El programa no se congela, pero un hilo nunca avanza.
*/
class Tarea1 implements Runnable {
    private static final ReentrantLock lock = new ReentrantLock(true); // lock justo

    @Override
    public void run() {
        while (true) {
            lock.lock();
            try {
                System.out.println(Thread.currentThread().getName() + " obtuvo el lock");
                try {
                    Thread.sleep(200);
                } catch (InterruptedException  e) {
                    Thread.currentThread().interrupt();
                }
            } finally {
                lock.unlock();
            }
            
        }
    }
}

public class Solucion1 {
    public static void main(String[] args) {
        Thread t1 = new Thread(new Tarea(), "MAX");
        Thread t2 = new Thread(new Tarea(), "MIN");

        t1.setPriority(Thread.MAX_PRIORITY);
        t2.setPriority(Thread.MIN_PRIORITY);

        t1.start();
        t2.start();
    }
}
