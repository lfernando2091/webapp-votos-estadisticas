package com.saganet.politik.database.catalogos;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.saganet.politik.modelos.JavaBeanT;

@Alias("LocalidadEO")
public class LocalidadEO extends JavaBeanT implements Serializable {
	private static final long serialVersionUID = 6110753214176962368L;

	private Integer id;
	private Integer idLocalidad;
	private MunicipioEO municipio;
	private TipoLocalidadEO tipo;
	private String nombre;
	private String llave;

	@Override
	public String toString() {
		return "LocalidadEO [id=" + id + ", idLocalidad=" + idLocalidad + ", municipio=" + municipio + ", tipo=" + tipo
				+ ", nombre=" + nombre + ", llave=" + llave + "]";
	}
	
	public boolean contieneTerritorio(JavaBeanT territorio){
		return this.equals(territorio) || municipio.contieneTerritorio(territorio);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdLocalidad() {
		return idLocalidad;
	}

	public void setIdLocalidad(Integer idLocalidad) {
		this.idLocalidad = idLocalidad;
	}

	public MunicipioEO getMunicipio() {
		return municipio;
	}

	public void setMunicipio(MunicipioEO municipio) {
		this.municipio = municipio;
	}

	public TipoLocalidadEO getTipo() {
		return tipo;
	}

	public void setTipo(TipoLocalidadEO tipo) {
		this.tipo = tipo;
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
	
	@JsonIgnore
	public String getNombreCompleto(){
		StringBuilder nombre;
		
		nombre = new StringBuilder();
		
		nombre.append(municipio.getNombreCompleto());
		nombre.append(": ");
		nombre.append(this.nombre);
		
		return nombre.toString();
	}

}
