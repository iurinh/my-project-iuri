package control;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.entity.Relatorio;
import dao.DAO;
import dao.DAOFactoryTableMySQL;
import dao.DAOImplementationRelatorio;

/**
 * Servlet implementation class ControllerRelatorio
 */
@WebServlet("/ControllerRelatorio")
public class ControllerRelatorio extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private Relatorio relatorio;
	private DAO dao;
	private String msg;
	
	/**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerRelatorio() {
        super();
        relatorio = new Relatorio();
        dao = new DAOImplementationRelatorio();
        msg = "";
    }
    
    public Relatorio getRelatorio() {
		return relatorio;
	}

	public void setRelatorio(Relatorio relatorio) {
		this.relatorio = relatorio;
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
		try{
			switch (request.getParameter("cmd")) {
			case "Adicionar":
				adicionar(request,response);
				break;
			case "Alterar":

				break;
			case "Remover":

				break;
			default:
				break;
			}
		} catch(Exception e){
			msg = e.getMessage();
		}
		
    	RequestDispatcher rd;
    	rd = request.getRequestDispatcher("./viewRelatorio.jsp");
		rd.include(request, response);
	}

	private void adicionar(HttpServletRequest request, HttpServletResponse response) throws Exception {
		relatorio.setDescricao(request.getParameter("txtDescricao"));
		relatorio.setDia(request.getParameter("txtData"));
		dao.adicionar(relatorio);
	}

	public List<Relatorio> obterRelatorios() throws Exception{
		return dao.buscarTodos();
	}
}
