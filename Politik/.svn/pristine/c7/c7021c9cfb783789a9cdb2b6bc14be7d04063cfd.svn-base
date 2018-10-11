package com.saganet.politik.components.encuestas.edomex2017.entrevistaEntrevistador;


import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.saganet.politik.database.encuestas.edomex2017.entrevistaEntrevistador.ReporteCallCenterEO;
import com.saganet.politik.modelos.Modelo;

@Component("Edomex2017ReporteCallCenterC")
public class ReporteCallCenterC {

	@Autowired
	SqlSession sqlSession;

	private static final Logger logger = LoggerFactory.getLogger(ReporteCallCenterC.class);
	
	public Modelo<ReporteCallCenterEO> modelo() {
		List<ReporteCallCenterEO> listado=sqlSession.selectList("encuestas.edomex2017.entrevistaEntrevistador.reporteCallCenter.listado");
		logger.debug("Listado : {}",listado);
		return new Modelo<>(listado);
	}
}
