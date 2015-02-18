package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DAOImplementationMySQL implements DAO<Object>{

	private EntityManager e;
	private EntityManagerFactory emf;
	private DAOFactoryTableMySQL factoryconnection;
	
	@Override
	public void adicionar(Object Object) throws Exception {
		abrirTransacao();
		e.persist(Object);
		fecharTransacao();
	}

	@Override
	public void remover(Object Object) throws Exception {
		abrirTransacao();
		e.remove(Object);
		fecharTransacao();
	}

	@Override
	public void alterar(Object Object) throws Exception {
		abrirTransacao();
		e.merge(Object);
		fecharTransacao();
	}

	@Override
	public List<Object> buscarTodos() throws Exception {
		List<Object> lsObject = new ArrayList<>();
		
		abrirTransacao();
		lsObject = e.createQuery("FROM " + Object.class.getName()).getResultList();
		fecharTransacao();
		
		return lsObject;
	}

	private void abrirTransacao() {
		emf = factoryconnection.createConnection();
		e = emf.createEntityManager();
		e.getTransaction().begin();
	}
	
	private void fecharTransacao() {
		e.getTransaction().commit();
		e.close();
		emf.close();
		factoryconnection.closeConnection(emf);
	}

}
