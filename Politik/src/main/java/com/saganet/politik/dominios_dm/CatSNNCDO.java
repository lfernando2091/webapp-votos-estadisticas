package com.saganet.politik.dominios_dm;

public enum CatSNNCDO {
	SI(1, "Si"),
	NO(2, "No"),
	NO_CONTESTA(3, "No contesta");
	
	private final String nombre;
	private final Integer id;
	
	private CatSNNCDO(Integer id, String nombre) {
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
