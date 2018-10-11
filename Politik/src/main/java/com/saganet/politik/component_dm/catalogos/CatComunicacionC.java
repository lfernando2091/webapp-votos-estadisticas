package com.saganet.politik.component_dm.catalogos;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.saganet.politik.database.catalogos.EntidadEO;
import com.saganet.politik.database_dm.catalogos.CatComunicacionEO;
import com.saganet.politik.modelos.Modelo;

@Component("CatComunicacionC")
public class CatComunicacionC {
	
	@Autowired
	SqlSession sqlSessionDM;
	
	@Autowired
	SqlSession sqlSession;
	
	private static final Logger logger = LoggerFactory.getLogger(CatComunicacionC.class);
	
	public Modelo<CatComunicacionEO> modelo(){
		Modelo<CatComunicacionEO> modelo;
		List<CatComunicacionEO> listado;
		
		listado = sqlSessionDM.selectList("catalogos.catComunicacion.listado");
		logger.debug("Listado CatComunicacion: {}", listado);
		
		modelo = new Modelo<>();
		modelo.setListado(listado);
		
		if(!listado.isEmpty()){
			modelo.setSeleccionado(listado.get(0));
		}
		
		logger.debug("Modelo CatComunicacion: {}", modelo);
		
		/////////////////////////////////////////////////////
		Modelo<EntidadEO> modeloEntidades;
		List<EntidadEO> listadoEntidades;
		listadoEntidades = sqlSession.selectList("catalogos.entidades.listado");
		modeloEntidades = new Modelo<>();
		modeloEntidades.setListado(listadoEntidades);
		if(!listadoEntidades.isEmpty()){
			modeloEntidades.setSeleccionado(listadoEntidades.get(0));
		}
		logger.debug("ListadoEntidades: {}", listadoEntidades);
		logger.debug("Modelo Entidades: {}", modeloEntidades);
		/////////////////////////////////////////////////////
		
		return modelo;
		
	}
	
}
