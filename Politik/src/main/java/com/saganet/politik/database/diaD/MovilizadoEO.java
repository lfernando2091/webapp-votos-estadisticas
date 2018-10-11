package com.saganet.politik.database.diaD;

import java.io.Serializable;
import org.apache.ibatis.type.Alias;

import com.saganet.politik.database.administracion.UsuarioEO;
import com.saganet.politik.dominios.CalificacionDO;
import com.saganet.politik.dominios.ProgramasEdoMexDO;
import com.saganet.politik.modelos.JavaBeanT;

@Alias("DiaDMovilizadoEO")
public class MovilizadoEO extends JavaBeanT implements Serializable {
	
	private static final long serialVersionUID = -6147451553202869253L;
	private Integer id;
	private Integer idRegion;
	private String region;
	private Integer idMunicipio;
	private String municipio;
	private Integer seccion;
	private MovilizadorEO movilizador;
	private String nombre;
	private String primerApellido;
	private String segundoApellido;
	private ProgramasEdoMexDO programa;
	private Integer folio;
	private CalificacionDO calificacion;
	private Boolean registroJornada;
	private String telefono;
	private String email;
	private String domicilio;
	private String calle;
	private String numExterior;
	private String numInterior;
	private String colonia;
	private String clave;
	private Boolean padron;
	private String fechaNac;
	private Integer cp;
	private boolean directo;
	private UsuarioEO usuario;
	//-------------------
	private String tipo;
	private String calif;

	
	
	@Override
	public String toString() {
		return "MovilizadoEO [id=" + id + ", idRegion=" + idRegion + ", region=" + region + ", idMunicipio="
				+ idMunicipio + ", municipio=" + municipio + ", seccion=" + seccion + ", movilizador=" + movilizador
				+ ", nombre=" + nombre + ", primerApellido=" + primerApellido + ", segundoApellido=" + segundoApellido
				+ ", programa=" + programa + ", folio=" + folio + ", calificacion=" + calificacion
				+ ", registroJornada=" + registroJornada + ", telefono=" + telefono + ", email=" + email
				+ ", domicilio=" + domicilio + ", calle=" + calle + ", numExterior=" + numExterior + ", numInterior="
				+ numInterior + ", colonia=" + colonia + ", clave=" + clave + ", padron=" + padron + ", fechaNac="
				+ fechaNac + ", cp=" + cp + ", directo=" + directo + ", usuario=" + usuario + ", tipo=" + tipo
				+ ", calif=" + calif + "]";
	}



	public String getCalif() {
		return calif;
	}



	public void setCalif(String calif) {
		this.calif = calif;
	}



	public String getTipo() {
		return tipo;
	}



	public void setTipo(String tipo) {
		this.tipo = tipo;
	}



	public Integer getCp() {
		return cp;
	}

	public void setCp(Integer cp) {
		this.cp = cp;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdRegion() {
		return idRegion;
	}

	public void setIdRegion(Integer idRegion) {
		this.idRegion = idRegion;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public Integer getIdMunicipio() {
		return idMunicipio;
	}

	public void setIdMunicipio(Integer idMunicipio) {
		this.idMunicipio = idMunicipio;
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public Integer getSeccion() {
		return seccion;
	}

	public void setSeccion(Integer seccion) {
		this.seccion = seccion;
	}

	public MovilizadorEO getMovilizador() {
		return movilizador;
	}

	public void setMovilizador(MovilizadorEO movilizador) {
		this.movilizador = movilizador;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre.toUpperCase();
	}

	public String getPrimerApellido() {
		return primerApellido;
	}

	public void setPrimerApellido(String primerApellido) {
		this.primerApellido = primerApellido.toUpperCase();
	}

	public String getSegundoApellido() {
		return segundoApellido;
	}

	public void setSegundoApellido(String segundoApellido) {
		this.segundoApellido = segundoApellido.toUpperCase();
	}

	public ProgramasEdoMexDO getPrograma() {
		return programa;
	}

	public void setPrograma(ProgramasEdoMexDO programa) {
		this.programa = programa;
	}

	public Integer getFolio() {
		return folio;
	}

	public void setFolio(Integer folio) {
		this.folio = folio;
	}

	public CalificacionDO getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(CalificacionDO calificacion) {
		this.calificacion = calificacion;
	}

	public Boolean getRegistroJornada() {
		return registroJornada;
	}

	public void setRegistroJornada(Boolean registroJornada) {
		this.registroJornada = registroJornada;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio.toUpperCase();
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle.toUpperCase();
	}

	public String getNumExterior() {
		return numExterior;
	}

	public void setNumExterior(String numExterior) {
		this.numExterior = numExterior.toUpperCase();
	}

	public String getNumInterior() {
		return numInterior;
	}

	public void setNumInterior(String numInterior) {
		this.numInterior = numInterior.toUpperCase();
	}

	public String getColonia() {
		return colonia;
	}

	public void setColonia(String colonia) {
		this.colonia = colonia.toUpperCase();
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave.toUpperCase();
	}

	public Boolean getPadron() {
		return padron;
	}

	public void setPadron(Boolean padron) {
		this.padron = padron;
	}

	public String getFechaNac() {
		return fechaNac;
	}

	public void setFechaNac(String fechaNac) {
		this.fechaNac = fechaNac;
	}

	public boolean isDirecto() {
		return directo;
	}

	public void setDirecto(boolean directo) {
		this.directo = directo;
	}

	public UsuarioEO getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioEO usuario) {
		this.usuario = usuario;
	}

}
