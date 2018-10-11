package com.saganet.politik.dominios;

public enum BuenaRegularNadaDO {
    NC("No contesto"),
	BUENA("Buena"),
	REGULAR("Regular"),
	NADA("Nada");
	
	private final String nombre;

	private BuenaRegularNadaDO(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}
	
	
}
