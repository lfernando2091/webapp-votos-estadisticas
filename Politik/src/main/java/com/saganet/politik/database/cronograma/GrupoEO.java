package com.saganet.politik.database.cronograma;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

import com.saganet.politik.modelos.JavaBeanT;

@Alias("GrupoEO")
public class GrupoEO extends JavaBeanT implements Serializable {
	private static final long serialVersionUID = 4048832018689005637L;

	private Integer id;
	private String nombre;

	@Override
	public String toString() {
		return "GrupoEO [id=" + id + ", nombre=" + nombre + "]";
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
}
