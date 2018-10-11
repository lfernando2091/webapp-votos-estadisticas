package com.saganet.politik.dominios;

public enum EsquemasParticionesDO {
	WH_PARTICIONES("wh_particiones");
	
	private final String nombre;
	
	private EsquemasParticionesDO(String nombre){
		this.nombre = nombre;
	}
	
	public String getNombre(){
		return nombre;
	}
}
