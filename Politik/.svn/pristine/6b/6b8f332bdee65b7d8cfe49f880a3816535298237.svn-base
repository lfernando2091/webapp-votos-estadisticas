package com.saganet.politik.database.warehouse;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

import com.saganet.politik.database.catalogos.EntidadEO;
import com.saganet.politik.database.mdm.PersonaEO;
import com.saganet.politik.modelos.JavaBeanT;

@Alias("AliadoEstrategicoEO")
public class AliadoEstrategicoEO extends JavaBeanT implements Serializable {
	private static final long serialVersionUID = 2591456432872195017L;
	
	private Integer id;
	private PersonaEO persona;
	private EntidadEO entidad;
	
	@Override
	public String toString() {
		return "AliadoEstrategicoEO [id=" + id + ", persona=" + persona + ", entidad=" + entidad + "]";
	}
	@Override
	public Integer getId() {
		return id;
	}
	public PersonaEO getPersona() {
		return persona;
	}
	public void setPersona(PersonaEO persona) {
		this.persona = persona;
	}
	public EntidadEO getEntidad() {
		return entidad;
	}
	public void setEntidad(EntidadEO entidad) {
		this.entidad = entidad;
	}
	
}
