package com.saganet.politik.database.encuestas.edomex2017.callCenter;

import java.io.Serializable;
import org.apache.ibatis.type.Alias;

import com.saganet.politik.database.administracion.UsuarioEO;
import com.saganet.politik.dominios.ProgramasEdoMexDO;
import com.saganet.politik.modelos.JavaBeanT;

@Alias("Edomex2017CallcenterCapturistaEO")
public class CapturistaEO extends JavaBeanT implements Serializable {
	
	private static final long serialVersionUID = -6147451553202869253L;
	private Integer id;
	private String nombre;
	private String primerApellido;
	private String segundoApellido;
	private UsuarioEO usuario;
	private EncargadoEO encargado;
	private ProgramasEdoMexDO programa;
	
	@Override
	public String toString() {
		return "CapturistaEO [id=" + id + ", nombre=" + nombre + ", primerApellido=" + primerApellido
				+ ", segundoApellido=" + segundoApellido + ", usuario="
				+ encargado + "]";
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


	public EncargadoEO getEncargado() {
		return encargado;
	}

	public void setEncargado(EncargadoEO encargado) {
		this.encargado = encargado;
	}

	public UsuarioEO getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioEO usuario) {
		this.usuario = usuario;
	}

	public ProgramasEdoMexDO getPrograma() {
		return programa;
	}

	public void setProgama(ProgramasEdoMexDO programa) {
		this.programa = programa;
	}


	
}
