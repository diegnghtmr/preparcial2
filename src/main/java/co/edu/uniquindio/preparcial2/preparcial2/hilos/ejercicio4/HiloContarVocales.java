package co.edu.uniquindio.preparcial2.preparcial2.hilos.ejercicio4;

public class HiloContarVocales extends Thread {
    private String palabra;
    private int resultado;

    public HiloContarVocales(String palabra) {
        this.palabra = palabra;
    }

    @Override
    public void run() {
        resultado = contarVocales(palabra);
        //System.out.println(resultado);
    }

    private int contarVocales(String palabra) {
        int count = 0;
        for (char c : palabra.toCharArray()) {
            if ("aeiouAEIOU".indexOf(c) != -1) {
                count++;
            }
        }
        return count;
    }

    public int getResultado() {
        return resultado;
    }
}