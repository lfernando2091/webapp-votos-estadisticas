package com.saganet.politik.dominios_dm;

public enum CatMbrmDO {
	MUY_BUENA(1, "Muy Buena"),
	BUENA(2, "Buena"),
	REGULAR (3, "Regular"),
	MALA(4, "Mala");

	private final String nombre;
	private final Integer id;
	
	private CatMbrmDO(Integer id, String nombre) {
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
