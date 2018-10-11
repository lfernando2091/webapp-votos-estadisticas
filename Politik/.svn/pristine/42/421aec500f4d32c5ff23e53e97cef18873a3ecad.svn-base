package com.saganet.politik.database.catalogos;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.saganet.politik.database.gis.GeoDataEO;
import com.saganet.politik.modelos.JavaBeanT;

@Alias("DfederalEO")
public class DFederalEO extends JavaBeanT implements Serializable {
	private static final long serialVersionUID = 6530201293564308183L;

	private Integer id;
	private Integer idDFederal;
	private EntidadEO entidad;
	private String nombre;
	private String llave;
	private GeoDataEO geoData;

	@Override
	public String toString() {
		return "DFederalEO [id=" + id + ", idDFederal=" + idDFederal + ", entidad=" + entidad + ", nombre=" + nombre
				+ ", llave=" + llave + ", geoData=" + geoData + "]";
	}
	
	public boolean contieneTerritorio(JavaBeanT territorio){
		return this.equals(territorio) || entidad.equals(territorio);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdDFederal() {
		return idDFederal;
	}

	public void setIdDFederal(Integer idDFederal) {
		this.idDFederal = idDFederal;
	}

	public EntidadEO getEntidad() {
		return entidad;
	}

	public void setEntidad(EntidadEO entidad) {
		this.entidad = entidad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getLlave() {
		return llave;
	}

	public void setLlave(String llave) {
		this.llave = llave;
	}

	public GeoDataEO getGeoData() {
		return geoData;
	}

	public void setGeoData(GeoDataEO geoData) {
		this.geoData = geoData;
	}
	
	@JsonIgnore
	public String getNombreCompleto(){
		StringBuilder nombre;
		
		nombre = new StringBuilder();
		
		nombre.append(entidad.getNombre());
		nombre.append(": ");
		nombre.append(this.nombre);
		
		return nombre.toString();
	}

}
