package com.saganet.politik.database.importaciones;

import java.io.Serializable;
import java.sql.Timestamp;
import org.apache.ibatis.type.Alias;

import com.saganet.politik.dominios.EstatusImportacionDO;
import com.saganet.politik.dominios.TiposImportacionesDO;
import com.saganet.politik.modelos.JavaBeanT;

@Alias("ImportacionesEO")
public class ImportacionesEO extends JavaBeanT implements Serializable {

	private static final long serialVersionUID = 5000048663022904465L;

	@Override
	public String toString() {
		return "ImportacionesEO [id=" + id + ", fecha=" + fecha + ", mapeoImportacion=" + mapeoImportacion
				+ ", estatus=" + estatus + "]";
	}
	
	private Integer id;
	private Timestamp fecha;
	private MapeoImportacionEO mapeoImportacion;
	private EstatusImportacionDO estatus;
	private TiposImportacionesDO tipo;

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Timestamp getFecha() {
		return fecha;
	}
	public void setFecha(Timestamp fecha) {
		this.fecha = fecha;
	}
	public MapeoImportacionEO getMapeoImportacion() {
		return mapeoImportacion;
	}
	public void setMapeoImportacion(MapeoImportacionEO mapeoImportacion) {
		this.mapeoImportacion = mapeoImportacion;
	}
	public EstatusImportacionDO getEstatus() {
		return estatus;
	}
	public void setEstatus(EstatusImportacionDO estatus) {
		this.estatus = estatus;
	}
	public TiposImportacionesDO getTipo() {
		return tipo;
	}
	public void setTipo(TiposImportacionesDO tipo) {
		this.tipo = tipo;
	}

}
