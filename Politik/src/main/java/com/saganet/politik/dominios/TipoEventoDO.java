package com.saganet.politik.dominios;

public enum TipoEventoDO {
	PROGRAMAS("Programas");
	
	private final String nombre;
	
	private TipoEventoDO(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}
}
