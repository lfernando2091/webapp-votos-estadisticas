package com.saganet.politik.database.encuestas.sujetosSociales;

import java.io.Serializable;
import org.apache.ibatis.type.Alias;
import com.saganet.politik.database.administracion.UsuarioEO;
import com.saganet.politik.modelos.JavaBeanT;

@Alias("SujetosSocialesEncuestadoresConectadosEO")
public class EncuestadoresConectadosEO extends JavaBeanT implements Serializable {
	
	private static final long serialVersionUID = 2198549554059215572L;

	private Integer id;
	private UsuarioEO usuario;
	private String	municipioProspera;
	
	@Override
	public String toString() {
		return "EncuestadoresConectadosEO [id=" + id + ", usuario=" + usuario + ", municipioProspera="
				+ municipioProspera + "]";
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
	public void setUsuario(UsuarioEO usuario) {
		this.usuario = usuario;
	}
	public String getMunicipioProspera() {
		return municipioProspera;
	}
	public void setMunicipioProspera(String municipioProspera) {
		this.municipioProspera = municipioProspera;
	}	
}
