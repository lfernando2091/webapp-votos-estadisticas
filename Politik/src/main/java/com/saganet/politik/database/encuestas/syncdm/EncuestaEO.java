package com.saganet.politik.database.encuestas.syncdm;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import org.apache.ibatis.type.Alias;

import com.saganet.politik.modelos.JavaBeanT;
@Alias("SyncDMEncuestaEO")
public class EncuestaEO extends JavaBeanT implements Serializable {
/**
	 * 
	 */
	private static final long serialVersionUID = 1626762843462214282L;
private Integer id;
private String nombre;
private Date fechaCaducidad;
private List<PreguntaEO> preguntas;
@Override
public String toString() {
	return "EncuestaEO [id=" + id + ", nombre=" + nombre + ", fechaCaducidad=" + fechaCaducidad + ", preguntas="
			+ preguntas + "]";
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
public Date getFechaCaducidad() {
	return fechaCaducidad;
}
public void setFechaCaducidad(Date fechaCaducidad) {
	this.fechaCaducidad = fechaCaducidad;
}
public List<PreguntaEO> getPreguntas() {
	return preguntas;
}
public void setPreguntas(List<PreguntaEO> preguntas) {
	this.preguntas = preguntas;
}


}
