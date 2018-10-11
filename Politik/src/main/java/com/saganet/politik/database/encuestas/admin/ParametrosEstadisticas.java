package com.saganet.politik.database.encuestas.admin;


import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import com.saganet.politik.database.diaD.MovilizadorEO;
import com.saganet.politik.database.diaD.SeccionalEO;




@Component("ParametrosEstadisticas")
@Scope(value="session", proxyMode=ScopedProxyMode.TARGET_CLASS)
public class ParametrosEstadisticas {
	CampaniaEO campania;
	MovilizadorEO movilizador;
	SeccionalEO seccional;
	
	public CampaniaEO getCampania() {
		return campania;
	}

	public void setCampania(CampaniaEO campania) {
		this.campania = campania;
	}

	public MovilizadorEO getMovilizador() {
		return movilizador;
	}

	public void setMovilizador(MovilizadorEO movilizador) {
		this.movilizador = movilizador;
	}

	public SeccionalEO getSeccional() {
		return seccional;
	}

	public void setSeccional(SeccionalEO seccional) {
		this.seccional = seccional;
	}

	
}
