package com.saganet.politik.database_dm.sincronizacion;

import java.io.Serializable;

import com.saganet.politik.dominios_dm.CatMbrmDO;
import com.saganet.politik.dominios_dm.CatPersonajeDO;

public class OpinionPersonajeEO implements Serializable {

	private static final long serialVersionUID = 1394377339099530215L;
	private Integer id;
	private CatPersonajeDO personaje;
	private CatMbrmDO respuesta;
	
	@Override
	public String toString() {
		return "OpinionPersonajeEO [id=" + id + ", personaje=" + personaje + ", respuesta=" + respuesta + "]";
	}
	
	public CatPersonajeDO getPersonaje() {
		return personaje;
	}
	public void setPersonaje(CatPersonajeDO personaje) {
		this.personaje = personaje;
	}
	public CatMbrmDO getRespuesta() {
		return respuesta;
	}
	public void setRespuesta(CatMbrmDO respuesta) {
		this.respuesta = respuesta;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
}
