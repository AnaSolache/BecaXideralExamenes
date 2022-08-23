package com.examen1.interfaz;

public class Ilum implements Alexa{

	@Override
	public String Prender() {
		return "Alexa prendio las luces";
	}
	
	@Override
	public String Conectar() {
		return  "Alexa atenuo luces";
	}

	@Override
	public String Apagar() {
		return "Alexa apago las luces";
	}

}
