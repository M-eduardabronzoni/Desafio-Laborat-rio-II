package Etapa2;
import java.util.Random;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.Scanner;
import java.io.IOException;

public class PrincipalCandidatos {

	public static void main(String[] args) {
		Random random = new Random();
		Scanner scanner = new Scanner(System.in);

		try {
		FileReader arquivo_nomes = new FileReader("C:\\Users\\bronz\\eclipse-workspace\\DesafioLabII\\src\\Etapa2\\nomes.txt");
		BufferedReader leitor_nomes = new BufferedReader(arquivo_nomes);
		
		FileReader arquivo_partidos = new FileReader("C:\\Users\\bronz\\eclipse-workspace\\DesafioLabII\\src\\Etapa2\\partidos.txt");
		BufferedReader leitor_partidos = new BufferedReader(arquivo_partidos);
		
		
		int numeroAleatorio = random.nextInt(100) + 1;
		Candidato[] arrayCandidatos = new Candidato[numeroAleatorio];
		
		
		
		for (int i = 0; i<arrayCandidatos.length; i++) {
			String nome = leitor_nomes.readLine();
			
			
			String partido = leitor_partidos.readLine();
			
			int intencoesVotos = random.nextInt(900);
			
			arrayCandidatos[i] = new Candidato(nome, partido, intencoesVotos);
			System.out.println(arrayCandidatos[i].toString());
		}
		
		leitor_nomes.close();
		leitor_partidos.close();
	
		OrdenarCandidatos.ordenaCandidatosPorPartido(arrayCandidatos);
		OrdenarCandidatos.ordenaCandidatosPorVotos(arrayCandidatos);
		OrdenarCandidatos.ordenaCandidatosPorNome(arrayCandidatos);
		
		OrdenarCandidatos.imprimirRelatorio(arrayCandidatos);
		
		System.out.println("\nDigite o nome do candidato que deseja pesquisar:");
        String nomeBuscado = scanner.nextLine();
		
		
		int posicao = OrdenarCandidatos.pesquisaBinariaCandidatos(arrayCandidatos, nomeBuscado);
		
		if (posicao != -1) {
		    // Passo 1: Encontrou um índice, agora volta para o primeiro
			int i = posicao;
		    // Passo 2: Imprime todos os registros com o nome buscado
		    System.out.println("Candidatos encontrados para '" + nomeBuscado + "':");
		    while (i < arrayCandidatos.length && 
		           arrayCandidatos[i].getNome().equals(nomeBuscado)) {
		        System.out.println(arrayCandidatos[i].toString());
		        i++;
		    }

		} else {
		    System.out.println("Candidato não encontrado.");
		}
		} catch (IOException e) {
            // Trata erros de arquivo (não encontrado, erro de leitura, etc.)
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
            e.printStackTrace();
        }
		 scanner.close();
	}
	
}
