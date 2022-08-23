package com.examen2.composite;

public class Imagen extends ContMensaje implements Email {

	public Imagen(Email idea1, Email idea2) {
		super(idea1, idea2);
	}

	@Override
	public String getMensaje() {
		return "\n" + " tambien hay una imagen que tiene: " +"\n"
				+ idea1.getMensaje()+" y "+idea2.getMensaje();	
		}

	@Override
	public String toString() {
		return "Inserto  una imagen que tiene: " + idea1.getMensaje() +" y "+ idea2.getMensaje();
	}
	
}
