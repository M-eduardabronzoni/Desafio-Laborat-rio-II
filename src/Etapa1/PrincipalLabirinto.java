package Etapa1;


public class PrincipalLabirinto {

	public static void main(String[] args) {
		        Labirinto lab = new Labirinto();
		        lab.criaLabirinto("C:\\Users\\bronz\\eclipse-workspace\\DesafioLabII\\src\\Etapa1\\labirinto.txt"); // 1️⃣ monta o array
		        System.out.println("Labirinto inicial:");
			    lab.imprimeLabirinto();   // 2️⃣ mostra o original

			    if (lab.percorreLabirinto()){// 3️⃣ executa o algoritmo recursivo
			    	System.out.println("Solução encontrada");
			    }
			    else {
			    	System.out.println("Labirinto sem solução");
			    }
			    
			    lab.preencheNaoVisitados();
			    
			    System.out.println("\nLabirinto final:");
			    lab.imprimeLabirinto();   // 4️⃣ mostra o resultado
	}}