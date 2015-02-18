package model.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Professor {
	
	@Id
	@GeneratedValue
	@Column(name="ID_PROFESSOR")
	private long id;

	@Column(nullable=false, name="REGISTRO_PROFESSOR")
	private long registro;
	
	@Column(nullable=false, name="NOME_PROFESSOR")
	private String nome;
	
	@Column(nullable=false)
	private String Disciplina;
	
	@OneToMany
	private List<Turma> lsTurma;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getRegistro() {
		return registro;
	}

	public void setRegistro(long registro) {
		this.registro = registro;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDisciplina() {
		return Disciplina;
	}

	public void setDisciplina(String disciplina) {
		Disciplina = disciplina;
	}

	public List<Turma> getLsTurma() {
		return lsTurma;
	}

	public void setLsTurma(List<Turma> lsTurma) {
		this.lsTurma = lsTurma;
	}

}
