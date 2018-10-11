package com.saganet.politik.database.catalogos;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

import com.saganet.politik.dominios.TiposComisionCongresoUnionDO;
import com.saganet.politik.modelos.JavaBeanT;

@Alias("ComisionCongresoUnionEO")
public class ComisionCongresoUnionEO extends JavaBeanT implements Serializable {
	private static final long serialVersionUID = 4471885399474230255L;
	
	private Integer id;
	private String nombre;
	private TiposComisionCongresoUnionDO tipo;
	private Boolean diputados;
	private Boolean senadores;

	@Override
	public String toString() {
		return "ComisionCongresoUnionEO [id=" + id + ", nombre=" + nombre + ", tipo=" + tipo + ", diputados="
				+ diputados + ", senadores=" + senadores + "]";
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

	public TiposComisionCongresoUnionDO getTipo() {
		return tipo;
	}

	public void setTipo(TiposComisionCongresoUnionDO tipo) {
		this.tipo = tipo;
	}

	public Boolean getDiputados() {
		return diputados;
	}

	public void setDiputados(Boolean diputados) {
		this.diputados = diputados;
	}

	public Boolean getSenadores() {
		return senadores;
	}

	public void setSenadores(Boolean senadores) {
		this.senadores = senadores;
	}

}
