package com.saganet.politik.dominios;

public enum EstatusEventoDO {
	PROGRAMADO("Programado"),
	REALIZADO("Realizado"),
	APROBADO("Aprobado"),
	NO_APROBADO("No Aprobado");
	
	private final String nombre;
	
	private EstatusEventoDO(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}
}
