package com.saganet.politik.database.match;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

import com.saganet.politik.modelos.JavaBeanT;

@Alias("MatchPersonaFuenteEO")
public class MatchPersonaFuenteEO extends JavaBeanT implements Serializable {
	private static final long serialVersionUID = 2370287072207715160L;
	
	private Integer id;
	private String nombre;
	private String apellidoPaterno;
	private String apellidoMaterno;
	private Integer dia;
	private Integer mes;
	private Integer anio;
	private Integer entidadNacimiento;
	private String genero;
	private String clave;
	
	@Override
	public String toString() {
		return "MatchPersonaFuenteEO [id=" + id + ", nombre=" + nombre + ", apellidoPaterno=" + apellidoPaterno
				+ ", apellidoMaterno=" + apellidoMaterno + ", dia=" + dia + ", mes=" + mes + ", anio=" + anio
				+ ", entidadNacimiento=" + entidadNacimiento + ", genero=" + genero + ", clave=" + clave + "]";
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

	public String getApellidoPaterno() {
		return apellidoPaterno;
	}

	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}

	public String getApellidoMaterno() {
		return apellidoMaterno;
	}

	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}

	public Integer getDia() {
		return dia;
	}

	public void setDia(Integer dia) {
		this.dia = dia;
	}

	public Integer getMes() {
		return mes;
	}

	public void setMes(Integer mes) {
		this.mes = mes;
	}

	public Integer getAnio() {
		return anio;
	}

	public void setAnio(Integer anio) {
		this.anio = anio;
	}

	public Integer getEntidadNacimiento() {
		return entidadNacimiento;
	}

	public void setEntidadNacimiento(Integer entidadNacimiento) {
		this.entidadNacimiento = entidadNacimiento;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}
	
}
