package com.saganet.politik.dominios;

public enum ResultadoEntrevistaEntrevistadorDO {
	EXITOSO("...."),
	NO_PERMITIO_MINUTOS("Dijo no tener minutos"),
	NO_QUISO_CONTESTAR("No quiso contestar"),
	NUMERO_INVALIDO("N�mero invalido"),
	NUMERO_NO_EXISTE("N�mero no existe"),
	NUMERO_OCUPADO("N�mero ocupado"),
	NUMERO_HA_CAMBIADO("N�mero ha cambiado"),
	NUMERO_FUERA_SERVICIO("N�mero fuera de servicio"),
	NUMERO_EQUIVOCADO("N�mero equivocado"),
	PERSONA_NO_ENCONTRADA("Persona no encontrada"),
	ENVIA_A_BUZON("Manda a Buzon"),
	MENOR_DE_EDAD("Menor de Edad"),
	No_CONTESTA("No Contestan"),	
	;
	
	private final String nombre;

	private ResultadoEntrevistaEntrevistadorDO(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}
}
