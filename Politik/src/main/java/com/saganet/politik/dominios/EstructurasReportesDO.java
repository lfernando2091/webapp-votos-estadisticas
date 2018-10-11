package com.saganet.politik.dominios;

public enum EstructurasReportesDO {
	CONCENTRADO_NACIONAL("Concentrado Nacional"),
	CONCENTRADO_ESTATAL("Concentrado Estatal"),
	ESTRUCTURA_OPERATIVA_2018("Estructura Operativa 2018");
	
	private final String nombre;

	private EstructurasReportesDO(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}
	
}
