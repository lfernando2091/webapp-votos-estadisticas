package com.saganet.politik.database.encuestas.admin;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

import com.saganet.politik.modelos.JavaBeanT;

@Alias("CampaniaEO")
public class CampaniaEO extends JavaBeanT implements Serializable {
	private static final long serialVersionUID = -1896982579508692296L;
	
	private Integer id;
	private EncuestaEO encuesta;
	private String nombre;
	private String fecha;
	private String tablaContactos;
	private String nick;
	private String fechaRegistro;
	private Integer universoContactos;
	private Integer avanceContactos;
	
	@Override
	public String toString() {
		return "CampaniaEO [id=" + id + ", encuesta=" + encuesta + ", nombre=" + nombre + ", fecha=" + fecha
				+ ", tablaContactos=" + tablaContactos + ", nick=" + nick + ", fechaRegistro=" + fechaRegistro
				+ ", universoContactos=" + universoContactos + ", avanceContactos=" + avanceContactos + "]";
	}
	
	public Integer getId() {
		return id;
	}
	public EncuestaEO getEncuesta() {
		return encuesta;
	}
	public void setEncuesta(EncuestaEO encuesta) {
		this.encuesta = encuesta;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getTablaContactos() {
		return tablaContactos;
	}
	public void setTablaContactos(String tablaContactos) {
		this.tablaContactos = tablaContactos;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(String fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public Integer getUniversoContactos() {
		return universoContactos;
	}

	public void setUniversoContactos(Integer universoContactos) {
		this.universoContactos = universoContactos;
	}

	public Integer getAvanceContactos() {
		return avanceContactos;
	}

	public void setAvanceContactos(Integer avanceContactos) {
		this.avanceContactos = avanceContactos;
	}
	
}
