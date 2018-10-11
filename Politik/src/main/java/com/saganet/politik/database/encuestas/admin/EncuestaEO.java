package com.saganet.politik.database.encuestas.admin;

import java.io.Serializable;
import java.util.List;

import org.apache.ibatis.type.Alias;

import com.saganet.politik.modelos.JavaBeanT;

@Alias("EncuestaEO")
public class EncuestaEO extends JavaBeanT implements Serializable {
	private static final long serialVersionUID = -4357900120624740316L;
	
	private Integer id;
	private String descripcion;
	private String nick;
	private String fecha;
	
	private List<PreguntaEO> preguntas;
	private List<ReglaEncuestaEO> reglasEncuestas;
	
	@Override
	public String toString() {
		return "EncuestaEO [id=" + id + ", descripcion=" + descripcion + ", nick=" + nick + ", fecha=" + fecha
				+ ", preguntas=" + preguntas + "]";
	}
	
	public List<PreguntaEO> getPreguntas() {
		return preguntas;
	}

	public void setPreguntas(List<PreguntaEO> preguntas) {
		this.preguntas = preguntas;
	}

	public Integer getId() {
		return id;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}

	public List<ReglaEncuestaEO> getReglasEncuestas() {
		return reglasEncuestas;
	}

	public void setReglasEncuestas(List<ReglaEncuestaEO> reglasEncuestas) {
		this.reglasEncuestas = reglasEncuestas;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	
}
