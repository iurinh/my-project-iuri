package Factory;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FactoryTableOracle {

	public static void main(String[] args) {
		new FactoryTableOracle();
	}
	
	public FactoryTableOracle() {
		EntityManagerFactory factoryOracle = Persistence.createEntityManagerFactory("Diario_Escolar_Oracle");
		factoryOracle.close();
	}
}
