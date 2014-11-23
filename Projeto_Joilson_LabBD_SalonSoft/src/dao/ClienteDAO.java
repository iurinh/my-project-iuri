package dao;

import java.util.ArrayList;
import java.util.List;

import entity.Cliente;

public class ClienteDAO implements AbstractDAO<Cliente>{

	@Override
	public void insert(Cliente value) {
		System.out.println("Cliente incluido na DAO");
	}

	@Override
	public void update(Cliente value) {
		System.out.println("Cliente alterado na DAO -> ID: " + value.getId());
	}

	@Override
	public void delete(Cliente value) {
		System.out.println("Cliente deletado na DAO -> ID: " + value.getId());
	}

	@Override
	public List<Cliente> selectAll() {
		System.out.println("Lista de clientes trazida da DAO");
		
		List<Cliente> lsCliente = new ArrayList<Cliente>();
		
		lsCliente.add(new Cliente());
		lsCliente.add(new Cliente());
		lsCliente.add(new Cliente());
		lsCliente.add(new Cliente());
		
		lsCliente.get(0).setId(1L);
		lsCliente.get(0).setNome("IURI");
		lsCliente.get(0).setEmail("kkkkkkkkkkkk");
		
		lsCliente.get(1).setId(2L);
		lsCliente.get(1).setNome("Naide");
		lsCliente.get(1).setEmail("dddddddddddd");
		
		lsCliente.get(2).setId(3L);
		lsCliente.get(2).setNome("Alex");
		lsCliente.get(2).setEmail("aaaaaaaaaaa");
		
		lsCliente.get(3).setId(4L);
		lsCliente.get(3).setNome("LEo");
		lsCliente.get(3).setEmail("rrrrrrrrrrrrr");
		
		return lsCliente;
	}
}
