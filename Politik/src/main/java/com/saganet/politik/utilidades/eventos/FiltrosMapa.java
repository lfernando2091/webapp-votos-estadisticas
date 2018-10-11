package com.saganet.politik.utilidades.eventos;

import java.io.Serializable;
import java.sql.Timestamp;

import com.saganet.politik.database.catalogos.EntidadEO;
import com.saganet.politik.dominios.NivelesDO;

public class FiltrosMapa implements Serializable {
	private static final long serialVersionUID = 451236995756767922L;

	private Timestamp fechaInicio;
	private Timestamp fechaFinal;
	private NivelesDO nivel;
	private EntidadEO entidad;

	public FiltrosMapa() {
		nivel = NivelesDO.ENTIDAD;
	}

	@Override
	public String toString() {
		return "FiltrosMapa [fechaInicio=" + fechaInicio + ", fechaFinal=" + fechaFinal + ", nivel=" + nivel
				+ ", entidad=" + entidad + "]";
	}

	public Timestamp getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Timestamp fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Timestamp getFechaFinal() {
		return fechaFinal;
	}

	public void setFechaFinal(Timestamp fechaFinal) {
		this.fechaFinal = fechaFinal;
	}

	public NivelesDO getNivel() {
		return nivel;
	}

	public void setNivel(NivelesDO nivel) {
		this.nivel = nivel;
	}

	public EntidadEO getEntidad() {
		return entidad;
	}

	public void setEntidad(EntidadEO entidad) {
		this.entidad = entidad;
	}

}
