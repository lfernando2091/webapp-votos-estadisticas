package com.saganet.politik.dominios;

public enum NivelesDependenciasDO {
	SECRETARIA 					("SECRETAR�A"), 
	SUB_SECRETARIA 				("SUBSECRETAR�A"),
	DIRECCION_GENERAL 			("DIRECCI�N GENERAL"),
	ORGANISMO_DESCONCENTRADO	("ORGANISMO DESCONCENTRADO"),
	COORDINACION				("COORDINACI�N"),
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
