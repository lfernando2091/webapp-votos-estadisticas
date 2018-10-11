package com.saganet.politik.dominios;

public enum TiposRepresentanteDO {
	PRESIDENTE("Presidente de la República", NivelesDO.NACIONAL),
	SENADOR("Senador", NivelesDO.ENTIDAD),
	GOBERNADOR("Gobernador", NivelesDO.ENTIDAD),
	DIPUTADO_FEDERAL("Diputado Federal", NivelesDO.DFEDERAL),
	DIPUTADO_LOCAL("Diputado Local", NivelesDO.DLOCAL),
	PRESIDENTE_MUNICIPAL_CABILDO("Presidente Municipal y Cabildo", NivelesDO.MUNICIPIO),
	PRESIDENTE_MUNICIPAL("Presidente Municipal", NivelesDO.MUNICIPIO),
	CABILDO("Cabildo", NivelesDO.MUNICIPIO);
	

	private final String nombre;
	private final NivelesDO nivel;

	private TiposRepresentanteDO(String nombre, NivelesDO nivel) {
		this.nombre = nombre;
		this.nivel = nivel;
	}

	public String getNombre() {
		return nombre;
	}
	
	public NivelesDO getNivel(){
		return nivel;
	}
}
