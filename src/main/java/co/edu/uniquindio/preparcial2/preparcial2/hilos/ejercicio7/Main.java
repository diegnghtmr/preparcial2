package co.edu.uniquindio.preparcial2.preparcial2.hilos.ejercicio7;

public class Main {
    public static void main(String[] args) {
        int[][] matriz = {
                {60, 22, 41, 5},
                {13, 33, 44, 5},
                {89, 10, 100, 99},
                {5, 101, 6, 34}
        };

        T1 t1 = new T1(matriz);
        T2 t2 = new T2(matriz);

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        int a = t1.getMaximo();
        double b = t2.getPromedio();
        double c = a * b;

        System.out.println("El valor de c es: " + c);
    }
}