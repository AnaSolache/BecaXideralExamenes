package com.examen1.abstracta;

public class Tele extends Alexa{

	@Override
	String Prender() {
		return "Alexa prendio television";
	}
	
	@Override
	String Conectar() {
		return "Alexa se conecto a la television";
	}

	@Override
	String Apagar() {
		return "Alexa apago la television";		
	}

}
