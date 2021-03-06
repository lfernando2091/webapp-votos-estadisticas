package com.saganet.politik.database.administracion;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.type.Alias;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.saganet.politik.database.catalogos.DependenciaEO;
import com.saganet.politik.dominios.NivelesDO;
import com.saganet.politik.dominios.ProgramaFuerzaCiudadanaDO;
import com.saganet.politik.dominios.ProgramasEdoMexDO;
import com.saganet.politik.modelos.JavaBeanT;
import com.saganet.politik.utilidades.Formateador;

@Alias("UsuarioEO")
public class UsuarioEO extends JavaBeanT implements Serializable {
	private static final long serialVersionUID = 705717660039700078L;

	private Integer id;
	private String nick;
	private String nombre;
	private String pw;	
	private Boolean habilitado;
	private NivelesDO nivel;
	private Timestamp ultimoAcceso;
	private String mail;
	private List<RolEO> roles;
	private List<JavaBeanT> territorios;
	private List<DependenciaEO> dependencias;
	private List<UsuarioAccesoEO> accesos;
    private String celular;
    private  List<ProgramasEdoMexDO> progamas;
    private  List<ProgramaFuerzaCiudadanaDO> progamas2;
	
	
	public UsuarioEO() {
		roles = new ArrayList<>();
		territorios = new ArrayList<>();
		nivel = NivelesDO.NACIONAL;
		dependencias = new ArrayList<>();
		accesos = new ArrayList<>();
		progamas = new ArrayList<>();
		progamas2 = new ArrayList<>();
	}


	@Override
	public String toString() {
		return "UsuarioEO [id=" + id + ", nick=" + nick + ", nombre=" + nombre + ", pw=" + pw + ", habilitado="
				+ habilitado + ", nivel=" + nivel + ", ultimoAcceso=" + ultimoAcceso + ", mail=" + mail + ", roles="
				+ roles + ", territorios=" + territorios + ", dependencias=" + dependencias + ", accesos=" + accesos
				+ ", celular=" + celular + "]";
	}



	public String getCelular() {
		return celular;
	}



	public void setCelular(String celular) {
		this.celular = celular;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre.toUpperCase();
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public Boolean getHabilitado() {
		return habilitado;
	}

	public void setHabilitado(Boolean habilitado) {
		this.habilitado = habilitado;
	}

	public List<RolEO> getRoles() {
		return roles;
	}

	public void setRoles(List<RolEO> roles) {
		this.roles = roles;
	}

	public NivelesDO getNivel() {
		return nivel;
	}

	public void setNivel(NivelesDO nivel) {
		this.nivel = nivel;
	}

	public Timestamp getUltimoAcceso() {
		return ultimoAcceso;
	}
	
	@JsonIgnore
	public String getUltimoAccesoFormato(){
		Formateador formateador;
		formateador = new Formateador();
		return formateador.fechaHora(ultimoAcceso);
	}

	public void setUltimoAcceso(Timestamp ultimoAcceso) {
		this.ultimoAcceso = ultimoAcceso;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public List<JavaBeanT> getTerritorios() {
		return territorios;
	}

	public void setTerritorios(List<JavaBeanT> territorios) {
		this.territorios = territorios;
	}

	public List<DependenciaEO> getDependencias() {
		return dependencias;
	}

	public void setDependencias(List<DependenciaEO> dependencias) {
		this.dependencias = dependencias;
	}

	public List<UsuarioAccesoEO> getAccesos() {
		return accesos;
	}

	public void setAccesos(List<UsuarioAccesoEO> accesos) {
		this.accesos = accesos;
	}



	public List<ProgramasEdoMexDO> getProgamas() {
		return progamas;
	}



	public void setProgamas(List<ProgramasEdoMexDO> progamas) {
		this.progamas = progamas;
	}



	public List<ProgramaFuerzaCiudadanaDO> getProgamas2() {
		return progamas2;
	}



	public void setProgamas2(List<ProgramaFuerzaCiudadanaDO> progamas2) {
		this.progamas2 = progamas2;
	}






	

}