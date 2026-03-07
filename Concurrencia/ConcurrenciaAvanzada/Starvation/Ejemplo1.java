package Concurrencia.ConcurrenciaAvanzada.Starvation;


/* Starvation (inanición) ocurre cuando:
* Un thread nunca obtiene CPU o recursos porque otros threads siempre tienen prioridad.
* El programa no se congela, pero un hilo nunca avanza.
*/
class Tarea implements Runnable {
    @Override
    public void run() {
        while (true) {
            System.out.println(Thread.currentThread().getName());
        }
    }
}

public class Ejemplo1  {
    public static void main(String[] args) {
        Thread t1 = new Thread(new Tarea());
        Thread t2 = new Thread(new Tarea());

        t1.setPriority(Thread.MAX_PRIORITY);
        t2.setPriority(Thread.MIN_PRIORITY);

        t1.start();
        t2.start();
    }
}
