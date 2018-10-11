package com.saganet.politik.dominios_dm;

public enum  CatSNDO {
	SI(1,"Si"),
	NO(2,"No");
	
	private final String nombre;
	private final Integer id;
	
	private CatSNDO(Integer id, String nombre) {
		this.nombre = nombre;
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public Integer getId() {
		return id;
	}
}
