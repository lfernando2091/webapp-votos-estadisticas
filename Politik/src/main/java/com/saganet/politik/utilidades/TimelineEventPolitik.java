package com.saganet.politik.utilidades;

import java.util.Date;

import org.primefaces.extensions.model.timeline.TimelineEvent;

import com.saganet.politik.database.cronograma.EventoEO;

public class TimelineEventPolitik extends TimelineEvent {
	private static final long serialVersionUID = 7614350012835818249L;

	private EventoEO evento;

	@Override
	public String toString() {
		return "TimelineEventPolitik [evento=" + evento + " " + super.toString() + " ]";
	}

	public TimelineEventPolitik() {
		evento = new EventoEO();
	}

	public TimelineEventPolitik(EventoEO evento, Object data, Date startDate, Date endDate, Boolean editable,
			String group, String styleClass) {
		super(data, startDate, endDate, editable, group, styleClass);
		this.evento = evento;
	}

	public EventoEO getEvento() {
		return evento;
	}

	public void setEvento(EventoEO evento) {
		this.evento = evento;
	}

}
