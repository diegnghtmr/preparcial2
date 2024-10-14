package co.edu.uniquindio.preparcial2.preparcial2.hilos.ejercicio6v3Final;

public class HiloS2 extends Thread {
    private int resultado;

    @Override
    public void run() {
        resultado = factorial(6);
    }

    public int getResultado() {
        return resultado;
    }

    private int factorial(int n) {
        if (n == 0) {
            return 1;
        }
        return n * factorial(n - 1);
    }
}
