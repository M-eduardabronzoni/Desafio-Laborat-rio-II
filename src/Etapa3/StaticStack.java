package Etapa3;

public class StaticStack<E> implements Stack<E> {
	private int top;//topo da pilha (indice do último elemento inserido).
	private E[] elements;
	
	public StaticStack(int maxSize) { //inicializa a pilha elements que também necessita de um cast, 
		//para que o tipo Object (genético) seja tratado como E, como definido na interface. 
		this.elements = (E[]) new Object[maxSize];
		this.top = -1;
	}
	
	public boolean isEmpty() {
		//ou: top < 0;
		return top == -1;
	}
	
	public boolean isFull() {
		return top == elements.length -1; //quanto top for igual ao último valor de índice.
	}
	
	public int numElements() {
		//quando queremos o ultimo indice fazemos o tamanho do array/pilha
		//-1; neste caso fazemos ao contrário, agora temos o último indice (top) e queremos o tamanho, logo, top + 1;
			
		return top + 1; 
	}
	
	public void push(E objetoInserir) {
		if(isFull()) {
			throw new OverflowException();
		}
		
		elements[++top] = objetoInserir;
	}
	
	public E pop() { //retorna o elemento retirado da pilha 
		if (isEmpty())
			throw new UnderflowException();
		E elementoRetirado = elements[top];
		elements[top--] = null; //remove e decrementa o topo;
		return elementoRetirado;
	}
	
	public E top() {//retorna o elemento do topo da pilha
		if (isEmpty())
			throw new UnderflowException();
		return elements[top];
	}
	
	public String toString() {
		if (isEmpty())
			return "[Empty]";
		else {
			String printPilha = "[";
			for (int i = numElements() - 1; i >= 0; i--) {
				printPilha += "\n" + elements[i];
			}
			printPilha += "\n]";
			return printPilha;
		}
	}
	
	
}
