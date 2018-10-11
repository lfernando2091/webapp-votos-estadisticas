package com.saganet.politik.database.warehouse;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

import com.saganet.politik.database.catalogos.TipoTelefonoEO;
import com.saganet.politik.modelos.JavaBeanT;

@Alias("TelefonoEO")
public class TelefonoEO extends JavaBeanT implements Serializable {

	private static final long serialVersionUID = 3382251918030379238L;
	private Integer id;
	private TipoTelefonoEO tipo;
	private String telefono;
	private String ext;
	private String observaciones;
	
	@Override
	public String toString() {
		return "TelefonoEO [id=" + id + ", tipo=" + tipo + ", telefono=" + telefono + ", ext=" + ext
				+ ", observaciones=" + observaciones + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public TipoTelefonoEO getTipo() {
		return tipo;
	}

	public void setTipo(TipoTelefonoEO tipo) {
		this.tipo = tipo;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getExt() {
		return ext;
	}

	public void setExt(String ext) {
		this.ext = ext;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

}
