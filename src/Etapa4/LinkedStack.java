package Etapa4;

public class LinkedStack<E> implements Stack<E>{
	private Node<E> top;// Aponta para a referência do último elemento inserido
	private int count;  // Conta quantos elementos há na pilha
	
	//não possui construtor, então quando instanciado um obejto da classe os atributos recebem valores padrão de acordo com os seus tipos; 
	public boolean isEmpty() {
		return top == null;
	}
	
	public boolean isFull() { //não aplicável a listas encadeadas - Pilhas encadeadas não "enchem" (limite é a memória do computador)
		return false;
	}
	
	public void push(Object element) {
		Node<E> newNode = new Node(element);
		newNode.setNext(top); // Novo nó aponta para o antigo topo
		top = newNode; // Atualiza topo
		count++;
	}
	
	public E pop() {
		if (isEmpty()) {
            throw new UnderflowException();
        }
		E elementoRetirado = top.getElement();
		top = top.getNext();
		count--; 
		return elementoRetirado;
	}
	
	public E top() {
		if (isEmpty()) {
            throw new UnderflowException();
        }
		return top.getElement();
	}
	
	public int numElements() {
		return count;
	}
}
