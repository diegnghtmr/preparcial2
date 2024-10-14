package co.edu.uniquindio.preparcial2.preparcial2.hilos.ejercicio5v2;

public class Hilo1 extends Thread {
    private BoundedSemaphore semaphore;
    private String variable;

    public Hilo1(BoundedSemaphore semaphore, String variable) {
        this.semaphore = semaphore;
        this.variable = variable;
    }

    @Override
    public void run() {
        try {
            semaphore.ocupar();
            System.out.println("Hilo 1: Comienza a concatenar a la variable");
            for (int i = 0; i < 6; i++) {
                variable += "hola";
                Thread.sleep(1000);
            }
            semaphore.liberar();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String getVariable() {
        return variable;
    }
}
