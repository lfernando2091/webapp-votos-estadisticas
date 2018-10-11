package com.saganet.politik.dominios_dm;

public enum TiposSexoDO {
	X(0,"X"),
	H(2,"H"),
	M(3,"M");
	
	private final Integer id;
	private final String nombre;

	private TiposSexoDO(Integer id,String nombre) {
		this.id = id;
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}
	
	public Integer getId(){
		return id;
	}
	
}
