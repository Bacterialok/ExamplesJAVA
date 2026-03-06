package Concurrencia.Runnable;

import java.net.Socket;

public class EjemploRunneable implements Runnable {

    //Codigo que ejecutara el hilo
    @Override
    public void run() {
        System.out.println("Ejecutando tarea");
    }

    public static void main(String[] args) {
        Runnable tarea =new EjemploRunneable();
        Thread hilo =new Thread(tarea);
        //Inicia el thread
        hilo.start();

        //Pausa el thread
        //Thread.sleep(1000);

        //Hace que un hilo espere a otro
        //thread.join();

        //Obtiene nombre del trabajo
        //Thread.getName();
        System.out.println(hilo.getName());

        //Devuelve el thread actual
        //currentThread();
        System.out.println(Thread.currentThread().getName());

        //Clase anonima
        Thread hilo1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Ejecutando tarea desde clase anonima");
            }
        });

        hilo1.start();

        //Lambda
        Thread hilo2 = new Thread(() -> {
            System.out.println("Hola desde otro hilo");
        });

        hilo2.start();
    }
}
