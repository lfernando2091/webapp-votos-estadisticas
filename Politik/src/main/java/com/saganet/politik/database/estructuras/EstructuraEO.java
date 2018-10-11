package com.saganet.politik.database.estructuras;

import java.io.Serializable;
import java.util.List;

import org.apache.ibatis.type.Alias;

import com.saganet.politik.database.catalogos.TablaEO;
import com.saganet.politik.dominios.AmbitosDO;
import com.saganet.politik.dominios.NivelesDO;
import com.saganet.politik.modelos.JavaBeanT;
import com.saganet.politik.utilidades.diagram.DiagramModelPolitik;

@Alias("EstructuraEO")
public class EstructuraEO extends JavaBeanT implements Serializable {
	private static final long serialVersionUID = 8435102328864600220L;

	private Integer id;
	private NivelesDO nivel;
	private AmbitosDO ambito;
	private String nombre;
	private String observaciones;
	private TablaEO tabla;
	private List<NodoEO> nodos;
	private DiagramModelPolitik modelo;
	
	public EstructuraEO(){
		nivel = NivelesDO.ENTIDAD;
		ambito = AmbitosDO.GENERAL;
	}

	@Override
	public String toString() {
		return "EstructuraEO [id=" + id + ", nivel=" + nivel + ", ambito=" + ambito + ", nombre=" + nombre
				+ ", observaciones=" + observaciones + ", tabla=" + tabla + ", nodos=" + nodos + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public NivelesDO getNivel() {
		return nivel;
	}

	public void setNivel(NivelesDO nivel) {
		this.nivel = nivel;
	}

	public AmbitosDO getAmbito() {
		return ambito;
	}

	public void setAmbito(AmbitosDO ambito) {
		this.ambito = ambito;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public List<NodoEO> getNodos() {
		return nodos;
	}

	public void setNodos(List<NodoEO> nodos) {
		this.nodos = nodos;
	}

	public DiagramModelPolitik getModelo() {
		return modelo;
	}

	public void setModelo(DiagramModelPolitik modelo) {
		this.modelo = modelo;
	}

	public TablaEO getTabla() {
		return tabla;
	}

	public void setTabla(TablaEO tabla) {
		this.tabla = tabla;
	}

}
