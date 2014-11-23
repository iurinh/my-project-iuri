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
import dao.ClienteDAO;
import entity.Cliente;

@WebServlet("/ControllerCliente")
public class ControllerCliente extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	private String cmd;
	private Cliente cliente;
	private RequestDispatcher rd;
	private AbstractDAO<Cliente> daoCliente;
	private String idClienteSelecionado;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Reiniciando Controller Cliente");
		
		cmd = req.getParameter("cmd");
		idClienteSelecionado = req.getParameter("idCliente");
		System.out.println(idClienteSelecionado);
		
		if("0".equalsIgnoreCase(idClienteSelecionado)){
			req.setAttribute("MSG", "Por favor, selecione um cliente valido.");
			rd = req.getRequestDispatcher("./alterar_excluir_cliente.jsp");
			rd.include(req, resp);
		} else if("LimparFormulario".equalsIgnoreCase(cmd)){
			rd = req.getRequestDispatcher("./novo_cliente.jsp");
			rd.include(req, resp);
		} else if("Adicionar".equalsIgnoreCase(cmd)){
			cliente = new Cliente();
			
			cliente.setNome(req.getParameter("txtNome"));
			cliente.setTelefone(req.getParameter("txtTelefone"));
			cliente.setCelular(req.getParameter("txtCelular"));
			cliente.setEmail(req.getParameter("txtEmail"));
			
			daoCliente = new ClienteDAO();
			daoCliente.insert(cliente);
			
			req.setAttribute("MSG", "O cliente foi inserido com sucesso");
			rd = req.getRequestDispatcher("./novo_cliente.jsp");
			rd.include(req, resp);
		} else if("Pesquisar".endsWith(cmd)){
			Cliente clienteSearch = searchById(idClienteSelecionado);
			
			if(clienteSearch == null){
				req.setAttribute("MSG", "Engracado, mas esse cliente não possui mais dados no nosso banco...");
				System.out.println("Busca por cliente retornou nulo");
			}
			else{
				cliente = clienteSearch;
				System.out.println(cliente.getNome() + " passou na memoria.");
				req.setAttribute("Cliente", cliente);
			}
			
			rd = req.getRequestDispatcher("./alterar_excluir_cliente.jsp");
			rd.include(req, resp);
		} else if("Alterar".equalsIgnoreCase(cmd)){
			cliente = new Cliente();
			System.out.println(idClienteSelecionado);
			cliente.setId(Long.parseLong(idClienteSelecionado));
			cliente.setNome(req.getParameter("txtNome"));
			cliente.setTelefone(req.getParameter("txtTelefone"));
			cliente.setCelular(req.getParameter("txtCelular"));
			cliente.setEmail(req.getParameter("txtEmail"));
			
			daoCliente = new ClienteDAO();
			daoCliente.update(cliente);;
			
			req.setAttribute("MSG", "Cliente alterado com sucesso!");
			rd = req.getRequestDispatcher("./alterar_excluir_cliente.jsp");
			rd.include(req, resp);
		}  else if("Excluir".equalsIgnoreCase(cmd)){
			cliente = new Cliente();
			
			cliente.setId(Long.parseLong(idClienteSelecionado));
			cliente.setNome(req.getParameter("txtNome"));
			cliente.setTelefone(req.getParameter("txtTelefone"));
			cliente.setCelular(req.getParameter("txtCelular"));
			cliente.setEmail(req.getParameter("txtEmail"));
			
			daoCliente = new ClienteDAO();
			daoCliente.delete(cliente);;
			
			req.setAttribute("MSG", "Cliente excluido com sucesso!");
			rd = req.getRequestDispatcher("./alterar_excluir_cliente.jsp");
			rd.include(req, resp);
		}
	}
	
	public Cliente getClienteVazio(){
		cliente = new Cliente();
		
		return cliente;
	}
	
	public List<Cliente> getListaClientes(){
		daoCliente = new ClienteDAO();
		return daoCliente.selectAll();
	}
	
	public Cliente searchById(String value) {
		daoCliente = new ClienteDAO();
		
		List<Cliente> lsClientes = daoCliente.selectAll();
		for(int i = 0; i < lsClientes.size(); i++){
			if(lsClientes.get(i).getId() == Long.parseLong(value)){
				System.out.println("Encontrado" + i + " value " + value);
				return lsClientes.get(i);
			}
		}
		System.out.println("Nao encontrou ninguem com o searchById()");
		return null;
	}
}
