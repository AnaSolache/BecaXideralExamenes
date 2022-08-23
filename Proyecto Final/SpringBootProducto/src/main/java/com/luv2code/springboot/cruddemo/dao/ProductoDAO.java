package com.luv2code.springboot.cruddemo.dao;

import java.util.List;
import com.luv2code.springboot.cruddemo.entity.Producto;

public interface ProductoDAO {

	public List<Producto> findAll();
	
	public Producto findById(int theId);
	
	public void save(Producto theEmployee);
	
	public void deleteById(int theId);
	
}
