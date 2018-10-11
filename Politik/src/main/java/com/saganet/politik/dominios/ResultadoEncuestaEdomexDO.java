package com.saganet.politik.dominios;

public enum ResultadoEncuestaEdomexDO {
	
	EXITOSO(" "),
	NO_LOCALIZADO("No Localizado"),
	DOMICILIO_NO_ENCONTRADO("Domicilio no encontrado"),
	NO_HUBO_QUIEN_CONTESTARA("No hubo quien respondiera"),
	MENOR_DE_EDAD("Menor de edad"),
	NO_QUISIERON_CONTESTAR("No quisieron contestar"),
	NO_VIVE_AHI("No vive ah�"),
	FINADO("Finado"),
	OTRO("Otro");
	
	private final String nombre;

	private ResultadoEncuestaEdomexDO(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}
	
}
