package com.saganet.politik.database.encuestas.admin;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

import com.saganet.politik.modelos.JavaBeanT;

@Alias("RespuestaCerradaEO")
public class RespuestaCerradaEO extends JavaBeanT implements Serializable {
	private static final long serialVersionUID = 399462197551997127L;
	
	private Integer id;
	private Integer idPregunta;
	private String respuesta;
	private String nick;
	private String fecha;
	
	@Override
	public String toString() {
		return "RespuestaCerradaEO [id=" + id + ", idPregunta=" + idPregunta + ", respuesta=" + respuesta + ", nick="
				+ nick + ", fecha=" + fecha + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdPregunta() {
		return idPregunta;
	}

	public void setIdPregunta(Integer idPregunta) {
		this.idPregunta = idPregunta;
	}
	
	public String getRespuesta() {
		return respuesta;
	}

	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

}
