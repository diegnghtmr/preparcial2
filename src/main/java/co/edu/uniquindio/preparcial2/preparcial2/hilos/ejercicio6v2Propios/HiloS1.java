package co.edu.uniquindio.preparcial2.preparcial2.hilos.ejercicio6v2Propios;

public class HiloS1 extends Thread {
    public int resultado;

    @Override
    public void run() {
        resultado = sumaRecursiva(10);
    }

    private int sumaRecursiva(int n) {
        if (n == 0) {
            return 0;
        }
        return n + sumaRecursiva(n - 1);
    }
}
