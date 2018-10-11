package com.saganet.politik.dominios;

public enum TiposReglasDO {
	COMBINADA("Combinada"), 
	SIMPLE("Simple");

	private final String nombre;

	private TiposReglasDO(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}
}
