package Etapa3;

public class Etapa3 {
	public boolean checkBrackets(Stack s1) {
		  // Pilha temporária para inverter a pilha original
        Stack<Character> temp = new StaticStack<>(s1.numElements());
        Stack<Character> aux = new StaticStack<>(s1.numElements()); // pilha para verificar os parênteses

        int tamanho = s1.numElements();

        // 1️⃣ Inverte a pilha original para ler na ordem correta (primeiro inserido → primeiro lido)
        for (int i = 0; i < tamanho; i++) {
            temp.push((char) s1.pop());
        }

        // 2️⃣ Agora percorremos a pilha invertida na ordem correta
        for (int i = 0; i < tamanho; i++) {
            char c = (char) temp.pop();

            if (c == '(') {
                aux.push(c); // guarda o "("
            } 
            else if (c == ')') {
                if (aux.isEmpty()) {
                    return false; // existe um ")" sem um "(" antes, aux está vazia ainda.
                }
                aux.pop(); // encontrou o par "()", remove
            }
        }

        // expressão correta somente se a pilha auxiliar estiver vazia
        return aux.isEmpty();
	}
}
