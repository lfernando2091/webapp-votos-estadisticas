package com.saganet.politik.utilidades;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Formateador implements Serializable {
	private static final long serialVersionUID = -7707491601937532045L;

	private SimpleDateFormat fFecha, fFecha2, fFecha3, fFecha4, fFecha5;
	private NumberFormat fEntero;

	public Formateador() {
		iniciarFecha();
		iniciarFecha2();
		iniciarFecha3();
		iniciarFecha4();
		iniciarFecha5();
		iniciarEntero();
	}

	public String fecha(Date fecha) {
		return fFecha.format(fecha);
	}

	public String fechaArchivo(Date fecha) {
		return fFecha2.format(fecha);
	}
	
	public String fechaCalendario(Date fecha){
		return fFecha3.format(fecha);
	}
	
	public String fechaHora(Timestamp timeStamp){
		return fFecha4.format(timeStamp);
	}
	
	public Date fechaStringToDate(String fecha){
		if(fecha == null){
			return null;
		}
		
		try {
			return new Date(fFecha5.parse(fecha).getTime());
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}

	public String entero(Integer entero) {
		return fEntero.format(entero);
	}

	private void iniciarFecha() {
		fFecha = new SimpleDateFormat("dd/MM/yyyy");
	}

	private void iniciarFecha2() {
		fFecha2 = new SimpleDateFormat("ddMMyyyy_HHmmss");
	}

	private void iniciarFecha3() {
		fFecha3 = new SimpleDateFormat("yyyy/MM/dd HH:mm");
	}
	
	private void iniciarFecha4() {
		fFecha4 = new SimpleDateFormat("dd/MM/yyyy HH:mm");
	}
	
	private void iniciarFecha5() {
		fFecha5 = new SimpleDateFormat("yyyy-MM-dd");
	}

	private void iniciarEntero() {
		fEntero = NumberFormat.getIntegerInstance();
	}
}
