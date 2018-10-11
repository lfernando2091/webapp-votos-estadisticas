package com.saganet.politik.dominios;

public enum CandidatosPartidosEedomex2017DO {
	JOSEFINA_VAZQUEZ_MOTA_PAN("JOSEFINA VAZQUEZ MOTA - PAN"),
	ALFREDO_DEL_MAZO_MAZA_PRI("ALFREDO DEL MAZO MAZA - PRI"),
	JUAN_ZEPEDA_HERNANDEZ_PRD("JUAN ZEPEDA HERNANDEZ - PRD"),
	DELFINA_GOMEZ_ALVAREZ_MORENA("DELFINA GOMEZ ALVAREZ - PT"),
	OSCAR_GONZALEZ_YANEZ_PT("OSCAR GONZÁLEZ YÁÑEZ - MORENA"),
	ISIDRO_PASTOR_MEDRANO_INDEPENDIENTE("ISIDRO PASTOR MEDRANO - INDEPENDIENTE"),
	NS_NC("NS/NC");
	private final String nombre;
	

	private CandidatosPartidosEedomex2017DO(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

}
