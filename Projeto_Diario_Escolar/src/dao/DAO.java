package dao;

import java.util.List;

public interface DAO<T> {
	public void adicionar(T object) throws Exception;
	public void remover(T object) throws Exception;
	public void alterar(T object) throws Exception;
	public List<T> buscarTodos() throws Exception;
}
