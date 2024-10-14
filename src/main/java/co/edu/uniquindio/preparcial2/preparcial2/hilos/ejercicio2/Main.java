package co.edu.uniquindio.preparcial2.preparcial2.hilos.ejercicio2;

public class Main {
    public static void main(String[] args) {
        Hilo2 hilo2 = new Hilo2(2);
        //? se desborda y comienza a dar 0
        // el enunciado pide un int, aunque un long no sirve mucho tampoco
        hilo2.start();
    }
}
