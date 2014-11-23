package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionFactory {
	
	private static final String USER_NAME = "SYSTEM";
	private static final String PASSWORD = "FATEC";
	private static final String URL = "jdbc:oracle:thin:@localhost:1521/XE";

	private ConnectionFactory() {}

	public static Connection getConnection() {

		try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            return DriverManager.getConnection(URL, USER_NAME, PASSWORD);
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Erro ao abrir a conexão !!", ex);
        } catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Erro ao abrir a conexão !!", e);
		}
    }
}
