package model.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Turma {

	@Id
	@GeneratedValue
	@Column(name="ID_TURMA")
	private long id;
	
	@Column(nullable=false)
	private long etapa; //o mesmo que série, ano, semestre etc
	
	@Column(nullable=false)
	private String grupo; //o mesmo que turma, letra, local etc
	
	@OneToMany
	private List<Relatorio> relatorio;
	
	@OneToMany
	private List<Aluno> lsAluno;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getEtapa() {
		return etapa;
	}

	public void setEtapa(long etapa) {
		this.etapa = etapa;
	}

	public String getGrupo() {
		return grupo;
	}

	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}

	public List<Relatorio> getRelatorio() {
		return relatorio;
	}

	public void setRelatorio(List<Relatorio> relatorio) {
		this.relatorio = relatorio;
	}

	public List<Aluno> getAluno() {
		return lsAluno;
	}

	public void setAluno(List<Aluno> lsAluno) {
		this.lsAluno = lsAluno;
	}

}
