package com.saganet.politik.database.encuestas.admin;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import com.saganet.politik.database.diaD.MovilizadoEO;
import com.saganet.politik.database.diaD.MovilizadorEO;

@Component("ParametrosPromovidos")

public class ParametrosPromovidos {
	
	private MovilizadorEO movilizador;

	

	public MovilizadorEO getMovilizador() {
		return movilizador;
	}

	public void setMovilizador(MovilizadorEO movilizador) {
		this.movilizador = movilizador;
	}
	
	
}
