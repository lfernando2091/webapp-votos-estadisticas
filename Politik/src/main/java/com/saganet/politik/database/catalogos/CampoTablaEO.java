package com.saganet.politik.database.catalogos;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

import com.saganet.politik.dominios.TiposCampoDO;
import com.saganet.politik.modelos.JavaBeanT;

@Alias("CampoTablaEO")
public class CampoTablaEO extends JavaBeanT implements Serializable{
	private static final long serialVersionUID = -1717535525963363335L;

	private Integer id;
	private String nombre;
	private TiposCampoDO tipo;

	@Override
	public String toString() {
		return "CampoTablaEO [id=" + id + ", nombre=" + nombre + ", tipo=" + tipo + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public TiposCampoDO getTipo() {
		return tipo;
	}

	public void setTipo(TiposCampoDO tipo) {
		this.tipo = tipo;
	}
}
