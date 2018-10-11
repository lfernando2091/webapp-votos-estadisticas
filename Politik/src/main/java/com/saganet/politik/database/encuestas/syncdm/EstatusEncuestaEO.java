package com.saganet.politik.database.encuestas.syncdm;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

import com.saganet.politik.modelos.JavaBeanT;
@Alias("SyncDMEstatusEncuestaEO")
public class EstatusEncuestaEO extends JavaBeanT implements Serializable {
/**
	 * 
	 */
	private static final long serialVersionUID = 1960725010991813794L;
private Integer id;
private String nombre;
@Override
public String toString() {
	return "EstatusEncuestaEO [id=" + id + ", nombre=" + nombre + "]";
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


}
