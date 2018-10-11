package com.saganet.politik.database.encuestas.hermanos;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

import com.saganet.politik.modelos.JavaBeanT;
@Alias("HermanosMovilizacionFCEO")
public class MovilizacionFCEO extends JavaBeanT implements Serializable {

	private static final long serialVersionUID = -7218033312851148606L;
	private Integer id;
	private String municipio;
	private String coordinador;
	private String casa;
	private String calle;
	private String numeroExterior;
	private String municipioCasaCiudadana;
	private String telefonoCasaCiudadana;
	private String seccion;
	private String movilizador;
	private String movilizado;
	private String domicilio;
	private String telefono;
	private String celular;
	private String claveElector;
	private String seccion1;
	private String nombre1;
	private String primerApellido1;
	private String segundoApellido1;
	private String obs;
	private Boolean cruzado;
	private Boolean primero;
	private Boolean segundo;
	private Boolean tercero;
	private Boolean seccionIgual;
	private Boolean nombreIgual;
	private String calificacion;
	
	
	
	@Override
	public String toString() {
		return "MovilizacionFCEO [id=" + id + ", municipio=" + municipio + ", coordinador=" + coordinador + ", casa="
				+ casa + ", calle=" + calle + ", numeroExterior=" + numeroExterior + ", municipioCasaCiudadana="
				+ municipioCasaCiudadana + ", telefonoCasaCiudadana=" + telefonoCasaCiudadana + ", seccion=" + seccion
				+ ", movilizador=" + movilizador + ", movilizado=" + movilizado + ", domicilio=" + domicilio
				+ ", telefono=" + telefono + ", celular=" + celular + ", claveElector=" + claveElector + ", seccion1="
				+ seccion1 + ", nombre1=" + nombre1 + ", primerApellido1=" + primerApellido1 + ", segundoApellido1="
				+ segundoApellido1 + ", obs=" + obs + ", cruzado=" + cruzado + ", primero=" + primero + ", segundo="
				+ segundo + ", tercero=" + tercero + ", seccionIgual=" + seccionIgual + ", nombreIgual=" + nombreIgual
				+ ", calificacion=" + calificacion + "]";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getMunicipio() {
		return municipio;
	}
	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}
	public String getCoordinador() {
		return coordinador;
	}
	public void setCoordinador(String coordinador) {
		this.coordinador = coordinador;
	}
	public String getCasa() {
		return casa;
	}
	public void setCasa(String casa) {
		this.casa = casa;
	}
	public String getCalle() {
		return calle;
	}
	public void setCalle(String calle) {
		this.calle = calle;
	}
	public String getNumeroExterior() {
		return numeroExterior;
	}
	public void setNumeroExterior(String numeroExterior) {
		this.numeroExterior = numeroExterior;
	}
	public String getMunicipioCasaCiudadana() {
		return municipioCasaCiudadana;
	}
	public void setMunicipioCasaCiudadana(String municipioCasaCiudadana) {
		this.municipioCasaCiudadana = municipioCasaCiudadana;
	}
	public String getTelefonoCasaCiudadana() {
		return telefonoCasaCiudadana;
	}
	public void setTelefonoCasaCiudadana(String telefonoCasaCiudadana) {
		this.telefonoCasaCiudadana = telefonoCasaCiudadana;
	}
	public String getSeccion() {
		return seccion;
	}
	public void setSeccion(String seccion) {
		this.seccion = seccion;
	}
	public String getMovilizador() {
		return movilizador;
	}
	public void setMovilizador(String movilizador) {
		this.movilizador = movilizador;
	}
	public String getMovilizado() {
		return movilizado;
	}
	public void setMovilizado(String movilizado) {
		this.movilizado = movilizado;
	}
	public String getDomicilio() {
		return domicilio;
	}
	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	public String getClaveElector() {
		return claveElector;
	}
	public void setClaveElector(String claveElector) {
		this.claveElector = claveElector;
	}
	public String getSeccion1() {
		return seccion1;
	}
	public void setSeccion1(String seccion1) {
		this.seccion1 = seccion1;
	}
	public String getNombre1() {
		return nombre1;
	}
	public void setNombre1(String nombre1) {
		this.nombre1 = nombre1;
	}
	public String getPrimerApellido1() {
		return primerApellido1;
	}
	public void setPrimerApellido1(String primerApellido1) {
		this.primerApellido1 = primerApellido1;
	}
	public String getSegundoApellido1() {
		return segundoApellido1;
	}
	public void setSegundoApellido1(String segundoApellido1) {
		this.segundoApellido1 = segundoApellido1;
	}
	public String getObs() {
		return obs;
	}
	public void setObs(String obs) {
		this.obs = obs;
	}
	public Boolean getCruzado() {
		return cruzado;
	}
	public void setCruzado(Boolean cruzado) {
		this.cruzado = cruzado;
	}
	public Boolean getPrimero() {
		return primero;
	}
	public void setPrimero(Boolean primero) {
		this.primero = primero;
	}
	public Boolean getSegundo() {
		return segundo;
	}
	public void setSegundo(Boolean segundo) {
		this.segundo = segundo;
	}
	public Boolean getTercero() {
		return tercero;
	}
	public void setTercero(Boolean tercero) {
		this.tercero = tercero;
	}
	public Boolean getSeccionIgual() {
		return seccionIgual;
	}
	public void setSeccionIgual(Boolean seccionIgual) {
		this.seccionIgual = seccionIgual;
	}
	public Boolean getNombreIgual() {
		return nombreIgual;
	}
	public void setNombreIgual(Boolean nombreIgual) {
		this.nombreIgual = nombreIgual;
	}
	public String getCalificacion() {
		return calificacion;
	}
	public void setCalificacion(String calificacion) {
		this.calificacion = calificacion;
	}
	
	
}
