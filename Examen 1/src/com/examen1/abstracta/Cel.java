package com.examen1.abstracta;


public class Cel extends Alexa {

	@Override
	String Prender() {
		return "Alexa prendio tu celular";
	}
	
	@Override
	String Conectar() {
		return "Alexa se conecto al celular";
	}

	@Override
	String Apagar() {
		return "Alexa apago tu celular";
	}

}
