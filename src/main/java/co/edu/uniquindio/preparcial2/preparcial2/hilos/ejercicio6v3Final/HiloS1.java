package co.edu.uniquindio.preparcial2.preparcial2.hilos.ejercicio6v3Final;

public class HiloS1 extends Thread {
    private int resultado;

    @Override
    public void run() {
        resultado = sumaRecursiva(10);
    }

    public int getResultado() {
        return resultado;
    }

    private int sumaRecursiva(int n) {
        if (n == 1) {
            return 1;
        }
        return n + sumaRecursiva(n - 1);
    }
}
