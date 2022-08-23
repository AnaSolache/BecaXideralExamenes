package com.examen1.interfaz;

public class Cliente {

	public static void main(String[] args) {
		
		Alexa dispositivo = Conectar.getDisp("Cel");
		Alexa dispo2 = Conectar.getDisp("Tele");
		Alexa dispo3 = Conectar.getDisp("Ilum");
		Alexa dispo4 = Conectar.getDisp("Etc");
		//opciones método conectar Cel, Tele, Ilum & default
		ejecuta(dispositivo);
		ejecuta(dispo2);
		ejecuta(dispo3);
		ejecuta(dispo4);
		
	}
	
	private static void ejecuta(Alexa indicacion) {
		String resp1 = indicacion.Apagar()+"\n"+ indicacion.Prender() +"\n"+indicacion.Conectar();
		System.out.println(resp1);
	}

}
