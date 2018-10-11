package com.saganet.politik.database.catalogos;

import java.io.Serializable;
import java.util.List;

import org.apache.ibatis.type.Alias;

import com.saganet.politik.modelos.JavaBeanT;

@Alias("PartidoEO")
public class PartidoEO extends JavaBeanT implements Serializable {
	private static final long serialVersionUID = 675357716118451958L;

	private Integer id;
	private String nombre;
	private String siglas;
	private Boolean coalicion;
	private List<PartidoEO> partidosCoalicion;
	private String combinaciones;

	public PartidoEO() {
		coalicion = new Boolean(false);
	}

	@Override
	public String toString() {
		return "PartidoEO [id=" + id + ", nombre=" + nombre + ", siglas=" + siglas + ", coalicion=" + coalicion
				+ ", partidosCoalicion=" + partidosCoalicion + ", combinaciones=" + combinaciones + "]";
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

	public String getSiglas() {
		return siglas;
	}

	public void setSiglas(String siglas) {
		this.siglas = siglas;
	}

	public Boolean getCoalicion() {
		return coalicion;
	}

	public void setCoalicion(Boolean coalicion) {
		this.coalicion = coalicion;
	}

	public List<PartidoEO> getPartidosCoalicion() {
		return partidosCoalicion;
	}

	public void setPartidosCoalicion(List<PartidoEO> partidosCoalicion) {
		this.partidosCoalicion = partidosCoalicion;
	}

	public String getCombinaciones() {
		return combinaciones;
	}

	public void setCombinaciones(String combinaciones) {
		this.combinaciones = combinaciones;
	}

}
