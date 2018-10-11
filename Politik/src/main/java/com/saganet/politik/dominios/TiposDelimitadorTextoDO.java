package com.saganet.politik.dominios;

public enum TiposDelimitadorTextoDO {
	COMILLAS_DOBLES("\"","Comillas  Dobles"), 
	COMILLA("'","Comilla");

	private final String simbolo;
	private final String nombre;


	private TiposDelimitadorTextoDO(String simbolo,String nombre) {
		this.nombre = nombre;
		this.simbolo = simbolo;
	}

	public String getNombre() {
		return nombre;
	}
	
	public String getSimbolo() {
		return simbolo;
	}

}
