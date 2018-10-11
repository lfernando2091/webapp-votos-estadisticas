package com.saganet.politik.database.catalogos;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.saganet.politik.database.gis.GeoDataEO;
import com.saganet.politik.modelos.JavaBeanT;

@Alias("MunicipioEO")
public class MunicipioEO extends JavaBeanT implements Serializable {
	private static final long serialVersionUID = 247255681670093596L;

	private Integer id;
	private Integer idMunicipio;
	private EntidadEO entidad;
	private String nombre;
	private String llave;
	private GeoDataEO geoData;

	@Override
	public String toString() {
		return "MunicipioEO [id=" + id + ", idMunicipio=" + idMunicipio + ", entidad=" + entidad + ", nombre=" + nombre
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

	public Integer getIdMunicipio() {
		return idMunicipio;
	}

	public void setIdMunicipio(Integer idMunicipio) {
		this.idMunicipio = idMunicipio;
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
