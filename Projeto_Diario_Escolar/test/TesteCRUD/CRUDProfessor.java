package TesteCRUD;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import model.entity.Professor;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import control.ControllerProfessor;
import dao.DAO;
import dao.DAOFactoryTableMySQL;
import dao.DAOImplementationProfessor;

public class CRUDProfessor {

	private DAO<Professor> dao = new DAOImplementationProfessor();
	private Professor professor = new Professor();
	
	private EntityManager e;
	private EntityManagerFactory emf;
	private DAOFactoryTableMySQL factoryconnection = new DAOFactoryTableMySQL();
	
	@Before
	public void setUpBefore() throws Exception {
		professor.setDisciplina("Matemática");
		professor.setNome("Einstein");
		professor.setRegistro(112233L);
	}

	@After
	public void tearDownAfter() throws Exception {
		emf = factoryconnection.createConnection();
		e = emf.createEntityManager();
		e.getTransaction().begin();
		
		List<Professor> ls = e.createQuery("FROM ".concat(Professor.class.getName()).concat(" WHERE Disciplina = 'Matemática'")).getResultList();
		ls.addAll(e.createQuery("FROM ".concat(Professor.class.getName()).concat(" WHERE NOME_PROFESSOR = 'Albert Einstein'")).getResultList());
		
		for (Professor professor : ls) {
			System.out.println("ID: ".concat(professor.getId().toString().concat(" foi encontrado.")));
			e.remove(professor);
			System.out.println("ID: ".concat(professor.getId().toString().concat(" foi excluido.")));
		}
		
		e.getTransaction().commit();
		factoryconnection.closeConnection(emf);
	}

	@Test
	public void testeAdicionar() throws Exception {
		dao.adicionar(professor);
	}
	
	@Test
	public void testeRemover() throws Exception {
		dao.remover(professor);
	}
	
	@Test
	public void testeAlterar() throws Exception{
		dao.adicionar(professor);
		
		System.out.println("Professor original");
		System.out.println(professor.getId());
		System.out.println(professor.getNome());
		System.out.println(professor.getRegistro());
		
		professor.setNome("Albert Einstein");;
		
		System.out.println("Professor modificado");
		System.out.println(professor.getId());
		System.out.println(professor.getNome());
		System.out.println(professor.getRegistro());
		
		dao.alterar(professor);
	}
	
	@Test
	public void testeBuscarTodos() throws Exception{
		
		dao.adicionar(professor);
		
		for (Professor prof : dao.buscarTodos()) {
			System.out.println("REGISTRO ENCONTRADO");
			System.out.println(prof.getId());
			System.out.println(prof.getNome());
			System.out.println(prof.getRegistro());
			System.out.println();
		};
	}
	
	@Test
	public void testeBuscarTodosController() throws Exception {
		
		dao.adicionar(professor);
		
		for (Professor prof : new ControllerProfessor().obterProfessores()) {
			System.out.println("REGISTRO ENCONTRADO");
			System.out.println(prof.getId());
			System.out.println(prof.getNome());
			System.out.println(prof.getRegistro());
			System.out.println();
		};
	}

}
