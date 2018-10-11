package com.saganet.politik.dominios;

public enum NivelesDependenciasDO {
	SECRETARIA 					("SECRETARÍA"), 
	SUB_SECRETARIA 				("SUBSECRETARÍA"),
	DIRECCION_GENERAL 			("DIRECCIÓN GENERAL"),
	ORGANISMO_DESCONCENTRADO	("ORGANISMO DESCONCENTRADO"),
	COORDINACION				("COORDINACIÓN"),
	GOBIERNO 					("GOBIERNO"), 
	PODER 						("PODER");

	private final String nombre;

	private NivelesDependenciasDO(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}
}
