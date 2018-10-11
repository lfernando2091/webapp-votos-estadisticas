package com.saganet.politik.utilidades;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import com.saganet.politik.database.diaD.MovilizadoEO;
import com.saganet.politik.database.diaD.MovilizadorEO;
import com.saganet.politik.modelos.Modelo;

@Component("ParametrosPDF")
@Scope(value="session", proxyMode=ScopedProxyMode.TARGET_CLASS)
public class ParametrosPDF {
	
	Modelo<MovilizadoEO> modeloPromovidos;
	MovilizadorEO activista;

	public Modelo<MovilizadoEO> getModeloPromovidos() {
		return modeloPromovidos;
	}

	public void setModeloPromovidos(Modelo<MovilizadoEO> modeloPromovidos) {
		this.modeloPromovidos = modeloPromovidos;
	}

	public MovilizadorEO getActivista() {
		return activista;
	}

	public void setActivista(MovilizadorEO activista) {
		this.activista = activista;
	}
	

	
	

}
