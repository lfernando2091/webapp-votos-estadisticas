package com.saganet.politik.beans.estructuras;

import java.io.Serializable;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CapturaB implements Serializable {
	private static final long serialVersionUID = -218800029327260981L;

	private static final Logger logger = LoggerFactory.getLogger(CapturaB.class);
	
	private HashMap<String, Object> seleccionado;

	public HashMap<String, Object> getSeleccionado() {
		return seleccionado;
	}

	public void setSeleccionado(HashMap<String, Object> seleccionado) {
		logger.debug("Objeto CapturaBean recibido: {}", seleccionado);
		this.seleccionado = new HashMap<>(seleccionado);
	}
}
