package co.edu.uniquindio.preparcial2.preparcial2.hilos.ejercicio3;

public class Hilo3 extends Thread {
    public Hilo3(String nombre) {
        super(nombre);
    }

    @Override
    public void run() {
        System.out.println("Iniciando el hilo");
        try {
            for (int i = 0; i < 15; i++) {
                System.out.println(getName());
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Hilo finalizado");
    }
}
