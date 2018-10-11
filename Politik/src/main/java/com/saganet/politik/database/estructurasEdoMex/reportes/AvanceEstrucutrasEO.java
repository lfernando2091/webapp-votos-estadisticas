package com.saganet.politik.database.estructurasEdoMex.reportes;

import java.io.Serializable;
import org.apache.ibatis.type.Alias;

import com.saganet.politik.database.catalogos.EntidadEO;
import com.saganet.politik.database.catalogos.GeozonaParticionEO;
import com.saganet.politik.database.catalogos.MunicipioEO;
import com.saganet.politik.database.catalogos.SeccionEO;
import com.saganet.politik.database.mdm.PersonaEO;
import com.saganet.politik.modelos.JavaBeanT;

@Alias("AvanceEstrucutrasEO")
public class AvanceEstrucutrasEO extends JavaBeanT implements Serializable {
	private static final long serialVersionUID = 1869647800401555906L;

	private Integer id;
	private EntidadEO entidad;
	private GeozonaParticionEO region;
	private MunicipioEO municipio;
	private SeccionEO seccion;
	private Integer avance_cr;
	private Integer meta_cr;
	private Integer porcentaje_cr;
	private Integer avance_cm;
	private Integer meta_cm;
	private Integer porcentaje_cm;
	private Integer avance_s;
	private Integer meta_s;
	private Integer porcentaje_s;
	private Integer avance_v;
	private Integer meta_v;
	private Integer porcentaje_v;
	@Override
	public String toString() {
		return "AvanceEstrucutrasEO [id=" + id + ", entidad=" + entidad + ", region=" + region + ", municipio="
				+ municipio + ", seccion=" + seccion + ", avance_cr=" + avance_cr + ", meta_cr=" + meta_cr
				+ ", porcentaje_cr=" + porcentaje_cr + ", avance_cm=" + avance_cm + ", meta_cm=" + meta_cm
				+ ", porcentaje_cm=" + porcentaje_cm + ", avance_s=" + avance_s + ", meta_s=" + meta_s
				+ ", porcentaje_s=" + porcentaje_s + ", avance_v=" + avance_v + ", meta_v=" + meta_v + ", porcentaje_v="
				+ porcentaje_v + "]";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public EntidadEO getEntidad() {
		return entidad;
	}
	public void setEntidad(EntidadEO entidad) {
		this.entidad = entidad;
	}
	public GeozonaParticionEO getRegion() {
		return region;
	}
	public void setRegion(GeozonaParticionEO region) {
		this.region = region;
	}
	public MunicipioEO getMunicipio() {
		return municipio;
	}
	public void setMunicipio(MunicipioEO municipio) {
		this.municipio = municipio;
	}
	public SeccionEO getSeccion() {
		return seccion;
	}
	public void setSeccion(SeccionEO seccion) {
		this.seccion = seccion;
	}
	public Integer getAvance_cr() {
		return avance_cr;
	}
	public void setAvance_cr(Integer avance_cr) {
		this.avance_cr = avance_cr;
	}
	public Integer getMeta_cr() {
		return meta_cr;
	}
	public void setMeta_cr(Integer meta_cr) {
		this.meta_cr = meta_cr;
	}
	public Integer getPorcentaje_cr() {
		return porcentaje_cr;
	}
	public void setPorcentaje_cr(Integer porcentaje_cr) {
		this.porcentaje_cr = porcentaje_cr;
	}
	public Integer getAvance_cm() {
		return avance_cm;
	}
	public void setAvance_cm(Integer avance_cm) {
		this.avance_cm = avance_cm;
	}
	public Integer getMeta_cm() {
		return meta_cm;
	}
	public void setMeta_cm(Integer meta_cm) {
		this.meta_cm = meta_cm;
	}
	public Integer getPorcentaje_cm() {
		return porcentaje_cm;
	}
	public void setPorcentaje_cm(Integer porcentaje_cm) {
		this.porcentaje_cm = porcentaje_cm;
	}
	public Integer getAvance_s() {
		return avance_s;
	}
	public void setAvance_s(Integer avance_s) {
		this.avance_s = avance_s;
	}
	public Integer getMeta_s() {
		return meta_s;
	}
	public void setMeta_s(Integer meta_s) {
		this.meta_s = meta_s;
	}
	public Integer getPorcentaje_s() {
		return porcentaje_s;
	}
	public void setPorcentaje_s(Integer porcentaje_s) {
		this.porcentaje_s = porcentaje_s;
	}
	public Integer getAvance_v() {
		return avance_v;
	}
	public void setAvance_v(Integer avance_v) {
		this.avance_v = avance_v;
	}
	public Integer getMeta_v() {
		return meta_v;
	}
	public void setMeta_v(Integer meta_v) {
		this.meta_v = meta_v;
	}
	public Integer getPorcentaje_v() {
		return porcentaje_v;
	}
	public void setPorcentaje_v(Integer porcentaje_v) {
		this.porcentaje_v = porcentaje_v;
	}


	
	
	
}
