package com.saganet.politik.dominios;

public enum SiNoDO {

	
	
	NC("No contesto"),
	NO("No"),
	SI("Si");
	
	private final String nombre;

	private SiNoDO(String nombre){
		this.nombre = nombre;
	}
	
	public String getNombre(){
		return nombre;
	}
	
}
