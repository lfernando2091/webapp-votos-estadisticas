package com.saganet.politik.database.eventos;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

import com.saganet.politik.dominios.PosturaDO;
import com.saganet.politik.modelos.JavaBeanT;
@Alias("MencionEO")
public class MencionEO extends JavaBeanT implements Serializable {

	private static final long serialVersionUID = 5739441478544453019L;
	
	private Integer id;
	private IntervencionEO intervencion;
	private String  descripcion;
	private String personaje;
	private PosturaDO postura;
	@Override
	public String toString() {
		return "MencionEO [id=" + id + ", intervencion=" + intervencion + ", descripcion=" + descripcion
				+ ", personaje=" + personaje + ", postura=" + postura + "]";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public IntervencionEO getIntervencion() {
		return intervencion;
	}
	public void setIntervencion(IntervencionEO intervencion) {
		this.intervencion = intervencion;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getPersonaje() {
		return personaje;
	}
	public void setPersonaje(String personaje) {
		this.personaje = personaje;
	}
	public PosturaDO getPostura() {
		return postura;
	}
	public void setPostura(PosturaDO postura) {
		this.postura = postura;
	}	
	
}
