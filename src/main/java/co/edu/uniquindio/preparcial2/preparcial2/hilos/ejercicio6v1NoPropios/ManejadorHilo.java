package co.edu.uniquindio.preparcial2.preparcial2.hilos.ejercicio6v1NoPropios;

public class ManejadorHilo {
    BoundedSemaphore semaphore = new BoundedSemaphore(1);

    public void ejecutarHilos() {
        HiloS1 hiloS1 = new HiloS1();
        HiloS2 hiloS2 = new HiloS2();
        HiloS3 hiloS3 = new HiloS3();

        Thread t1 = new Thread(hiloS1);
        Thread t2 = new Thread(hiloS2);
        Thread t3 = new Thread(hiloS3);

        // Iniciar los hilos
        t1.start();
        t2.start();
        t3.start();

        try {
            // Esperar a que todos los hilos terminen
            t1.join();
            t2.join();
            t3.join();

            // Utilizar el semáforo para asegurar la sincronización
            semaphore.ocupar();

            // S4: Calcular d = a * b
            int d = hiloS1.resultado * hiloS2.resultado;

            // S5: Imprimir los resultados
            System.out.println("Valor de d (a * b): " + d);
            System.out.println("Cantidad de consonantes: " + hiloS3.resultado);

            // Liberar el semáforo
            semaphore.liberar();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
