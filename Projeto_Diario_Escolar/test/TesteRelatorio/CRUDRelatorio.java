package TesteRelatorio;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import model.entity.Relatorio;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import control.ControllerRelatorio;
import dao.DAO;
import dao.DAOFactoryTableMySQL;
import dao.DAOImplementationRelatorio;

public class CRUDRelatorio {

	private DAO<Relatorio> dao = new DAOImplementationRelatorio();
	private Relatorio relatorio = new Relatorio();
	
	private EntityManager e;
	private EntityManagerFactory emf;
	private DAOFactoryTableMySQL factoryconnection = new DAOFactoryTableMySQL();
	
	@Before
	public void setUpBefore() throws Exception {
		relatorio.setDia("16/09/2090");
    	relatorio.setDescricao("Este registro é de teste....");
	}

	@After
	public void tearDownAfter() throws Exception {
		emf = factoryconnection.createConnection();
		e = emf.createEntityManager();
		e.getTransaction().begin();
		
		List<Relatorio> ls = e.createQuery("FROM ".concat(Relatorio.class.getName()).concat(" WHERE descricao = 'Este registro é de teste....'")).getResultList();
		ls.addAll(e.createQuery("FROM ".concat(Relatorio.class.getName()).concat(" WHERE descricao = 'Modificado'")).getResultList());
		
		for (Relatorio relatorio : ls) {
			System.out.println("ID: ".concat(relatorio.getId().toString().concat(" foi encontrado.")));
			e.remove(relatorio);
			System.out.println("ID: ".concat(relatorio.getId().toString().concat(" foi excluido.")));
		}
		
		e.getTransaction().commit();
		factoryconnection.closeConnection(emf);
	}

	@Test
	public void testeAdicionar() throws Exception {
		dao.adicionar(relatorio);
	}
	
	@Test
	public void testeRemover() throws Exception {
		dao.remover(relatorio);
	}
	
	@Test
	public void testeAlterar() throws Exception{
		dao.adicionar(relatorio);
		
		System.out.println("Relatorio original");
		System.out.println(relatorio.getId());
		System.out.println(relatorio.getDescricao());
		
		relatorio.setDescricao("Modificado");
		
		System.out.println("Relatorio modificado");
		System.out.println(relatorio.getId());
		System.out.println(relatorio.getDescricao());
		
		dao.alterar(relatorio);
	}
	
	@Test
	public void testeBuscarTodos() throws Exception{
		
		dao.adicionar(relatorio);
		
		for (Relatorio rel : dao.buscarTodos()) {
			System.out.println("REGISTRO ENCONTRADO");
			System.out.println(rel.getId());
			System.out.println(rel.getDescricao());
			System.out.println(rel.getDia());
			System.out.println();
		};
	}
	
	@Test
	public void testeBuscarTodosController() throws Exception {
		
		dao.adicionar(relatorio);
		
		for (Relatorio rel : new ControllerRelatorio().obterRelatorios()) {
			System.out.println("REGISTRO ENCONTRADO");
			System.out.println(rel.getId());
			System.out.println(rel.getDescricao());
			System.out.println(rel.getDia());
			System.out.println();
		};
	}
}
