package com.saganet.politik.database.elecciones;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

import com.saganet.politik.database.catalogos.PartidoEO;
import com.saganet.politik.database.mdm.PersonaEO;
import com.saganet.politik.modelos.JavaBeanT;

@Alias("CandidatoEO")
public class CandidatoEO extends JavaBeanT implements Serializable {
	private static final long serialVersionUID = 1601474678823801914L;

	private Integer id;
	private PersonaEO persona;
	private JavaBeanT territorio;
	private PartidoEO partido;

	@Override
	public String toString() {
		return "CandidatoEO [id=" + id + ", persona=" + persona + ", territorio=" + territorio + ", partido=" + partido
				+ "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public PersonaEO getPersona() {
		return persona;
	}

	public void setPersona(PersonaEO persona) {
		this.persona = persona;
	}

	public JavaBeanT getTerritorio() {
		return territorio;
	}

	public void setTerritorio(JavaBeanT territorio) {
		this.territorio = territorio;
	}

	public PartidoEO getPartido() {
		return partido;
	}

	public void setPartido(PartidoEO partido) {
		this.partido = partido;
	}

}
