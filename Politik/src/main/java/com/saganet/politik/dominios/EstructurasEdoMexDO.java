package com.saganet.politik.dominios;

public enum EstructurasEdoMexDO {
	COORDINADOR_REGIONAL("Coordinador Regional"),
	COORDINADOR_MUNICIPAL("Coordinador Municipal"),
	SUPERVISOR("Supervisor"),
	VISITADOR("Entrevistador");
	
	private final String nombre;

	private EstructurasEdoMexDO(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}
	
}
