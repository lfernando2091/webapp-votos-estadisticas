package com.saganet.politik.database.encuestas.admin;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

import com.saganet.politik.modelos.JavaBeanT;

@Alias("ReglaResultadoEO")
public class ReglaResultadoEO extends JavaBeanT implements Serializable {
	private static final long serialVersionUID = 7576524533857386023L;
	
	private Integer id;
	private Integer idRegla;
	private String resultado;
	private String nick;
	private String fecha;
	
	@Override
	public String toString() {
		return "ReglaResultadoEO [id=" + id + ", idRegla=" + idRegla + ", resultado=" + resultado + ", nick=" + nick
				+ ", fecha=" + fecha + "]";
	}

	public Integer getId() {
		return id;
	}
	
	public Integer getIdRegla() {
		return idRegla;
	}
	public void setIdRegla(Integer idRegla) {
		this.idRegla = idRegla;
	}
	public String getResultado() {
		return resultado;
	}
	public void setResultado(String resultado) {
		this.resultado = resultado;
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
