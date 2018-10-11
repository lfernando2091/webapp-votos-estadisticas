package com.saganet.politik.components.warehouse;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.saganet.politik.database.mdm.PersonaEO;
import com.saganet.politik.database.mdm.TablaPersonaEO;
import com.saganet.politik.modelos.mdm.TablasPersonasT;

@Component("PerfilesController")
public class PerfilesC {
	
	@Autowired
	SqlSession sqlSession;
	
	private static final Logger logger = LoggerFactory.getLogger(PerfilesC.class);

	public String validaPersona(PersonaEO persona){
		if(persona == null){
			logger.debug("No se recibió a la persona.");
			return "vacia";
		}else{
			logger.debug("Persona recibida.");
			return "llena";
		}
	}
	
	public TablasPersonasT tablaPersonas(PersonaEO persona){
		
		TablasPersonasT tabla;
		List<TablaPersonaEO> listado;
		
		tabla = new TablasPersonasT();
		
		logger.debug("idPersonaAntes {}", persona.getId());
		
		listado = sqlSession.selectList("mdm.tablasPersonas.busquedaPorIdPersona",persona);
		
		logger.debug("idPersonaDespues {}", persona.getId());
		
		if(!listado.isEmpty()){
			tabla.setSeleccionado(listado.get(0));
		}
		
		tabla.setListado(listado);
		
		return tabla;
	}
	
}
