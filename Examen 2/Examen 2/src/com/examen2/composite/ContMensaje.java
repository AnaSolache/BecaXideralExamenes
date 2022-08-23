package com.examen2.composite;

public abstract class ContMensaje implements Email{

	Email idea1;
	Email idea2;
	
	public ContMensaje(Email idea1, Email idea2) {
		this.idea1=idea1;
		this.idea2=idea2;
	}
}
