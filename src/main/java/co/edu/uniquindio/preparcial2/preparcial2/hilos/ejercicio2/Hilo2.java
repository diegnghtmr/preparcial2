package co.edu.uniquindio.preparcial2.preparcial2.hilos.ejercicio2;

public class Hilo2 extends Thread{
    private int numero;

    public Hilo2(int numeroInicial) {
        this.numero = numeroInicial;
    }

    @Override
    public void run() {
        System.out.println("Iniciando el hilo.");
        try {
            for (int i = 0; i < 10; i++) {
                numero *= numero;
                System.out.println(numero);
                Thread.sleep(1500);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Hilo finalizado.");
    }

}
