package com.saganet.politik.utilidades.diagram;

import org.primefaces.model.diagram.Element;

import com.saganet.politik.modelos.JavaBeanT;

public class ElementPolitik extends Element {
	private static final long serialVersionUID = -3471442121143748332L;

	private JavaBeanT objeto;

	public ElementPolitik() {
		super();
		objeto = new JavaBeanT();
	}

	public ElementPolitik(JavaBeanT objeto, String texto, String x, String y) {
		super(texto, x, y);
		this.objeto = objeto;
	}

	public ElementPolitik(JavaBeanT objeto, String texto) {
		super(texto);
		this.objeto = objeto;
	}

	@Override
	public String toString() {
		return "ElementPolitik [objeto=" + objeto + "]";
	}

	public JavaBeanT getObjeto() {
		return objeto;
	}

	public void setObjeto(JavaBeanT objeto) {
		this.objeto = objeto;
	}

}
