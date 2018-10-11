package com.saganet.politik.dominios;

public enum TiposAccionesDO {
	INSERTAR("Insertar"),
	ACTUALIZAR("Actualizar"),
	ELIMINAR("Eliminar"),
	CONSULTAR("Consultar"),
	ACCESO("Acceso");

	private final String nombre;

	private TiposAccionesDO(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}
}
