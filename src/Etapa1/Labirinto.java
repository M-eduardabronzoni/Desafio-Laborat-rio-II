package Etapa1;

import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.BufferedReader;

public class Labirinto {
	public static final char PAREDE = 'X';
	public static final char CAMINHO_ABERTO = ' ';
	public static final char SAIDA = 'D';
	public static final char CAMINHO_SOLUCAO = '#';
	private char[][] labirinto;
	
	

	/*instanciar o array preenchendo- o com o conteúdo recebido da estrutura do labirinto de um arquivo de texto.*/
	public void criaLabirinto(String filename) {
	    try {
	        FileReader arquivo = new FileReader(filename);
	        BufferedReader leitor = new BufferedReader(arquivo);

	        String linha;
	        int numLinhas = 0;
	        int numColunas = 0;

	        // Determinar o número de linhas e colunas do labirinto
	        while ((linha = leitor.readLine()) != null) {
	            String[] partes = linha.split("\t", -1); // separa pelos TABs
	            numLinhas++;
	            if (partes.length > numColunas) {
	                numColunas = partes.length;
	            }
	        }
	        leitor.close();

	        // Inicializar o labirinto com o tamanho apropriado
	        this.labirinto = new char[numLinhas][numColunas];

	        // Preencher o labirinto com os dados do arquivo
	        leitor = new BufferedReader(new FileReader(filename));
	        String line;
	        int i = 0;

	        while ((line = leitor.readLine()) != null) {
	            String[] partes = line.split("\t", -1);

	            for (int j = 0; j < partes.length; j++) {
	                if (partes[j].equals("")) {
	                    labirinto[i][j] = ' ';
	                } else {
	                    labirinto[i][j] = partes[j].charAt(0);
	                }
	            }

	            // Preencher colunas restantes com espaços
	            for (int j = partes.length; j < numColunas; j++) {
	                labirinto[i][j] = ' ';
	            }

	            i++;
	        }

	        leitor.close();

	    } catch (FileNotFoundException e) {
	        System.err.println("Erro: arquivo não encontrado -> " + filename);
	        throw new IllegalArgumentException("Arquivo não encontrado: " + filename, e);
	    } catch (IOException e) {
	        System.err.println("Erro ao ler o arquivo: " + e.getMessage());
	        throw new IllegalArgumentException("Erro de leitura no arquivo: " + filename, e);
	    } catch (IndexOutOfBoundsException e) {
	        System.err.println("Erro: índice fora dos limites do array.");
	        throw new IllegalArgumentException("Formato inválido do arquivo", e);
	    } catch (Exception e) {
	        System.err.println("Erro inesperado ao criar o labirinto: " + e.getMessage());
	        throw new IllegalArgumentException("Erro inesperado ao processar labirinto", e);
	    }
	}
	
	public boolean percorreLabirinto() {
		return resolverLabirinto(0, 0);
	}	
	
	public void imprimeLabirinto() {
		    for (int i = 0; i < labirinto.length; i++) {
		        for (int j = 0; j < labirinto[i].length; j++) {
		            System.out.print(labirinto[i][j] + "\t"); // usa TAB pra deixar espaçado
		        }
		        System.out.println();
		    }
		}

		
	public boolean resolverLabirinto(int x, int y) {
		
	    // Verifica se está fora dos limites
	    if (x < 0 || y < 0 || x >= labirinto.length || y >= labirinto[0].length) {
	        return false;
	    }

	    // Se for parede, ponto visitado ou já marcado como caminho
	    if (labirinto[x][y] == 'X' || labirinto[x][y] == '.' || labirinto[x][y] == '#') {
	        return false;
	    }

	    // Se encontrou o destino
	    if (labirinto[x][y] == 'D') {
	    	
	        return true;
	    }

	    // Só entra se for um espaço vazio
	    if (labirinto[x][y] == ' ');
	    // Marca temporariamente como visitado (tentativa)
	    labirinto[x][y] = '.';
	    
	    System.out.println("Visitando posição [" + x + "][" + y + "]");

	    // Tenta mover nas 4 direções
	    	if (resolverLabirinto(x - 1, y) || // cima
	        resolverLabirinto(x + 1, y) || // baixo
	        resolverLabirinto(x, y - 1) || // esquerda
	        resolverLabirinto(x, y + 1)) { // direita
	        
	        // Parte da solução → marca como caminho verdadeiro
	        labirinto[x][y] = '#';
	        return true;
	    }

	    // Se não deu certo, volta — mantém como '.' para mostrar tentativa
	    return false;
	}
	
	public void preencheNaoVisitados() {
		// Preenche com '.' os espaços não visitados
	    for (int i = 0; i < labirinto.length; i++) {
	        for (int j = 0; j < labirinto[i].length; j++) {
	            if (labirinto[i][j] == ' ') {
	                labirinto[i][j] = '.';
	            }
	        }
	    }
	}
}
