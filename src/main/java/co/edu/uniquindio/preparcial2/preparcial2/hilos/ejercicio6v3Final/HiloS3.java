package co.edu.uniquindio.preparcial2.preparcial2.hilos.ejercicio6v3Final;

public class HiloS3 extends Thread {
    private int resultado;

    @Override
    public void run() {
        String palabra = "Electroencefalografista";
        resultado = contarConsonantes(palabra);
    }

    public int getResultado() {
        return resultado;
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
