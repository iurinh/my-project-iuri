package control;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAO;
import dao.LoginDAOMySQL;
import model.Login;

@WebServlet("/LoginController")
public class LoginController extends HttpServlet{
	private static final long serialVersionUID = 2180050525992863862L;

	private Login login;
	private List<Login> lsLogin;

	private DAO<Login> dao;
	
	private String cmd;
	private String msg;
	private String pagina;
	
	private RequestDispatcher rd;
	
	public LoginController() {
		login = new Login();
		lsLogin = new ArrayList<Login>();
		
		dao = new LoginDAOMySQL();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		msg = "";
		cmd = req.getParameter("cmd");
		pagina = "./login.jsp";
		if("Limpar".equals(cmd)){
			msg = "Dados dos campos apagados.";
		} else if ("Acessar".equals(cmd)){
			try {
				boolean validaLogin = verificarAcesso(req);
				if( validaLogin ){
					msg = "Não encontramos seu login de acesso!";
					req.setAttribute("MSG", msg);
					pagina = "./index.jsp";
				} else 
					msg = "Sucesso! Seu login existe.";
					
			} catch (Exception e) {
				e.printStackTrace();
				msg = e.getMessage();
			}
		} else if ("Adicionar".equals(cmd)){
			login.setLogin(req.getParameter("txtLogin"));
			login.setSenha(req.getParameter("txtSenha"));
			login.setTipoAcesso(req.getParameter("cbAcesso"));
			try {
				dao.adicionar(login);
			} catch (Exception e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
		}
		
		req.setAttribute("MSG", msg);
		rd = req.getRequestDispatcher(pagina);
		rd.include(req, resp);
	}

	private boolean verificarAcesso(HttpServletRequest req) throws Exception {
		login.setLogin(req.getParameter("txtLogin"));
		login.setSenha(req.getParameter("txtSenha"));
		
		lsLogin = dao.buscarTodos(login);
		
		return lsLogin.size() != 1;
	}
}
