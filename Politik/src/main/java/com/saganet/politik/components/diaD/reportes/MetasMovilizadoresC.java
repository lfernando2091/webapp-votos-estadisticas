package com.saganet.politik.components.diaD.reportes;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.webflow.execution.RequestContext;

import com.saganet.politik.database.diaD.reportes.MetasMovilizadoresCompletoEO;
import com.saganet.politik.database.diaD.reportes.MetasMovilizadoresEO;
import com.saganet.politik.dominios.NivelReporteCompletoDO;
import com.saganet.politik.dominios.ProgramasEdoMexDO;
import com.saganet.politik.modelos.Modelo;

@Component("DiaDReportesMetasMovilizadoresC")
public class MetasMovilizadoresC {
@Autowired
SqlSession sqlSession;

private static final Logger logger = LoggerFactory.getLogger(MetasMovilizadoresC.class);
public String modelo(RequestContext context, NivelReporteCompletoDO nivel, ProgramasEdoMexDO programa){
	HashMap<String, Object> flowScope;
	List<MetasMovilizadoresEO> listado;
	Modelo<MetasMovilizadoresEO> modelo;
	
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
	listado = sqlSession.selectList("diaD.reportes.metasMovilizadores.listado", flowScope);
	modelo = new Modelo<>(listado);
	flowScope.put("modelo", modelo);
	flowScope.put("total", subtotal(modelo));
	logger.debug("Listado: {}", listado);
	}catch(Exception e){
		
		System.out.println(e.getMessage());
	}
	
	return "success";
}
public String modeloCompleto(RequestContext context, NivelReporteCompletoDO nivel, ProgramasEdoMexDO programa){
	HashMap<String, Object> flowScope;
	List<MetasMovilizadoresCompletoEO> listado;
	Modelo<MetasMovilizadoresCompletoEO> modelo;
	
	logger.debug("Nivel: {}", nivel.getNombre());
	logger.debug("Programa: {}", programa.getNombre());
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
	listado = sqlSession.selectList("diaD.reportes.metasMovilizadoresCompleto.listado", flowScope);
	modelo = new Modelo<>(listado);
	flowScope.put("modelo", modelo);
	flowScope.put("total", subtotalCompleto(modelo));
	logger.debug("Listado Metas Movilziadores: {}", listado);
	}catch(Exception e){
		
		System.out.println(e.getMessage());
	}
	
	return "success";
}
public HashMap<String, Object> subtotal(Modelo<MetasMovilizadoresEO> modelo){
	HashMap<String, Object> mapa;
	Integer meta, avance;
	
	meta = 0;
	avance = 0;
	mapa = new HashMap<>();
	
	for (MetasMovilizadoresEO metaMovilizador : modelo.getListado()) {
		avance = avance + metaMovilizador.getCapturados();
		meta = meta + metaMovilizador.getMeta();
	}
	mapa.put("tavance", avance);
	mapa.put("tmeta", meta);
	mapa.put("tporcentaje", avance==0?0:Math.round((avance.doubleValue()/meta.doubleValue())*100));
	return mapa;
	
}
public HashMap<String, Object> subtotalCompleto(Modelo<MetasMovilizadoresCompletoEO> modelo){
	HashMap<String, Object> mapa;
	Integer metaRowan, avanceRowan,metaFitz, avanceFitz,metaAbby, avanceAbby;
	
	metaRowan = 0;
	avanceRowan = 0;
	metaAbby = 0;
	avanceAbby = 0;
	metaFitz = 0;
	avanceFitz = 0;
	mapa = new HashMap<>();
	
	for (MetasMovilizadoresCompletoEO metaMovilizador : modelo.getListado()) {
		avanceRowan = avanceRowan + metaMovilizador.getAvanceRowan();
		metaRowan = metaRowan + metaMovilizador.getMetaRowan();
		avanceAbby = avanceAbby + metaMovilizador.getAvanceAbby();
		metaAbby = metaAbby + metaMovilizador.getMetaAbby();
		avanceFitz = avanceFitz + metaMovilizador.getAvanceFitz();
		metaFitz = metaFitz + metaMovilizador.getMetaFitz();
	}
	mapa.put("tavanceRowan", avanceRowan);
	mapa.put("tmetaRowan", metaRowan);
	mapa.put("tporcentajeRowan", avanceRowan==0?0:Math.round((avanceRowan.doubleValue()/metaRowan.doubleValue())*100));
	mapa.put("tavanceAbby", avanceAbby);
	mapa.put("tmetaAbby", metaAbby);
	mapa.put("tporcentajeAbby", avanceAbby==0?0:Math.round((avanceAbby.doubleValue()/metaAbby.doubleValue())*100));
	mapa.put("tavanceFitz", avanceFitz);
	mapa.put("tmetaFitz", metaFitz);
	mapa.put("tporcentajeFitz", avanceFitz==0?0:Math.round((avanceFitz.doubleValue()/metaFitz.doubleValue())*100));
	mapa.put("avance", avanceFitz+avanceRowan+avanceAbby);
	mapa.put("meta", metaFitz+metaRowan+metaAbby);
	mapa.put("porcentaje", avanceFitz+avanceRowan+avanceAbby==0?0: Math.round((( avanceFitz+avanceRowan+avanceAbby)/(metaFitz.doubleValue()+metaRowan.doubleValue()+metaAbby.doubleValue()))*100));
    logger.debug("Porcentaje: {} ", (avanceFitz+avanceRowan+avanceAbby)==0?0: Math.round((( avanceFitz+avanceRowan+avanceAbby)/(metaFitz.doubleValue()+metaRowan.doubleValue()+metaAbby.doubleValue()))*100));
	return mapa;
	
}
}
