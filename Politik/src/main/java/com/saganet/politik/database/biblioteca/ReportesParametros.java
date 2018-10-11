package com.saganet.politik.database.biblioteca;

import java.io.File;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component("ReportesParametros")
@Scope(value="session", proxyMode=ScopedProxyMode.TARGET_CLASS)
public class ReportesParametros {

	private File ar;
	
	private String rutaActual;
	
	private String rutaAnterior;

	public File getAr() {
		return ar;
	}

	public void setAr(File ar) {
		this.ar = ar;
	}

	public String getRutaActual() {
		return rutaActual;
	}

	public void setRutaActual(String rutaActual) {
		this.rutaActual = rutaActual;
	}

	public String getRutaAnterior() {
		return rutaAnterior;
	}

	public void setRutaAnterior(String rutaAnterior) {
		this.rutaAnterior = rutaAnterior;
	}
	
}