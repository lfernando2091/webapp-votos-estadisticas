package com.saganet.politik.dominios;

public enum BuenaRegularMaloDO {
    NC("No contesto"),
	BUENA("Buena"),
	REGULAR("Regular"),
	MALO("Malo");
	
	private final String nombre;

	private BuenaRegularMaloDO(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}
	
	
}
