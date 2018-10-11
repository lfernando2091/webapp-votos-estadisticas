package com.saganet.politik.tablas.utilidades;

import java.io.Serializable;
import java.util.List;

import com.saganet.politik.dominios.MesDO;


public class MesesT implements Serializable {
	private static final long serialVersionUID = 2606213534259760986L;

	private List<MesDO> listado;
	private MesDO seleccionado;
	
	public List<MesDO> getListado() {
		return listado;
	}
	public void setListado(List<MesDO> listado) {
		this.listado = listado;
	}
	public MesDO getSeleccionado() {
		return seleccionado;
	}
	public void setSeleccionado(MesDO seleccionado) {
		this.seleccionado = seleccionado;
	}
}
