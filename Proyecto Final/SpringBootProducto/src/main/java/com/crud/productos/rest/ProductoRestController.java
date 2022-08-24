package com.crud.productos.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.productos.entity.Producto;
import com.crud.productos.service.ProductoService;

@RestController
@RequestMapping("/api")
public class ProductoRestController {

	private ProductoService productoService;
	
	@Autowired
	public ProductoRestController(ProductoService theProductoService) {
		productoService = theProductoService;
	}
	
	// expose "/productos" and return list of employees
	@GetMapping("/productos")
	public List<Producto> findAll() {
		return productoService.findAll();
	}

	// add mapping for GET /producto/{productoId}
	
	@GetMapping("/productos/{productoId}")
	public Producto getProducto(@PathVariable int productoId) {
		
		Producto theProducto = productoService.findById(productoId);
		
		if (theProducto == null) {
			throw new RuntimeException("Producto id no encontrado - " + productoId);
		}
		
		return theProducto;
	}
	
	// add mapping for POST /employees - add new employee
	
	@PostMapping("/productos")
	public Producto addProducto(@RequestBody Producto theProducto) {
		
		// also just in case they pass an id in JSON ... set id to 0
		// this is to force a save of new item ... instead of update
		
		theProducto.setId(0);
		
		productoService.save(theProducto);
		
		return theProducto;
	}
	
	// add mapping for PUT /employees - update existing employee
	
	@PutMapping("/productos")
	public Producto updateProducto(@RequestBody Producto theProducto) {
		
		productoService.save(theProducto);
		
		return theProducto;
	}
	
	// add mapping for DELETE /employees/{employeeId} - delete employee
	
	@DeleteMapping("/productos/{productoId}")
	public String deleteProducto(@PathVariable int productoId) {
		
		Producto tempProducto = productoService.findById(productoId);
		
		// throw exception if null
		
		if (tempProducto == null) {
			throw new RuntimeException("Producto id no encontrado - " + productoId);
		}
		
		productoService.deleteById(productoId);
		return "Se borró producto con id - " + productoId;
	}
	
}










