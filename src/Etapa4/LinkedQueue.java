package Etapa4;

public class LinkedQueue<E> implements Queue<E>{//faz a implementação dos métodos da interface Queue(fila)
	private Node<E> front; //ponteiro para o inicio da fila
	private Node<E> rear; //ponteiro para o final da fila 
	private int size;
	
	
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public boolean isFull() {//não aplicável a listas encadeadas - Filas encadeadas não "enchem" (limite é a memória do computador)
		return false;
	}
	
	public void enqueue(Object element) {
		Node<E> newNode = new Node(element);
		if (isEmpty()) {
			front = newNode;
			rear = newNode;
		}
		else {
			rear.setNext(newNode); // O antigo fim aponta para o novo nó
	        rear = newNode;  
		}
		
		size++;
		
	}
	
	public E dequeue() {
		 if (isEmpty()) {
	            throw new UnderflowException();
		 }
		 E elementoRemovido = front.getElement();
		 front = front.getNext();
		 if (front == null) { 
	            rear = null;
	        }
	        size--;
	        return elementoRemovido;
	}
	
	public E first() {
		if (isEmpty()) {
            throw new UnderflowException();
        }
		return front.getElement();
	}
		
	
	public E front() {
		if (isEmpty()) {
            throw new UnderflowException();
        }
		return front.getElement();
	}
		
	
	public E back() {
		if (isEmpty()) {
            throw new UnderflowException();
        }
		return rear.getElement();
	}
	
	public int numElements() {
		return size;
	}
}
