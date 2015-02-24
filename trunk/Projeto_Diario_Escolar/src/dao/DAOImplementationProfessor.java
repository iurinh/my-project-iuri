package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import model.entity.Professor;

public class DAOImplementationProfessor implements DAO<Professor> {

	private EntityManager e;
	private EntityManagerFactory emf;
	private DAOFactoryTableMySQL factoryconnection;
	
	public DAOImplementationProfessor() {
		factoryconnection = new DAOFactoryTableMySQL();
	}
	
	@Override
	public void adicionar(Professor professor) throws Exception {
		abrirTransacao();
		e.persist(professor);
		fecharTransacao();
	}

	@Override
	public void remover(Professor professor) throws Exception {
		abrirTransacao();
		e.remove(professor);
		fecharTransacao();
	}

	@Override
	public void alterar(Professor professor) throws Exception {
		abrirTransacao();
		e.merge(professor);
		fecharTransacao();
	}

	@Override
	public List<Professor> buscarTodos() throws Exception {
		List<Professor> lsProfessor = new ArrayList<>();
		
		abrirTransacao();
		lsProfessor = e.createQuery("FROM " + Professor.class.getName()).getResultList();
		fecharTransacao();
		
		return lsProfessor;
	}
	
	private void abrirTransacao() {
		emf = factoryconnection.createConnection();
		e = emf.createEntityManager();
		e.getTransaction().begin();
	}
	
	private void fecharTransacao() {
		e.getTransaction().commit();
		factoryconnection.closeConnection(emf);
	}

}
