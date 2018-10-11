package com.saganet.politik.database.encuestas.edomex2017.entrevistaEntrevistados;

import java.io.Serializable;
import java.sql.Timestamp;

import org.apache.ibatis.type.Alias;

import com.saganet.politik.dominios.CandidatosEdomex2017DO;
import com.saganet.politik.dominios.CandidatosPartidosEedomex2017DO;
import com.saganet.politik.dominios.PartidosEleccionEdomex2017DO;
import com.saganet.politik.dominios.ResultadoEntrevistaEntrevistadorDO;
import com.saganet.politik.dominios.SiNoNSNCDO;
import com.saganet.politik.modelos.JavaBeanT;

@Alias("Edomex2017EntrevistaEntrevistadosEntrevistaEntrevistadoEO")
public class EntrevistaEntrevistadoEO extends JavaBeanT implements Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = -453047533099892132L;
	private Integer id;
	private Integer idEntrevistado;
	private SiNoNSNCDO _1;
	private CandidatosEdomex2017DO _2;
	private SiNoNSNCDO _3;
	private String _4;
	private PartidosEleccionEdomex2017DO _5;
	private SiNoNSNCDO _6;
	private PartidosEleccionEdomex2017DO _7;
	private PartidosEleccionEdomex2017DO _8;
	private CandidatosEdomex2017DO _9;
	private ResultadoEntrevistaEntrevistadorDO resultado;
	private String nickCaptura;
	private Timestamp fechaCaptura;
	private String nickActualizacion;
	private Timestamp fechaActualizacion;
	@Override
	public String toString() {
		return "EntrevistaEntrevistadoEO [id=" + id + ", idEntrevistado=" + idEntrevistado + ", _1=" + _1 + ", _2=" + _2
				+ ", _3=" + _3 + ", _4=" + _4 + ", _5=" + _5 + ", _6=" + _6 + ", _7=" + _7 + ", _8=" + _8 + ", _9=" + _9
				+ ", resultado=" + resultado + ", nickCaptura=" + nickCaptura + ", fechaCaptura=" + fechaCaptura
				+ ", nickActualizacion=" + nickActualizacion + ", fechaActualizacion=" + fechaActualizacion + "]";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getIdEntrevistado() {
		return idEntrevistado;
	}
	public void setIdEntrevistado(Integer idEntrevistado) {
		this.idEntrevistado = idEntrevistado;
	}
	public SiNoNSNCDO get_1() {
		return _1;
	}
	public void set_1(SiNoNSNCDO _1) {
		this._1 = _1;
	}
	public CandidatosEdomex2017DO get_2() {
		return _2;
	}
	public void set_2(CandidatosEdomex2017DO _2) {
		this._2 = _2;
	}
	public SiNoNSNCDO get_3() {
		return _3;
	}
	public void set_3(SiNoNSNCDO _3) {
		this._3 = _3;
	}
	public String get_4() {
		return _4;
	}
	public void set_4(String _4) {
		this._4 = _4;
	}
	public PartidosEleccionEdomex2017DO get_5() {
		return _5;
	}
	public void set_5(PartidosEleccionEdomex2017DO _5) {
		this._5 = _5;
	}
	public SiNoNSNCDO get_6() {
		return _6;
	}
	public void set_6(SiNoNSNCDO _6) {
		this._6 = _6;
	}
	public PartidosEleccionEdomex2017DO get_7() {
		return _7;
	}
	public void set_7(PartidosEleccionEdomex2017DO _7) {
		this._7 = _7;
	}
	public PartidosEleccionEdomex2017DO get_8() {
		return _8;
	}
	public void set_8(PartidosEleccionEdomex2017DO _8) {
		this._8 = _8;
	}
	public CandidatosEdomex2017DO get_9() {
		return _9;
	}
	public void set_9(CandidatosEdomex2017DO _9) {
		this._9 = _9;
	}
	public ResultadoEntrevistaEntrevistadorDO getResultado() {
		return resultado;
	}
	public void setResultado(ResultadoEntrevistaEntrevistadorDO resultado) {
		this.resultado = resultado;
	}
	public String getNickCaptura() {
		return nickCaptura;
	}
	public void setNickCaptura(String nickCaptura) {
		this.nickCaptura = nickCaptura;
	}
	public Timestamp getFechaCaptura() {
		return fechaCaptura;
	}
	public void setFechaCaptura(Timestamp fechaCaptura) {
		this.fechaCaptura = fechaCaptura;
	}
	public String getNickActualizacion() {
		return nickActualizacion;
	}
	public void setNickActualizacion(String nickActualizacion) {
		this.nickActualizacion = nickActualizacion;
	}
	public Timestamp getFechaActualizacion() {
		return fechaActualizacion;
	}
	public void setFechaActualizacion(Timestamp fechaActualizacion) {
		this.fechaActualizacion = fechaActualizacion;
	}
	
	

}
