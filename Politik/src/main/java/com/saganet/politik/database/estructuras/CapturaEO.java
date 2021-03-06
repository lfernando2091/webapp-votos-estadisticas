package com.saganet.politik.database.estructuras;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.type.Alias;

import com.saganet.politik.database.catalogos.DependenciaEO;
import com.saganet.politik.database.catalogos.EleccionEO;
import com.saganet.politik.database.mdm.PersonaEO;
import com.saganet.politik.dominios.CargosDependenciaDO;
import com.saganet.politik.modelos.JavaBeanT;

@Alias("EstructurasCapturaEO")
public class CapturaEO extends JavaBeanT implements Serializable {
	private static final long serialVersionUID = 1869647800401555906L;

	private Integer id;
	// Generales
	private PersonaEO persona;
	private PersonaEO personaPadre;
	private NodoEO nodo;
	private JavaBeanT territorio;
	private HashMap<String, List<FiguraAtributoEO>> mapaAtributos;
	// Dependencia
	private DependenciaEO dependencia;
	private CargosDependenciaDO cargo;
	private Date fechaInicio;
	private Date fechaTermino;
	private Boolean vigente;
	// Eleccion
	private EleccionEO eleccion;
	
	public CapturaEO() {
		vigente = true;
		cargo = CargosDependenciaDO.SECRETARIO;
		mapaAtributos = new HashMap<>();
	}

	@Override
	public String toString() {
		return "CapturaEO [id=" + id + ", persona=" + persona + ", personaPadre=" + personaPadre + ", nodo=" + nodo
				+ ", territorio=" + territorio + ", mapaAtributos=" + mapaAtributos + ", dependencia=" + dependencia
				+ ", cargo=" + cargo + ", fechaInicio=" + fechaInicio + ", fechaTermino=" + fechaTermino + ", vigente="
				+ vigente + ", eleccion=" + eleccion + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public PersonaEO getPersona() {
		return persona;
	}

	public void setPersona(PersonaEO persona) {
		this.persona = persona;
	}

	public PersonaEO getPersonaPadre() {
		return personaPadre;
	}

	public void setPersonaPadre(PersonaEO personaPadre) {
		this.personaPadre = personaPadre;
	}

	public NodoEO getNodo() {
		return nodo;
	}

	public void setNodo(NodoEO nodo) {
		this.nodo = nodo;
	}

	public JavaBeanT getTerritorio() {
		return territorio;
	}

	public void setTerritorio(JavaBeanT territorio) {
		this.territorio = territorio;
	}

	public HashMap<String, List<FiguraAtributoEO>> getMapaAtributos() {
		return mapaAtributos;
	}

	public void setMapaAtributos(HashMap<String, List<FiguraAtributoEO>> mapaAtributos) {
		this.mapaAtributos = mapaAtributos;
	}

	public DependenciaEO getDependencia() {
		return dependencia;
	}

	public void setDependencia(DependenciaEO dependencia) {
		this.dependencia = dependencia;
	}

	public CargosDependenciaDO getCargo() {
		return cargo;
	}

	public void setCargo(CargosDependenciaDO cargo) {
		this.cargo = cargo;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaTermino() {
		return fechaTermino;
	}

	public void setFechaTermino(Date fechaTermino) {
		this.fechaTermino = fechaTermino;
	}

	public Boolean getVigente() {
		return vigente;
	}

	public void setVigente(Boolean vigente) {
		this.vigente = vigente;
	}

	public EleccionEO getEleccion() {
		return eleccion;
	}

	public void setEleccion(EleccionEO eleccion) {
		this.eleccion = eleccion;
	}

}
