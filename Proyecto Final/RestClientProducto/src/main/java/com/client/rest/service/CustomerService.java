package com.client.rest.service;

import java.util.List;
import com.client.rest.model.Producto;

public interface CustomerService {

	public List<Producto> getProductos();

	public void saveProducto(Producto theProducto);

	public Producto getProducto(int theId);

	public void deleteProducto(int theId);
	
}
