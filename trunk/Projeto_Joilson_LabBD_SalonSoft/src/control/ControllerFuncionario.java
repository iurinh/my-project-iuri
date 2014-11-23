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
import dao.FuncionarioDAO;
import entity.Funcionario;

@WebServlet("/ControllerFuncionario")
public class ControllerFuncionario extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	private String cmd;
	private Funcionario funcionario;
	private RequestDispatcher rd;
	private AbstractDAO<Funcionario> daoFuncionario;
	private String idFuncionarioSelecionado;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Reiniciando Controller Funcionario");
		
		cmd = req.getParameter("cmd");
		idFuncionarioSelecionado = req.getParameter("idFuncionario");
		System.out.println(idFuncionarioSelecionado);
		
		if("0".equalsIgnoreCase(idFuncionarioSelecionado)){
			req.setAttribute("MSG", "Por favor, selecione um funcionario valido.");
			rd = req.getRequestDispatcher("./alterar_excluir_funcionario.jsp");
			rd.include(req, resp);
		} else if("LimparFormulario".equalsIgnoreCase(cmd)){
			rd = req.getRequestDispatcher("./novo_funcionario.jsp");
			rd.include(req, resp);
		} else if("Adicionar".equalsIgnoreCase(cmd)){
			funcionario = new Funcionario();
			
			funcionario.setNome(req.getParameter("txtNome"));
			funcionario.setTelefone(req.getParameter("txtTelefone"));
			funcionario.setCelular(req.getParameter("txtCelular"));
			
			daoFuncionario = new FuncionarioDAO();
			daoFuncionario.insert(funcionario);
			
			req.setAttribute("MSG", "O funcionario foi inserido com sucesso");
			rd = req.getRequestDispatcher("./novo_funcionario.jsp");
			rd.include(req, resp);
		} else if("Pesquisar".endsWith(cmd)){
			Funcionario funcionarioSearch = searchById(idFuncionarioSelecionado);
			
			if(funcionarioSearch == null){
				req.setAttribute("MSG", "Engracado, mas esse funcionario não possui mais dados no nosso banco...");
				System.out.println("Busca por funcionario retornou nulo");
			}
			else{
				funcionario = funcionarioSearch;
				System.out.println(funcionario.getNome() + " passou na memoria.");
				req.setAttribute("Funcionario", funcionario);
			}
			
			rd = req.getRequestDispatcher("./alterar_excluir_funcionario.jsp");
			rd.include(req, resp);
		} else if("Alterar".equalsIgnoreCase(cmd)){
			funcionario = new Funcionario();
			System.out.println(idFuncionarioSelecionado);
			funcionario.setId(Long.parseLong(idFuncionarioSelecionado));
			funcionario.setNome(req.getParameter("txtNome"));
			funcionario.setTelefone(req.getParameter("txtTelefone"));
			funcionario.setCelular(req.getParameter("txtCelular"));
			
			daoFuncionario = new FuncionarioDAO();
			daoFuncionario.update(funcionario);;
			
			req.setAttribute("MSG", "Funcionario alterado com sucesso!");
			rd = req.getRequestDispatcher("./alterar_excluir_funcionario.jsp");
			rd.include(req, resp);
		}  else if("Excluir".equalsIgnoreCase(cmd)){
			funcionario = new Funcionario();
			
			funcionario.setId(Long.parseLong(idFuncionarioSelecionado));
			funcionario.setNome(req.getParameter("txtNome"));
			funcionario.setTelefone(req.getParameter("txtTelefone"));
			funcionario.setCelular(req.getParameter("txtCelular"));
			
			daoFuncionario = new FuncionarioDAO();
			daoFuncionario.delete(funcionario);;
			
			req.setAttribute("MSG", "Funcionario excluido com sucesso!");
			rd = req.getRequestDispatcher("./alterar_excluir_funcionario.jsp");
			rd.include(req, resp);
		}
	}
	
	public Funcionario getFuncionarioVazio(){
		funcionario = new Funcionario();
		
		return funcionario;
	}
	
	public List<Funcionario> getListaFuncionarios(){
		daoFuncionario = new FuncionarioDAO();
		return daoFuncionario.selectAll();
	}
	
	public Funcionario searchById(String value) {
		daoFuncionario = new FuncionarioDAO();
		
		List<Funcionario> lsFuncionarios = daoFuncionario.selectAll();
		for(int i = 0; i < lsFuncionarios.size(); i++){
			if(lsFuncionarios.get(i).getId() == Long.parseLong(value)){
				System.out.println("Encontrado" + i + " value " + value);
				return lsFuncionarios.get(i);
			}
		}
		System.out.println("Nao encontrou ninguem com o searchById()");
		return null;
	}
}
