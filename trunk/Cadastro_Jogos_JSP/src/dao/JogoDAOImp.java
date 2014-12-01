package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Jogo;

public class JogoDAOImp implements JogoDAO {

	private ConnectionFactoryMySQL con;
	
	public JogoDAOImp() throws SQLException {
		con = new ConnectionFactoryMySQL();
		con.getCon();
	}
	
	@Override
	public void inserir(Jogo jogo) throws SQLException {
		String sql = "INSERT INTO jogo (NOME,NIVEL) VALUES (?,?)";
		PreparedStatement stm = (PreparedStatement) con.getCon().prepareStatement(sql);
		try{
			stm.setString(1, jogo.getNome());
			stm.setLong(2, jogo.getNivel());
			stm.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Erro Query INSERT");
			System.out.println(e.getMessage());
			throw new SQLException("Erro Query INSERT:\n" + e.getMessage());
		}
	}

	@Override
	public void atualizar(Jogo jogo) throws SQLException {
		String sql = "UPDATE jogo SET nome=?, nivel=? WHERE id=?";
		PreparedStatement stm = (PreparedStatement) con.getCon().prepareStatement(sql);
		try{
			stm.setString(1, jogo.getNome());
			stm.setLong(2, jogo.getNivel());
			stm.setLong(3, jogo.getId());
			stm.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Erro Query UPDATE");
			System.out.println(e.getMessage());
			throw new SQLException("Erro FIND UPDATE:\n" + e.getMessage());
		}
	}

	@Override
	public void remover(int id) throws SQLException {
		String sql = "DELETE FROM jogo WHERE id = ?";
		PreparedStatement stm = (PreparedStatement) con.getCon().prepareStatement(sql);
		try{
			stm.setLong(1, id);
			stm.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Erro Query DELETE");
			System.out.println(e.getMessage());
			throw new SQLException("Erro FIND DELETE:\n" + e.getMessage());
		}
	}

	@Override
	public List<Jogo> buscarTodos() throws SQLException {
		String sql = "SELECT * FROM jogo";
		PreparedStatement stm = (PreparedStatement) con.getCon().prepareStatement(sql);
		ResultSet rs;
		List<Jogo> lsJogo = new ArrayList<>();
		try{
			rs = stm.executeQuery();
			while(rs.next()){
				Jogo jogo = new Jogo();
				jogo.setId(rs.getInt("ID"));
				jogo.setNome(rs.getString("NOME"));
				jogo.setNivel(rs.getInt("NIVEL"));
				
				lsJogo.add(jogo);
			}
		} catch (SQLException e) {
			System.out.println("Erro Query FIND");
			System.out.println(e.getMessage());
			throw new SQLException("Erro FIND INSERT:\n" + e.getMessage());
		}
		return lsJogo;
	}

}
