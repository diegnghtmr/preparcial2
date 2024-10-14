package co.edu.uniquindio.preparcial2.preparcial2.hilos.ejercicio6v1NoPropios;

public class HiloS3 implements Runnable {
    public int resultado;

    @Override
    public void run() {
        resultado = contarConsonantes("Electroencefalografista");
    }

    private int contarConsonantes(String palabra) {
        int contador = 0;
        String consonantes = "bcdfghjklmnpqrstvwxyzBCDFGHJKLMNPQRSTVWXYZ";
        for (char c : palabra.toCharArray()) {
            if (consonantes.indexOf(c) != -1) {
                contador++;
            }
        }
        return contador;
    }
}
