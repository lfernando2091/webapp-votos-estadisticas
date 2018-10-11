package com.saganet.politik.dominios_dm;

public enum CatPartidoDO {
	PAN(1,"PAN"),
	PRI(2,"PRI"),
	PRD(3,"PRD"),
	MORENA(4,"Morena"),
	PVEM(5,"PVEM"),
	PT(6,"PT"),
	MC(7,"MC"),
	PNA(8,"PNA"),
	PES(9,"PES"),
	NO_CONTESTA(10,"No contesta");
	
	private final String nombre;
	private final Integer id;
	
	private CatPartidoDO(Integer id, String nombre) {
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
