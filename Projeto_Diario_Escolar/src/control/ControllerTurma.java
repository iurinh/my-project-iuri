package control;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.entity.Turma;
import dao.DAO;
import dao.DAOImplementationTurma;

/**
 * Servlet implementation class ControllerTurma
 */
@WebServlet("/ControllerTurma")
public class ControllerTurma extends HttpServlet {
	private DAO dao;
	private String msg;
	private Turma turma;
	
    public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}

	/**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerTurma() {
        dao = new DAOImplementationTurma();
        msg = "";
        turma = new Turma();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			switch (request.getParameter("cmd")) {
			case "Adicionar":
				
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
    	rd = request.getRequestDispatcher("./viewTurma.jsp");
		rd.include(request, response);
	}

	public List<Turma> obterTurmaes() throws Exception{
		return dao.buscarTodos();
	}

}
