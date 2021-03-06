package com.saganet.politik.components.diaD.reportes;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("diaDReportesListadoSeccionalesC")
public class ListadoSeccionalesC {

	@Autowired
	SqlSession sqlSession;
	
	@SuppressWarnings("unused")
	private static final Logger logger = LoggerFactory.getLogger(ListadoSeccionalesC.class);
	
	public HashMap<String, Object> contacto(Integer idInterno){
		HashMap<String, Object> mapa;
		
		mapa = new HashMap<>();
		mapa.put("idInterno", idInterno);
		mapa= sqlSession.selectOne("encuestas.edomex2017.v2.captura.buscarPorId", mapa);
		return mapa;
	}
}
