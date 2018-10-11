package com.saganet.politik.database.encuestas.syncdm;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

import com.saganet.politik.dominios.syncdm.TipoAccionDO;
import com.saganet.politik.modelos.JavaBeanT;
@Alias("SyncDMRespuestaEO")
public class RespuestaEO extends JavaBeanT implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4815741943585858640L;
	private Integer id;
	private String respuestaC;
	private TipoAccionDO tipoAccion;
	private String valorAccion;
	EstatusEncuestaEO idEncuestaEstatus;
	@Override
	public String toString() {
		return "RespuestaEO [id=" + id + ", respuestaC=" + respuestaC + ", tipoAccion=" + tipoAccion + ", valorAccion="
				+ valorAccion + ", idEncuestaEstatus=" + idEncuestaEstatus + "]";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getRespuestaC() {
		return respuestaC;
	}
	public void setRespuestaC(String respuestaC) {
		this.respuestaC = respuestaC;
	}
	public TipoAccionDO getTipoAccion() {
		return tipoAccion;
	}
	public void setTipoAccion(TipoAccionDO tipoAccion) {
		this.tipoAccion = tipoAccion;
	}
	public String getValorAccion() {
		return valorAccion;
	}
	public void setValorAccion(String valorAccion) {
		this.valorAccion = valorAccion;
	}
	public EstatusEncuestaEO getIdEncuestaEstatus() {
		return idEncuestaEstatus;
	}
	public void setIdEncuestaEstatus(EstatusEncuestaEO idEncuestaEstatus) {
		this.idEncuestaEstatus = idEncuestaEstatus;
	}
	
	
}
