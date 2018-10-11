package com.saganet.politik.database.administracion;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

import com.saganet.politik.modelos.JavaBeanT;

@Alias("RolEO")
public class RolEO extends JavaBeanT implements Serializable {
	private static final long serialVersionUID = 2318129857455823024L;

	private Integer id;
	private String rol;
	private String descripcion;

	@Override
	public String toString() {
		return "RolEO [id=" + id + ", rol=" + rol + ", descripcion=" + descripcion + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}
