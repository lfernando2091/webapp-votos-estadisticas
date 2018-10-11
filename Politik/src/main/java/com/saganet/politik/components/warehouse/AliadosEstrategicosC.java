package com.saganet.politik.components.warehouse;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.saganet.politik.database.mdm.PersonaEO;
import com.saganet.politik.database.warehouse.AliadoEstrategicoEO;
import com.saganet.politik.modelos.warehouse.AliadosEstrategicosT;

@Component("AliadosEstrategicosController")
public class AliadosEstrategicosC {

	@Autowired
	SqlSession sqlSession;
	
	private static final Logger logger = LoggerFactory.getLogger(AliadosEstrategicosC.class);
	
	public AliadosEstrategicosT tabla(){
		
		AliadosEstrategicosT tabla;
		List<AliadoEstrategicoEO> listado;
		
		tabla = new AliadosEstrategicosT();
		
		listado = null;
		try{
			listado = sqlSession.selectList("warehouse.aliadosEstrategicos.listado");
		}catch(Exception ex){
			logger.debug("Error: {}", ex.toString());
		}
		
		
		if(!listado.isEmpty()){
			tabla.setSeleccionado(listado.get(0));
		}
		
		tabla.setListado(listado);
		
		return tabla;
	}
	
	public void insertarAliadoEstrategico(PersonaEO persona){
		
		AliadoEstrategicoEO aliadoEstrategicoEO;
		
		try{
			sqlSession.insert("warehouse.aliadosEstrategicos.insertarAliadoEstrategico", persona);
			logger.debug("persona: {}", persona.getId());
			logger.debug("persona: {}", persona.getEntidadNacimiento().getId());
			logger.debug("persona: {}", persona.getEntidadNacimiento().getId());
		}catch(Exception ex){
			logger.debug("Error al insertar Aliado Estratégico: {}", ex.toString());
		}
		
		
		aliadoEstrategicoEO = new AliadoEstrategicoEO();
		
		try{
			aliadoEstrategicoEO = sqlSession.selectOne("warehouse.aliadosEstrategicos.buscarAliadoEstrategicoByPersona",persona);
			logger.debug("AliadoEstrategico: {}", aliadoEstrategicoEO.getId());
			logger.debug("AliadoEstrategico: {}", aliadoEstrategicoEO.getPersona().getId());
			logger.debug("AliadoEstrategico: {}", aliadoEstrategicoEO.getPersona().getEntidadNacimiento().getId());
		}catch(Exception ex){
			logger.debug("Error Al buscar el Aliado Estrategico: {}", ex.toString());
		}
		
		
		try{
			sqlSession.insert("warehouse.aliadosEstrategicos.insertarTablasPersonasForAliadosEstrategicos",aliadoEstrategicoEO);
		}catch(Exception ex){
			logger.debug("Error insertar en tabla_personas para Aliado Estratégico: {}", ex.toString());
		}
		
	}
	
}
