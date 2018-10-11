package com.saganet.politik.components.encuestas.hermanos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.webflow.execution.RequestContext;

import com.saganet.politik.beans.seguridad.Usuario;
import com.saganet.politik.database.administracion.UsuarioEO;
import com.saganet.politik.database.encuestas.hermanos.EncuestaEO;
import com.saganet.politik.database.encuestas.hermanos.EntrevistadoEO;
import com.saganet.politik.database.encuestas.hermanos.MovilizacionFCEO;
import com.saganet.politik.database.mdm.PersonaEO;
import com.saganet.politik.dominios.ResultadoEncuestaEdomexDO;
import com.saganet.politik.modelos.Modelo;

@Component("HermanosCapturaC")
public class CapturaC {
	@Autowired
	SqlSession sqlSession;
	private static final Logger logger = LoggerFactory.getLogger(CapturaC.class);

	public String buscarId(RequestContext context, Integer id) {
		logger.debug("Encuesta: {}",id);
		HashMap<String, Object> flowScope, parametros, datosNick;
		List<Object> entrevistados;
		EntrevistadoEO entrevistado;
		EncuestaEO encuesta;
		MovilizacionFCEO fuenteHermano;
		Integer idMunicipioLogueado;
		
		List<UsuarioEO> listado;
		int suma;
		listado = new ArrayList<>();
		suma = 1;
		idMunicipioLogueado=0;
		flowScope = (HashMap<String, Object>) context.getFlowScope().asMap();
		parametros = new HashMap<>();
		datosNick= new HashMap<>();
		fuenteHermano =  new MovilizacionFCEO();
		//buscamos al visitador
		try{
		datosNick = sqlSession.selectOne("encuestas.hermanos.registroUsuarios.buscarDatosNick", getUsuario().getNick());
		parametros.put("municipio", Integer.parseInt(datosNick.get("id_municipio").toString()));
		
		
		}catch(Exception e){
			
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_FATAL, "Operación no válida.", "Contact admin."));
			return "error";
		}
		fuenteHermano =  sqlSession.selectOne("encuestas.hermanos.tablaFuenteHermanos.fuente", id);
		parametros.put("folio", id);
	
		entrevistado = sqlSession.selectOne("encuestas.hermanos.entrevistado.buscarId", parametros);

		logger.debug("parametros: {}",parametros);
		logger.debug("entrevistado: {}",entrevistado);
		if(entrevistado!=null){
			
			encuesta = new EncuestaEO();
			entrevistado.setFechaNacimiento(entrevistado.getFechaNacimiento()!=null?entrevistado.getFechaNacimiento().toString().substring(6,8)+"/"+entrevistado.getFechaNacimiento().toString().substring(4,6) + "/"+entrevistado.getFechaNacimiento().toString().substring(0,5):null);
			//buscamos si esta contestado
				logger.debug("Encuesta: {}",entrevistado);
				try{
				encuesta = sqlSession.selectOne("encuestas.hermanos.captura.buscarPorId", entrevistado);
				}catch(Exception e){
					logger.debug(" Error: {}",e.getCause());
				}
				if(encuesta==null){
					encuesta = new EncuestaEO();
					encuesta.setNick(getUsuario().getNick());
					encuesta.setIdContacto(entrevistado.getIdInterno().toString());
				}else{
					encuesta.setNickActualizacion(getUsuario().getNick());
					entrevistado.setNombre(encuesta.getNombre());
					entrevistado.setApellidoPaterno(encuesta.getPaterno());
					entrevistado.setApellidoMaterno(encuesta.getMaterno());
					entrevistado.setFechaNacimiento(encuesta.getFechaNacimiento());
					entrevistado.setSexo(encuesta.getGenero());
					FacesContext.getCurrentInstance().addMessage(null,
							new FacesMessage(FacesMessage.SEVERITY_WARN, "*IMPORTANTE: El folio consultado ya ha sido capturado anteriormente ("+encuesta.getNick()+ " " + encuesta.getFecha() + ").", "Contact admin."));
				}
				listado.add(getUsuario());
				flowScope.put("entrevistado", entrevistado);
				flowScope.put("encuesta", encuesta);
				flowScope.put("modeloEncuestadores", new Modelo<>(listado));
				flowScope.put("fuente", fuenteHermano);
				flowScope.put("tieneClave", entrevistado!=null);
				flowScope.put("tieneClave", true);
				
				logger.debug("encuesta: {}", encuesta);
				logger.debug("fuente: {}", fuenteHermano);
				logger.debug("entrevistado: {}", entrevistado);
				return "success";
			}else{
				
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_FATAL, "Folio no encontrádo.", "Contact admin."));
				return "error";
			}
			
		
	}
	
	
	public String buscaInterno(RequestContext context, Integer id) {
		logger.debug("Encuesta: {}",id);
		HashMap<String, Object> flowScope, parametros;
		List<Object> entrevistados;
		EntrevistadoEO entrevistado;
		EncuestaEO encuesta;
		
		List<UsuarioEO> listado;
		int suma;
		listado = new ArrayList<>();
		suma = 1;
		flowScope = (HashMap<String, Object>) context.getFlowScope().asMap();
		parametros = new HashMap<>();
		
		//buscamos al visitador
		
		
		parametros.put("folio", id);
		
		entrevistado = sqlSession.selectOne("encuestas.hermanos.entrevistado.buscarIdInterno", parametros);
		
		if(entrevistado!=null){
			
				encuesta = new EncuestaEO();
				entrevistado.setFechaNacimiento(entrevistado.getFechaNacimiento().toString().substring(6,8)+"/"+entrevistado.getFechaNacimiento().toString().substring(4,6) + "/"+entrevistado.getFechaNacimiento().toString().substring(0,5));
				//buscamos si esta contestado
				logger.debug("Encuesta: {}",entrevistado);
				try{
				encuesta = sqlSession.selectOne("encuestas.hermanos.captura.buscarPorId", entrevistado);
				}catch(Exception e){
					logger.debug(" Error: {}",e.getCause());
				}
				if(encuesta==null){
					encuesta = new EncuestaEO();
					encuesta.setNick(getUsuario().getNick());
					encuesta.setIdContacto(entrevistado.getIdInterno().toString());
				}else{
					encuesta.setNickActualizacion(getUsuario().getNick());
					entrevistado.setNombre(encuesta.getNombre());
					entrevistado.setApellidoPaterno(encuesta.getPaterno());
					entrevistado.setApellidoMaterno(encuesta.getMaterno());
					entrevistado.setFechaNacimiento(encuesta.getFechaNacimiento());
					entrevistado.setSexo(encuesta.getGenero());
					FacesContext.getCurrentInstance().addMessage(null,
							new FacesMessage(FacesMessage.SEVERITY_WARN, "*IMPORTANTE: El folio consultado ya ha sido capturado anteriormente ("+encuesta.getNick()+ " " + encuesta.getFecha() + ").", "Contact admin."));
				}
				listado.add(getUsuario());
				flowScope.put("entrevistado", entrevistado);
				flowScope.put("encuesta", encuesta);
				flowScope.put("modeloEncuestadores", new Modelo<>(listado));
				logger.debug("encuesta: {}", encuesta);
				logger.debug("entrevistado: {}", entrevistado);
				return "success";
			
			
		}else{
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "No se encontró información", "Contact admin."));
			return "error";
		}
		
	}
	
	
	public void guardar(RequestContext context) {
		logger.debug("Encuesta guardar: {}", "entro");
		HashMap<String, Object> flowScope;
		flowScope = (HashMap<String, Object>) context.getFlowScope().asMap();
	try{
		logger.debug(" flowScope: {}",flowScope );
		sqlSession.insert("encuestas.hermanos.captura.insertar",flowScope);
		sqlSession.update("encuestas.hermanos.captura.actualizarEstatus", flowScope);
		logger.debug("Valor de la variable: {} ", (Boolean)flowScope.get("tieneclave"));
		if((Boolean)flowScope.get("tieneClave")==false){
			sqlSession.update("encuestas.hermanos.entrevistado.actualizarVisitado", flowScope);
		}
	}catch(Exception e){
		logger.debug(" Error: {}",e.getCause());
		
	}
	}


	public void actualizar(RequestContext context) {
		try{
		HashMap<String, Object> flowScope;
		flowScope = (HashMap<String, Object>) context.getFlowScope().asMap();
		sqlSession.update("encuestas.hermanos.captura.actualizarEncuesta", flowScope);
		sqlSession.update("encuestas.hermanos.captura.actualizarEstatus", flowScope);
		logger.debug("Valor de la variable: {} ", (Boolean)flowScope.get("tieneclave"));
		if((Boolean)flowScope.get("tieneClave")==false){
			sqlSession.update("encuestas.hermanos.entrevistado.actualizarVisitado", flowScope);
		}
		logger.debug(" encuesta: {}",flowScope.get("entrevistado"));
		}catch(Exception e){
			logger.debug(" Error: {}",e.getCause());
			
		}
	}

public Modelo<UsuarioEO> modeloEntrevistadores(){
	List<UsuarioEO> listado;
	listado = new ArrayList<>();
	listado.add(getUsuario());
	return new Modelo<>(listado);
}
	

	public UsuarioEO getUsuario() {
		return ((Usuario) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsuario();
	}

	
	public String establecerPersona(RequestContext context, PersonaEO persona) {
		HashMap<String, Object> flowScope;
		EntrevistadoEO entrevistado, inicial;
		StringBuilder fechaNac;
		
		
		flowScope = (HashMap<String, Object>) context.getFlowScope().asMap();
		entrevistado = new EntrevistadoEO();
		fechaNac = new StringBuilder();
		inicial = (EntrevistadoEO) flowScope.get("entrevistado");
		if(persona!=null){
			entrevistado = sqlSession.selectOne("encuestas.hermanos.entrevistado.buscarPadron", persona.getClaves().get(0).getClave());
			fechaNac.append(entrevistado.getFechaNacimiento().toString().substring(6,8));
			fechaNac.append("/");
			fechaNac.append(entrevistado.getFechaNacimiento().toString().substring(4,6));
			fechaNac.append("/");
			fechaNac.append(entrevistado.getFechaNacimiento().toString().substring(0,4));
			entrevistado.setFechaNacimiento(fechaNac.toString());
			entrevistado.setIdInterno(Integer.parseInt(flowScope.get("folioBusqueda").toString()));
			entrevistado.setEstatus(inicial.getEstatus());
			entrevistado.setPadron(true);
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Persona encontrada", "Contact admin."));
			flowScope.put("entrevistado", entrevistado);
			flowScope.put("tieneClave", false);
			return "success";
		}else{
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_FATAL, "Persona no encontrada", "Contact admin."));
			return "error";
		}
		
	}
}
