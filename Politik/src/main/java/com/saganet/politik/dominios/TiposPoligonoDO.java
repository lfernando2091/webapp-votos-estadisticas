package com.saganet.politik.dominios;

public enum TiposPoligonoDO {
	ENTIDAD("Entidad Federativa"),
	MUNICIPIO("Municipio"),
	DISTRITO_FEDERAL("Distrito Federal"),
	SECCION("Secci�n"),
	MANZANA("Manzana");
	
	private final String nombre;

	private TiposPoligonoDO(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

}
