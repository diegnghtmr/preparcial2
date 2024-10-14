package co.edu.uniquindio.preparcial2.preparcial2.hilos.ejercicio5v2;

public class Main {
    static BoundedSemaphore semaphore = new BoundedSemaphore(1);
    static String variable = "";
    public static void main(String[] args) {
        long tac = System.currentTimeMillis();
        long tf = tac + 20000;

        while (System.currentTimeMillis() < tf) {
            Hilo1 hilo1 = new Hilo1(semaphore, variable);
            hilo1.start();

            try {
                hilo1.join();
                variable = hilo1.getVariable();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            Hilo2 hilo2 = new Hilo2(semaphore, variable);
            hilo2.start();

            try {
                hilo2.join();
                variable = hilo2.getVariable();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Proceso completado.");
    }
}
