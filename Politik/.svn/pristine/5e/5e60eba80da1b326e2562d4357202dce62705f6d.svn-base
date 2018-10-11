package com.saganet.politik.database.mdm;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

import com.saganet.politik.database.catalogos.EntidadEO;
import com.saganet.politik.database.catalogos.TipoClaveEO;
import com.saganet.politik.modelos.JavaBeanT;

@Alias("PersonaClaveEO")
public class PersonaClaveEO extends JavaBeanT implements Serializable {
	private static final long serialVersionUID = -5271481032811959064L;

	private Integer id;
	private TipoClaveEO tipo;
	private EntidadEO entidad;
	private String clave;

	@Override
	public String toString() {
		return "PersonaClaveEO [id=" + id + ", tipo=" + tipo + ", entidad=" + entidad + ", clave=" + clave + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public TipoClaveEO getTipo() {
		return tipo;
	}

	public void setTipo(TipoClaveEO tipo) {
		this.tipo = tipo;
	}

	public EntidadEO getEntidad() {
		return entidad;
	}

	public void setEntidad(EntidadEO entidad) {
		this.entidad = entidad;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

}
