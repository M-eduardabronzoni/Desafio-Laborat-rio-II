package Etapa2;

public class Candidato {
	private String nome; //nome completo do candidato
	private String partido; 
	private int intencoesVotos; //representa a quantidade de intenções de voto obtidas na pesquisa
	
	public Candidato(String nome, String partido, int intencoesVotos) { //Construtor - inicializa todos os atributos
		this.nome = nome;
		this.partido = partido; 
		this.intencoesVotos = intencoesVotos;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPartido() {
		return partido;
	}

	public void setPartido(String partido) {
		this.partido = partido;
	}

	public int getIntencoesVotos() {
		return intencoesVotos;
	}

	public void setIntencoesVotos(int intecoesVotos) {
		this.intencoesVotos = intecoesVotos;
	}

	@Override
	public String toString() {
		return "Informações sobre o Candidato - \nNome=" + nome + "\nPartido=" + partido + "\nIntenções de Votos=" + intencoesVotos;
	}
	
	

	
}
