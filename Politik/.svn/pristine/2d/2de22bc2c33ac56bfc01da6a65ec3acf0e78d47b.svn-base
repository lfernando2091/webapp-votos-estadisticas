package com.saganet.politik.database.estructuras;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.type.Alias;

import com.saganet.politik.database.catalogos.GeozonaEO;
import com.saganet.politik.dominios.FiguraAtributosDO;
import com.saganet.politik.dominios.NivelesDO;
import com.saganet.politik.modelos.JavaBeanT;

@Alias("FiguraEO")
public class FiguraEO extends JavaBeanT implements Serializable {
	private static final long serialVersionUID = 6046211172722991229L;

	private Integer id;
	private NivelesDO nivel;
	private String nombre;
	private GeozonaEO geozona;
	private Integer idGeozona;
	private Boolean jerarquico;
	private List<FiguraAtributosDO> atributos;
	
	public FiguraEO(){
		nivel = NivelesDO.ENTIDAD;
		jerarquico = false;
		atributos = new ArrayList<>();
	}

	@Override
	public String toString() {
		return "FiguraEO [id=" + id + ", nivel=" + nivel + ", nombre=" + nombre + ", geozona=" + geozona
				+ ", idGeozona=" + idGeozona + ", jerarquico=" + jerarquico + ", atributos=" + atributos + "]";
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

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public GeozonaEO getGeozona() {
		return geozona;
	}

	public void setGeozona(GeozonaEO geozona) {
		this.geozona = geozona;
	}

	public Integer getIdGeozona() {
		return idGeozona;
	}

	public void setIdGeozona(Integer idGeozona) {
		this.idGeozona = idGeozona;
	}

	public Boolean getJerarquico() {
		return jerarquico;
	}

	public void setJerarquico(Boolean jerarquico) {
		this.jerarquico = jerarquico;
	}

	public List<FiguraAtributosDO> getAtributos() {
		return atributos;
	}

	public void setAtributos(List<FiguraAtributosDO> atributos) {
		this.atributos = atributos;
	}
}
