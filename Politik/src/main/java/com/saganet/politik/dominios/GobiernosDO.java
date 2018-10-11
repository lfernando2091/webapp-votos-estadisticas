package com.saganet.politik.dominios;

public enum GobiernosDO {
	NC("No contesto"),
GOBIERNO_FEDERAL("Gobierno Federal"),
GOBIERNO_ESTATAL("Gobierno Estatal"),
GOBIERNO_MUNICIPAL("Gobierno Municipal"),
NO_SABE("No Sabe");
	private final String  nombre;

	private GobiernosDO(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}
	
}
