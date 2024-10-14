package co.edu.uniquindio.preparcial2.preparcial2.hilos.ejercicio5v3Final;

public class ManejadorHilo {
    private BoundedSemaphore semaphore;
    private String variable;

    public ManejadorHilo() {
        this.semaphore = new BoundedSemaphore(1);
        this.variable = "";
    }

    public void iniciarProceso() {
        long tac = System.currentTimeMillis();
        long tf = tac + 20000;

        while (System.currentTimeMillis() < tf) {
            HiloServicio1 hilo1 = new HiloServicio1(semaphore, variable);
            hilo1.start();

            try {
                hilo1.join();
                variable = hilo1.getVariable();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            HiloServicio2 hilo2 = new HiloServicio2(semaphore, variable);
            hilo2.start();

            try {
                hilo2.join();
                variable = hilo2.getVariable();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
