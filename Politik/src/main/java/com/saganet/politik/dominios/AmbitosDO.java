package com.saganet.politik.dominios;

public enum AmbitosDO {
	GENERAL("General"),
	DEPENDENCIA("Dependencia"),
	DEPENDENCIAS("Dependencias"),
	ELECCION("Elecci�n");
	
	private final String nombre;
	
	private AmbitosDO(String nombre){
		this.nombre = nombre;
	}
	
	public String getNombre(){
		return nombre;
	}
}
