package com.saganet.politik.database.catalogos;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import org.apache.ibatis.type.Alias;

import com.saganet.politik.dominios.TiposRepresentanteDO;
import com.saganet.politik.database.elecciones.CandidatoEO;
import com.saganet.politik.database.estructuras.EstructuraEO;
import com.saganet.politik.database.estructuras.ProgramaPromocionEO;
import com.saganet.politik.dominios.TiposEleccionDO;
import com.saganet.politik.modelos.JavaBeanT;

@Alias("EleccionEO")
public class EleccionEO extends JavaBeanT implements Serializable {
	private static final long serialVersionUID = -7226018733675579949L;

	private Integer id;
	private TiposEleccionDO tipo;
	private TiposRepresentanteDO representante;
	private Integer ejercicio;
	private Date fechaJornada;
	private String descripcion;
	private List<JavaBeanT> territorios;
	private List<PartidoEO> partidos;
	private List<EstructuraEO> estructuras;
	private List<CandidatoEO> candidatos;
	private List<ProgramaPromocionEO> programasPromocion;
	
	public EleccionEO(){
		tipo = TiposEleccionDO.ORDINARIA;
		representante = TiposRepresentanteDO.PRESIDENTE;
	}

	@Override
	public String toString() {
		return "EleccionEO [id=" + id + ", tipo=" + tipo + ", representante=" + representante + ", ejercicio="
				+ ejercicio + ", fechaJornada=" + fechaJornada + ", descripcion=" + descripcion + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public TiposEleccionDO getTipo() {
		return tipo;
	}

	public void setTipo(TiposEleccionDO tipo) {
		this.tipo = tipo;
	}

	public TiposRepresentanteDO getRepresentante() {
		return representante;
	}

	public void setRepresentante(TiposRepresentanteDO representante) {
		this.representante = representante;
	}

	public Integer getEjercicio() {
		return ejercicio;
	}

	public void setEjercicio(Integer ejercicio) {
		this.ejercicio = ejercicio;
	}

	public Date getFechaJornada() {
		return fechaJornada;
	}

	public void setFechaJornada(Date fechaJornada) {
		this.fechaJornada = fechaJornada;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<JavaBeanT> getTerritorios() {
		return territorios;
	}

	public void setTerritorios(List<JavaBeanT> territorios) {
		this.territorios = territorios;
	}

	public List<PartidoEO> getPartidos() {
		return partidos;
	}

	public void setPartidos(List<PartidoEO> partidos) {
		this.partidos = partidos;
	}

	public List<EstructuraEO> getEstructuras() {
		return estructuras;
	}

	public void setEstructuras(List<EstructuraEO> estructuras) {
		this.estructuras = estructuras;
	}

	public List<CandidatoEO> getCandidatos() {
		return candidatos;
	}

	public void setCandidatos(List<CandidatoEO> candidatos) {
		this.candidatos = candidatos;
	}

	public List<ProgramaPromocionEO> getProgramasPromocion() {
		return programasPromocion;
	}

	public void setProgramasPromocion(List<ProgramaPromocionEO> programasPromocion) {
		this.programasPromocion = programasPromocion;
	}

}
