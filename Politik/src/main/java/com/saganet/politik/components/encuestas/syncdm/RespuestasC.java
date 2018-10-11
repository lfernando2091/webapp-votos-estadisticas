package com.saganet.politik.components.encuestas.syncdm;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.saganet.politik.database.encuestas.syncdm.RespuestaEO;
import com.saganet.politik.modelos.Modelo;

@Component("SyncDMRespuestasC")
public class RespuestasC {
@Autowired
SqlSession sqlSession;
private static final Logger logger = LoggerFactory.getLogger(RespuestasC.class);
	public Modelo<RespuestaEO> modelo(Integer idPregunta){
		Modelo<RespuestaEO> modelo;
		List<RespuestaEO> listado;
		
		modelo = new Modelo<>();
		listado = sqlSession.selectList("encuestas.syncdm.respuestas.listado", idPregunta);
		modelo.setListado(listado);
		if(!listado.isEmpty()){
			modelo.setSeleccionado(listado.get(0));
		}
		logger.debug("listado:{}", listado);
		return modelo;
	}
}
