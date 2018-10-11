package com.saganet.politik.database.catalogos;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

import com.saganet.politik.modelos.JavaBeanT;

@Alias("ProgramaEO")
public class ProgramaEO extends JavaBeanT implements Serializable {
	private static final long serialVersionUID = 3360018679966088902L;
	
	private Integer id;
	private DependenciaEO dependencia;
	private ProgramaEO programaPadre;
	private String programa;
	private String descripcion;
	private String observaciones;
	private Integer estrategia;
	private String nick;
	private String fecha;
	private String nickActualizacion;
	private String fechaActualizacion;
	
	@Override
	public String toString() {
		return "ProgramaEO [id=" + id + ", dependencia=" + dependencia + ", programaPadre=" + programaPadre
				+ ", programa=" + programa + ", descripcion=" + descripcion + ", observaciones=" + observaciones
				+ ", estrategia=" + estrategia + ", nick=" + nick + ", fecha=" + fecha + ", nickActualizacion="
				+ nickActualizacion + ", fechaActualizacion=" + fechaActualizacion + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public DependenciaEO getDependencia() {
		return dependencia;
	}

	public void setDependencia(DependenciaEO dependencia) {
		this.dependencia = dependencia;
	}

	public ProgramaEO getProgramaPadre() {
		return programaPadre;
	}

	public void setProgramaPadre(ProgramaEO programaPadre) {
		this.programaPadre = programaPadre;
	}

	public String getPrograma() {
		return programa;
	}

	public void setPrograma(String programa) {
		this.programa = programa;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public Integer getEstrategia() {
		return estrategia;
	}

	public void setEstrategia(Integer estrategia) {
		this.estrategia = estrategia;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getNickActualizacion() {
		return nickActualizacion;
	}

	public void setNickActualizacion(String nickActualizacion) {
		this.nickActualizacion = nickActualizacion;
	}

	public String getFechaActualizacion() {
		return fechaActualizacion;
	}

	public void setFechaActualizacion(String fechaActualizacion) {
		this.fechaActualizacion = fechaActualizacion;
	}
	
}
