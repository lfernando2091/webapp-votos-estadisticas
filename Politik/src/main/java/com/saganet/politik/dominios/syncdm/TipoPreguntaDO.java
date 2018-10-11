package com.saganet.politik.dominios.syncdm;

public enum TipoPreguntaDO {
CERRADAMULTIPLE("Cerrada Multiple"),
CERRADASIMPLE("Cerrada Simple"),
ABIERTAMULTIPLELINEA("Abierta Multiple Linea"),
ABIERTASIMPLELINEA("Abierta Simple Linea"),
CERRADAFECHA("Cerrada Fecha");
	
	
	private final String nombre;

	private TipoPreguntaDO(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}
	
	
}
