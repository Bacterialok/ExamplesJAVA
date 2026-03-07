package Concurrencia.ConcurrenciaAvanzada.Deadlock;

import java.util.concurrent.locks.ReentrantLock;

/* ¿Qué es un Deadlock?
* Este es uno de los errores más peligrosos en programación concurrente porque el programa se queda bloqueado para siempre.
* Un Deadlock ocurre cuando:
* Dos o más threads se bloquean mutuamente esperando recursos que el otro posee.
*/
public class EjemploDeadlock {
    static Object recurso1 = new Object();
    static Object recurso2 = new Object();

    static ReentrantLock lock1 = new ReentrantLock();
    static ReentrantLock lock2 = new ReentrantLock();

    public static void main(String[] args) {

        //Error Deadlock
        Thread t3 = new Thread(() -> {
            synchronized (recurso1) {
                System.out.println("Thread 1 tomo recurso1");
                try {
                    Thread.sleep(100);
                } catch (Exception e) {
                }

                synchronized (recurso2) {
                    System.out.println("Thread 1 tomo recurso2");
                }
            }
        });
        

        Thread t4 = new Thread(() -> {
            synchronized (recurso2) {
                System.out.println("Thread 2 tomo recurso2");

                try {
                    Thread.sleep(100);
                } catch (Exception e) {
                }

                synchronized (recurso1) {
                    System.out.println("Thread 2 tomo recurso1");
                }
            }
        });

        t3.start();
        t4.start();

        //Solucion Deadlock
        Thread t1 = new Thread(() -> {
            if (lock1.tryLock()) {
                try {
                    System.out.println("Thread 1 tomó lock1");
                    try {
                        Thread.sleep(100);
                    } catch (Exception e) {
                    }

                    if (lock2.tryLock()) {
                        try {
                            System.out.println("Thread 1 tomó lock2");
                        } finally {
                            lock2.unlock();
                        }
                    } else {
                        System.out.println("Thread 1 no pudo tomar lock2");
                    }
                } finally {
                    lock1.unlock();
                }
            }
        });

        Thread t2 = new Thread(() -> {
            if (lock2.tryLock()) {
                try {
                    System.out.println("Thread 2 tomó lock2");
                    try {
                        Thread.sleep(100);
                    } catch (Exception e) {
                    }

                    if (lock1.tryLock()) {
                        try {
                            System.out.println("Thread 2 tomó lock1");
                        } finally {
                            lock1.unlock();
                        }
                    } else {
                        System.out.println("Thread 2 no pudo tomar lock1");
                    }
                } finally {
                    lock2.unlock();
                }
            }
        });

        t1.start();
        t2.start();

        //Solucion 3 con Timeouts
    }
}
