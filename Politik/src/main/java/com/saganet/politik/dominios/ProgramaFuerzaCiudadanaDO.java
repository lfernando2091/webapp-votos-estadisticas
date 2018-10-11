package com.saganet.politik.dominios;

public enum ProgramaFuerzaCiudadanaDO {
	COORDINADORES("COORDINADORES","Fracción 1"),
	NEGATIVOS("NEGATIVOS","Fracción 2");

	private final String nombre;
	private final String nombre2;
	
	private ProgramaFuerzaCiudadanaDO(String nombre, String nombre2){
		this.nombre = nombre;
		this.nombre2 = nombre2;
	}
	
	public String getNombre(){
		return nombre;
	}
	public String getNombre2(){
		return nombre2;
	}
}
