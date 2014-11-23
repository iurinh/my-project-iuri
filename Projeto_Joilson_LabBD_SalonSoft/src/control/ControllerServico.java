package control;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AbstractDAO;
import dao.ServicoDAO;
import entity.Servico;

@WebServlet("/ControllerServico")
public class ControllerServico extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	private String cmd;
	private Servico servico;
	private RequestDispatcher rd;
	private AbstractDAO<Servico> daoServico;
	private String idServicoSelecionado;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Reiniciando Controller Servico");
		
		cmd = req.getParameter("cmd");
		idServicoSelecionado = req.getParameter("idServico");
		System.out.println(idServicoSelecionado);
		
		if("0".equalsIgnoreCase(idServicoSelecionado)){
			req.setAttribute("MSG", "Por favor, selecione um servico valido.");
			rd = req.getRequestDispatcher("./alterar_excluir_servico.jsp");
			rd.include(req, resp);
		} else if("LimparFormulario".equalsIgnoreCase(cmd)){
			rd = req.getRequestDispatcher("./novo_servico.jsp");
			rd.include(req, resp);
		} else if("Adicionar".equalsIgnoreCase(cmd)){
			servico = new Servico();
			
			servico.setNome(req.getParameter("txtNome"));
			servico.setValor(Double.parseDouble(req.getParameter("txtValor")));
			
			daoServico = new ServicoDAO();
			daoServico.insert(servico);
			
			req.setAttribute("MSG", "O servico foi inserido com sucesso");
			rd = req.getRequestDispatcher("./novo_servico.jsp");
			rd.include(req, resp);
		} else if("Pesquisar".endsWith(cmd)){
			Servico servicoSearch = searchById(idServicoSelecionado);
			
			if(servicoSearch == null){
				req.setAttribute("MSG", "Engracado, mas esse servico não possui mais dados no nosso banco...");
				System.out.println("Busca por servico retornou nulo");
			}
			else{
				servico = servicoSearch;
				System.out.println(servico.getNome() + " passou na memoria.");
				req.setAttribute("Servico", servico);
			}
			
			rd = req.getRequestDispatcher("./alterar_excluir_servico.jsp");
			rd.include(req, resp);
		} else if("Alterar".equalsIgnoreCase(cmd)){
			servico = new Servico();
			System.out.println(idServicoSelecionado);
			servico.setIdServico(Long.parseLong(idServicoSelecionado));
			servico.setNome(req.getParameter("txtNome"));
			servico.setValor(Double.parseDouble(req.getParameter("txtValor")));
			
			daoServico = new ServicoDAO();
			daoServico.update(servico);;
			
			req.setAttribute("MSG", "Servico alterado com sucesso!");
			rd = req.getRequestDispatcher("./alterar_excluir_servico.jsp");
			rd.include(req, resp);
		}  else if("Excluir".equalsIgnoreCase(cmd)){
			servico = new Servico();
			
			servico.setIdServico(Long.parseLong(idServicoSelecionado));
			servico.setNome(req.getParameter("txtNome"));
			servico.setValor(Double.parseDouble(req.getParameter("txtValor")));
			
			daoServico = new ServicoDAO();
			daoServico.delete(servico);;
			
			req.setAttribute("MSG", "Servico excluido com sucesso!");
			rd = req.getRequestDispatcher("./alterar_excluir_servico.jsp");
			rd.include(req, resp);
		}
	}
	
	public Servico getServicoVazio(){
		servico = new Servico();
		
		return servico;
	}
	
	public List<Servico> getListaServicos(){
		daoServico = new ServicoDAO();
		return daoServico.selectAll();
	}
	
	public Servico searchById(String value) {
		daoServico = new ServicoDAO();
		
		List<Servico> lsServicos = daoServico.selectAll();
		for(int i = 0; i < lsServicos.size(); i++){
			if(lsServicos.get(i).getIdServico() == Long.parseLong(value)){
				System.out.println("Encontrado" + i + " value " + value);
				return lsServicos.get(i);
			}
		}
		System.out.println("Nao encontrou ninguem com o searchById()");
		return null;
	}
}
