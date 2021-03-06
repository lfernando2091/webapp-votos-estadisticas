package com.saganet.politik.database.estructurasEdoMex;

import java.io.Serializable;
import org.apache.ibatis.type.Alias;

import com.saganet.politik.database.administracion.UsuarioEO;
import com.saganet.politik.database.catalogos.GeozonaParticionEO;
import com.saganet.politik.database.catalogos.MunicipioEO;
import com.saganet.politik.database.mdm.PersonaEO;
import com.saganet.politik.dominios.ProgramasEdoMexDO;
import com.saganet.politik.modelos.JavaBeanT;

@Alias("EstructurasEdoMexCoordinadorMunicipalEO")
public class CoordinadorMunicipalEO extends JavaBeanT implements Serializable {
	private static final long serialVersionUID = 1869647800401555906L;

	private Integer id;
	private PersonaEO persona;
	private GeozonaParticionEO region;
	private MunicipioEO municipio;
	private UsuarioEO usuario;
	private ProgramasEdoMexDO programa;
	
	@Override
	public String toString() {
		return "CoordinadorMunicipalEO [id=" + id + ", persona=" + persona + ", region=" + region + ", municipio="
				+ municipio + ", usuario=" + usuario + ", programa=" + programa + "]";
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public PersonaEO getPersona() {
		return persona;
	}
	public void setPersona(PersonaEO persona) {
		this.persona = persona;
	}
	public GeozonaParticionEO getRegion() {
		return region;
	}
	public void setRegion(GeozonaParticionEO region) {
		this.region = region;
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

	public ProgramasEdoMexDO getPrograma() {
		return programa;
	}

	public void setPrograma(ProgramasEdoMexDO programa) {
		this.programa = programa;
	}
}
