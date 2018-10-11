package com.saganet.politik.database.diaD;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;
import com.saganet.politik.dominios.ProgramasEdoMexDO;
import com.saganet.politik.modelos.JavaBeanT;

@Alias("RegistroMovilizadorEO")
public class RegistroMovilizadorEO extends JavaBeanT implements Serializable {

	private static final long serialVersionUID = -8376359751006214005L;
	private Integer id;
	private Integer  region;
	private String nombreRegion;
	private Integer idMunicipio;
	private String nombreMunicipio;
	private ProgramasEdoMexDO programa;
	private String codigoAlfanumerico;
	@Override
	public String toString() {
		return "RegistroMovilizadorEO [id=" + id + ", region=" + region + ", nombreRegion=" + nombreRegion
				+ ", idMunicipio=" + idMunicipio + ", nombreMunicipio=" + nombreMunicipio + ", programa=" + programa
				+ ", codigoAlfanumerico=" + codigoAlfanumerico + "]";
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
	public Integer getIdMunicipio() {
		return idMunicipio;
	}
	public void setIdMunicipio(Integer idMunicipio) {
		this.idMunicipio = idMunicipio;
	}
	public String getNombreMunicipio() {
		return nombreMunicipio;
	}
	public void setNombreMunicipio(String nombreMunicipio) {
		this.nombreMunicipio = nombreMunicipio;
	}
	public ProgramasEdoMexDO getPrograma() {
		return programa;
	}
	public void setPrograma(ProgramasEdoMexDO programa) {
		this.programa = programa;
	}
	public String getCodigoAlfanumerico() {
		return codigoAlfanumerico;
	}
	public void setCodigoAlfanumerico(String codigoAlfanumerico) {
		this.codigoAlfanumerico = codigoAlfanumerico;
	}
	
	
	

}
