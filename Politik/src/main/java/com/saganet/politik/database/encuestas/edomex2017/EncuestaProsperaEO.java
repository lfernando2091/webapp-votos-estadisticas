package com.saganet.politik.database.encuestas.edomex2017;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

import com.saganet.politik.database.encuestas.edomex2017.supervisor.EncuestadorEO;
import com.saganet.politik.dominios.BuenaRegularMaloDO;
import com.saganet.politik.dominios.BuenaRegularMaloNoReciboDO;
import com.saganet.politik.dominios.BuenaRegularNadaDO;
import com.saganet.politik.dominios.GobiernosDO;
import com.saganet.politik.dominios.MuchoRegularNadaDO;
import com.saganet.politik.dominios.ResultadoEncuestaEdomexDO;
import com.saganet.politik.dominios.SiNoDO;
import com.saganet.politik.modelos.JavaBeanT;
@Alias("Edomex2017EncuestaProsperaEO")
public class EncuestaProsperaEO extends JavaBeanT implements Serializable {
	private static final long serialVersionUID = -6147451553202869253L;
	private Integer id;
	private Integer idInterno;
	private GobiernosDO r1;
	private SiNoDO r2;
	private BuenaRegularMaloDO r3;
	private BuenaRegularMaloNoReciboDO r4;
	private SiNoDO r5;
	private String nick;
	private String estatus;
	private java.sql.Timestamp fecha;
	private EncuestadorEO encuestador;
	private ResultadoEncuestaEdomexDO resultado;
	private String email;
	private String telefono;
	@Override
	public String toString() {
		return "EncuestaProsperaEO [id=" + id + ", idInterno=" + idInterno + ", r1=" + r1 + ", r2=" + r2 + ", r3=" + r3
				+ ", r4=" + r4 + ", r5=" + r5 + ", nick=" + nick + ", estatus=" + estatus + ", fecha=" + fecha
				+ ", encuestador=" + encuestador + ", resultado=" + resultado + ", email=" + email + ", telefono="
				+ telefono + "]";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getIdInterno() {
		return idInterno;
	}
	public void setIdInterno(Integer idInterno) {
		this.idInterno = idInterno;
	}
	public GobiernosDO getR1() {
		return r1;
	}
	public void setR1(GobiernosDO r1) {
		this.r1 = r1;
	}
	public SiNoDO getR2() {
		return r2;
	}
	public void setR2(SiNoDO r2) {
		this.r2 = r2;
	}
	public BuenaRegularMaloDO getR3() {
		return r3;
	}
	public void setR3(BuenaRegularMaloDO r3) {
		this.r3 = r3;
	}
	public BuenaRegularMaloNoReciboDO getR4() {
		return r4;
	}
	public void setR4(BuenaRegularMaloNoReciboDO r4) {
		this.r4 = r4;
	}
	public SiNoDO getR5() {
		return r5;
	}
	public void setR5(SiNoDO r5) {
		this.r5 = r5;
	}
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	public String getEstatus() {
		return estatus;
	}
	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}
	public java.sql.Timestamp getFecha() {
		return fecha;
	}
	public void setFecha(java.sql.Timestamp fecha) {
		this.fecha = fecha;
	}
	public EncuestadorEO getEncuestador() {
		return encuestador;
	}
	public void setEncuestador(EncuestadorEO encuestador) {
		this.encuestador = encuestador;
	}
	public ResultadoEncuestaEdomexDO getResultado() {
		return resultado;
	}
	public void setResultado(ResultadoEncuestaEdomexDO resultado) {
		this.resultado = resultado;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	
	
}
