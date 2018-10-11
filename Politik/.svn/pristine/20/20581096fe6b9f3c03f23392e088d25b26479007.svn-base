package com.saganet.politik.database.eventos;


import com.saganet.politik.database.catalogos.ProgramaEO;
import com.saganet.politik.database.catalogos.ProgramaEjercicioEO;
import com.saganet.politik.database.mdm.PersonaEO;
import com.saganet.politik.modelos.JavaBeanT;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;


@Alias("BeneficiarioEO")
public class BeneficiarioEO extends JavaBeanT implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer id;
	private EventoSocialEO evento;
	private PersonaEO persona;
	private ProgramaEO programa;
	private ProgramaEjercicioEO ejercicio;

	@Override
	public String toString() {
		return "BeneficiarioEO [id=" + id + ", evento=" + evento + ", persona=" + persona + ", programa=" + programa
				+ ", ejercicio=" + ejercicio + "]";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public EventoSocialEO getEvento() {
		return evento;
	}
	public void setEvento(EventoSocialEO evento) {
		this.evento = evento;
	}
	public PersonaEO getPersona() {
		return persona;
	}
	public void setPersona(PersonaEO persona) {
		this.persona = persona;
	}
	public ProgramaEO getPrograma() {
		return programa;
	}
	public void setPrograma(ProgramaEO programa) {
		this.programa = programa;
	}
	public ProgramaEjercicioEO getEjercicio() {
		return ejercicio;
	}
	public void setEjercicio(ProgramaEjercicioEO ejercicio) {
		this.ejercicio = ejercicio;
	}
	
}
