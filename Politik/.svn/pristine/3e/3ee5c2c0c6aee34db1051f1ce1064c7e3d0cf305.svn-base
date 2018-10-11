package com.saganet.politik.database.catalogos;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

import com.saganet.politik.dominios.TiposCasillaDO;
import com.saganet.politik.modelos.JavaBeanT;

@Alias("CasillaEO")
public class CasillaEO extends JavaBeanT implements Serializable {
	private static final long serialVersionUID = 6296991097442792622L;

	private Integer id;
	private SeccionEO seccion;
	private TiposCasillaDO tipo;
	private String nombre;
	private String llave;

	@Override
	public String toString() {
		return "CasillaEO [id=" + id + ", seccion=" + seccion + ", tipo=" + tipo + ", nombre=" + nombre + ", llave="
				+ llave + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public SeccionEO getSeccion() {
		return seccion;
	}

	public void setSeccion(SeccionEO seccion) {
		this.seccion = seccion;
	}

	public TiposCasillaDO getTipo() {
		return tipo;
	}

	public void setTipo(TiposCasillaDO tipo) {
		this.tipo = tipo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getLlave() {
		return llave;
	}

	public void setLlave(String llave) {
		this.llave = llave;
	}

}
