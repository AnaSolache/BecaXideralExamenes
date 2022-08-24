package com.client.rest.model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Producto {

// define atributos
	
	private int id;
	private String nombre;
	private int precio;
	private String descripcion;
}