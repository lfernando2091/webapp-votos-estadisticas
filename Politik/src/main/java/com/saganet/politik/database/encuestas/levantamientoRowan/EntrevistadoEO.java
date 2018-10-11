package com.saganet.politik.database.encuestas.levantamientoRowan;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

import com.saganet.politik.dominios.GenerosDO;
import com.saganet.politik.modelos.JavaBeanT;
@Alias("LevantamientoRowanEntrevistadoEO")
public class EntrevistadoEO extends JavaBeanT implements Serializable {

	private static final long serialVersionUID = -5314634127731897341L;
	private Integer id;
	private Integer entidad;
	private Integer regionEdomex2017;
	private String nombreRegion;
	private Integer municipio;
	private String nombreMunicipio;
	private Integer localidad;
	private String nombreLocalidad;
	private Integer seccion;
	private Integer manzana;
	private Integer idInterno;
	private String claveElector;
	private String apellidoPaterno;
	private String apellidoMaterno;
	private String nombre;
	private String fechaNacimiento;
	private String lugarNacimiento;
	private GenerosDO sexo;
	private String ocupacion;
	private String calle;
	private String numExterior;
	private String numInterior;
	private String colonia;
	private String codigoPostal;
	private String programaTodo;
	private String programaGeneral;
	private String estatus;
	private String grupo;
	private String calificacion;
	
	@Override
	public String toString() {
		return "EntrevistadoEO [id=" + id + ", entidad=" + entidad + ", regionEdomex2017=" + regionEdomex2017
				+ ", nombreRegion=" + nombreRegion + ", municipio=" + municipio + ", nombreMunicipio=" + nombreMunicipio
				+ ", localidad=" + localidad + ", nombreLocalidad=" + nombreLocalidad + ", seccion=" + seccion
				+ ", manzana=" + manzana + ", idInterno=" + idInterno + ", claveElector=" + claveElector
				+ ", apellidoPaterno=" + apellidoPaterno + ", apellidoMaterno=" + apellidoMaterno + ", nombre=" + nombre
				+ ", fechaNacimiento=" + fechaNacimiento + ", lugarNacimiento=" + lugarNacimiento + ", sexo=" + sexo
				+ ", ocupacion=" + ocupacion + ", calle=" + calle + ", numExterior=" + numExterior + ", numInterior="
				+ numInterior + ", colonia=" + colonia + ", codigoPostal=" + codigoPostal + ", programaTodo="
				+ programaTodo + ", programaGeneral=" + programaGeneral + ", estatus=" + estatus + ", grupo=" + grupo
				+ ", calificacion=" + calificacion + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getEntidad() {
		return entidad;
	}

	public void setEntidad(Integer entidad) {
		this.entidad = entidad;
	}

	public Integer getRegionEdomex2017() {
		return regionEdomex2017;
	}

	public void setRegionEdomex2017(Integer regionEdomex2017) {
		this.regionEdomex2017 = regionEdomex2017;
	}

	public String getNombreRegion() {
		return nombreRegion;
	}

	public void setNombreRegion(String nombreRegion) {
		this.nombreRegion = nombreRegion;
	}

	public Integer getMunicipio() {
		return municipio;
	}

	public void setMunicipio(Integer municipio) {
		this.municipio = municipio;
	}

	public String getNombreMunicipio() {
		return nombreMunicipio;
	}

	public void setNombreMunicipio(String nombreMunicipio) {
		this.nombreMunicipio = nombreMunicipio;
	}

	public Integer getLocalidad() {
		return localidad;
	}

	public void setLocalidad(Integer localidad) {
		this.localidad = localidad;
	}

	public String getNombreLocalidad() {
		return nombreLocalidad;
	}

	public void setNombreLocalidad(String nombreLocalidad) {
		this.nombreLocalidad = nombreLocalidad;
	}

	public Integer getSeccion() {
		return seccion;
	}

	public void setSeccion(Integer seccion) {
		this.seccion = seccion;
	}

	public Integer getManzana() {
		return manzana;
	}

	public void setManzana(Integer manzana) {
		this.manzana = manzana;
	}

	public Integer getIdInterno() {
		return idInterno;
	}

	public void setIdInterno(Integer idInterno) {
		this.idInterno = idInterno;
	}

	public String getClaveElector() {
		return claveElector;
	}

	public void setClaveElector(String claveElector) {
		this.claveElector = claveElector;
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

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getLugarNacimiento() {
		return lugarNacimiento;
	}

	public void setLugarNacimiento(String lugarNacimiento) {
		this.lugarNacimiento = lugarNacimiento;
	}

	public GenerosDO getSexo() {
		return sexo;
	}

	public void setSexo(GenerosDO sexo) {
		this.sexo = sexo;
	}

	public String getOcupacion() {
		return ocupacion;
	}

	public void setOcupacion(String ocupacion) {
		this.ocupacion = ocupacion;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public String getNumExterior() {
		return numExterior;
	}

	public void setNumExterior(String numExterior) {
		this.numExterior = numExterior;
	}

	public String getNumInterior() {
		return numInterior;
	}

	public void setNumInterior(String numInterior) {
		this.numInterior = numInterior;
	}

	public String getColonia() {
		return colonia;
	}

	public void setColonia(String colonia) {
		this.colonia = colonia;
	}

	public String getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public String getProgramaTodo() {
		return programaTodo;
	}

	public void setProgramaTodo(String programaTodo) {
		this.programaTodo = programaTodo;
	}

	public String getProgramaGeneral() {
		return programaGeneral;
	}

	public void setProgramaGeneral(String programaGeneral) {
		this.programaGeneral = programaGeneral;
	}

	public String getEstatus() {
		return estatus;
	}

	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}

	public String getGrupo() {
		return grupo;
	}

	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}

	public String getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(String calificacion) {
		this.calificacion = calificacion;
	}


	
}
