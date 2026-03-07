package Concurrencia.Runnable;

class Tarea implements Runnable {

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(Thread.currentThread().getName() + " -> " + i);
        }

        try {
            Thread.sleep(500);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}

public class Ejemplo2 {
    public static void main(String[] args) {
        Thread t1 = new Thread(new Tarea());
        Thread t2 = new Thread(new Tarea());

        t1.start();
        t2.start();
    }
}
