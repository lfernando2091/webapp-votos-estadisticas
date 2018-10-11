package com.saganet.politik.dominios;

public enum TiposPreguntaDO {
	ABIERTA("Abierta"), 
	CERRADA("Cerrada");

	private final String nombre;

	private TiposPreguntaDO(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}
}
