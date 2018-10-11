package com.saganet.politik.database.estructuras;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

import com.saganet.politik.modelos.JavaBeanT;

@Alias("ProgramaPromocionEO")
public class ProgramaPromocionEO extends JavaBeanT implements Serializable {
	private static final long serialVersionUID = 7198505700192534164L;

	private Integer id;
	private String nombre;

	@Override
	public String toString() {
		return "ProgramaPromocionEO [id=" + id + ", nombre=" + nombre + "]";
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
