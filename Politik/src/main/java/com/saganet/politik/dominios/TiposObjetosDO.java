package com.saganet.politik.dominios;

public enum TiposObjetosDO {
	PERSONAS("PERSONAS");

	private final String nombre;

	private TiposObjetosDO(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}
}
