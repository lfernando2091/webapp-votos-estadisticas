package com.saganet.politik.dominios;

public enum CargosDependenciaDO {
	SECRETARIO("Secretario"),
	SUBSECRETARIO("Subsecretario"),
	DIRECTOR_GENERAL("Director General"),
	COORDINADOR("Coordinador");
	
	private final String nombre;
	
	private CargosDependenciaDO(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

}
