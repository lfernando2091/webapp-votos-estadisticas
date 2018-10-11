package com.saganet.politik.database.estructuras;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

import com.saganet.politik.modelos.JavaBeanT;

@Alias("NodoMetaEO")
public class NodoMetaEO extends JavaBeanT implements Serializable {
	private static final long serialVersionUID = -6811426526741039025L;

	private Integer id;
	private String llave;
	private JavaBeanT territorio;
	private Integer meta;
	private Integer avance;
	
	@Override
	public String toString() {
		return "NodoMetaEO [id=" + id + ", llave=" + llave + ", territorio=" + territorio + ", meta=" + meta
				+ ", avance=" + avance + "]";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getLlave() {
		return llave;
	}
	public void setLlave(String llave) {
		this.llave = llave;
	}
	public JavaBeanT getTerritorio() {
		return territorio;
	}
	public void setTerritorio(JavaBeanT territorio) {
		this.territorio = territorio;
	}
	public Integer getMeta() {
		return meta;
	}
	public void setMeta(Integer meta) {
		this.meta = meta;
	}
	/**
	 * @return the avance
	 */
	public Integer getAvance() {
		return avance;
	}
	/**
	 * @param avance the avance to set
	 */
	public void setAvance(Integer avance) {
		this.avance = avance;
	}
	
}
