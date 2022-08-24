package com.crud.productos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.crud.productos.dao.ProductoDAO;
import com.crud.productos.entity.Producto;

@Service
public class ProductoServiceImpl implements ProductoService {

	private ProductoDAO productoDAO;
	
	@Autowired
	public ProductoServiceImpl(@Qualifier("productoDAOHibernateImpl")ProductoDAO theProductoDAO) {
		productoDAO = theProductoDAO;
	}
	
	@Override
	@Transactional
	public List<Producto> findAll() {
		return productoDAO.findAll();
	}

	@Override
	@Transactional
	public Producto findById(int theId) {
		return productoDAO.findById(theId);
	}

	@Override
	@Transactional
	public void save(Producto theProducto) {
		productoDAO.save(theProducto);
	}

	@Override
	@Transactional
	public void deleteById(int theId) {
		productoDAO.deleteById(theId);
	}

}






