package com.saganet.politik.database.eventos;


import java.io.Serializable;

import org.apache.ibatis.type.Alias;


import com.saganet.politik.modelos.JavaBeanT;
@Alias("IntervencionEO")
public class IntervencionEO extends JavaBeanT implements Serializable {
	
	private static final long serialVersionUID = -5464120940693776641L;
	private Integer id;
	private AsistenteEO asistente;
	private String  descripcion;
	@Override
	public String toString() {
		return "IntervencionEO [id=" + id + ", asistente=" + asistente + ", descripcion=" + descripcion + "]";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public AsistenteEO getAsistente() {
		return asistente;
	}
	public void setAsistente(AsistenteEO asistente) {
		this.asistente = asistente;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
}
