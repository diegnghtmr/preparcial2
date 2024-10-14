package co.edu.uniquindio.preparcial2.preparcial2.hilos.ejercicio4;

public class HiloSumaRecursiva extends Thread {
    private int N;
    private int resultado;

    public HiloSumaRecursiva(int N) {
        this.N = N;
    }

    @Override
    public void run() {
        resultado = sumaRecursiva(N);
        //System.out.println(resultado);
    }

    private int sumaRecursiva(int n) {
        if (n == 1) {
            return 1;
        }
        return n + sumaRecursiva(n - 1);
    }

    public int getResultado() {
        return resultado;
    }
}
