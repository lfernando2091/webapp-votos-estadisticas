package com.saganet.politik.database.cronograma;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

import com.saganet.politik.modelos.JavaBeanT;

@Alias("IconoEO")
public class IconoEO extends JavaBeanT implements Serializable {
	private static final long serialVersionUID = 3059020865755193501L;

	private Integer id;
	private String nombre;
	private String ruta;

	@Override
	public String toString() {
		return "IconoEO [id=" + id + ", nombre=" + nombre + ", ruta=" + ruta + "]";
	}

	@Override
	public boolean equals(Object obj) {
		IconoEO check;
		check = (IconoEO) obj;
		
		return this.id.equals(check.getId());
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

	public String getRuta() {
		return ruta;
	}

	public void setRuta(String ruta) {
		this.ruta = ruta;
	}
}
