package entity;

import java.util.Date;

public class Agendamento {

	private int numAgendamento;

	private Date data;

	private String horario;

	private Cliente cliente;

	private Servico servico;

	private Funcionario funcionario;

	public Agendamento() {

	}

	public int getNumAgendamento() {
		return numAgendamento;
	}

	public void setNumAgendamento(int numAgendamento) {
		this.numAgendamento = numAgendamento;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Servico getServico() {
		return servico;
	}

	public void setServico(Servico servico) {
		this.servico = servico;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
}
