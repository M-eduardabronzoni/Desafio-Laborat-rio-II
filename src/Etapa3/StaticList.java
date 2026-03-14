package Etapa3;

public class StaticList<E> implements List<E>{
	private E[] elements;
	private int size; //número de elementos atual presentes na lista 
	
	public StaticList(int maxSize) {
	    // Criação segura do array genérico:
	    // O Java não permite new E[], então criamos um array de Object
	    // e fazemos o cast para E[], assumindo o controle sobre os tipos armazenados.
		this.elements = (E[])new Object[maxSize]; 
	}
	
	public void insert(E objetoInserir, int pos) { //imagino que os parametros sejam esses 
		if (isFull()) 
			throw new OverflowException();
		
		if (pos < 0 || pos > size)
			throw new IndexOutOfBoundsException("Posição inválida");
			
		for (int i = size-1; i >= pos; i--)
			elements[i+1] = elements[i];
		
		elements[pos] = objetoInserir;
		size++;
			
	}
	

	public int contaElementos (E el) {
		try {
			return contaElementosRecursivo(el, 0);
		}
		catch(Exception e) {
			throw new UnderflowException();
		}
	}
	
	private int contaElementosRecursivo(E el, int pos) throws UnderflowException {//recursivo - faz o tratamento da execeção e conta quantas vezes um determinado elemento aparece na lista
		int count = 0;
		
		if (pos == size) //caso base 
			return 0;
		if (elements[pos].equals(el))
			count++;
		return count + contaElementosRecursivo(el, pos+1);
	}
	
	public int numElements() {
		return size;
		
	}
	
	public boolean isEmpty() {
		if (size == 0)
			return true;
		else 
			return false;
		
	}
	
	public boolean isFull() {
		if (size == elements.length) {
			return true;
		}
		else
			return false;
	}
	
	public E get(int pos) {
		if (pos < 0 || pos >= size)
			throw new IndexOutOfBoundsException("Posição inválida");
		return elements[pos]; 
	}
	
	public E remove(int pos) {
		if (isEmpty())
			throw new UnderflowException();
		if (pos < 0 || pos >= size)
			throw new IndexOutOfBoundsException("Posição inválida");
			
		
		E objetoRemovido = elements[pos];
		for (int i=pos; i < size-1; i++) {
			elements[i] = elements[i+1];
		}
		
		elements[size-1] = null;
		size--;
		
		return objetoRemovido;
		
		
	}

	public int search(E element) {
		for (int i = 0; i < size; i++)
			if (element.equals(elements[i]))
				return i;
		
		// se chegar até aqui, é porque não encontrou
		return -1;
	}
	
}
