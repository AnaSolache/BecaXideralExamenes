package com.examen2.composite;

public class Cliente {

	public static void main(String[] args) {
	
		Email em1 = new LeafIdea("Amor");
		Email em2 = new LeafIdea("Cariño");
		Email em3 = new LeafIdea("Una carta");
		Email em4 = new LeafIdea("Corazones");
		Email em5 = new Texto(em1,em2);
		Email em6 = new Imagen(em4,em5);
		Email em7 = new Pdf(em3,em6);

		System.out.println(em5);
		System.out.println("****************");
		System.out.println(em6);
		System.out.println("****************");
		System.out.println(em7);
		System.out.println("****************");
	
		/*
				 * Escribio un texto expresando: Amor y Cariño
		****************
		Inserto  una imagen que tiene: Corazones y 
		 tambien hay un texto expresando: 
		Amor y Cariño
		****************
		Inserto un pdf con:  Una carta y 
		 tambien hay una imagen que tiene: 
		Corazones y 
		 tambien hay un texto expresando: 
		Amor y Cariño
		****************
		 * */
	}

}
