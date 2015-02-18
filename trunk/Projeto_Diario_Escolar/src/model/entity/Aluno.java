package model.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Aluno {
	
	@Id
	@GeneratedValue
	@Column(name="ID_ALUNO")
	private long id;
	
	@Column(nullable=false, unique=true, name="REGISTRO_ALUNO")
	private String registro;
	
	@Column(nullable=false, name="NOME_ALUNO")
	private String nome;
		
	@ManyToOne
	private Turma turma;
	
	@OneToMany
	private List<Presenca> lspresenca;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getRegistro() {
		return registro;
	}

	public void setRegistro(String registro) {
		this.registro = registro;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}

	public List<Presenca> getLspresenca() {
		return lspresenca;
	}

	public void setLspresenca(List<Presenca> lspresenca) {
		this.lspresenca = lspresenca;
	}

}
