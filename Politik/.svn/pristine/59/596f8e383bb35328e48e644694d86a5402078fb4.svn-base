package com.saganet.politik.database.importaciones;

import java.io.Serializable;
import java.sql.Timestamp;

import org.apache.ibatis.type.Alias;

import com.saganet.politik.modelos.JavaBeanT;

@Alias("ImportacionesLogEO")
public class LogEO extends JavaBeanT implements Serializable {
	private static final long serialVersionUID = 8845589458414872399L;
	
	private Integer id;
	private Integer idImportacion;
	private String descripcion;
	private Timestamp fecha;

	@Override
	public String toString() {
		return "LogEO [id=" + id + ", idImportacion=" + idImportacion + ", descripcion=" + descripcion + ", fecha="
				+ fecha + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Timestamp getFecha() {
		return fecha;
	}

	public void setFecha(Timestamp fecha) {
		this.fecha = fecha;
	}

	public Integer getIdImportacion() {
		return idImportacion;
	}

	public void setIdImportacion(Integer idImportacion) {
		this.idImportacion = idImportacion;
	}
}
