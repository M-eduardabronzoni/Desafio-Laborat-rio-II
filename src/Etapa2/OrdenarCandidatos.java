package Etapa2;


public class OrdenarCandidatos {
	
	public static void ordenaCandidatosPorNome(Candidato[] arrayCandidatos) { //Método Insertion Sort
		try {
		for (int i = 1; i<arrayCandidatos.length; i++) {
			int j = i-1; //usado para percorrer os elementos anteriores ao atual, ou seja, j indica a posição do candidato anterior
			Candidato candidatoAtual = arrayCandidatos[i];
			
				
			
			while (j >= 0 && arrayCandidatos[j].getNome().compareTo(candidatoAtual.getNome()) > 0){ //Retorna > 0 se nomeAtual vem depois de nomeProximo 
				arrayCandidatos[j+1] = arrayCandidatos[j];
				j--;
			}
			
			arrayCandidatos[j + 1] = candidatoAtual;
		} } catch (IllegalArgumentException e) {
			throw new IllegalArgumentException("Erro ao acessar o array passado como parâmetro", e);
		}
	}
	
	public static void ordenaCandidatosPorVotos(Candidato[] arrayCandidatos) { //Método Selection Sort 
		try {
		for (int i = 0; i < arrayCandidatos.length-1; i++) {
			int maximoIndice = i; // Encontraremos o índice do maior elemento
			
			for (int j = i+1; j < arrayCandidatos.length; j++) {
				if (arrayCandidatos[j].getIntencoesVotos() > arrayCandidatos[maximoIndice].getIntencoesVotos()) {
					maximoIndice = j;
				}
			}
			Candidato auxiliar = arrayCandidatos[i]; //evita perder o valor original de arrayCandidatos[i] durante a troca.
			arrayCandidatos[i] = arrayCandidatos[maximoIndice];
			arrayCandidatos[maximoIndice] = auxiliar;
		}} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException("Erro ao acessar o array passado como parâmetro", e);
		}
	}
	
	public static void ordenaCandidatosPorPartido(Candidato[] arrayCandidatos) {//Método Bubble Sort - o que possui o menor número de intenções de votos entre os nomes iguais será o último partido.
		try {
		for (int i=0; i < arrayCandidatos.length - 1; i++) {
			for (int j = i+1; j < arrayCandidatos.length; j++) {
				if (arrayCandidatos[i].getNome().equals(arrayCandidatos[j].getNome())) {
					if (arrayCandidatos[i].getIntencoesVotos() < arrayCandidatos[j].getIntencoesVotos());
						Candidato auxiliar2 = arrayCandidatos[i];
						arrayCandidatos[i] = arrayCandidatos[j];
						arrayCandidatos[j] = auxiliar2;
				}
				
            }
		}} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException("Erro ao acessar o array passado como parâmetro", e);
		}
			
	}
	
	public static int pesquisaBinariaCandidatos(Candidato[] arrayCandidatos, String nomeBuscado) {
		try {
            int inicio = 0;
            int fim = arrayCandidatos.length - 1;
            int resultado = -1; // Variável para armazenar o primeiro índice encontrado
            
            while (inicio <= fim) {
                int med = (inicio + fim) / 2;
                int comparacao = nomeBuscado.compareTo(arrayCandidatos[med].getNome());

                if (comparacao == 0) {
                    // Achou uma correspondência = nomes iguais!
                    resultado = med; 
                    // Continua buscando na metade esquerda para encontrar a primeira ocorrência
                    fim = med - 1; 
                } else if (comparacao < 0) {
                    // Nome buscado está antes
                    fim = med - 1; 
                } else { 
                    // Nome buscado está depois
                    inicio = med + 1; 
                }
            }
            return resultado;
		} catch (IllegalArgumentException e) {
		throw new IllegalArgumentException("Erro ao acessar o array passado como parâmetro", e);
		}
	}
	
	public static void imprimirRelatorio(Candidato[] arrayCandidatos) {
		
		String linhaSeparadora = "===========================================================================";
		
		System.out.println("\n\n" + linhaSeparadora);
		System.out.println("         RELATÓRIO DE VOTAÇÃO");
		System.out.println(linhaSeparadora);
		
		// Cabeçalho da Tabela
		System.out.printf("%-20s %-15s %s\n", "Nome", "Partido", "Intenções de Votos");
		System.out.println(linhaSeparadora);
		
		System.out.println("Candidatos ordenados por nome:\n");

		// Impressão dos dados
		for (int i = 0; i < arrayCandidatos.length; i++) {
			Candidato candidato = arrayCandidatos[i];
			System.out.printf("%-20s %-15s %d\n", candidato.getNome(), candidato.getPartido(), candidato.getIntencoesVotos());
		}
		
		System.out.println(linhaSeparadora);
		
		// --- Linhas de Resumo ---
		if (arrayCandidatos.length > 0) {
			Candidato primeiro = arrayCandidatos[0];
			Candidato ultimo = arrayCandidatos[arrayCandidatos.length - 1]; // Último elemento do array
			
			// Para simular a formatação exemplo do professor
			System.out.printf("Primeiro candidato: %-25s %-15s %d\n", primeiro.getNome(), primeiro.getPartido(), primeiro.getIntencoesVotos());
			System.out.printf("Último candidato: %-28s %-15s %d", ultimo.getNome(), ultimo.getPartido(), ultimo.getIntencoesVotos());
			System.out.print("[OK]\n"); 
		}
	}

}
