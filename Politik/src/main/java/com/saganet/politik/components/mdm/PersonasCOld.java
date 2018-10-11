package com.saganet.politik.components.mdm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.saganet.politik.database.catalogos.EntidadEO;
import com.saganet.politik.database.catalogos.TipoClaveEO;
import com.saganet.politik.database.mdm.PersonaEO;
import com.saganet.politik.tablas.mdm.PersonasT;

@Component("PersonasController")
public class PersonasCOld {
	@Autowired
	SqlSession sqlSession;
	//@Autowired
	//Parametros parametros;
	
	private static final Logger logger = LoggerFactory.getLogger(PersonasCOld.class);

	public PersonasT tablaBlanca() {
		return new PersonasT();
	}
	
	public PersonaEO nuevaPersona(){
		PersonaEO persona = new PersonaEO();
		return persona;
	}
	
	public PersonaEO buscarPersona(Integer idPersona){
		logger.debug("Identificador de la persona recibido {}", idPersona);
		return sqlSession.selectOne("mdm.personas.buscarPorId", idPersona);
	}
	
	public PersonaEO buscarPersonaSimple(Integer idPersona){
		logger.debug("Identificador de la persona recibido {}", idPersona);
		return sqlSession.selectOne("mdm.personas.buscarPorIdSimple", idPersona);
	}

	public PersonasT buscarPorClave(TipoClaveEO tipoClave, String clave, EntidadEO entidad) {
		PersonasT tabla;
		List<PersonaEO> listado;
		HashMap<String, Object> mapa;

		mapa = new HashMap<String, Object>();
		listado = new ArrayList<PersonaEO>();

		if (entidad.getId().intValue() != -1) // No es Todos
			mapa.put("idEntidad", entidad.getId());
		
		switch (tipoClave.getId()) {
		case 0: // idPersona
			mapa.put("idPersona", Integer.parseInt(clave));
			//mapa.put("entidades", parametros.getEntidadesT());
			listado = sqlSession.selectList("mdm.personas.buscarBasicaPorId", mapa);
			break;
		case 1: // IFE
			
			mapa.put("claveElector", clave);
			logger.debug("Buscando Por claveElector");
			logger.debug("claveElector: {}", clave);
			logger.debug("Entidad: {}", mapa.get("idEntidad"));
			
			try{
				listado = sqlSession.selectList("mdm.personas.buscarBasicaPorCveElector", mapa);
			}catch (Exception e) {
				// TODO: handle exception
				logger.debug("Error al realizar la busqueda por claveElector: {}", e.toString());
			}
			
			break;
		case 2: // CURP
			mapa.put("idTipoClave", tipoClave.getId());
			mapa.put("clave", clave);
			//mapa.put("entidades", parametros.getEntidadesT());
			listado = sqlSession.selectList("mdm.personas.buscarBasicaPorClave", mapa);
			//logger.debug("seccion persona: {}",listado.get(0).getSeccion().toString());
			break;
		}

		tabla = new PersonasT();
		tabla.setListado(listado);

		if (!listado.isEmpty()) {
			logger.debug("setSeleccionado {}", listado.get(0).getId());
			tabla.setSeleccionado(listado.get(0));
			logger.debug("setSeleccionado 2225 {}", tabla.getSeleccionado().getId());
			logger.debug("setKey {}", tabla.getKey());
		}
		
		logger.debug("Tabla {}", tabla);

		return tabla;
	}

	public PersonasT buscarPorDatos(PersonaEO persona, EntidadEO entidad) {
		
		PersonaEO personaEO = new PersonaEO();
		personaEO = persona;
		personaEO.setEntidadNacimiento(entidad);
		
		PersonasT tabla;
		List<PersonaEO> listado = null;
		
		tabla = new PersonasT();
		try{
			logger.debug("PersonaID: {}", personaEO.getId());
			logger.debug("PersonaNombre: {}", personaEO.getNombre());
			logger.debug("getPrimerApellido: {}", personaEO.getPrimerApellido());
			logger.debug("getSegundoApellido: {}", personaEO.getSegundoApellido());
			logger.debug("PersonaEntidad: {}", personaEO.getEntidadNacimiento().getId());
			logger.debug("dia: {}", personaEO.getDia());
			logger.debug("año: {}", personaEO.getAnho());
			logger.debug("mes: {}", personaEO.getMes());
			listado = sqlSession.selectList("mdm.personas.buscarBasicaPorDatos", personaEO);
			
			logger.debug("Listado: nombre: {}", listado.get(0).getNombre());
			
		}catch(Exception e){
			logger.debug("Error al realizar la busqueda por datos: {}", e.toString());
		}
		
		tabla.setListado(listado);
		if(!listado.isEmpty()){
			tabla.setSeleccionado(listado.get(0));
		}
		
		return tabla;
	}
	
	public String verificaridPersona(Integer idPersona){
		logger.debug("valor de persona recibido {}",idPersona);
		if(idPersona == null)
			return "no";
		else
			return "si";
	}
	
	public String verificaridPersona(PersonaEO persona){
		logger.debug("valor de persona recibido {}",persona);
		if(persona == null)
			return "no";
		else
			return "si";
	}
	
//	public TablaEO registroTabla(PersonaWHEO personaWHEO){
//		TablaEO tabla;
//		
//		tabla = new TablaEO();
//		
//		tabla = sqlSession.selectOne("warehouse.tablas.registro", personaWHEO);
//		logger.debug("TablaEO: {}", tabla);
//		
//		return tabla;
//	}
	
	public String getDomicilioPersona(PersonaEO persona){
		String domicilio;
		domicilio=sqlSession.selectOne("mdm.personas.buscarDomicilio",persona.getId());
		return domicilio;
	}

	public void validarTabla(PersonasT persona){
		logger.debug("personaT {}", persona);
		logger.debug("personaT key {}", persona.getKey());
		logger.debug("IDpersonaT {}", persona.getSeleccionado());
		logger.debug("IDpersonaT {}", persona.getSeleccionado().getId());
	}
	public void validarPersonas(PersonaEO persona){
		logger.debug("persona {}", persona);
		logger.debug("IDpersona {}", persona.getId());
	}

}
