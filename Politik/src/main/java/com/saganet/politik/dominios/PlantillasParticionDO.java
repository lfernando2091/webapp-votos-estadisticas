package com.saganet.politik.dominios;

public enum PlantillasParticionDO {
	ENTIDADES("Entidades");
	
	private String nombre;
	
	private PlantillasParticionDO(String nombre) {
		this.nombre = nombre;
	}
	
	public String getNombre(){
		return nombre;
	}
}
