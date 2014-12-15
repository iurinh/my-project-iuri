package Factory;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FactoryTableMySQL {

	public static void main(String[] args) {
		new FactoryTableMySQL();
	}
	
	public FactoryTableMySQL() {
		EntityManagerFactory factoryMySQL = Persistence.createEntityManagerFactory("Diario_Escolar_MySQL");
		factoryMySQL.close();
	}

}
