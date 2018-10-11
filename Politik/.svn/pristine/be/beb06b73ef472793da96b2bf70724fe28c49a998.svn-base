package com.saganet.politik.components.encuestas.syncdm;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.saganet.politik.database.encuestas.syncdm.EncuestaEO;
import com.saganet.politik.modelos.Modelo;

@Component("SyncDMEncuestasC")
public class EncuestasC {

	@Autowired
	SqlSession sqlSession;
	public Modelo<EncuestaEO> modelo(){
		Modelo<EncuestaEO> modelo;
		List<EncuestaEO> listado;
		modelo = new Modelo<>();
		listado = sqlSession.selectList("syncdm.encuestas.listado");
		modelo.setListado(listado);
		if(!listado.isEmpty()){
			modelo.setSeleccionado(listado.get(0));
		}
		return modelo;
	}
	
}
