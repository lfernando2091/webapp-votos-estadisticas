package com.saganet.politik.database.catalogos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.type.Alias;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.saganet.politik.modelos.JavaBeanT;

@Alias("GeozonaParticionEO")
public class GeozonaParticionEO extends JavaBeanT implements Serializable {

	private static final long serialVersionUID = 3615758099115478098L;
	private Integer id;
	private Integer idParticion;
	private String nombre;
	private String llave;
	private List<JavaBeanT> territorios;
	
	public GeozonaParticionEO() {
		territorios = new ArrayList<>();
	}
	
	@Override
	public String toString() {
		return "GeozonaParticionEO [id=" + id + ", idParticion=" + idParticion + ", nombre=" + nombre + ", llave="
				+ llave + ", territorios=" + territorios + "]";
	}
	
	public boolean contieneTerritorio(JavaBeanT territorio){
		boolean respuesta;
		String clase;
		
		respuesta = false;
		
		clase = null;
		if(!territorios.isEmpty()){
			clase = territorios.get(0).getClass().getSimpleName();
		}
		
		for(JavaBeanT t : territorios){
			switch(clase){
			case "EntidadEO":
				respuesta = ((EntidadEO) t).equals(territorio);
				break;
			case "DFederalEO":
				respuesta = ((DFederalEO) t).contieneTerritorio(territorio);
				break;
			case "DLocalEO":
				respuesta = ((DLocalEO) t).contieneTerritorio(territorio);
				break;
			case "MunicipioEO":
				respuesta = ((MunicipioEO) t).contieneTerritorio(territorio);
				break;
			case "LocalidadEO":
				respuesta = ((LocalidadEO) t).contieneTerritorio(territorio);
				break;
			case "ManzanaEO":
				respuesta = ((ManzanaEO) t).contieneTerritorio(territorio);
				break;
			case "SeccionEO":
				respuesta = ((SeccionEO) t).contieneTerritorio(territorio);
				break;
			}
		}
		
		return respuesta;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getIdParticion() {
		return idParticion;
	}
	public void setIdParticion(Integer idParticion) {
		this.idParticion = idParticion;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public List<JavaBeanT> getTerritorios() {
		return territorios;
	}
	public void setTerritorios(List<JavaBeanT> territorios) {
		this.territorios = territorios;
	}

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
}
