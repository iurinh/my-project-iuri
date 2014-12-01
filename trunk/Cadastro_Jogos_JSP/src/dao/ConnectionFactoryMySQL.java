package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactoryMySQL {

	private Connection con;
	
	public ConnectionFactoryMySQL() throws SQLException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbjogo", "root", "root");
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println("Erro de conexao:");
			System.out.println(e.getMessage());
			throw new SQLException("Erro de conexao:\n" + e.getMessage());
		}
	}

	public Connection getCon() {
		return con;
	}

	public void setCon(Connection con) {
		this.con = con;
	}
	
	
}
