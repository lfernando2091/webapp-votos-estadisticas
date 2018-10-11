package com.saganet.politik.dominios;

public enum EsquemasDO {
	WAREHOUSE("warehouse"),
	IMPORTACIONES("importaciones"),
	ESTADISITCAS("estadisticas");
	
	private final String nombre;
	
	private EsquemasDO(String nombre){
		this.nombre = nombre;
	}
	
	public String getNombre(){
		return nombre;
	}
}
