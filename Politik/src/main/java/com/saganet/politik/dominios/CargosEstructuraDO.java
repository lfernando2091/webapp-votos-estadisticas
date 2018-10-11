package com.saganet.politik.dominios;

public enum CargosEstructuraDO {
	COMISIONADO_TERRITORIAL("Comisionado Territorial"),
	COMISIONADO_SECCIONAL("Comisionado Seccional"),
	PROMOTOR("Promotor"),
	OTRO("Otro");
	private final String nombre;
	
	private CargosEstructuraDO(String nombre){
		this.nombre = nombre;
	}
	
	public String getNombre(){
		return nombre;
	}
}
