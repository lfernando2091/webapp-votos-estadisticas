package com.saganet.politik.database.encuestas.fuerzaCiudadana;

import java.io.Serializable;
import java.sql.Timestamp;

import org.apache.ibatis.type.Alias;

import com.saganet.politik.dominios.CandidatosEdomex2017DO;
import com.saganet.politik.dominios.GenerosDO;
import com.saganet.politik.dominios.PartidosEleccionEdomex2017DO;
import com.saganet.politik.dominios.ResultadoEncuestaEdomexDO;
import com.saganet.politik.dominios.SiNoNSNCDO;
import com.saganet.politik.modelos.JavaBeanT;
@Alias("FuerzaCiudadanaEncuestaEO")
public class EncuestaEO extends JavaBeanT implements Serializable {
	private static final long serialVersionUID = -6933355450665704649L;
private Integer id;
private String idContacto;
private ResultadoEncuestaEdomexDO resultado;
private String nick;
private Timestamp fecha;
private String encuestador;

private SiNoNSNCDO r1;
//private SiNoNSNCDO ;
private PartidosEleccionEdomex2017DO r2;
private CandidatosEdomex2017DO r3;
private SiNoNSNCDO r4;
private String nombre;
private String paterno;
private String materno;
private String fechaNacimiento;
private GenerosDO genero;
private String tel;
private String email;
private String nickActualizacion;
private String fechaActualizacion;
private Integer versionCaptura;
@Override
public String toString() {
	return "EncuestaEO [id=" + id + ", idContacto=" + idContacto + ", resultado=" + resultado + ", nick=" + nick
			+ ", fecha=" + fecha + ", encuestador=" + encuestador + ", r1=" + r1 + ", r2=" + r2 + ", r3=" + r3 + ", r4="
			+ r4 + ", nombre=" + nombre + ", paterno=" + paterno + ", materno=" + materno + ", fechaNacimiento="
			+ fechaNacimiento + ", genero=" + genero + ", tel=" + tel + ", email=" + email + ", nickActualizacion="
			+ nickActualizacion + ", fechaActualizacion=" + fechaActualizacion + ", versionCaptura=" + versionCaptura
			+ "]";
}
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public String getIdContacto() {
	return idContacto;
}
public void setIdContacto(String idContacto) {
	this.idContacto = idContacto;
}
public ResultadoEncuestaEdomexDO getResultado() {
	return resultado;
}
public void setResultado(ResultadoEncuestaEdomexDO resultado) {
	this.resultado = resultado;
}
public String getNick() {
	return nick;
}
public void setNick(String nick) {
	this.nick = nick;
}
public Timestamp getFecha() {
	return fecha;
}
public void setFecha(Timestamp fecha) {
	this.fecha = fecha;
}

public String getEncuestador() {
	return encuestador;
}
public void setEncuestador(String encuestador) {
	this.encuestador = encuestador;
}
public SiNoNSNCDO getR1() {
	return r1;
}
public void setR1(SiNoNSNCDO r1) {
	this.r1 = r1;
}
public PartidosEleccionEdomex2017DO getR2() {
	return r2;
}
public void setR2(PartidosEleccionEdomex2017DO r2) {
	this.r2 = r2;
}
public CandidatosEdomex2017DO getR3() {
	return r3;
}
public void setR3(CandidatosEdomex2017DO r3) {
	this.r3 = r3;
}
public SiNoNSNCDO getR4() {
	return r4;
}
public void setR4(SiNoNSNCDO r4) {
	this.r4 = r4;
}
public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre.toUpperCase();
}
public String getPaterno() {
	return paterno;
}
public void setPaterno(String paterno) {
	this.paterno = paterno.toUpperCase();
}
public String getMaterno() {
	return materno;
}
public void setMaterno(String materno) {
	this.materno = materno.toUpperCase();
}
public String getFechaNacimiento() {
	return fechaNacimiento;
}
public void setFechaNacimiento(String fechaNacimiento) {
	this.fechaNacimiento = fechaNacimiento;
}
public GenerosDO getGenero() {
	return genero;
}
public void setGenero(GenerosDO genero) {
	this.genero = genero;
}
public String getTel() {
	return tel;
}
public void setTel(String tel) {
	this.tel = tel;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getNickActualizacion() {
	return nickActualizacion;
}
public void setNickActualizacion(String nickActualizacion) {
	this.nickActualizacion = nickActualizacion;
}
public String getFechaActualizacion() {
	return fechaActualizacion;
}
public void setFechaActualizacion(String fechaActualizacion) {
	this.fechaActualizacion = fechaActualizacion;
}
public Integer getVersionCaptura() {
	return versionCaptura;
}
public void setVersionCaptura(Integer versionCaptura) {
	this.versionCaptura = versionCaptura;
}




}
