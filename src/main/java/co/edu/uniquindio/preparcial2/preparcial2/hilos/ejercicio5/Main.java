package co.edu.uniquindio.preparcial2.preparcial2.hilos.ejercicio5;

public class Main {

    static BoundedSemaphore semaphore = new BoundedSemaphore(1);
    static String variable = "";

    public static void main(String[] args) {
        long tac = System.currentTimeMillis();
        long tf = tac + 20000;

        while (System.currentTimeMillis() < tf) {
            Thread hilo1 = new Thread(() -> {
                try {
                    semaphore.ocupar();
                    System.out.println("Hilo 1: Comienza a concatenar a la variable");
                    for (int i = 0; i < 6; i++) {
                        variable += "hola";
                        //System.out.println("Hilo 1: " + variable);
                        Thread.sleep(1000);
                    }
                    semaphore.liberar();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });

            hilo1.start();

            try {
                hilo1.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            Thread hilo2 = new Thread(() -> {
                try {
                    semaphore.ocupar();
                    String var = variable;
                    System.out.println("Hilo 2: Leyendo variable: " + var);
                    variable = "";
                    System.out.println("Hilo 2: Variable borrada");
                    semaphore.liberar();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });

            hilo2.start();

            try {
                hilo2.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Proceso completado.");
    }
}

