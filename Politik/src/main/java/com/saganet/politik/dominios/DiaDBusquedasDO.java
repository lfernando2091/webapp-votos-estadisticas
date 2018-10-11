package com.saganet.politik.dominios;

public enum DiaDBusquedasDO {
	//AVANZADA("Busqueda Avanzada"),
	POR_SECCION("Busqueda Por Seccion"),
	//POR_NOMBRE("Busqueda Por Nombre"),
	POR_FOLIO("Busqueda Por Folio");
	
	private final String nombre;
	
	private DiaDBusquedasDO(String nombre){
		this.nombre = nombre;
	}
	
	public String getNombre(){
		return nombre;
	}
}
