package dao;

import java.util.ArrayList;
import java.util.List;

import model.Login;

import org.hibernate.Session;

public class LoginDAOMySQL implements DAO<Login>{

	private Session session;
	
	@Override
	public void adicionar(Login login) throws Exception {
		abrirTransacao();
		session.save(login);
		fecharTransacao();
	}

	@Override
	public void remover(Login login) throws Exception {
		abrirTransacao();
		session.delete(login);
		fecharTransacao();
	}

	@Override
	public void alterar(Login login) throws Exception {
		abrirTransacao();
		session.merge(login);
		fecharTransacao();
	}

	@Override
	public List<Login> buscarTodos(Login login) throws Exception {
		List<Login> lsLogin = new ArrayList<>();
		
		abrirTransacao();
		lsLogin = session.createSQLQuery("FROM " + Login.class.getName()).list();
		fecharTransacao();
		
		return lsLogin;
	}

	private void abrirTransacao() {
		session.beginTransaction();
	}
	
	private void fecharTransacao() {
		session.getTransaction().commit();
		session.close();
	}

}
