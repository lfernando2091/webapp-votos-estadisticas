package com.saganet.politik.dominios_dm;

public enum RegionesDO {
	I_AMECAMECA(1,"I Amecameca"),
	II_ATLACOMULCO(2,"II Atlacomulco"),
	III_CHIMALHUACÁN(3,"III Chimalhuacán"),
	IV_CUAUTITLÁN_IZCALLI(4,"IV Cuautitlán Izcalli"),
	V_ECATEPEC(5,"V Ecatepec"),
	VI_HUIXQUILUCAN(6,"VI Huixquilucan"),
	VII_IXTAPAN_DE_LA_SAL(7,"VII Ixtapan de la Sal"),
	VIII_IXTLAHUACA(8,"VIII Ixtlahuaca"),
	IX_LERMA(9,"IX Lerma"),
	X_METEPEC(10,"X Metepec"),
	XI_NAUCALPAN(11,"XI Naucalpan"),
	XII_NEZAHUALCÓYOTL(12,"XII Nezahualcóyotl"),
	XIII_OTUMBA(13,"XIII Otumba"),
	XIV_TEJUPILCO(14,"XIV Tejupilco"),
	XV_TEXCOCO(15,"XV Texcoco"),
	XVI_TLALNEPANTLA(16,"XVI Tlalnepantla"),
	XVII_TOLUCA(17,"XVII Toluca"),
	XVIII_TULTITLÁN(18,"XVIII Tultitlán"),
	XIX_VALLE_DE_BRAVO(19,"XIX Valle de Bravo"),
	XX_ZUMPANGO(20,"XX Zumpango");
	
	private final String nombre;
	private final Integer id;
	
	private RegionesDO(Integer id, String nombre) {
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
