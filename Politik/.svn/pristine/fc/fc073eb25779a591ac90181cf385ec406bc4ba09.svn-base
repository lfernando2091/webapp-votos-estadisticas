package com.saganet.politik.database.catalogos;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

import com.saganet.politik.dominios.EsquemasParticionesDO;
import com.saganet.politik.modelos.JavaBeanT;

@Alias("TablaParticionEO")
public class TablaParticionEO extends JavaBeanT implements Serializable {
	private static final long serialVersionUID = 3106451474557287256L;

	private Integer id;
	private Integer idTabla;
	private Integer idParticion;
	private String particion;
	private EsquemasParticionesDO esquema;

	@Override
	public String toString() {
		return "TablaParticionEO [id=" + id + ", idTabla=" + idTabla + ", idParticion=" + idParticion + ", particion="
				+ particion + ", esquema=" + esquema + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdTabla() {
		return idTabla;
	}

	public void setIdTabla(Integer idTabla) {
		this.idTabla = idTabla;
	}

	public Integer getIdParticion() {
		return idParticion;
	}

	public void setIdParticion(Integer idParticion) {
		this.idParticion = idParticion;
	}

	public String getParticion() {
		return particion;
	}

	public void setParticion(String particion) {
		this.particion = particion;
	}

	public EsquemasParticionesDO getEsquema() {
		return esquema;
	}

	public void setEsquema(EsquemasParticionesDO esquema) {
		this.esquema = esquema;
	}
}
