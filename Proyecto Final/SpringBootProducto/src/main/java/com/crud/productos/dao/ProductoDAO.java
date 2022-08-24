package com.crud.productos.dao;

import java.util.List;

import com.crud.productos.entity.Producto;

public interface ProductoDAO {

	public List<Producto> findAll();
	
	public Producto findById(int theId);
	
	public void save(Producto theEmployee);
	
	public void deleteById(int theId);
	
}
