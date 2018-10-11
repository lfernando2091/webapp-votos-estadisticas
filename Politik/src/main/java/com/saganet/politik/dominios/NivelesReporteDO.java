package com.saganet.politik.dominios;

public enum NivelesReporteDO {
	REGION("Region"),
	MUNICIPIO("Municipio"),
	SECCION("Sección");
	
	private final String nombre;
	
	private NivelesReporteDO(String nombre){
		this.nombre = nombre;
	}
	
	public String getNombre(){
		return nombre;
	}
}
 