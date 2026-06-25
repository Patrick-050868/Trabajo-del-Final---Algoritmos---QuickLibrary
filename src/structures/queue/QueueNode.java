package structures.queue;

public class QueueNode<T> {
	private T dato;
	private QueueNode<T> next;
	
	public QueueNode(T _dato) {
		this.dato = _dato;
		this.next = null;
	}

	public T getDato() {
		return dato;
	}

	public void setDato(T dato) {
		this.dato = dato;
	}

	public QueueNode getNext() {
		return next;
	}

	public void setNext(QueueNode next) {
		this.next = next;
	}
	
	
}
