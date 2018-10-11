package com.saganet.politik.dominios;

public enum EstatusVariableDO {
	PENDIENTE("Pendiente"),
	EJECUTANDO("En Proceso"),
	CREADA("Creada");
	
	private final String nombre;
	
	private EstatusVariableDO(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}
}
