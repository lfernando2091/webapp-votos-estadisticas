package com.saganet.politik.database.eventos;

import com.saganet.politik.database.catalogos.DependenciaEO;
import com.saganet.politik.database.mdm.PersonaEO;
import com.saganet.politik.modelos.JavaBeanT;
import java.io.Serializable;
import org.apache.ibatis.type.Alias;

@Alias("ResponsableEO")
public class ResponsableEO extends JavaBeanT implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer id;
	private PersonaEO persona;
	private EventoSocialEO evento;
	private DependenciaEO dependencia;
	private String cargo;
	
	@Override
	public String toString() {
		return "ResponsableEO [id=" + id + ", persona=" + persona + ", evento=" + evento + ", dependencia="
				+ dependencia + ", cargo=" + cargo + "]";
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
}
