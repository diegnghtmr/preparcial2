package co.edu.uniquindio.preparcial2.preparcial2.hilos.ejercicio7;

public class T1 extends Thread {
    private int[][] matriz;
    private int maximo;

    public T1(int[][] matriz) {
        this.matriz = matriz;
        this.maximo = Integer.MIN_VALUE;
    }

    @Override
    public void run() {
        maximo = obtenerMayorRecursivo(matriz, 0, 0);
    }

    private int obtenerMayorRecursivo(int[][] matriz, int row, int col) {
        if (row >= matriz.length) {
            return maximo;
        }
        if (col >= matriz[row].length) {
            return obtenerMayorRecursivo(matriz, row + 1, 0);
        }
        if (matriz[row][col] > maximo) {
            maximo = matriz[row][col];
        }
        return obtenerMayorRecursivo(matriz, row, col + 1);
    }

    public int getMaximo() {
        return maximo;
    }
}