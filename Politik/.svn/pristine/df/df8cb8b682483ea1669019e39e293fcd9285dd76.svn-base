package com.saganet.politik.database.diaD.reportes;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

import com.saganet.politik.modelos.JavaBeanT;

@Alias("DiaDReportesMetasMovilizadoresCompletoEO")
public class MetasMovilizadoresCompletoEO extends JavaBeanT implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5817754966279724740L;
	private Integer id;
	private Integer idRegion;
	private String region;
	private Integer idMunicipio;
	private String municipio;
	private Integer seccion;
	
	private Integer metaRowan;
	private Integer avanceRowan;
	private String porcentajeRowan;
	
	private Integer metaFitz;
	private Integer avanceFitz;
	private String porcentajeFitz;
	
	private Integer metaAbby;
	private Integer avanceAbby;
	private String porcentajeAbby;
	
	private Integer tMeta;
	private Integer tAvance;
	private String tPorcentaje; 
	
	@Override
	public String toString() {
		return "MetasMovilizadoresCompletoEO [id=" + id + ", idRegion=" + idRegion + ", region=" + region
				+ ", idMunicipio=" + idMunicipio + ", municipio=" + municipio + ", seccion=" + seccion + ", metaRowan="
				+ metaRowan + ", avanceRowan=" + avanceRowan + ", porcentajeRowan=" + porcentajeRowan + ", metaFitz="
				+ metaFitz + ", avanceFitz=" + avanceFitz + ", porcentajeFitz=" + porcentajeFitz + ", metaAbby="
				+ metaAbby + ", avancAbby=" + avanceAbby + ", porcentajeAbby=" + porcentajeAbby + "]";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getIdRegion() {
		return idRegion;
	}
	public void setIdRegion(Integer idRegion) {
		this.idRegion = idRegion;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public Integer getIdMunicipio() {
		return idMunicipio;
	}
	public void setIdMunicipio(Integer idMunicipio) {
		this.idMunicipio = idMunicipio;
	}
	public String getMunicipio() {
		return municipio;
	}
	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}
	public Integer getSeccion() {
		return seccion;
	}
	public void setSeccion(Integer seccion) {
		this.seccion = seccion;
	}
	public Integer getMetaRowan() {
		return metaRowan;
	}
	public void setMetaRowan(Integer metaRowan) {
		this.metaRowan = metaRowan;
	}
	public Integer getAvanceRowan() {
		return avanceRowan;
	}
	public void setAvanceRowan(Integer avanceRowan) {
		this.avanceRowan = avanceRowan;
	}
	public String getPorcentajeRowan() {
		return porcentajeRowan;
	}
	public void setPorcentajeRowan(String porcentajeRowan) {
		this.porcentajeRowan = porcentajeRowan;
	}
	public Integer getMetaFitz() {
		return metaFitz;
	}
	public void setMetaFitz(Integer metaFitz) {
		this.metaFitz = metaFitz;
	}
	public Integer getAvanceFitz() {
		return avanceFitz;
	}
	public void setAvanceFitz(Integer avanceFitz) {
		this.avanceFitz = avanceFitz;
	}
	public String getPorcentajeFitz() {
		return porcentajeFitz;
	}
	public void setPorcentajeFitz(String porcentajeFitz) {
		this.porcentajeFitz = porcentajeFitz;
	}
	public Integer getMetaAbby() {
		return metaAbby;
	}
	public void setMetaAbby(Integer metaAbby) {
		this.metaAbby = metaAbby;
	}
	public Integer getAvanceAbby() {
		return avanceAbby;
	}
	public void setAvanceAbby(Integer avanceAbby) {
		this.avanceAbby = avanceAbby;
	}
	public String getPorcentajeAbby() {
		return porcentajeAbby;
	}
	public void setPorcentajeAbby(String porcentajeAbby) {
		this.porcentajeAbby = porcentajeAbby;
	}
	public Integer gettMeta() {
		return  metaAbby+metaFitz + metaRowan;
	}
	public void settMeta(Integer tMeta) {
		this.tMeta = tMeta;
	}
	public Integer gettAvance() {
		return avanceAbby + avanceFitz+avanceRowan;
	}
	public void settAvance(Integer tAvance) {
		this.tAvance = tAvance;
	}
	public String gettPorcentaje() {
		return (avanceAbby + avanceFitz+avanceRowan)==0?"0%":Math.round(((avanceAbby + avanceFitz+avanceRowan)/(metaAbby+metaFitz + metaRowan))*100)+"%";
	}
	public void settPorcentaje(String tPorcentaje) {
		this.tPorcentaje = tPorcentaje;
	}

	
}
