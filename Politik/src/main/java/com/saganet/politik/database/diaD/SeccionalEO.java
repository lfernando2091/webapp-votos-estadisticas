package com.saganet.politik.database.diaD;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

import com.saganet.politik.database.catalogos.SeccionEO;
import com.saganet.politik.dominios.GenerosDO;
import com.saganet.politik.dominios.ProgramasEdoMexDO;
import com.saganet.politik.modelos.JavaBeanT;

@Alias("SeccionalEO")
public class SeccionalEO extends JavaBeanT implements Serializable{

	private static final long serialVersionUID = 5554997387141000821L;
	private  Integer id;
	private  Integer idSeccion;
	private  String  nombre;
	private  String fechaNacimiento;
	private  String  primerApellido;
	private  String  segundoApellido;
	private  GenerosDO genero;
	private  String  calle;
	private  String  numeroInterior;
	private  String  numeroExterior;
	private  String  colonia;
	private  Integer  codigoPostal;
	private  SeccionEO seccion;
	private ProgramasEdoMexDO programa;
	
	@Override
	public Integer getId() {
		return id;
	}



	@Override
	public String toString() {
		return "SeccionalEO [id=" + id + ", idSeccion=" + idSeccion + ", nombre=" + nombre + ", fechaNacimiento="
				+ fechaNacimiento + ", primerApellido=" + primerApellido + ", segundoApellido=" + segundoApellido
				+ ", genero=" + genero + ", calle=" + calle + ", numeroInterior=" + numeroInterior + ", numeroExterior="
				+ numeroExterior + ", colonia=" + colonia + ", codigoPostal=" + codigoPostal + ", seccion=" + seccion
				+ ", programa=" + programa + "]";
	}



	public ProgramasEdoMexDO getPrograma() {
		return programa;
	}
	public void setPrograma(ProgramasEdoMexDO programa) {
		this.programa = programa;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre.toUpperCase();
	}
	public String getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
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
	public GenerosDO getGenero() {
		return genero;
	}
	public void setGenero(GenerosDO genero) {
		this.genero = genero;
	}
	public String getCalle() {
		return calle;
	}
	public void setCalle(String calle) {
		this.calle = calle.toUpperCase();
	}
	public String getNumeroInterior() {
		return numeroInterior;
	}
	public void setNumeroInterior(String numeroInterior) {
		this.numeroInterior = numeroInterior;
	}
	public String getNumeroExterior() {
		return numeroExterior;
	}
	public void setNumeroExterior(String numeroExterior) {
		this.numeroExterior = numeroExterior;
	}
	public String getColonia() {
		return colonia;
	}
	public void setColonia(String colonia) {
		this.colonia = colonia.toUpperCase();
	}
	public Integer getCodigoPostal() {
		return codigoPostal;
	}
	public void setCodigoPostal(Integer codigoPostal) {
		this.codigoPostal = codigoPostal;
	}
	public SeccionEO getSeccion() {
		return seccion;
	}
	public void setSeccion(SeccionEO seccion) {
		this.seccion = seccion;
	}

	public Integer getIdSeccion() {
		return idSeccion;
	}


	public void setIdSeccion(Integer idSeccion) {
		this.idSeccion = idSeccion;
	}
	
}
