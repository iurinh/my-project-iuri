package entity;

public class Cliente {

	private Long id;
	private String nome;
	private String telefone;
	private String celular;
	private String email;

	public Cliente() {
		nome = "";
		telefone = "";
		celular = "";
		email = "";
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		System.out.println("Cliente setado: " + nome);
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		System.out.println(telefone);
		this.telefone = telefone;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
