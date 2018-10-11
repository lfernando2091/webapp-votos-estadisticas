package com.saganet.politik.database.catalogos;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

import com.saganet.politik.modelos.JavaBeanT;

@Alias("TipoClaveEO")
public class TipoClaveEO extends JavaBeanT implements Serializable {
	private static final long serialVersionUID = 7177846516096161298L;

	private Integer id;
	private String nombre;

	@Override
	public String toString() {
		return "TipoClaveEO [id=" + id + ", nombre=" + nombre + "]";
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
