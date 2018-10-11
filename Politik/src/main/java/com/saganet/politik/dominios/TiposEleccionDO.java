package com.saganet.politik.dominios;

public enum TiposEleccionDO {
	ORDINARIA("Ordinaria"), 
	EXTRAORDINARIA("Extraordinaria");

	private final String nombre;

	private TiposEleccionDO(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

}
