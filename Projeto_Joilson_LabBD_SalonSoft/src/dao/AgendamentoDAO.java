package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

//import oracle.jdbc.OracleCallableStatement;
//import oracle.jdbc.OracleTypes;
import util.ConnectionFactory;
import entity.Agendamento;

public class AgendamentoDAO implements AbstractDAO<Agendamento> {

	private Connection conexao;

	public AgendamentoDAO() {
		conexao = ConnectionFactory.getConnection();
	}

	@Override
	public void insert(Agendamento agendamento) {

		try {
			String sql = "INSERT INTO agendamento(horario,data,id_cliente,id_servico) values (?,?,?,?)";
			PreparedStatement statement = conexao.prepareStatement(sql);
			/*
			 * statement.setString(1, agendamento.getHorario());
			 * statement.setString(2, new SimpleDateFormat("yyyy/MM/dd")
			 * .format(agendamento.getData())); statement.setLong(3,
			 * agendamento.getCliente().getId()); statement.setLong(4,
			 * agendamento.getServico().getId_servico());
			 */

			statement.execute();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(Agendamento value) {

	}

	@Override
	public void delete(Agendamento value) {

	}

	@Override
	public List<Agendamento> selectAll() {

		return null;
	}

	public void uniqueResult() {
/*
		OracleCallableStatement cstmt;
		try {
			cstmt = (OracleCallableStatement) conexao.prepareCall("{call proc_get_agendamento(?)}");
			cstmt.registerOutParameter(1, OracleTypes.CURSOR);
			cstmt.execute();
			ResultSet rset = (ResultSet) cstmt.getObject(1);
			while (rset.next()) {
				System.out.println(rset.getDate("dt_agendamento"));
				System.out.println(rset.getString("horario"));
			}
			cstmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}*/
	}

}
