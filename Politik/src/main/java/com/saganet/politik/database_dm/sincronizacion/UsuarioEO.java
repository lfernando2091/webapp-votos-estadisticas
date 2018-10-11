package com.saganet.politik.database_dm.sincronizacion;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

import com.saganet.politik.dominios_dm.EmpresaDO;
import com.saganet.politik.dominios_dm.EstatusUsuarioDO;
import com.saganet.politik.dominios_dm.RegionesDO;
@Alias("SincronizacionUsuarioEO")
public class UsuarioEO implements Serializable {
	private static final long serialVersionUID = -1285913591803067849L;
	private Integer id;
	private String usuario;
	private String password;
	private String nombre;
	private String primerApellido;
	private String segundoApellido;
	private Integer supervisor;
	private Integer borrado;
	private EmpresaDO empresa;
	private Integer admin;
	private RegionesDO region;
	private EstatusUsuarioDO estatus;

	@Override
	public String toString() {
		return "UsuarioEO [id=" + id + ", usuario=" + usuario + ", password=" + password + ", nombre=" + nombre
				+ ", primerApellido=" + primerApellido + ", segundoApellido=" + segundoApellido + ", supervisor="
				+ supervisor + ", borrado=" + borrado + ", empresa=" + empresa + ", admin=" + admin + ", region="
				+ region + ", estatus=" + estatus + "]";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getPrimerApellido() {
		return primerApellido;
	}
	public void setPrimerApellido(String primerApellido) {
		this.primerApellido = primerApellido;
	}
	public String getSegundoApellido() {
		return segundoApellido;
	}
	public void setSegundoApellido(String segundoApellido) {
		this.segundoApellido = segundoApellido;
	}
	public Integer getSupervisor() {
		return supervisor;
	}
	public void setSupervisor(Integer supervisor) {
		this.supervisor = supervisor;
	}
	public Integer getBorrado() {
		return borrado;
	}
	public void setBorrado(Integer borrado) {
		this.borrado = borrado;
	}
	public EmpresaDO getEmpresa() {
		return empresa;
	}
	public void setEmpresa(EmpresaDO empresa) {
		this.empresa = empresa;
	}
	public Integer getAdmin() {
		return admin;
	}
	public void setAdmin(Integer admin) {
		this.admin = admin;
	}
	public RegionesDO getRegion() {
		return region;
	}
	public void setRegion(RegionesDO region) {
		this.region = region;
	}
	public EstatusUsuarioDO getEstatus() {
		return estatus;
	}
	public void setEstatus(EstatusUsuarioDO estatus) {
		this.estatus = estatus;
	}
}
