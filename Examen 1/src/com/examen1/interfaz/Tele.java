package com.examen1.interfaz;

public class Tele implements Alexa{

	@Override
	public String Prender() {
		return "Alexa prendio television";
	}
	
	@Override
	public String Conectar() {
		return "Alexa se conecto a la television";
	}

	@Override
	public String Apagar() {
		return "Alexa apago la television";		
	}

}
