package co.edu.uniquindio.preparcial2.preparcial2.hilos.ejercicio7;

public class T2 extends Thread {
    private int[][] matriz;
    private double promedio;

    public T2(int[][] matriz) {
        this.matriz = matriz;
        this.promedio = 0.0;
    }

    @Override
    public void run() {
        int sum = 0;
        for (int i = 0; i < matriz.length; i++) {
            sum += matriz[i][i];
        }
        promedio = (double) sum / matriz.length;
    }

    public double getPromedio() {
        return promedio;
    }
}