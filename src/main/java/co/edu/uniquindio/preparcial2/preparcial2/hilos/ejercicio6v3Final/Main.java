package co.edu.uniquindio.preparcial2.preparcial2.hilos.ejercicio6v3Final;

public class Main {
    public static void main(String[] args) {
        // Crear instancias de los hilos propios
        HiloS1 hiloS1 = new HiloS1();
        HiloS2 hiloS2 = new HiloS2();
        HiloS3 hiloS3 = new HiloS3();

        // Iniciar los hilos
        hiloS1.start();
        hiloS2.start();
        hiloS3.start();

        // Esperar a que los hilos terminen
        try {
            hiloS1.join();
            hiloS2.join();
            hiloS3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Realizar las operaciones S4 y S5
        int a = hiloS1.getResultado();
        int b = hiloS2.getResultado();
        int c = hiloS3.getResultado();

        int d = a * b; // S4: d = a * b

        // S5: Imprimir resultados
        System.out.println("El valor de d (a * b) es: " + d);
        System.out.println("La cantidad de consonantes es: " + c);
    }

    /* No propios: se debe implementar la interfaz Runnable en las clases HiloS1, HiloS2 y HiloS3
    y crear instancias de los hilos propios para iniciarlos con la clase Thread. A diferencia de los propios,
    los hilos no propios no se pueden iniciar directamente con el método start() de la clase Thread.

        --- Crear instancias de los hilos ---
        HiloS1 hiloS1 = new HiloS1();
        HiloS2 hiloS2 = new HiloS2();
        HiloS3 hiloS3 = new HiloS3();

        --- Iniciar los hilos ---
        Thread t1 = new Thread(hiloS1);
        Thread t2 = new Thread(hiloS2);
        Thread t3 = new Thread(hiloS3);
     */
}
