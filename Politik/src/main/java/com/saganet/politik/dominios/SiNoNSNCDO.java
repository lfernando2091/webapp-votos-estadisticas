package com.saganet.politik.dominios;

public enum SiNoNSNCDO {

	SI("Si"),
	NO("No"),
	NS_NC("NS/NC");
	
	
	private final String nombre;

	private SiNoNSNCDO(String nombre){
		this.nombre = nombre;
	}
	
	public String getNombre(){
		return nombre;
	}
	
}
