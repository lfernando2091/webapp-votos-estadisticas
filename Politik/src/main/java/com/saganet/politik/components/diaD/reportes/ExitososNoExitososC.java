package com.saganet.politik.components.diaD.reportes;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.jasper.tagplugins.jstl.core.ForEach;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.webflow.execution.RequestContext;

import com.saganet.politik.components.diaD.SeccionalC;
import com.saganet.politik.database.diaD.reportes.ExitosoNoExitosoEO;
import com.saganet.politik.dominios.NivelReporteCompletoDO;
import com.saganet.politik.dominios.NivelesReporteDO;
import com.saganet.politik.dominios.ProgramasEdoMexDO;
import com.saganet.politik.modelos.Modelo;

@Component("DiadReportesExitososNoExitososC")
public class ExitososNoExitososC {
@Autowired
SqlSession sqlSession;
private static final Logger logger = LoggerFactory.getLogger(ExitososNoExitososC.class);

	public String modelo(RequestContext context,  NivelReporteCompletoDO nivel, ProgramasEdoMexDO programa){
		HashMap<String, Object> flowScope;
		List<ExitosoNoExitosoEO> listado;
	   Modelo<ExitosoNoExitosoEO> modelo;
		
		flowScope = (HashMap<String, Object>) context.getFlowScope().asMap();
		flowScope.put("nivel", nivel);
		flowScope.put("programa", programa.getNombre2());
		flowScope.put("region",flowScope.get("listadoRegiones"));
		flowScope.put("municipio",flowScope.get("listadoMunicipios"));
		flowScope.put("seccion",flowScope.get("listadoSecciones"));
		logger.debug("Listado Municipio: {}", flowScope.get("municipio"));
		try{
		listado = sqlSession.selectList("diaD.reportes.exitososNoExitosos.listado", flowScope);
		modelo =   new Modelo<>(listado);
		flowScope.put("modelo",modelo);
		logger.debug("Listado despues: {}", listado);
	    flowScope.put("total", total(modelo));
	    logger.debug("Total: {}", listado);
		return "success";
		}catch(Exception e){
			logger.debug("Error: {}", e.getMessage());
			return "error";
		}
		
	}
	
	public HashMap<String, Object> total(Modelo<ExitosoNoExitosoEO> modelo){
		HashMap<String, Object> mapa;
		
		mapa = new HashMap<>();
		Integer _1;
		Integer _2;
		Integer _3;
		Integer _4;
		Integer _5;
		Integer _6;
		Integer _7;
		Integer _8;
		Integer _9;
		Integer _10;
		Integer _11;
		Integer _12;
		Integer _13;

		_1 =0;
		_2 =0;
		_3 =0;
		_4 =0;
		_5 =0;
		_6 =0;
		_7 =0;
		_8 =0;
		_9 =0;
		_10 =0;
		_11 =0;
		_12 =0;
		_13 =0;
		for (ExitosoNoExitosoEO exitosoNoExitosoEO : modelo.getListado()) {
			_1 = _1 + exitosoNoExitosoEO.getContactos();
			_2 = _2 + exitosoNoExitosoEO.getaFavor();
			_3 = _3 + exitosoNoExitosoEO.getIndeciso();
			_4 = _4 + exitosoNoExitosoEO.getEnContra();
			_5 = _5 + exitosoNoExitosoEO.getTotalExitosas();
			_6 = _6 + exitosoNoExitosoEO.getMe();
			_7 = _7 + exitosoNoExitosoEO.getF();
			_8 = _8 + exitosoNoExitosoEO.getO();
			_9 = _9 + exitosoNoExitosoEO.getNva();
			_10 = _10 + exitosoNoExitosoEO.getNqc();
			_11 = _11 + exitosoNoExitosoEO.getNhqc();
			_12 = _12 + exitosoNoExitosoEO.getDne();
			_13 = _13 + exitosoNoExitosoEO.getTotalNoExitosas();
			
		}

		mapa.put("_1", _1);
		mapa.put("_2", _2);
		mapa.put("_3", _3);
		mapa.put("_4", _4);
		mapa.put("_5", _5);
		mapa.put("_6", _6);
		mapa.put("_7", _7);
		mapa.put("_8", _8);
		mapa.put("_9", _9);
		mapa.put("_10", _10);
		mapa.put("_11", _11);
		mapa.put("_12", _12);
		mapa.put("_13", _13);
		
		return mapa;
	}
}
