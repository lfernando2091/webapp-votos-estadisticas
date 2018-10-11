package com.saganet.politik.dominios;

public enum CargosComisionCongresoUnionDO {
	PRESIDENTE("Presidente"),
	SECRETARIO("Secretario"),
	INTEGRANTE("Integrante");
	
	private final String nombre;
	
	private CargosComisionCongresoUnionDO(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre(){
		return nombre;
	}
}
