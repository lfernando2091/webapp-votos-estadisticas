package com.saganet.politik.database.encuestas.edomex2017.supervisor;

import java.io.Serializable;
import org.apache.ibatis.type.Alias;
import com.saganet.politik.modelos.JavaBeanT;
import com.saganet.politik.dominios.ProgramasEdoMexDO;
import com.saganet.politik.database.catalogos.MunicipioEO;
import com.saganet.politik.database.administracion.UsuarioEO;
import com.saganet.politik.database.encuestas.edomex2017.callCenter.EncargadoEO;

@Alias("Edomex2017SupervisorEncuestadorEO")
public class EncuestadorEO extends JavaBeanT implements Serializable {
	
	private static final long serialVersionUID = -6147451553202869253L;
	private Integer id;
	private String nombre;
	private String primerApellido;
	private String segundoApellido;
	private String email;
	private String movil;
	private ProgramasEdoMexDO progama;
	private MunicipioEO municipio;
	private UsuarioEO usuario;
	private SupervisorEO supervisor;
	private EncargadoEO callCenter;
	
	
	@Override
	public String toString() {
		return "EncuestadorEO [id=" + id + ", nombre=" + nombre + ", primerApellido=" + primerApellido
				+ ", segundoApellido=" + segundoApellido + ", email=" + email + ", movil=" + movil + ", progama="
				+ progama + ", municipio=" + municipio + ", usuario=" + usuario + ", supervisor=" + supervisor
				+ ", callCenter=" + callCenter + "]";
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
	public MunicipioEO getMunicipio() {
		return municipio;
	}
	public void setMunicipio(MunicipioEO municipio) {
		this.municipio = municipio;
	}
	public UsuarioEO getUsuario() {
		return usuario;
	}
	public void setUsuario(UsuarioEO usuario) {
		this.usuario = usuario;
	}
	public SupervisorEO getSupervisor() {
		return supervisor;
	}
	public void setSupervisor(SupervisorEO supervisor) {
		this.supervisor = supervisor;
	}
	public EncargadoEO getCallCenter() {
		return callCenter;
	}
	public void setCallCenter(EncargadoEO callCenter) {
		this.callCenter = callCenter;
	}
	
}
