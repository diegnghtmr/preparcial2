package co.edu.uniquindio.preparcial2.preparcial2.hilos.ejercicio5v3Final;

public class HiloServicio2 extends Thread {
    private BoundedSemaphore semaphore;
    private String variable;

    public HiloServicio2(BoundedSemaphore semaphore, String variable) {
        this.semaphore = semaphore;
        this.variable = variable;
    }

    @Override
    public void run() {
        try {
            semaphore.ocupar();
            System.out.println("Hilo 2: Leyendo variable: " + variable);
            variable = "";
            System.out.println("Hilo 2: Variable borrada");
            semaphore.liberar();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String getVariable() {
        return variable;
    }
}
