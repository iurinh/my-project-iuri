package dao;

import java.sql.SQLException;
import java.util.List;

import entity.Jogo;

public interface JogoDAO {

	public void inserir(Jogo jogo) throws SQLException;
	public void atualizar(Jogo jogo) throws SQLException;
	public void remover(int id) throws SQLException;
	public List<Jogo> buscarTodos() throws SQLException;
	
}
