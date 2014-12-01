package control;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.JogoDAO;
import dao.JogoDAOImp;
import entity.Jogo;

@WebServlet("/JogosController")
public class JogosController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	private Jogo jogo;
	private JogoDAO jogoDAO;
	private List<Jogo> lsJogo;
	private RequestDispatcher rd;
	
	private String cmd;
	
	private String message;
	
	public JogosController() throws SQLException, ServletException, IOException {
		jogo = new Jogo();
		jogoDAO = new JogoDAOImp();
		lsJogo = new ArrayList<>();
	}

	public String getMessage(){
		return message;
	}
	
	public List<Jogo> getListaJogo() throws SQLException{
		lsJogo = jogoDAO.buscarTodos();
		return lsJogo;
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		message = "";
		
		cmd = req.getParameter("cmd");
		System.out.println("Botao " + cmd + " selecionado.");
		
		String regex = "[\\d]+";
		
		try{
			if("Incluir".equals(cmd)){
				jogo.setNome(req.getParameter("txtNome"));
				if(req.getParameter("txtNivel").matches(regex)){
					jogo.setNivel(Integer.parseInt(req.getParameter("txtNivel")));
					jogoDAO.inserir(jogo);
					message = "Incluir Realizado!";
				} else
					message = "Insira somente numeros naturais no nivel do jogo!";
			} else if("Pesquisar".equals(cmd)){
				System.out.println("Buscando ID: " + req.getParameter("ComboBoxJogos"));
				int idSelecionado = Integer.parseInt(req.getParameter("ComboBoxJogos"));

				buscaId(idSelecionado);

				req.setAttribute("Jogo", jogo);
				req.setAttribute("ListaJogo", getListaJogo());
				
				if("0".equals(idSelecionado))
					message = "Selecione algum jogo";
				else if(jogo == null)
					message = "Nao sei como, mas encontramos um jogo nulo...";
				else
					message = "Pesquisar Realizado!";
			} else if("Atualizar".equals(cmd)){
				jogo.setNome(req.getParameter("txtNome"));
				jogo.setNivel(Integer.parseInt(req.getParameter("txtNivel")));
				jogoDAO.atualizar(jogo);
				message = "Atualizar Realizado!";
			} else if("Deletar".equals(cmd)){
				jogoDAO.remover(Integer.parseInt(req.getParameter("ComboBoxJogos")));
				message = "Deletar Realizado!";
			} else if("Limpar".equals("cmd")){
				message = "Campos limpos agora...";
			}
		} catch (SQLException e){
			System.out.println("Verifique o erro!");
			throw new IOException(e.getMessage());
		}
		
		req.setAttribute("MSG", getMessage());
		rd = req.getRequestDispatcher("./jogo.jsp");
		rd.include(req, resp);
	}

	private void buscaId(int idSelecionado) {
		for(int i = 0; i < lsJogo.size(); i++)
			if(idSelecionado == lsJogo.get(i).getId())
				jogo = lsJogo.get(i);
	}
}
