package com.saganet.politik.modelos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.primefaces.model.DualListModel;

@SuppressWarnings("serial")
public abstract class ModeloT<T extends JavaBeanT> implements Serializable, TablaI<T> {

	private List<T> listado;
	private T seleccionado;
	private List<T> seleccionMultiple;
	private DualListModel<T> modeloDual;
	
	public ModeloT() {
		seleccionMultiple = new ArrayList<T>();
	}

	public void setKey(Integer key) {
		if (listado != null)
			if (!listado.isEmpty())
				for (int i = 0; i < listado.size(); i++) {
					if (listado.get(i).getId().equals(key)) {
						seleccionado = listado.get(i);
					}
				}
	}

	public Integer getKey() {
		if (seleccionado != null)
			return seleccionado.getId();
		else
			return -1;
	}

	public List<T> getListado() {
		return listado;
	}

	public void setListado(List<T> listado) {
		this.listado = listado;
	}

	public T getSeleccionado() {
		return seleccionado;
	}

	public void setSeleccionado(T seleccionado) {
		this.seleccionado = seleccionado;
	}

	public List<T> getSeleccionMultiple() {
		return seleccionMultiple;
	}

	public void setSeleccionMultiple(List<T> seleccionMultiple) {
		this.seleccionMultiple = seleccionMultiple;
	}

	public DualListModel<T> getModeloDual() {
		return modeloDual;
	}

	public void setModeloDual(DualListModel<T> modeloDual) {
		this.modeloDual = modeloDual;
	}

}
