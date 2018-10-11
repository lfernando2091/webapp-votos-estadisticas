package com.saganet.politik.dominios;

public enum TiposCampoDO {
	INTEGER("integer", "Entero"),
	TEXT("text", "Texto"),
	NUMERIC("numeric", "Num�rico"),
	DATE("date", "Fecha,"),
	BOOLEAN("boolean", "Booleano");
	
	private final String tipo;
	private final String nombre;
	
	private TiposCampoDO(String tipo, String nombre){
		this.tipo = tipo;
		this.nombre = nombre;
	}
	
	public String getTipo(){
		return tipo;
	}

	public String getNombre() {
		return nombre;
	}
}
