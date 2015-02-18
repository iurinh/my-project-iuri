package dao;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DAOFactoryTableMySQL {

	public DAOFactoryTableMySQL() {
		//EntityManagerFactory factory = Persistence.createEntityManagerFactory("Diario_Escolar_MySQL");
		//factory.close();
	}
	
	public EntityManagerFactory createConnection(){
		return Persistence.createEntityManagerFactory("Diario_Escolar_MySQL");
	}
	
	public void closeConnection(EntityManagerFactory connection){
		connection.close();
	}

}
