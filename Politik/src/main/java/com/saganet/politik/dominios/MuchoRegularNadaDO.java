package com.saganet.politik.dominios;

public enum MuchoRegularNadaDO {
	NC("No contesto"),
	MUCHO("Mucho"),
	REGULAR("Regular"),
	NADA("Nada");
	
private final String nombre;

private MuchoRegularNadaDO(String nombre) {
	this.nombre = nombre;
}

public String getNombre() {
	return nombre;
}
	
}
