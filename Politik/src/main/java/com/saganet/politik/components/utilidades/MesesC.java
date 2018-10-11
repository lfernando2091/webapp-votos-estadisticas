package com.saganet.politik.components.utilidades;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import com.saganet.politik.dominios.MesDO;
import com.saganet.politik.tablas.utilidades.MesesT;


@Component("MesesController")
public class MesesC {

	public MesesT tabla() {
		MesesT tabla;
		List<MesDO> listado;

		tabla = new MesesT();
		listado = Arrays.asList(MesDO.values());
		tabla.setListado(listado);
		if (!listado.isEmpty()) {
			tabla.setSeleccionado(listado.get(0));
		}

		return tabla;
	}
}
