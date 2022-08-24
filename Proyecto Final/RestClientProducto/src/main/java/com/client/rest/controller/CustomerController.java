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
import com.client.rest.service.CustomerService;

@Controller
@RequestMapping("/productos")
public class CustomerController {

	// need to inject our customer service
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/lista")
	public String listsProductos(Model theModel) {
		
		// get customers from the service
		List<Producto> theProductos = customerService.getProductos();
				
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
		customerService.saveProducto(theProducto);	
		
		return "redirect:/productos/lista";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("productoId") int theId,
									Model theModel) {
		
		// get the customer from our service
		Producto theProducto = customerService.getProducto(theId);	
		
		// set customer as a model attribute to pre-populate the form
		theModel.addAttribute("customer", theProducto);
		
		// send over to our form		
		return "customer-form";
	}
	
	@GetMapping("/delete")
	public String deleteProducto(@RequestParam("productoId") int theId) {
		
		// delete the customer
		customerService.deleteProducto(theId);
		
		return "redirect:/productos/lista";
	}
}