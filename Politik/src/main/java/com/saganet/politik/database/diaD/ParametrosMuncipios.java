package com.saganet.politik.database.diaD;

import org.springframework.stereotype.Component;
import org.springframework.context.annotation.Scope;
import com.saganet.politik.database.catalogos.MunicipioEO;
import org.springframework.context.annotation.ScopedProxyMode;

@Component("ParametrosMuncipios")
@Scope(value="session", proxyMode=ScopedProxyMode.TARGET_CLASS)
public class ParametrosMuncipios {

	private MunicipioEO municipio;
	private String programa;
	private Integer seccion;

	public MunicipioEO getMunicipio() {
		return municipio;
	}
	public void setMunicipio(MunicipioEO municipio) {
		this.municipio = municipio;
	}
	public String getPrograma() {
		return programa;
	}
	public void setPrograma(String programa) {
		this.programa = programa;
	}
	public Integer getSeccion() {
		return seccion;
	}
	public void setSeccion(Integer seccion) {
		this.seccion = seccion;
	}	
}