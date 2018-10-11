package com.saganet.politik.database.estructuras;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.type.Alias;

import com.saganet.politik.dominios.NivelesDO;
import com.saganet.politik.modelos.JavaBeanT;

@Alias("NodoEO")
public class NodoEO extends JavaBeanT implements Serializable {
	private static final long serialVersionUID = 2311068020102798549L;

	private Integer id;
	private FiguraEO figura;
	private String nodo;
	private Integer nivel;
	private List<NodoMetaEO> metas;

	public NodoEO(){
		metas = new ArrayList<>();
	}
	
	public NodoEO(FiguraEO figura, String nodo) {
		this.figura = figura;
		this.nodo = nodo;
		metas = new ArrayList<>();
	}
	
	@Override
	public String toString() {
		return "NodoEO [id=" + id + ", figura=" + figura + ", nodo=" + nodo + ", nivel=" + nivel + ", metas=" + metas
				+ "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public FiguraEO getFigura() {
		return figura;
	}

	public void setFigura(FiguraEO figura) {
		this.figura = figura;
	}

	public String getNodo() {
		return nodo;
	}

	public void setNodo(String nodo) {
		this.nodo = nodo;
	}

	public Integer getNivel() {
		return nivel;
	}

	public void setNivel(Integer nivel) {
		this.nivel = nivel;
	}

	public List<NodoMetaEO> getMetas() {
		return metas;
	}

	public void setMetas(List<NodoMetaEO> metas) {
		this.metas = metas;
	}

}
