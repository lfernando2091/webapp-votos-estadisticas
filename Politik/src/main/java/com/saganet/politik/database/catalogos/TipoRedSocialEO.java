package com.saganet.politik.database.catalogos;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

import com.saganet.politik.modelos.JavaBeanT;

@Alias("TipoRedSocialEO")
public class TipoRedSocialEO extends JavaBeanT implements Serializable {
	private static final long serialVersionUID = 3740065583521637230L;

	private Integer id;
	private String nombre;
	private String direccion;
	private String logo;

	@Override
	public String toString() {
		return "TipoRedSocialEO [id=" + id + ", nombre=" + nombre + ", direccion=" + direccion + ", logo=" + logo + "]";
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

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

}
