package com.examen2.composite;

public class Word extends ContMensaje implements Email {

	public Word(Email idea1, Email idea2) {
		super(idea1, idea2);
	}

	@Override
	public String getMensaje() {
		return "\n" + " tambien hay un word expresando: " +"\n"
				+ idea1.getMensaje()+" y "+idea2.getMensaje();
	}
	
	@Override
	public String toString() {
		return "Inserto un word:  " + idea1.getMensaje() +" y "+ idea2.getMensaje();
	}

	
}
