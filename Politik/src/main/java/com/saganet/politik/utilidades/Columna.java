package com.saganet.politik.utilidades;

import java.io.Serializable;

import com.saganet.politik.dominios.TiposColumnaDO;

public class Columna implements Serializable {
	private static final long serialVersionUID = 6679331974525657292L;

	private String header;
	private String propiedad;
	private TiposColumnaDO tipo;

	public Columna(String header, String propiedad, TiposColumnaDO tipo) {
		super();
		this.header = header;
		this.propiedad = propiedad;
		this.tipo = tipo;
	}

	public String getHeader() {
		return header;
	}

	public void setHeader(String header) {
		this.header = header;
	}

	public String getPropiedad() {
		return propiedad;
	}

	public void setPropiedad(String propiedad) {
		this.propiedad = propiedad;
	}

	public TiposColumnaDO getTipo() {
		return tipo;
	}

	public void setTipo(TiposColumnaDO tipo) {
		this.tipo = tipo;
	}

}
