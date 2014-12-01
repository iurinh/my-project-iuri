package entity;

public class Jogo {

	private int id;
	private String nome;
	private int nivel;
	
	public Jogo() {
		id = 0;
		nome = "";
		nivel = 0;
	}
	
	public long getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public long getNivel() {
		return nivel;
	}
	public void setNivel(int nivel) {
		this.nivel = nivel;
	}
	
	
}
