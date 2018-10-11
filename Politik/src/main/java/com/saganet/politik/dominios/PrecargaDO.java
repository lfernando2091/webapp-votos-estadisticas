package com.saganet.politik.dominios;

public enum PrecargaDO {
	SIN_PRECARGA("Sin Precarga"),
	AMECAMECA("I Amecameca"),
	ATLACOMULCO("II Atlacomulco"),
	CHIMALHUACAN("III Chimalhuac�n"),
	CUAUTITLAN_IZCALLI("IV Cuautitl�n Izcalli"),
	ECATEPEC("V Ecatepec"),
	HUIXQUILUCAN("VI Huixquilucan"),
	IXTAPAN_DE_LA_SAL("VII Ixtapan de la Sal"),
	IXTLAHUACA("VIII Ixtlahuaca"),
	LERMA("IX Lerma"),
	METEPEC("X Metepec"),
	NAUCALPAN("XI Naucalpan"),
	NEZAHUALCOYOTL("XII Nezahualc�yotl"),
	OTUMBA("XIII Otumba"),
	TEJUPILCO("XIV Tejupilco"),
	TEXCOCO("XV Texcoco"),
	TLALNEPANTLA("XVI Tlalnepantla"),
	TOLUCA("XVII Toluca"),
	TULTITLAN("XVIII Tultitl�n"),
	VALLE_DE_BRAVO("XIX Valle de Bravo"),
	ZUMPANGO("XX Zumpango"),
	NO_ASIGNADO("No Asignado");
	
	private final String nombre;
	
	private PrecargaDO(String nombre){
		this.nombre = nombre;
	}
	
	public String getNombre(){
		return nombre;
	}
}
