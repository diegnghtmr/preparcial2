package co.edu.uniquindio.preparcial2.preparcial2.hilos.ejercicio4;

public class Main {
    public static void main(String[] args) {
        int N = 10;
        String palabra = "otorrinolaringologia";

        HiloSumaRecursiva t1 = new HiloSumaRecursiva(N);
        HiloContarVocales t2 = new HiloContarVocales(palabra);

        t1.start();
        t2.start();

        try {
            // Esperar a que terminen los hilos t1 y t2 usando join
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        int resultado = t1.getResultado() * t2.getResultado();
        System.out.println(resultado);
    }
}
