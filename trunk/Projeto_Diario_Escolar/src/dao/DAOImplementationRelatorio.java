package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.entity.Relatorio;

public class DAOImplementationRelatorio implements DAO<Relatorio>{

	private EntityManager e;
	private EntityManagerFactory emf;
	private DAOFactoryTableMySQL factoryconnection;
	
	public DAOImplementationRelatorio() {
		factoryconnection = new DAOFactoryTableMySQL();
	}
	
	@Override
	public void adicionar(Relatorio relatorio) throws Exception {
		abrirTransacao();
		e.persist(relatorio);
		fecharTransacao();
	}

	@Override
	public void remover(Relatorio relatorio) throws Exception {
		abrirTransacao();
		e.remove(relatorio);
		fecharTransacao();
	}

	@Override
	public void alterar(Relatorio relatorio) throws Exception {
		abrirTransacao();
		e.merge(relatorio);
		fecharTransacao();
	}

	@Override
	public List<Relatorio> buscarTodos() throws Exception {
		List<Relatorio> lsRelatorio = new ArrayList<>();
		
		abrirTransacao();
		lsRelatorio = e.createQuery("FROM " + Relatorio.class.getName()).getResultList();
		fecharTransacao();
		
		return lsRelatorio;
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
