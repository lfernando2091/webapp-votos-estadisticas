package com.saganet.politik.database.encuestas.edomex2017.supervisor;

import java.io.Serializable;
import org.apache.ibatis.type.Alias;

import com.saganet.politik.database.catalogos.MunicipioEO;
import com.saganet.politik.database.administracion.UsuarioEO;
import com.saganet.politik.dominios.ProgramasEdoMexDO;
import com.saganet.politik.modelos.JavaBeanT;

@Alias("Edomex2017SupervisorSupervisorEO")
public class SupervisorEO extends JavaBeanT implements Serializable {
	
	private static final long serialVersionUID = -6147451553202869253L;
	private Integer id;
	private UsuarioEO usuario;
	private ProgramasEdoMexDO progama;
	private MunicipioEO municipio;
		
	@Override
	public String toString() {
		return "SupervisorEO [id=" + id + ", usuario=" + usuario + ", progama=" + progama + ", municipio=" + municipio + "]";
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public UsuarioEO getUsuario() {
		return usuario;
	}
	public void settUsuario(UsuarioEO nick) {
		this.usuario = nick;
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
	
}
