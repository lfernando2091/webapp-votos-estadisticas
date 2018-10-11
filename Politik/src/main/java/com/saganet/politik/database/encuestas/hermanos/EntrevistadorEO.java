package com.saganet.politik.database.encuestas.hermanos;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

import com.saganet.politik.database.administracion.UsuarioEO;
import com.saganet.politik.database.catalogos.MunicipioEO;
import com.saganet.politik.modelos.JavaBeanT;

@Alias("HermanosEntrevistadorEO")
public class EntrevistadorEO extends JavaBeanT implements Serializable {


/**
	 * 
	 */
	private static final long serialVersionUID = -1069602133304341511L;
private Integer id;
private String nombre;
private String primerApellido;
private String segundoApellido;
private String email;
private String movil;
private String nick;
private String pw;
private Integer idRegion;
private MunicipioEO municipio;
private String clave;
private UsuarioEO usuario;
private String programa;

@Override
public String toString() {
	return "EntrevistadorEO [id=" + id + ", nombre=" + nombre + ", primerApellido=" + primerApellido
			+ ", segundoApellido=" + segundoApellido + ", email=" + email + ", movil=" + movil + ", programa=" + programa
			+ ", nick=" + nick + ", pw=" + pw + ", idRegion=" + idRegion + ", municipio=" + municipio + ", clave="
			+ clave + ", usuario=" + usuario + "]";
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

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getMovil() {
	return movil;
}

public void setMovil(String movil) {
	this.movil = movil;
}





public String getPrograma() {
	return programa;
}



public void setPrograma(String programa) {
	this.programa = programa;
}



public static long getSerialversionuid() {
	return serialVersionUID;
}



public String getNick() {
	return nick;
}

public void setNick(String nick) {
	this.nick = nick;
}

public String getPw() {
	return pw;
}

public void setPw(String pw) {
	this.pw = pw;
}

public Integer getIdRegion() {
	return idRegion;
}

public void setIdRegion(Integer idRegion) {
	this.idRegion = idRegion;
}

public MunicipioEO getMunicipio() {
	return municipio;
}

public void setMunicipio(MunicipioEO municipio) {
	this.municipio = municipio;
}

public String getClave() {
	return clave;
}

public void setClave(String clave) {
	this.clave = clave;
}

public UsuarioEO getUsuario() {
	return usuario;
}

public void setUsuario(UsuarioEO usuario) {
	this.usuario = usuario;
}



}
