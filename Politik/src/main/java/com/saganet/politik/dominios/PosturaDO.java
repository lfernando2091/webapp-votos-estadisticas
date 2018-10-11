package com.saganet.politik.dominios;

public enum PosturaDO {
	A_FAVOR("A Favor"),
	EN_CONTRA("En Contra"),
	NEUTRAL("Neutral");
	
	private final String nombre;
	
	private PosturaDO(String nombre){
		this.nombre = nombre;
	}
	
	public String getNombre(){
		return nombre;
	}
}
 