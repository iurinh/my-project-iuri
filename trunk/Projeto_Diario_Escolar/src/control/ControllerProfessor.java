package control;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.entity.Professor;
import dao.DAO;
import dao.DAOImplementationProfessor;

/**
 * Servlet implementation class ControllerProfessor
 */
@WebServlet("/ControllerProfessor")
public class ControllerProfessor extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private DAO dao;
	private String msg;
	private Professor professor;
	
    public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	/**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerProfessor() {
        dao = new DAOImplementationProfessor();
        msg = "";
        professor = new Professor();
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
    	rd = request.getRequestDispatcher("./viewProfessor.jsp");
		rd.include(request, response);
	}

	public List<Professor> obterProfessores() throws Exception{
		return dao.buscarTodos();
	}
}
