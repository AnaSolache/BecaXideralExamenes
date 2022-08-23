package com.examen1.interfaz;


public class Cel implements Alexa {

	@Override
	public String Prender() {
		return "Alexa prendio tu celular";
	}
	
	@Override
	public String Conectar() {
		return "Alexa se conecto al celular";
	}

	@Override
	public String Apagar() {
		return "Alexa apago tu celular";
	}

}
