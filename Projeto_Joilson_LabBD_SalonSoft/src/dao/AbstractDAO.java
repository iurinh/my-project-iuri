package dao;

import java.util.List;

import entity.Cliente;

public interface AbstractDAO<T> {

	public void insert(T value);

	public void update(T value);

	public void delete(T value);

	public List<T> selectAll();
}
