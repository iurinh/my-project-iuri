package model.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;

@Entity
public class Presenca {
	
	@Id
	@GeneratedValue
	@Column(name="ID_PRESENCA")
	private long id;
	
	@Temporal(javax.persistence.TemporalType.DATE)
	@Column(nullable=false, name="DATA_PRESENCA")
	private Date dia;
	
	@Column(nullable=false)
	private boolean status;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getDia() {
		return dia;
	}

	public void setDia(Date dia) {
		this.dia = dia;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

}
