package com.saganet.politik.database.catalogos;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.saganet.politik.database.gis.GeoDataEO;
import com.saganet.politik.modelos.JavaBeanT;

@Alias("EntidadEO")
public class EntidadEO extends JavaBeanT implements Serializable{
	private static final long serialVersionUID = -60083829599300485L;

	private Integer id;
	private String nombre;
	private GeoDataEO geoData;
	private String llave;

	public EntidadEO() {
		super();
	}

	public EntidadEO(Integer id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}
	
	public boolean contieneTerritorio(JavaBeanT territorio){
		return territorio.equals(this);
	}

	

	@Override
	public String toString() {
		return "EntidadEO [id=" + id + ", nombre=" + nombre + ", geoData=" + geoData + ", llave=" + llave + "]";
	}

	@Override
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	@JsonIgnore
	public String getLlave() {
		return llave;
	}

	public void setLlave(String llave) {
		this.llave = llave;
	}
	
	@JsonIgnore
	public String getNombreCompleto(){
		return getNombre();
	}

	public GeoDataEO getGeoData() {
		return geoData;
	}

	public void setGeoData(GeoDataEO geoData) {
		this.geoData = geoData;
	}
}
