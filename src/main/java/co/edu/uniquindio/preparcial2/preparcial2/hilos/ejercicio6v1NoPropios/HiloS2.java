package co.edu.uniquindio.preparcial2.preparcial2.hilos.ejercicio6v1NoPropios;

public class HiloS2 implements Runnable {
    public int resultado;

    @Override
    public void run() {
        resultado = factorial(6);
    }

    private int factorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }
}