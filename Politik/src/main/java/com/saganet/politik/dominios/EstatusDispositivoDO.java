package com.saganet.politik.dominios;

public enum EstatusDispositivoDO {
	REGISTRADO("Registrado"),
	APP_CARGADO("Aplicaci�n Cargada"); 

	private final String nombre;

	private EstatusDispositivoDO(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}
}
