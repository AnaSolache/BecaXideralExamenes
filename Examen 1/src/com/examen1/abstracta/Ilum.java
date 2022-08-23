package com.examen1.abstracta;

public class Ilum extends Alexa{

	@Override
	String Prender() {
		return "Alexa prendio las luces";
	}
	
	@Override
	String Conectar() {
		return  "Alexa atenuo luces";
	}

	@Override
	String Apagar() {
		return "Alexa apago las luces";
	}

}
