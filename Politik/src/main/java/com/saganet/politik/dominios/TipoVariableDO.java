package com.saganet.politik.dominios;

public enum TipoVariableDO {
	CALCULO("Calculo"),
	IMPORTACION("Importación");

	private final String nombre;

	private TipoVariableDO(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}
}
