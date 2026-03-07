package Concurrencia.ConcurrenciaAvanzada.Livelock;

class Recurso {
    boolean ocupado = false;
}

class Trabajador implements Runnable {
    private Recurso r1;
    private Recurso r2;

    public Trabajador(Recurso r1, Recurso r2) {
        this.r1 = r1;
        this.r2 = r2;
    }

    @Override
    public void run() {
        while(true) {
            if (!r1.ocupado) {
                r1.ocupado = true;
                System.out.println(Thread.currentThread().getName() + " tomo r1");

                if (!r2.ocupado) {
                    r2.ocupado = true;
                    System.out.println(Thread.currentThread().getName() + " tomo r2");
                    break;
                } else {
                    System.out.println(Thread.currentThread().getName() + " libera r1");
                    r1.ocupado = false;
                }
            }
        }
    }
}

public class LivelockEjemplo1 {
    public static void main(String[] args) {
        Recurso r1 = new Recurso();
        Recurso r2 = new Recurso();

        Thread t1 = new Thread(new Trabajador(r1, r2), "Thread 1");
        Thread t2 = new Thread(new Trabajador(r1, r2), "Thread 2");

        t1.start();
        t2.start();
    }
}
