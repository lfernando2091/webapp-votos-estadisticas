package com.saganet.politik.database.eventos;

import com.saganet.politik.database.catalogos.DependenciaEO;
import com.saganet.politik.database.mdm.PersonaEO;
import com.saganet.politik.modelos.JavaBeanT;
import java.io.Serializable;
import org.apache.ibatis.type.Alias;

@Alias("PresidiumEO")
public class PresidiumEO extends JavaBeanT implements Serializable {

	private static final long serialVersionUID = 8576707178438913338L;
	private Integer id;
	private PersonaEO persona;
	private EventoSocialEO evento;
	private DependenciaEO dependencia;
	private String cargo;
	private  boolean presidio;
	@Override
	public String toString() {
		return "PresidiumEO [id=" + id + ", persona=" + persona + ", evento=" + evento + ", dependencia=" + dependencia
				+ ", cargo=" + cargo + ", presidio=" + presidio + "]";
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
	public EventoSocialEO getEvento() {
		return evento;
	}
	public void setEvento(EventoSocialEO evento) {
		this.evento = evento;
	}
	public DependenciaEO getDependencia() {
		return dependencia;
	}
	public void setDependencia(DependenciaEO dependencia) {
		this.dependencia = dependencia;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public boolean isPresidio() {
		return presidio;
	}
	public void setPresidio(boolean presidio) {
		this.presidio = presidio;
	}
}
