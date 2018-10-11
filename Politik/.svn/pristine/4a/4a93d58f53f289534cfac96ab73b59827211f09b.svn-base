package com.saganet.politik.tablas.mdm;

import java.io.Serializable;
import java.util.List;

import com.saganet.politik.database.mdm.PersonaEO;

public class PersonasT implements Serializable {
	private static final long serialVersionUID = -8282101816546813745L;

	private List<PersonaEO> listado;
	private PersonaEO seleccionado;
	
	public Integer getKey() {
		if (seleccionado != null)
			return seleccionado.getId();
		else
			return -1;
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
	
	public List<PersonaEO> getListado() {
		return listado;
	}
	public void setListado(List<PersonaEO> listado) {
		this.listado = listado;
	}
	public PersonaEO getSeleccionado() {
		return seleccionado;
	}
	public void setSeleccionado(PersonaEO seleccionado) {
		this.seleccionado = seleccionado;
	}
}
