package com.saganet.politik.beans.cronograma;

import java.io.Serializable;

import org.primefaces.extensions.event.timeline.TimelineSelectEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.saganet.politik.utilidades.TimelineEventPolitik;

public class TimelineB implements Serializable {
	private static final long serialVersionUID = 814786221974036513L;

	private static final Logger logger = LoggerFactory.getLogger(TimelineB.class);

	private TimelineEventPolitik eventoSeleccionado;

	public TimelineB() {
		eventoSeleccionado = new TimelineEventPolitik();
	}

	public void onSelect(TimelineSelectEvent seleccion) {
		TimelineEventPolitik evento;

		evento = (TimelineEventPolitik) seleccion.getTimelineEvent();

		this.eventoSeleccionado = evento;

		logger.debug("Evento Seleccionado: {}", this.eventoSeleccionado);
	}

	public TimelineEventPolitik getEventoSeleccionado() {
		logger.debug("Se obtiene evento seleccionado: {}", eventoSeleccionado);
		return eventoSeleccionado;
	}

	public void setEventoSeleccionado(TimelineEventPolitik eventoSeleccionado) {
		this.eventoSeleccionado = eventoSeleccionado;
	}

}
