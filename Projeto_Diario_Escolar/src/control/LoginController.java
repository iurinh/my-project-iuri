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

import model.Login;

@WebServlet("/LoginController")
public class LoginController extends HttpServlet{
	private static final long serialVersionUID = 2180050525992863862L;

	private Login login;
	private List<Login> lsLogin;
	
	private String cmd;
	private String msg;
	
	private RequestDispatcher rd;
	
	public LoginController() {
		login = new Login();
		lsLogin = new ArrayList<Login>();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		msg = "";
		cmd = req.getParameter("cmd");
		
		if("Limpar".equals(cmd)){
			msg = "Dados dos campos apagados.";
		} else if ("Acessar".equals(cmd)){
			verificarAcesso(req);
		}
		
		req.setAttribute("MSG", msg);
		rd = req.getRequestDispatcher("./login.jsp");
		rd.include(req, resp);
	}

	private void verificarAcesso(HttpServletRequest req) {
		login.setLogin(req.getParameter("txtLogin"));
		login.setSenha(req.getParameter("txtSenha"));
		
		
	}

}
