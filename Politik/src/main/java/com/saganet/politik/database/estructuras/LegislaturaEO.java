package com.saganet.politik.database.estructuras;

import java.io.Serializable;
import java.sql.Date;

import org.apache.ibatis.type.Alias;

import com.saganet.politik.dominios.NivelesDO;
import com.saganet.politik.modelos.JavaBeanT;

@Alias("LegislaturaEO")
public class LegislaturaEO extends JavaBeanT implements Serializable {
	private static final long serialVersionUID = -7822747386153563005L;

	private Integer id;
	private NivelesDO nivel;
	private String llave;
	private JavaBeanT territorio;
	private Date fechaInicio;
	private Date fechaTermino;
	private String nombre;
	private Integer numero;
	
	public LegislaturaEO() {
		nivel = NivelesDO.NACIONAL;
	}

	@Override
	public String toString() {
		return "LegislaturaEO [id=" + id + ", nivel=" + nivel + ", llave=" + llave + ", territorio=" + territorio
				+ ", fechaInicio=" + fechaInicio + ", fechaTermino=" + fechaTermino + ", nombre=" + nombre + ", numero="
				+ numero + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public NivelesDO getNivel() {
		return nivel;
	}

	public void setNivel(NivelesDO nivel) {
		this.nivel = nivel;
	}

	public String getLlave() {
		return llave;
	}

	public void setLlave(String llave) {
		this.llave = llave;
	}

	public JavaBeanT getTerritorio() {
		return territorio;
	}

	public void setTerritorio(JavaBeanT territorio) {
		this.territorio = territorio;
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

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

}
