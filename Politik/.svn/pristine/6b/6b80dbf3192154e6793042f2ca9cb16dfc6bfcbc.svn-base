package com.saganet.politik.database.administracion;

import java.io.Serializable;
import java.sql.Timestamp;

import org.apache.ibatis.type.Alias;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.saganet.politik.modelos.JavaBeanT;
import com.saganet.politik.utilidades.Formateador;

@Alias("UsuarioAccesoEO")
public class UsuarioAccesoEO extends JavaBeanT implements Serializable {
	private static final long serialVersionUID = -925077956659893549L;

	private Integer id;
	private Timestamp acceso;
	private String host;
	private String cliente;

	@Override
	public String toString() {
		return "UsuarioAccesoEO [id=" + id + ", acceso=" + acceso + ", host=" + host + ", cliente=" + cliente + "]";
	}
	
	@JsonIgnore
	public String getAccesoFormato(){
		Formateador formateador;
		
		formateador = new Formateador();
		
		return formateador.fechaHora(acceso);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Timestamp getAcceso() {
		return acceso;
	}

	public void setAcceso(Timestamp acceso) {
		this.acceso = acceso;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}
}
