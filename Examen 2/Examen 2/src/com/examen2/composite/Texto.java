package com.examen2.composite;

public class Texto extends ContMensaje implements Email {

	public Texto(Email idea1, Email idea2) {
		super(idea1, idea2);
	}

	@Override
	public String getMensaje() {
		return "\n" + " tambien hay un texto expresando: " +"\n"
				+ idea1.getMensaje()+" y "+idea2.getMensaje();
	}
	
	@Override
	public String toString() {
		return "Escribio un texto expresando: " + idea1.getMensaje() +" y "+ idea2.getMensaje();
	}
	
}
