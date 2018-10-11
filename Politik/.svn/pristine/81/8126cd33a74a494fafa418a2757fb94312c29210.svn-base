package com.saganet.politik.database.sig;

import java.io.Serializable;
import java.util.List;

import org.apache.ibatis.type.Alias;
import org.primefaces.model.map.Polygon;

import com.saganet.politik.modelos.JavaBeanT;

import mx.com.saganet.peon.database.dominios.TiposPoligonoDO;


@Alias("PoligonoEO")
public class PoligonoEO extends JavaBeanT implements Serializable {
	private static final long serialVersionUID = -7204335932925821572L;

	private Integer id;
	private TiposPoligonoDO tipo;
	private String llave;
	private List<Polygon> poligonos;
	@Override
	public String toString() {
		return "PoligonoEO [id=" + id + ", tipo=" + tipo + ", llave=" + llave + ", poligonos=" + poligonos + "]";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public TiposPoligonoDO getTipo() {
		return tipo;
	}
	public void setTipo(TiposPoligonoDO tipo) {
		this.tipo = tipo;
	}
	public String getLlave() {
		return llave;
	}
	public void setLlave(String llave) {
		this.llave = llave;
	}
	public List<Polygon> getPoligonos() {
		return poligonos;
	}
	public void setPoligonos(List<Polygon> poligonos) {
		this.poligonos = poligonos;
	}

	

}
