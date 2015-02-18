package model.entity;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;

@Entity
public class Relatorio {

	@Id
	@GeneratedValue
	@Column(name="ID_RELATORIO")
	private Long id;
	
	@Temporal(javax.persistence.TemporalType.DATE)
	@Column(nullable=false, name="DATA_RELATORIO")
	private Date dia;
	
	@Column
	private String descricao;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDia() {
		return dia;
	}

	public void setDia(Date dia) {
		this.dia = dia;
	}
	
	public void setDia(String dia) throws Exception {
		DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			this.dia = sdf.parse(dia);
		} catch (ParseException e) {
			e.printStackTrace();
			throw new Exception("Houve um erro ao mudar o tipo da data de texto para 'DATE' na entidade RELATORIO");
		}
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	

}
