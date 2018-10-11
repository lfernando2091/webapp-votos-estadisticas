package com.saganet.politik.database.encuestas.entrevistasTelefonicas;

import java.io.Serializable;
import java.sql.Timestamp;

import org.apache.ibatis.type.Alias;

import com.saganet.politik.dominios.CargosEstructuraDO;
import com.saganet.politik.dominios.ResultadoEntrevistaEntrevistadorDO;
import com.saganet.politik.dominios.SiNoNSNCDO;
import com.saganet.politik.modelos.JavaBeanT;

@Alias("Resultados2EO")
public class ResultadosEO extends JavaBeanT implements Serializable {
	private static final long serialVersionUID = 2728678114445673170L;
	
	private Integer id;
	private Integer folio;
	private SiNoNSNCDO  _1;
	private CargosEstructuraDO _2;
	private String _3;
	private SiNoNSNCDO _4;
	private SiNoNSNCDO _5;
	private String _6;
	private SiNoNSNCDO _7;
	private String _8;
	private String _9;
	private String _10;
	private String _11;
	private String nick;
	private Timestamp fechaCaptura;
	private Timestamp fechaActualizacion;
	private ResultadoEntrevistaEntrevistadorDO resultado;
	private String otroCargo;
	@Override
	public String toString() {
		return "ResultadosEO [id=" + id + ", folio=" + folio + ", _1=" + _1 + ", _2=" + _2 + ", _3=" + _3 + ", _4=" + _4
				+ ", _5=" + _5 + ", _6=" + _6 + ", _7=" + _7 + ", _8=" + _8 + ", _9=" + _9 + ", _10=" + _10 + ", _11="
				+ _11 + ", nick=" + nick + ", fechaCaptura=" + fechaCaptura + ", fechaActualizacion="
				+ fechaActualizacion + ", resultado=" + resultado + ", otroCargo=" + otroCargo + "]";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getFolio() {
		return folio;
	}
	public void setFolio(Integer folio) {
		this.folio = folio;
	}
	public SiNoNSNCDO get_1() {
		return _1;
	}
	public void set_1(SiNoNSNCDO _1) {
		this._1 = _1;
	}
	public CargosEstructuraDO get_2() {
		return _2;
	}
	public void set_2(CargosEstructuraDO _2) {
		this._2 = _2;
	}
	public String get_3() {
		return _3;
	}
	public void set_3(String _3) {
		this._3 = _3;
	}
	public SiNoNSNCDO get_4() {
		return _4;
	}
	public void set_4(SiNoNSNCDO _4) {
		this._4 = _4;
	}
	public SiNoNSNCDO get_5() {
		return _5;
	}
	public void set_5(SiNoNSNCDO _5) {
		this._5 = _5;
	}
	public String get_6() {
		return _6;
	}
	public void set_6(String _6) {
		this._6 = _6;
	}
	public SiNoNSNCDO get_7() {
		return _7;
	}
	public void set_7(SiNoNSNCDO _7) {
		this._7 = _7;
	}
	public String get_8() {
		return _8;
	}
	public void set_8(String _8) {
		this._8 = _8;
	}
	public String get_9() {
		return _9;
	}
	public void set_9(String _9) {
		this._9 = _9;
	}
	public String get_10() {
		return _10;
	}
	public void set_10(String _10) {
		this._10 = _10;
	}
	public String get_11() {
		return _11;
	}
	public void set_11(String _11) {
		this._11 = _11;
	}
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	public Timestamp getFechaCaptura() {
		return fechaCaptura;
	}
	public void setFechaCaptura(Timestamp fechaCaptura) {
		this.fechaCaptura = fechaCaptura;
	}
	public Timestamp getFechaActualizacion() {
		return fechaActualizacion;
	}
	public void setFechaActualizacion(Timestamp fechaActualizacion) {
		this.fechaActualizacion = fechaActualizacion;
	}
	public ResultadoEntrevistaEntrevistadorDO getResultado() {
		return resultado;
	}
	public void setResultado(ResultadoEntrevistaEntrevistadorDO resultado) {
		this.resultado = resultado;
	}
	public String getOtroCargo() {
		return otroCargo;
	}
	public void setOtroCargo(String otroCargo) {
		this.otroCargo = otroCargo;
	}
	
	
	
	
	
	
	
	
}
