package com.saganet.politik.database.catalogos;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

import com.saganet.politik.dominios.EstatusDispositivoDO;
import com.saganet.politik.dominios.ModelosDispositivoDO;
import com.saganet.politik.dominios.PrecargaDO;
import com.saganet.politik.modelos.JavaBeanT;

@Alias("DispositivoMovilEO")
public class DispositivoMovilEO extends JavaBeanT implements Serializable {
	private static final long serialVersionUID = 7914789601844186955L;
	
	private Integer id;
	private Integer idRegistro;
	private String serie;
	private String imei1;
	private String imei2;
	private ModelosDispositivoDO modelo;
	private PrecargaDO precarga;
	private EstatusDispositivoDO estatus;
	private String nick;
	private String fechaCaptura;
	private String nickActualizacion;
	private String fechaActualizacion;
	
	@Override
	public String toString() {
		return "DispositivoMovilEO [id=" + id + ", idRegistro=" + idRegistro + ", serie=" + serie + ", imei1=" + imei1
				+ ", imei2=" + imei2 + ", modelo=" + modelo + ", estatus=" + estatus + ", nick=" + nick
				+ ", fechaCaptura=" + fechaCaptura + ", nickActualizacion=" + nickActualizacion
				+ ", fechaActualizacion=" + fechaActualizacion + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdRegistro() {
		return idRegistro;
	}

	public void setIdRegistro(Integer idRegistro) {
		this.idRegistro = idRegistro;
	}

	public String getSerie() {
		return serie;
	}

	public void setSerie(String serie) {
		this.serie = serie;
	}

	public String getImei1() {
		return imei1;
	}

	public void setImei1(String imei1) {
		this.imei1 = imei1;
	}

	public String getImei2() {
		return imei2;
	}

	public void setImei2(String imei2) {
		this.imei2 = imei2;
	}

	public ModelosDispositivoDO getModelo() {
		return modelo;
	}

	public void setModelo(ModelosDispositivoDO modelo) {
		this.modelo = modelo;
	}

	public PrecargaDO getPrecarga() {
		return precarga;
	}

	public void setPrecarga(PrecargaDO precarga) {
		this.precarga = precarga;
	}

	public EstatusDispositivoDO getEstatus() {
		return estatus;
	}

	public void setEstatus(EstatusDispositivoDO estatus) {
		this.estatus = estatus;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getFechaCaptura() {
		return fechaCaptura;
	}

	public void setFechaCaptura(String fechaCaptura) {
		this.fechaCaptura = fechaCaptura;
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
	
}
