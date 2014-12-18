package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Login;

public class LoginDAOMySQL implements DAO<Login>{

	private EntityManager e;
	private EntityManagerFactory emf;
	
	@Override
	public void adicionar(Login login) throws Exception {
		abrirTransacao();
		e.persist(login);
		fecharTransacao();
	}

	@Override
	public void remover(Login login) throws Exception {
		abrirTransacao();
		e.remove(login);
		fecharTransacao();
	}

	@Override
	public void alterar(Login login) throws Exception {
		abrirTransacao();
		e.merge(login);
		fecharTransacao();
	}

	@Override
	public List<Login> buscarTodos(Login login) throws Exception {
		List<Login> lsLogin = new ArrayList<>();
		
		abrirTransacao();
		lsLogin = e.createQuery("FROM " + Login.class.getName()).getResultList();
		fecharTransacao();
		
		return lsLogin;
	}

	private void abrirTransacao() {
		emf = Persistence.createEntityManagerFactory("Diario_Escolar_MySQL");
		e = emf.createEntityManager();
		e.getTransaction().begin();
	}
	
	private void fecharTransacao() {
		e.getTransaction().commit();
		e.close();
		emf.close();
	}

}
