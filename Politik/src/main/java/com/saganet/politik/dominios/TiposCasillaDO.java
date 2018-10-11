package com.saganet.politik.dominios;

public enum TiposCasillaDO {
	BASICA("Básica"), 
	CONTIGUA("Contigua"), 
	EXTRAORDINARIA("Extraordinaria"), 
	ESPECIAL("Especial");

	private final String nombre;

	private TiposCasillaDO(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}
}
