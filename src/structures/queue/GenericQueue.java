package structures.queue;

public class GenericQueue<T> {

    private QueueNode<T> front;
    private QueueNode<T> rear;
    private int size;

    public GenericQueue() {
        front = null;
        rear = null;
        size = 0;
    }

    /**
     * Agrega un elemento al final de la cola.
     */
    public void enqueue(T data) {

        QueueNode<T> newNode = new QueueNode<>(data);

        if (isEmpty()) {
            front = newNode;
            rear = newNode;
        } else {
            rear.setNext(newNode);
            rear = newNode;
        }

        size++;
    }

    /**
     * Elimina y devuelve el primer elemento.
     */
    public T dequeue() {

        if (isEmpty()) {
            return null;
        }

        T data = front.getData();

        front = front.getNext();

        if (front == null) {
            rear = null;
        }

        size--;

        return data;
    }

    /**
     * Devuelve el primer elemento sin eliminarlo.
     */
    public T peek() {

        if (isEmpty()) {
            return null;
        }

        return front.getData();
    }

    /**
     * Indica si la cola está vacía.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Devuelve la cantidad de elementos.
     */
    public int size() {
        return size;
    }

    /*
    
    public void mostrar() {

        if (isEmpty()) {
            System.out.println("La cola está vacía.");
            return;
        }

        QueueNode<T> current = front;

        while (current != null) {
            System.out.println(current.getData());
            current = current.getNext();
        }
    }
    */
    
    @Override
    public String toString() {
        if (isEmpty()) {
            return "La cola está vacía.";
        }

        StringBuilder sb = new StringBuilder();
        QueueNode<T> current = front;

        while (current != null) {
            sb.append(current.getData()).append("\n");
            current = current.getNext();
        }

        return sb.toString();
    }
}