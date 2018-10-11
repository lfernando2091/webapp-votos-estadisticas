package com.saganet.politik.components.diaD.reportes;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.webflow.execution.RequestContext;

import com.saganet.politik.database.diaD.reportes.MetasMovilizadoresEO;
import com.saganet.politik.database.diaD.reportes.MetasSeccionalesEO;
import com.saganet.politik.dominios.NivelReporteCompletoDO;
import com.saganet.politik.dominios.ProgramasEdoMexDO;
import com.saganet.politik.modelos.Modelo;

@Component("DiaDReportesMetasSeccionalesC")
public class MetasSeccionalesC {
@Autowired
SqlSession sqlSession;

private static final Logger logger = LoggerFactory.getLogger(MetasSeccionalesC.class);
public String modelo(RequestContext context, NivelReporteCompletoDO nivel, ProgramasEdoMexDO programa){
	HashMap<String, Object> flowScope;
	List<MetasSeccionalesEO> listado;
	Modelo<MetasSeccionalesEO> modelo;
	
	logger.debug("Listado: {}", nivel);
	logger.debug("Listado: {}", programa);
	flowScope = (HashMap<String, Object>) context.getFlowScope().asMap();
	if(nivel.getNombre().equals("General")){
		flowScope.put("nivel", "general");
	}else if(nivel.getNombre().equals("Estatal")){
		flowScope.put("nivel", "estatal");
	}else if(nivel.getNombre().equals("Región")){
		flowScope.put("nivel", "region");
	}else if(nivel.getNombre().equals("Sección")){
		flowScope.put("nivel", "seccion");
	}else if(nivel.getNombre().equals("Municipio")){
		flowScope.put("nivel", "municipio");
	}
	
	flowScope.put("programa", programa);
	flowScope.put("region",flowScope.get("listadoRegiones"));
	flowScope.put("municipio",flowScope.get("listadoMunicipios"));
	flowScope.put("seccion",flowScope.get("listadoSecciones"));
	try{
	listado = sqlSession.selectList("diaD.reportes.metasSeccionales.listado", flowScope);
	modelo = new Modelo<>(listado);
	flowScope.put("modelo", modelo);
	flowScope.put("total", subtotal(modelo));
	logger.debug("Listado: {}", listado);
	}catch(Exception e){
		
		System.out.println(e.getMessage());
	}
	
	return "sucess";
}
public HashMap<String, Object> subtotal(Modelo<MetasSeccionalesEO> modelo){
	HashMap<String, Object> mapa;
	Integer meta, avance;
	
	meta = 0;
	avance = 0;
	mapa = new HashMap<>();
	
	for (MetasSeccionalesEO metaSeccional : modelo.getListado()) {
		avance = avance + metaSeccional.getCapturados();
		meta = meta + metaSeccional.getMeta();
	}
	mapa.put("tavance", avance);
	mapa.put("tmeta", meta);
	mapa.put("tporcentaje", avance==0?0:Math.round((avance.doubleValue()/meta.doubleValue())*100));
	return mapa;
	
}
}
