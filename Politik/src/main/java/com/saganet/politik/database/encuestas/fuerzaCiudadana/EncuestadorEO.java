package com.saganet.politik.database.encuestas.fuerzaCiudadana;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

import com.saganet.politik.database.administracion.UsuarioEO;
import com.saganet.politik.database.catalogos.GeozonaParticionEO;
import com.saganet.politik.database.catalogos.MunicipioEO;
import com.saganet.politik.dominios.ProgramasEdoMexDO;
import com.saganet.politik.modelos.JavaBeanT;
@Alias("FuerzaCiudadanaEncuestadorEO")
public class EncuestadorEO extends JavaBeanT implements Serializable {
private static final long serialVersionUID = -7789229890683758895L;

private Integer id;
private String nombre;
private String primerApellido;
private String segundoApellido;
private String email;
private String movil;
 private ProgramasEdoMexDO progama;
private String nick;
private String pw;
private Integer idRegion;
private MunicipioEO municipio;
private String clave;
private UsuarioEO usuario;
private String supervisor;
private String call_center;

@Override
public String toString() {
	return "EncuestadorEO [id=" + id + ", nombre=" + nombre + ", primerApellido=" + primerApellido
			+ ", segundoApellido=" + segundoApellido + ", email=" + email + ", movil=" + movil + ", progama=" + progama
			+ ", nick=" + nick + ", pw=" + pw + ", idRegion=" + idRegion + ", municipio=" + municipio + ", clave="
			+ clave + ", usuario=" + usuario + ", supervisor=" + supervisor + ", call_center=" + call_center + "]";
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

public ProgramasEdoMexDO getProgama() {
	return progama;
}

public void setProgama(ProgramasEdoMexDO progama) {
	this.progama = progama;
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

public String getSupervisor() {
	return supervisor;
}

public void setSupervisor(String supervisor) {
	this.supervisor = supervisor;
}

public String getCall_center() {
	return call_center;
}

public void setCall_center(String call_center) {
	this.call_center = call_center;
}




}
