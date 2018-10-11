package com.saganet.politik.database.encuestas.edomex2017.v2;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

import com.saganet.politik.modelos.JavaBeanT;

@Alias("Edomex2017V2CalificacionEntrevistaEO")
public class CalificacionEntrevistaEO extends JavaBeanT implements Serializable {
/**
	 * 
	 */
	private static final long serialVersionUID = -4542686243187362284L;
private Integer id;
private Integer idTerritorio;
private String territorio;

private Integer idRegion;
private String nombreRegion;
private Integer idMunicipio;
private String nombreMunicipio;

private Integer aFavor;
private Integer indecisoAFavor;
private Integer indeciso;
private Integer indecisoEnContra;
private Integer enContra;



@Override
public String toString() {
	return "CalificacionEntrevistaEO [id=" + id + ", idTerritorio=" + idTerritorio + ", territorio=" + territorio
			+ ", idRegion=" + idRegion + ", nombreRegion=" + nombreRegion + ", idMunicipio=" + idMunicipio
			+ ", nombreMunicipio=" + nombreMunicipio + ", aFavor=" + aFavor + ", indecisoAFavor=" + indecisoAFavor
			+ ", indeciso=" + indeciso + ", indecisoEnContra=" + indecisoEnContra + ", enContra=" + enContra + "]";
}
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public Integer getIdTerritorio() {
	return idTerritorio;
}
public void setIdTerritorio(Integer idTerritorio) {
	this.idTerritorio = idTerritorio;
}
public String getTerritorio() {
	return territorio;
}
public void setTerritorio(String territorio) {
	this.territorio = territorio;
}
public Integer getIdRegion() {
	return idRegion;
}
public void setIdRegion(Integer idRegion) {
	this.idRegion = idRegion;
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
public Integer getaFavor() {
	return aFavor;
}
public void setaFavor(Integer aFavor) {
	this.aFavor = aFavor;
}
public Integer getIndecisoAFavor() {
	return indecisoAFavor;
}
public void setIndecisoAFavor(Integer indecisoAFavor) {
	this.indecisoAFavor = indecisoAFavor;
}
public Integer getIndeciso() {
	return indeciso;
}
public void setIndeciso(Integer indeciso) {
	this.indeciso = indeciso;
}
public Integer getIndecisoEnContra() {
	return indecisoEnContra;
}
public void setIndecisoEnContra(Integer indecisoEnContra) {
	this.indecisoEnContra = indecisoEnContra;
}
public Integer getEnContra() {
	return enContra;
}
public void setEnContra(Integer enContra) {
	this.enContra = enContra;
}

}
