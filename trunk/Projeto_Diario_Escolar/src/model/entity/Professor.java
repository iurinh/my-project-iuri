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
	private Long id;

	@Column(nullable=false, name="REGISTRO_PROFESSOR")
	private Long registro;
	
	@Column(nullable=false, name="NOME_PROFESSOR")
	private String nome;
	
	@Column(nullable=false)
	private String Disciplina;
	
	@OneToMany
	private List<Turma> lsTurma;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getRegistro() {
		return registro;
	}

	public void setRegistro(Long registro) {
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
