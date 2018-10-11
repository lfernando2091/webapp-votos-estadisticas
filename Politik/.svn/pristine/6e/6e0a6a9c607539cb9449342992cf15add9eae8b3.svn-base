package com.saganet.politik.database.cronograma;

import java.io.Serializable;
import java.sql.Timestamp;

import org.apache.ibatis.type.Alias;

import com.saganet.politik.modelos.JavaBeanT;

@Alias("EventoEO")
public class EventoEO extends JavaBeanT implements Serializable {
	private static final long serialVersionUID = -2249005386713377616L;

	private Integer id;
	private String nombre;
	private Timestamp inicio;
	private Timestamp fin;
	private GrupoEO grupo;
	private String descripcion;
	private String descripcionHTML;
	private IconoEO icono;
	private Boolean concentrador;
	private Integer idPadre;

	@Override
	public String toString() {
		return "EventoEO [id=" + id + ", nombre=" + nombre + ", inicio=" + inicio + ", fin=" + fin + ", grupo=" + grupo
				+ ", descripcion=" + descripcion + ", descripcionHTML=" + descripcionHTML + ", icono=" + icono
				+ ", concentrador=" + concentrador + ", idPadre=" + idPadre + "]";
	}
	
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

	public Timestamp getInicio() {
		return inicio;
	}

	public void setInicio(Timestamp inicio) {
		this.inicio = inicio;
	}

	public Timestamp getFin() {
		return fin;
	}

	public void setFin(Timestamp fin) {
		this.fin = fin;
	}

	public GrupoEO getGrupo() {
		return grupo;
	}

	public void setGrupo(GrupoEO grupo) {
		this.grupo = grupo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDescripcionHTML() {
		return descripcionHTML;
	}

	public void setDescripcionHTML(String descripcionHTML) {
		this.descripcionHTML = descripcionHTML;
	}

	public IconoEO getIcono() {
		return icono;
	}

	public void setIcono(IconoEO icono) {
		this.icono = icono;
	}

	public Boolean getConcentrador() {
		return concentrador;
	}

	public void setConcentrador(Boolean concentrador) {
		this.concentrador = concentrador;
	}

	public Integer getIdPadre() {
		return idPadre;
	}

	public void setIdPadre(Integer idPadre) {
		this.idPadre = idPadre;
	}
}
