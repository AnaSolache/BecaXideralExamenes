package com.examen2.composite;

public class Pdf extends ContMensaje implements Email {

	public Pdf(Email idea1, Email idea2) {
		super(idea1, idea2);
	}

	@Override
	public String getMensaje() {
		return "\n" + " tambien hay un pdf con: " +"\n"
				+ idea1.getMensaje()+" y "+idea2.getMensaje();	
		}
	
	@Override
	public String toString() {
		return "Inserto un pdf con:  " + idea1.getMensaje() +" y "+ idea2.getMensaje();
	}

	
}
