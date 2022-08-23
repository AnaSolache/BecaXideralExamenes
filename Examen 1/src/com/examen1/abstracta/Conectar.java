package com.examen1.abstracta;

public class Conectar {

//	public static Alexa getConectar(int i) {
//		if(i==1)
//			return new Cel();
//		else if (i==2)
//			return new Ilum();
//		else if (i==3)
//			return new Tele();
//		else 
//			return new Otra();
//	}
//	
	public static Alexa getDisp(String ask) {
		switch (ask) {
		case "Cel": 
			return new Cel();
		case "Ilum": 
			return new Ilum();
		case "Tele":
			return new Tele();
		default:
			return new Otra();
		
		}
	}
	
}
