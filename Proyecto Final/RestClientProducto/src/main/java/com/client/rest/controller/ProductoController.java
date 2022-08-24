package com.client.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.client.rest.model.Producto;
import com.client.rest.service.ProductoService;

@Controller
@RequestMapping("/producto")
public class ProductoController {

	// need to inject our customer service
	@Autowired
	private ProductoService productoService;
	
	@GetMapping("/lista")
	public String listsProductos(Model theModel) {
		
		// get customers from the service
		List<Producto> theProductos = productoService.getProductos();
				
		// add the customers to the model
		theModel.addAttribute("productos", theProductos);
		
		return "list-productos";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		// create model attribute to bind form data
		Producto theProducto = new Producto();
		
		theModel.addAttribute("producto", theProducto);
		
		return "producto-form";
	}
	
	@PostMapping("/saveProducto")
	public String saveProducto(@ModelAttribute("producto") Producto theProducto) {
		
		// save the customer using our service
		productoService.saveProducto(theProducto);	
		
		return "redirect:/producto/lista";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("productoId") int theId,
									Model theModel) {
		
		// obtener el producto de nuestro service
		Producto theProducto = productoService.getProducto(theId);	
		
		// crear un producto como un modelo para enviar a the form
		theModel.addAttribute("producto", theProducto);
		
		// enviarlo a jsp		
		return "producto-form";
	}
	
	@GetMapping("/delete")
	public String deleteProducto(@RequestParam("productoId") int theId) {
		
		// borrar un producto
		productoService.deleteProducto(theId);
		
		return "redirect:/producto/lista";
	}
}