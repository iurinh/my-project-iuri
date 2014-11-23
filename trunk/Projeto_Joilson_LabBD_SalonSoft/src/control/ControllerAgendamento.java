package control;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AbstractDAO;
import dao.AgendamentoDAO;
import entity.Agendamento;
import entity.Cliente;
import entity.Funcionario;
import entity.Servico;

@WebServlet("/ControllerAgendamento")
public class ControllerAgendamento extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	private String cmd;
	private Agendamento agendamento;
	private RequestDispatcher rd;
	private AbstractDAO<Agendamento> daoAgendamento;
	
	private String idClienteSelecionado;
	private String idFuncionarioSelecionado;
	private String idServicoSelecionado;
	private String idAgendamentoSelecionado;
	
	private ControllerCliente ctrlCliente;
	private ControllerFuncionario ctrlFuncionario;
	private ControllerServico ctrlServico;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Reiniciando Controller Agendamento");
		
		cmd = req.getParameter("cmd");

		idAgendamentoSelecionado = req.getParameter("idAgendamento");
		idClienteSelecionado = req.getParameter("idCliente");
		idFuncionarioSelecionado = req.getParameter("idFuncionario");
		idServicoSelecionado = req.getParameter("idServico");

		try{
			if("0".equalsIgnoreCase(idClienteSelecionado) ||
					"0".equalsIgnoreCase(idFuncionarioSelecionado) ||
					"0".equalsIgnoreCase(idServicoSelecionado)){
				req.setAttribute("MSG", "Por favor, selecione todas as opcoes.");
				rd = req.getRequestDispatcher("./alterar_excluir_agendamento.jsp");
				rd.include(req, resp);
			} else if("LimparFormulario".equalsIgnoreCase(cmd)){
				rd = req.getRequestDispatcher("./novo_agendamento.jsp");
				rd.include(req, resp);
			} else if("Adicionar".equalsIgnoreCase(cmd)){
				agendamento = new Agendamento();

				agendamento.setData(new SimpleDateFormat("dd/MM/yyyy").parse(req.getParameter("txtData")));
				agendamento.setHorario(req.getParameter("txtHorario"));
				agendamento.setCliente(new ControllerCliente().searchById(idClienteSelecionado));
				agendamento.setFuncionario(new ControllerFuncionario().searchById(idFuncionarioSelecionado));
				agendamento.setServico(new ControllerServico().searchById(idServicoSelecionado));

				daoAgendamento = new AgendamentoDAO();
				daoAgendamento.insert(agendamento);

				req.setAttribute("MSG", "O agendamento foi inserido com sucesso");
				rd = req.getRequestDispatcher("./novo_agendamento.jsp");
				rd.include(req, resp);
			} else if("Pesquisar".endsWith(cmd)){
				Agendamento agendamentoSearch = searchById(idAgendamentoSelecionado);

				if(agendamentoSearch == null){
					req.setAttribute("MSG", "Engracado, mas esse agendamento não possui mais dados no nosso banco...");
					System.out.println("Busca por agendamento retornou nulo");
				}
				else{
					agendamento = agendamentoSearch;
					req.setAttribute("Agendamento", agendamento);
				}

				rd = req.getRequestDispatcher("./alterar_excluir_agendamento.jsp");
				rd.include(req, resp);
			} else if("Alterar".equalsIgnoreCase(cmd)){
				agendamento = new Agendamento();
				System.out.println(idAgendamentoSelecionado);
				agendamento.setNumAgendamento(Integer.parseInt(idAgendamentoSelecionado));
				agendamento.setData(new SimpleDateFormat("dd/MM/yyyy").parse(req.getParameter("txtData")));
				agendamento.setHorario(req.getParameter("txtHorario"));
				agendamento.setCliente(new ControllerCliente().searchById(idClienteSelecionado));
				agendamento.setFuncionario(new ControllerFuncionario().searchById(idFuncionarioSelecionado));
				agendamento.setServico(new ControllerServico().searchById(idServicoSelecionado));

				daoAgendamento = new AgendamentoDAO();
				daoAgendamento.update(agendamento);;

				req.setAttribute("MSG", "Agendamento alterado com sucesso!");
				rd = req.getRequestDispatcher("./alterar_excluir_agendamento.jsp");
				rd.include(req, resp);
			}  else if("Excluir".equalsIgnoreCase(cmd)){
				agendamento = new Agendamento();

				agendamento.setNumAgendamento(Integer.parseInt(idAgendamentoSelecionado));
				agendamento.setData(new SimpleDateFormat("dd/MM/yyyy").parse(req.getParameter("txtData")));
				agendamento.setHorario(req.getParameter("txtHorario"));
				agendamento.setCliente(new ControllerCliente().searchById(idClienteSelecionado));
				agendamento.setFuncionario(new ControllerFuncionario().searchById(idFuncionarioSelecionado));
				agendamento.setServico(new ControllerServico().searchById(idServicoSelecionado));

				daoAgendamento = new AgendamentoDAO();
				daoAgendamento.delete(agendamento);;

				req.setAttribute("MSG", "Agendamento excluido com sucesso!");
				rd = req.getRequestDispatcher("./alterar_excluir_agendamento.jsp");
				rd.include(req, resp);
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	public Agendamento getAgendamentoVazio(){
		agendamento = new Agendamento();
		
		return agendamento;
	}
	
	public List<Agendamento> getListaAgendamentos(){
		daoAgendamento = new AgendamentoDAO();
		return daoAgendamento.selectAll();
	}
	
	public List<Cliente> getListaClientes(){
		ctrlCliente = new ControllerCliente();
		return ctrlCliente.getListaClientes();
	}
	
	public List<Funcionario> getListaFuncionarios(){
		ctrlFuncionario = new ControllerFuncionario();
		return ctrlFuncionario.getListaFuncionarios();
	}
	
	public List<Servico> getListaServicos(){
		ctrlServico = new ControllerServico();
		return ctrlServico.getListaServicos();
	}
	
	public Agendamento searchById(String value) {
		daoAgendamento = new AgendamentoDAO();
		
		List<Agendamento> lsAgendamentos = daoAgendamento.selectAll();
		for(int i = 0; i < lsAgendamentos.size(); i++){
			if(lsAgendamentos.get(i).getNumAgendamento() == Integer.parseInt(value)){
				System.out.println("Encontrado" + i + " value " + value);
				return lsAgendamentos.get(i);
			}
		}
		System.out.println("Nao encontrou ninguem com o searchById()");
		return null;
	}
}
