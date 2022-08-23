package com.examen3.lambdas;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.BiConsumer;
import java.util.function.Supplier;

public class Alexa {

	public static void main(String[] args) {
		
		//Se creo ArrayList con dispositivos
		List <Dispositivo> listaDispositivos =  new ArrayList<>();
		listaDispositivos.add(new Dispositivo("Leonardo","Telefono","Huawei",2));
		listaDispositivos.add(new Dispositivo("Familia","Television","Samsung",5));
		listaDispositivos.add(new Dispositivo("Leonardo","SmarthWach","Huawei",1));
		listaDispositivos.add(new Dispositivo("Angela","Celular","Samsung",2));
		listaDispositivos.add(new Dispositivo("Angela","SmarthWach","Samsung",1));
		listaDispositivos.add(new Dispositivo("Ana","Celular","Motorola",1));
		
		//Lambdas Consumer retornan métodos void
		Consumer<Dispositivo> prender = dis -> System.out.println("Alexa prendio "+dis.getUso()+" de " + dis.getPropietario());
		Consumer<Dispositivo> conectar = dis -> System.out.println("Alexa se conecto "+dis.getUso()+" de " + dis.getPropietario());
		Consumer<Dispositivo> apagar = dis -> System.out.println("Alexa apago "+dis.getUso()+" de " + dis.getPropietario());
		
		//Impresion y uso de lambdas Consumer, por cada elemento del ArrayList, con indicaciones
		System.out.println("*******************");
		System.out.println("Se obtienen 3 lambdas Consumer con forEach de todos los elementos del ArrayList = ");
		System.out.println("*******************");
		listaDispositivos.forEach(prender);
		System.out.println("*******************");
		listaDispositivos.forEach(conectar);
		System.out.println("*******************");
		listaDispositivos.forEach(apagar);
		System.out.println("*******************");
		
		//Uso de lambda Supplier sin parámetros, con retorno de dispositivo con metodo get()
		Supplier<Dispositivo> obtener = () -> new Dispositivo("Tavo","Celular","Motorola",1);
			Dispositivo nuevo = obtener.get();
			System.out.println("Se creo un nuevo dispositivo con Supplier = " + nuevo);
		
		//Uso de lambda Biconsumer con dos parámetros diferentes (dispositivo e integer) retorno void, con método accept()
		System.out.println("*******************");
		System.out.println("Con lambda BiConsumer se asigno vida util a dispositivo = ");		
		BiConsumer<Dispositivo,Integer> vidaUtil = (dis,anios) -> System.out.println(dis.getUso()+" de "+dis.getPropietario()+" tiene una vida util de "+anios+" años.");
			vidaUtil.accept(nuevo, 3);		
		System.out.println("*******************");
			
	}

}
