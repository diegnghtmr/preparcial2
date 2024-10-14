package co.edu.uniquindio.preparcial2.preparcial2.hilos.ejercicio6v2Propios;

public class ManejadorHilo {
    BoundedSemaphore semaphore = new BoundedSemaphore(1);

    public void ejecutarHilos() {
        HiloS1 t1 = new HiloS1();
        HiloS2 t2 = new HiloS2();
        HiloS3 t3 = new HiloS3();

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
            int d = t1.resultado * t2.resultado;

            // S5: Imprimir los resultados
            System.out.println("Valor de d (a * b): " + d);
            System.out.println("Cantidad de consonantes: " + t3.resultado);

            // Liberar el semáforo
            semaphore.liberar();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
