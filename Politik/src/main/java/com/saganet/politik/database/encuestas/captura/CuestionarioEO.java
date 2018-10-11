package com.saganet.politik.database.encuestas.captura;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

import com.saganet.politik.database.encuestas.admin.CampaniaEO;
import com.saganet.politik.modelos.JavaBeanT;

@Alias("CuestionarioEO")
public class CuestionarioEO extends JavaBeanT implements Serializable {
	private static final long serialVersionUID = 577888645321206915L;
	
	private CampaniaEO campania;
	private ContactoEO contacto;
	private String estatus;
	
	@Override
	public String toString() {
		return "CuestionarioEO [campania=" + campania + ", contacto=" + contacto + ", estatus=" + estatus + "]";
	}

	public CampaniaEO getCampania() {
		return campania;
	}

	public void setCampania(CampaniaEO campania) {
		this.campania = campania;
	}

	public ContactoEO getContacto() {
		return contacto;
	}

	public void setContacto(ContactoEO contacto) {
		this.contacto = contacto;
	}

	public String getEstatus() {
		return estatus;
	}

	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}
	
}
