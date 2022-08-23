package com.examen3.lambdas;

public class Dispositivo {

	private String propietario;
	private String uso;
	private String marca;
	private int antiguedad;
	
	public Dispositivo(String propietario, String uso, String marca, int antiguedad) {
		super();
		this.propietario = propietario;
		this.uso = uso;
		this.marca = marca;
		this.antiguedad = antiguedad;
	}

	public String getPropietario() {
		return propietario;
	}

	public void setPropietario(String propietario) {
		this.propietario = propietario;
	}

	public String getUso() {
		return uso;
	}

	public void setUso(String uso) {
		this.uso = uso;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public int getAntiguedad() {
		return antiguedad;
	}

	public void setAntiguedad(int antiguedad) {
		this.antiguedad = antiguedad;
	}

	@Override
	public String toString() {
		return "Dispositivo [propietario=" + propietario + ", uso=" + uso + ", marca=" + marca + ", antiguedad="
				+ antiguedad + "]";
	}
	

	
}
