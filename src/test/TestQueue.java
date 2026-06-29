package test;

import structures.queue.GenericQueue;

public class TestQueue {

    public static void main(String[] args) {

        GenericQueue<String> queue = new GenericQueue<>();

        System.out.println("==================================");
        System.out.println("      PRUEBA DE LA COLA");
        System.out.println("==================================");

        // Cola vacía
        System.out.println("\n¿La cola está vacía?");
        System.out.println(queue.isEmpty());

        // Enqueue
        System.out.println("\nAgregando elementos...");

        queue.enqueue("Solicitud 1");
        queue.enqueue("Solicitud 2");
        queue.enqueue("Solicitud 3");
        queue.enqueue("Solicitud 4");

        System.out.println("\nContenido de la cola:");
        System.out.println(queue);

        // Size
        System.out.println("Cantidad de elementos: " + queue.size());

        // Peek
        System.out.println("\nPrimer elemento:");
        System.out.println(queue.peek());

        // Dequeue
        System.out.println("\nEliminando el primer elemento...");
        System.out.println("Elemento eliminado: " + queue.dequeue());

        System.out.println("\nCola después del dequeue:");
        System.out.println(queue);

        System.out.println("Cantidad de elementos: " + queue.size());

        // Vaciar completamente
        System.out.println("\nVaciando la cola...");

        while (!queue.isEmpty()) {
            System.out.println("Se eliminó: " + queue.dequeue());
        }

        System.out.println("\nEstado final de la cola:");
        System.out.println(queue);

        System.out.println("¿La cola está vacía?");
        System.out.println(queue.isEmpty());

        System.out.println("Peek(): " + queue.peek());
        System.out.println("Dequeue(): " + queue.dequeue());

        System.out.println("\n========== FIN DE LA PRUEBA ==========");
    }
}