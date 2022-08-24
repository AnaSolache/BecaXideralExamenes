package com.crud.productos.service;

import java.util.List;

import com.crud.productos.entity.Producto;

public interface ProductoService {

	public List<Producto> findAll();
	
	public Producto findById(int theId);
	
	public void save(Producto theProducto);
	
	public void deleteById(int theId);
	
}
