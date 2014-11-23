package entity;

public class Servico {
	     
    private Long idServico;
    private String nome;
    private String duracao;
    private double valor;
    private boolean generoServicoMasc;
    private boolean generoServicoFem;
	public Long getIdServico() {
		return idServico;
	}
	public void setIdServico(Long idServico) {
		this.idServico = idServico;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDuracao() {
		return duracao;
	}
	public void setDuracao(String duracao) {
		this.duracao = duracao;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public boolean isGeneroServicoMasc() {
		return generoServicoMasc;
	}
	public void setGeneroServicoMasc(boolean generoServicoMasc) {
		this.generoServicoMasc = generoServicoMasc;
	}
	public boolean isGeneroServicoFem() {
		return generoServicoFem;
	}
	public void setGeneroServicoFem(boolean generoServicoFem) {
		this.generoServicoFem = generoServicoFem;
	}
}
