package com.saganet.politik.database.match;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

import com.saganet.politik.database.catalogos.TablaEO;
import com.saganet.politik.dominios.TiposMatchDO;
import com.saganet.politik.dominios.TiposObjetosDO;
import com.saganet.politik.modelos.JavaBeanT;

@Alias("MatchEO")
public class MatchEO extends JavaBeanT implements Serializable {
	private static final long serialVersionUID = -8023303647150043092L;
	
	private Integer id;
	private String nombre;
	private TiposObjetosDO objeto;
	private TiposMatchDO tipo;
	private String estatus;
	private TablaEO tabla;
	
	@Override
	public String toString() {
		return "MatchEO [id=" + id + ", nombre=" + nombre + ", objeto=" + objeto + ", tipo=" + tipo + ", estatus="
				+ estatus + ", tabla=" + tabla + "]";
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

	public TiposObjetosDO getObjeto() {
		return objeto;
	}

	public void setObjeto(TiposObjetosDO objeto) {
		this.objeto = objeto;
	}

	public TiposMatchDO getTipo() {
		return tipo;
	}

	public void setTipo(TiposMatchDO tipo) {
		this.tipo = tipo;
	}

	public String getEstatus() {
		return estatus;
	}

	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}

	public TablaEO getTabla() {
		return tabla;
	}

	public void setTabla(TablaEO tabla) {
		this.tabla = tabla;
	}

	
}