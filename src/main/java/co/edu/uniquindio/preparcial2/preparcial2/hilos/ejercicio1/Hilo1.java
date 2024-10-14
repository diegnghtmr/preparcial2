package co.edu.uniquindio.preparcial2.preparcial2.hilos.ejercicio1;

import java.time.Duration;

public class Hilo1 extends Thread{
    private int[] arreglo;

    public Hilo1(int tamanio) {
        this.arreglo = new int[tamanio];
        for (int i = 0; i < tamanio; i++) {
            arreglo[i] = i + 1;
        }
    }

    @Override
    public void run() {
        System.out.println("Iniciando el hilo.");
        try {
            for (int j : arreglo) {
                System.out.println(j);
                Thread.sleep(Duration.ofSeconds(1)); // Espera de 1 segundo entre cada impresión
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Hilo finalizado.");
    }
}
