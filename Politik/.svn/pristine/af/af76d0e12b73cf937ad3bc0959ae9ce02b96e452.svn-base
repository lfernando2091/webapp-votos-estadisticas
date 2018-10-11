package com.saganet.politik.database.encuestas.fuerzaCiudadana;

import java.io.Serializable;
import org.apache.ibatis.type.Alias;
import com.saganet.politik.modelos.JavaBeanT;

@Alias("FuerzaCiudadanaResultadoEncuestaCompletoVerticalEO")
public class ResultadoEncuestaCompletoVerticalEO extends JavaBeanT implements Serializable {
	
	private static final long serialVersionUID = 2198549554059215572L;
	
	private Integer id;	
	
	private String nombre;
	private String cantidadTotal;
	private String porcentajeTotal;
	
	private String cantidadNegativos;
	private String porcentajeNegativos;

	private String cantidadCoordinadores;
	private String porcentajeCoordinadores;
		
	@Override
	public String toString() {
		return "ResultadoEncuestaCompletoVerticalEO [id=" + id + ", nombre=" + nombre + ", cantidadTotal="
				+ cantidadTotal + ", porcentajeTotal=" + porcentajeTotal + ", cantidadNegativos=" + cantidadNegativos
				+ ", porcentajeNegativos=" + porcentajeNegativos + ", cantidadCoordinadores=" + cantidadCoordinadores
				+ ", porcentajeCoordinadores=" + porcentajeCoordinadores + "]";
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
	public String getCantidadTotalF() {
		return String.format("%,d", cantidadTotal);
	}
	public String getCantidadTotal() {
		return cantidadTotal;
	}
	public void setCantidadTotal(String cantidadTotal) {
		this.cantidadTotal = cantidadTotal;
	}
	public String getPorcentajeTotal() {
		return porcentajeTotal;
	}
	public void setPorcentajeTotal(String porcentajeTotal) {
		this.porcentajeTotal = porcentajeTotal;
	}
	public String getCantidadNegativos() {
		return cantidadNegativos;
	}
	public void setCantidadNegativos(String cantidadNegativos) {
		this.cantidadNegativos = cantidadNegativos;
	}
	public String getPorcentajeNegativos() {
		return porcentajeNegativos;
	}
	public void setPorcentajeNegativos(String porcentajeNegativos) {
		this.porcentajeNegativos = porcentajeNegativos;
	}
	public String getCantidadCoordinadores() {
		return cantidadCoordinadores;
	}
	public void setCantidadCoordinadores(String cantidadCoordinadores) {
		this.cantidadCoordinadores = cantidadCoordinadores;
	}
	public String getPorcentajeCoordinadores() {
		return porcentajeCoordinadores;
	}
	public void setPorcentajeCoordinadores(String porcentajeCoordinadores) {
		this.porcentajeCoordinadores = porcentajeCoordinadores;
	}
	
}
