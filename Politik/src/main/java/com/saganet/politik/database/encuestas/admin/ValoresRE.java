package com.saganet.politik.database.encuestas.admin;
/*Clase para mandar como objeto los valores de una encuesta*/

public class ValoresRE {

	
	private String campo;
	private double valor;
	private double porcentaje;
	private double porcentajeContactos;
	
	
	@Override
	public String toString() {
		return "ValoresRE [campo=" + campo + ", valor=" + valor + ", porcentaje=" + porcentaje
				+ ", porcentajeContactos=" + porcentajeContactos + "]";
	}
	public String getCampo() {
		return campo;
	}
	public void setCampo(String campo) {
		this.campo = campo;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public double getPorcentaje() {
		return porcentaje;
	}
	public void setPorcentaje(double porcentaje) {
		this.porcentaje = porcentaje;
	}
	public double getPorcentajeContactos() {
		return porcentajeContactos;
	}
	public void setPorcentajeContactos(double porcentajeContactos) {
		this.porcentajeContactos = porcentajeContactos;
	}
	
	
	
	
}
