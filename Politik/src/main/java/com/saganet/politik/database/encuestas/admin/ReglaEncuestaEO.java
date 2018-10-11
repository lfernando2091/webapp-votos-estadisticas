package com.saganet.politik.database.encuestas.admin;

import java.io.Serializable;
import java.util.List;

import org.apache.ibatis.type.Alias;

import com.saganet.politik.modelos.JavaBeanT;

@Alias("ReglaEncuestaEO")
public class ReglaEncuestaEO extends JavaBeanT implements Serializable {
	private static final long serialVersionUID = 8491399991080921099L;
	
	private Integer id;
	private Integer idEncuesta;
	private String regla;
	private String script;
	private String descripcion;
	private String tipo;
	private String nick;
	private String fecha;
	private String aplica;
	private String noAplica;
	
	List<ReglaResultadoEO> reglasResultados;
	
	@Override
	public String toString() {
		return "ReglaEncuestaEO [id=" + id + ", idEncuesta=" + idEncuesta + ", regla=" + regla + ", script=" + script
				+ ", descripcion=" + descripcion + ", tipo=" + tipo + ", nick=" + nick + ", fecha=" + fecha
				+ ", aplica=" + aplica + ", noAplica=" + noAplica + ", reglasResultados=" + reglasResultados + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdEncuesta() {
		return idEncuesta;
	}

	public void setIdEncuesta(Integer idEncuesta) {
		this.idEncuesta = idEncuesta;
	}

	public String getRegla() {
		return regla;
	}

	public void setRegla(String regla) {
		this.regla = regla;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
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

	public String getScript() {
		return script;
	}

	public void setScript(String script) {
		this.script = script;
	}

	public String getAplica() {
		return aplica;
	}

	public void setAplica(String aplica) {
		this.aplica = aplica;
	}

	public String getNoAplica() {
		return noAplica;
	}

	public void setNoAplica(String noAplica) {
		this.noAplica = noAplica;
	}

	public List<ReglaResultadoEO> getReglasResultados() {
		return reglasResultados;
	}

	public void setReglasResultados(List<ReglaResultadoEO> reglasResultados) {
		this.reglasResultados = reglasResultados;
	}

}
