package com.saganet.politik.database.catalogos;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.saganet.politik.modelos.JavaBeanT;


@Alias("ManzanaEO")
public class ManzanaEO extends JavaBeanT implements Serializable {
	private static final long serialVersionUID = -445606734604521843L;

	private Integer id;
	private Integer idManzana;
	private String nombre;
	private EntidadEO entidad;
	private MunicipioEO municipio;
	private SeccionEO seccion;
	private LocalidadEO localidad;
	private String llave;

	
	@Override
	public String toString() {
		return "ManzanaEO [id=" + id + ", idManzana=" + idManzana + ", nombre=" + nombre + ", entidad=" + entidad
				+ ", municipio=" + municipio + ", seccion=" + seccion + ", localidad=" + localidad + ", llave=" + llave
				+ "]";
	}

	public boolean contieneTerritorio(JavaBeanT territorio){
		return this.equals(territorio) || seccion.contieneTerritorio(territorio);
	}


	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdManzana() {
		return idManzana;
	}

	public void setIdManzana(Integer idManzana) {
		this.idManzana = idManzana;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public EntidadEO getEntidad() {
		return entidad;
	}

	public void setEntidad(EntidadEO entidad) {
		this.entidad = entidad;
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

	public LocalidadEO getLocalidad() {
		return localidad;
	}

	public void setLocalidad(LocalidadEO localidad) {
		this.localidad = localidad;
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
		
		nombre.append(localidad.getNombreCompleto());
		nombre.append(": ");
		nombre.append(seccion.getIdSeccion());
		nombre.append(":");
		nombre.append(this.idManzana);
		
		return nombre.toString();
	}

}
