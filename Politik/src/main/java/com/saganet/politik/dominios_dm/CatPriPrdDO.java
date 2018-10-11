package com.saganet.politik.dominios_dm;

public enum CatPriPrdDO {
	PRI(1,"PRI"),
	PRD(2,"PRD"),
	NO_SABE (3,"No sabe"),
	NO_CONTESTA(4,"No contesta");
	
	private final String nombre;
	private final Integer id;
	
	private CatPriPrdDO(Integer id, String nombre) {
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
