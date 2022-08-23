package com.examen1.abstracta;

public class Cliente {

	public static void main(String[] args) {
		Alexa dispositivo = Conectar.getDisp("Cel");
		//opciones método conectar Cel, Tele, Ilum & default
		ejecuta(dispositivo);
	}
	
	private static void ejecuta(Alexa indicacion) {
		String resp1 = indicacion.Apagar()+"\n"+ indicacion.Prender() +"\n"+indicacion.Conectar();
		System.out.println(resp1);
	}

}
