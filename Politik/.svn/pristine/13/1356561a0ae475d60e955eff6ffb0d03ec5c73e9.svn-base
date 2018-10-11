package com.saganet.politik.database.eventos;

import com.saganet.politik.database.catalogos.ProgramaEjercicioEO;
import com.saganet.politik.modelos.JavaBeanT;
import java.io.Serializable;
import org.apache.ibatis.type.Alias;

@Alias("EventoEjercicioProgramaEO")
public class EventoEjercicioProgramaEO extends JavaBeanT implements Serializable {
	
	private static final long serialVersionUID = 2958149825338022635L;
	private Integer id;
	private EventoSocialEO eventoSocial;
	private ProgramaEjercicioEO programaEjercicio;
	@Override
	public String toString() {
		return "EventoProgramaEO [id=" + id + ", eventoSocial=" + eventoSocial + ", programaEjercicio="
				+ programaEjercicio + "]";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public EventoSocialEO getEventoSocial() {
		return eventoSocial;
	}
	public void setEventoSocial(EventoSocialEO eventoSocial) {
		this.eventoSocial = eventoSocial;
	}
	public ProgramaEjercicioEO getProgramaEjercicio() {
		return programaEjercicio;
	}
	public void setProgramaEjercicio(ProgramaEjercicioEO programaEjercicio) {
		this.programaEjercicio = programaEjercicio;
	}

}
