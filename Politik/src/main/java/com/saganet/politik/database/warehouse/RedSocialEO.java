package com.saganet.politik.database.warehouse;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

import com.saganet.politik.database.catalogos.TipoRedSocialEO;
import com.saganet.politik.modelos.JavaBeanT;

@Alias("RedSocialEO")
public class RedSocialEO extends JavaBeanT implements Serializable {
	private static final long serialVersionUID = 1094609778230183855L;

	private Integer id;
	private String usuario;
	private TipoRedSocialEO tipo;
	private String observaciones;

	@Override
	public String toString() {
		return "RedSocialEO [id=" + id + ", usuario=" + usuario + ", tipo=" + tipo + ", observaciones=" + observaciones
				+ "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public TipoRedSocialEO getTipo() {
		return tipo;
	}

	public void setTipo(TipoRedSocialEO tipo) {
		this.tipo = tipo;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

}
