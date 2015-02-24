package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import model.entity.Turma;

public class DAOImplementationTurma implements DAO<Turma>{
	
	private EntityManager e;
	private EntityManagerFactory emf;
	private DAOFactoryTableMySQL factoryconnection;
	
	public DAOImplementationTurma() {
		factoryconnection = new DAOFactoryTableMySQL();
	}
	
	@Override
	public void adicionar(Turma turma) throws Exception {
		abrirTransacao();
		e.persist(turma);
		fecharTransacao();
	}

	@Override
	public void remover(Turma turma) throws Exception {
		abrirTransacao();
		e.remove(turma);
		fecharTransacao();
	}

	@Override
	public void alterar(Turma turma) throws Exception {
		abrirTransacao();
		e.merge(turma);
		fecharTransacao();
	}

	@Override
	public List<Turma> buscarTodos() throws Exception {
		List<Turma> lsTurma = new ArrayList<>();
		
		abrirTransacao();
		lsTurma = e.createQuery("FROM " + Turma.class.getName()).getResultList();
		fecharTransacao();
		
		return lsTurma;
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
