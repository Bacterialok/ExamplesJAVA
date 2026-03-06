package Concurrencia.Hilos;

public class EjemploThread extends Thread{
    public void run() {
        for(int i = 1; i <= 5; i++) {
            System.out.println("Hilo " + i);
        }
    }

    public static void main(String[] args) {
        EjemploThread hilo =new EjemploThread();
        hilo.start();

        for (int i = 0; i <=5; i++) {
            System.out.println("Main: " + i);
        }
    }
}
