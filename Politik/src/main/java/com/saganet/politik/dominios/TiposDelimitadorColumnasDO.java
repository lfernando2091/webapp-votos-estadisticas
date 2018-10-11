package com.saganet.politik.dominios;

public enum TiposDelimitadorColumnasDO {
	COMA(",","Coma"), 
	PUNTO_Y_COMA(";","Punto y Coma"), 
	PIPE("|","Pipe"),
	TABULADOR("	","Tabulador"),
	DIAGONAL("/","Diagonal");

	private final String simbolo;
	private final String nombre;

	private TiposDelimitadorColumnasDO(String simbolo,String nombre) {
		this.simbolo = simbolo;
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}
	
	public String getSimbolo() {
		return simbolo;
	}

}
