package com.saganet.politik.database.encuestas.hermanos;

import org.apache.ibatis.type.Alias;

@Alias("HermanosListaRevisionEO")
public class ListaRevisionEO {
private Integer id;
private String primerNombre;
private String segundoNombre;
private String apellidoPaterno;
private String apellidoMaterno;
private String telefonoCasa;
private String calle;
private String numeroExterior;
private String numeroInterior;
private String colonia;
private String cveElector;
private String  seccion;
private String municipio;
private String impreso;
private Integer folio;
private String aprobado;
private String claveElector;
private String folioLeventamiento;
@Override
public String toString() {
	return "ListaRevisionEO [id=" + id + ", primerNombre=" + primerNombre + ", segundoNombre=" + segundoNombre
			+ ", apellidoPaterno=" + apellidoPaterno + ", apellidoMaterno=" + apellidoMaterno + ", telefonoCasa="
			+ telefonoCasa + ", calle=" + calle + ", numeroExterior=" + numeroExterior + ", numeroInterior="
			+ numeroInterior + ", colonia=" + colonia + ", cveElector=" + cveElector + ", seccion=" + seccion
			+ ", municipio=" + municipio + ", impreso=" + impreso + ", folio=" + folio + ", aprobado=" + aprobado
			+ ", claveElector=" + claveElector + ", folioLeventamiento=" + folioLeventamiento + "]";
}
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public String getPrimerNombre() {
	return primerNombre;
}
public void setPrimerNombre(String primerNombre) {
	this.primerNombre = primerNombre;
}
public String getSegundoNombre() {
	return segundoNombre;
}
public void setSegundoNombre(String segundoNombre) {
	this.segundoNombre = segundoNombre;
}
public String getApellidoPaterno() {
	return apellidoPaterno;
}
public void setApellidoPaterno(String apellidoPaterno) {
	this.apellidoPaterno = apellidoPaterno;
}
public String getApellidoMaterno() {
	return apellidoMaterno;
}
public void setApellidoMaterno(String apellidoMaterno) {
	this.apellidoMaterno = apellidoMaterno;
}
public String getTelefonoCasa() {
	return telefonoCasa;
}
public void setTelefonoCasa(String telefonoCasa) {
	this.telefonoCasa = telefonoCasa;
}
public String getCalle() {
	return calle;
}
public void setCalle(String calle) {
	this.calle = calle;
}
public String getNumeroExterior() {
	return numeroExterior;
}
public void setNumeroExterior(String numeroExterior) {
	this.numeroExterior = numeroExterior;
}
public String getNumeroInterior() {
	return numeroInterior;
}
public void setNumeroInterior(String numeroInterior) {
	this.numeroInterior = numeroInterior;
}
public String getColonia() {
	return colonia;
}
public void setColonia(String colonia) {
	this.colonia = colonia;
}
public String getCveElector() {
	return cveElector;
}
public void setCveElector(String cveElector) {
	this.cveElector = cveElector;
}
public String getSeccion() {
	return seccion;
}
public void setSeccion(String seccion) {
	this.seccion = seccion;
}
public String getMunicipio() {
	return municipio;
}
public void setMunicipio(String municipio) {
	this.municipio = municipio;
}
public String getImpreso() {
	return impreso;
}
public void setImpreso(String impreso) {
	this.impreso = impreso;
}
public Integer getFolio() {
	return folio;
}
public void setFolio(Integer folio) {
	this.folio = folio;
}
public String getAprobado() {
	return aprobado;
}
public void setAprobado(String aprobado) {
	this.aprobado = aprobado;
}
public String getClaveElector() {
	return claveElector;
}
public void setClaveElector(String claveElector) {
	this.claveElector = claveElector;
}
public String getFolioLeventamiento() {
	return folioLeventamiento;
}
public void setFolioLeventamiento(String folioLeventamiento) {
	this.folioLeventamiento = folioLeventamiento;
}




}
