package com.saganet.politik.database.encuestas.edomex2017.foliosFaltantes;

import java.io.Serializable;
import java.text.DecimalFormat;
import org.apache.ibatis.type.Alias;

import com.saganet.politik.dominios.ProgramasEdoMexDO;
import com.saganet.politik.modelos.JavaBeanT;

@Alias("Edomex2017FoliosFaltantesEO")
public class FoliosFaltantesEO extends JavaBeanT implements Serializable {
	
	private static final long serialVersionUID = 2198549554059215572L;

	private Integer id;
	private Integer region;
	private String nombreRegion;
	private Integer municipio;
	private String nombreMunicipio;
	private Integer seccion;
	private Integer folio;
	private String estatus;
	private ProgramasEdoMexDO programa;
	@Override
	public String toString() {
		return "FoliosFaltantesEO [id=" + id + ", region=" + region + ", nombreRegion=" + nombreRegion + ", municipio="
				+ municipio + ", nombreMunicipio=" + nombreMunicipio + ", seccion=" + seccion + ", folio=" + folio
				+ ", estatus=" + estatus + ", programa=" + programa + "]";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getRegion() {
		return region;
	}
	public void setRegion(Integer region) {
		this.region = region;
	}
	public String getNombreRegion() {
		return nombreRegion;
	}
	public void setNombreRegion(String nombreRegion) {
		this.nombreRegion = nombreRegion;
	}
	public Integer getMunicipio() {
		return municipio;
	}
	public void setMunicipio(Integer municipio) {
		this.municipio = municipio;
	}
	public String getNombreMunicipio() {
		return nombreMunicipio;
	}
	public void setNombreMunicipio(String nombreMunicipio) {
		this.nombreMunicipio = nombreMunicipio;
	}
	public Integer getSeccion() {
		return seccion;
	}
	public void setSeccion(Integer seccion) {
		this.seccion = seccion;
	}
	public Integer getFolio() {
		return folio;
	}
	public void setFolio(Integer folio) {
		this.folio = folio;
	}
	public String getEstatus() {
		return estatus;
	}
	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}
	public ProgramasEdoMexDO getPrograma() {
		return programa;
	}
	public void setPrograma(ProgramasEdoMexDO programa) {
		this.programa = programa;
	}
	
	
	


}
