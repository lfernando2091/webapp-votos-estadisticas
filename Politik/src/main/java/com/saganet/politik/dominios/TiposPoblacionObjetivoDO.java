package com.saganet.politik.dominios;

public enum TiposPoblacionObjetivoDO {
	NA("N/A"), 
	NINOS("NIÑOS"),
	ADULTOS_MAYORES("ADULTOS MAYORES"),
	HOMBRES("HOMBRES"),
	MUJERES("MUJERES"),
	HOMBRES_MUJERES("HOMBRES Y MUJERES"),
	MADRES_SOLTERAS("MADRES SOLTERAS"),
	HOGARES("Hogares");

	private final String nombre;

	private TiposPoblacionObjetivoDO(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}
}
