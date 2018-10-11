package com.saganet.politik.database.encuestas.admin;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

import com.saganet.politik.modelos.JavaBeanT;

@Alias("ValorGraficaEO")
public class ValorGraficaEO extends JavaBeanT implements Serializable {
	private static final long serialVersionUID = -3397806834641365051L;
	
	private String campo;
	private Double valor;
	
	public ValorGraficaEO(String campo, Double valor) {
		this.campo = campo;
		this.valor = valor;
	}

	@Override
	public String toString() {
		return "ValorGraficaEO [campo=" + campo + ", valor=" + valor + "]";
	}

	public String getCampo() {
		return campo;
	}

	public void setCampo(String campo) {
		this.campo = campo;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}
	
}
