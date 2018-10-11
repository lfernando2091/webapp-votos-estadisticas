package com.saganet.politik.components.encuestas.edomex2017.entrevistaEntrevistados;

import java.util.HashMap;

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
import com.saganet.politik.database.encuestas.edomex2017.entrevistaEntrevistados.EntrevistaEntrevistadoEO;
import com.saganet.politik.database.encuestas.edomex2017.v2.EncuestaEO;
import com.saganet.politik.dominios.CandidatosEdomex2017DO;
import com.saganet.politik.dominios.PartidosEleccionEdomex2017DO;
import com.saganet.politik.dominios.SiNoNSNCDO;

@Component("Edomex2017EntrevistaEntrevistadosEntrevistaEntrevistadosC")
public class EntrevistaEntrevistadosC {
	@Autowired
	SqlSession sqlSession;

	private static final Logger logger = LoggerFactory.getLogger(EntrevistaEntrevistadosC.class);

	public String buscarFolio(RequestContext context, Integer id) {
		HashMap<String, Object> flowScope;
		EncuestaEO encuesta;
		EntrevistaEntrevistadoEO entrevista;
		try{
		flowScope = (HashMap<String, Object>) context.getFlowScope().asMap();
		encuesta = new EncuestaEO();
		entrevista = new EntrevistaEntrevistadoEO();
		encuesta = sqlSession.selectOne("encuestas.edomex2017.v2.captura.buscarEncuestaEntrevista_ss", id.toString());
		if (encuesta != null) {
			// BUSCAR FOLIO

			entrevista = sqlSession.selectOne("encuestas.edomex2017.entrevistaEntrevistador.entrevistaEntrevistados.buscarEncuesta_ss",
					id);
			if (entrevista == null) {
				entrevista = new EntrevistaEntrevistadoEO();
				entrevista.setNickCaptura(getUsuario().getNick());
				/*Integer idEnte = sqlSession
						.selectOne("encuestas.edomex2017.entrevistaEntrevistador.entrevistaEntrevistados.buscarId", id);
				entrevista.setId(idEnte);*/
			}else{
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_WARN, "*IMPORTANTE: El folio consultado ya ha sido capturado anteriormente ("+entrevista.getNickCaptura()+")", "Contact admin."));
				
				if(entrevista.get_9().equals(CandidatosEdomex2017DO.ALFREDO_DEL_MAZO_MAZA)){
					flowScope.put("preguntaNueve", SiNoNSNCDO.SI);
				}else if(entrevista.get_9().equals(CandidatosEdomex2017DO.OTRO)){
					flowScope.put("preguntaNueve", SiNoNSNCDO.NO);
				}else{
					flowScope.put("preguntaNueve", SiNoNSNCDO.NS_NC);
				}
			}

			flowScope.put("entrevista", entrevista);
			flowScope.put("entrevistado", encuesta);
			logger.debug("entrevistado: {}", flowScope);
			return "success";
		} else {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "No se encontró información", "Contact admin."));
			return "error";
		}
		// buscamos el id de la persona encuestada.
		}catch(Exception e){e.printStackTrace();}
		return "success";
	}

	public String guardar(RequestContext context) {
		EntrevistaEntrevistadoEO entrevista;
		EncuestaEO entrevistado;

		HashMap<String, Object> flowScope;
		flowScope = (HashMap<String, Object>) context.getFlowScope().asMap();
		entrevistado = (EncuestaEO) flowScope.get("entrevistado");
		entrevista = (EntrevistaEntrevistadoEO) flowScope.get("entrevista");
		entrevista.setIdEntrevistado(entrevistado.getIdContacto());
		logger.debug("Proceso: {}", entrevista);
		try {
			logger.debug("entrevista: {}", entrevista);
			logger.debug("entrevistado: {}", entrevistado);
			sqlSession.insert("encuestas.edomex2017.entrevistaEntrevistador.entrevistaEntrevistados.insertar",
					entrevista);
			logger.debug("insercion: {}", entrevista);
			sqlSession.update("encuestas.edomex2017.v2.captura.actualizarEncuestado", flowScope);
			logger.debug("actualizacion: {}", entrevistado);
			return "success";
		} catch (Exception error) {
			error.printStackTrace();
			return "error";
		}

	}
	
	public String guardar2(RequestContext context) {
		EntrevistaEntrevistadoEO entrevista;
		EncuestaEO entrevistado;

		HashMap<String, Object> flowScope;
		flowScope = (HashMap<String, Object>) context.getFlowScope().asMap();
		entrevistado = (EncuestaEO) flowScope.get("entrevistado");
		entrevista = (EntrevistaEntrevistadoEO) flowScope.get("entrevista");
		entrevista.setIdEntrevistado(entrevistado.getIdContacto());
		if(flowScope.get("preguntaNueve").equals(SiNoNSNCDO.SI)){
			entrevista.set_8(PartidosEleccionEdomex2017DO.PRI);
			entrevista.set_9(CandidatosEdomex2017DO.ALFREDO_DEL_MAZO_MAZA);
		}else if(flowScope.get("preguntaNueve").equals(SiNoNSNCDO.NO)){
			entrevista.set_8(PartidosEleccionEdomex2017DO.OTRO);
			entrevista.set_9(CandidatosEdomex2017DO.OTRO);
		}else{
			entrevista.set_8(PartidosEleccionEdomex2017DO.NS_NC);
			entrevista.set_9(CandidatosEdomex2017DO.NS_NC);
		}
		logger.debug("Proceso: {}", entrevista);
		try {
			logger.debug("entrevista: {}", entrevista);
			logger.debug("entrevistado: {}", entrevistado);
			sqlSession.insert("encuestas.edomex2017.entrevistaEntrevistador.entrevistaEntrevistados.insertar_ss",
				entrevista);
			logger.debug("insercion: {}", entrevista);
			sqlSession.update("encuestas.edomex2017.v2.captura.actualizarEncuestado_ss", flowScope);
			logger.debug("actualizacion: {}", entrevistado);
			return "success";
		} catch (Exception error) {
			error.printStackTrace();
			return "error";
		}

	}

	public String actualizar(RequestContext context) {
		HashMap<String, Object> flowScope;
		EntrevistaEntrevistadoEO entrevista;
		EncuestaEO entrevistado;

		flowScope = (HashMap<String, Object>) context.getFlowScope().asMap();
		entrevistado = (EncuestaEO) flowScope.get("entrevistado");
		entrevista = (EntrevistaEntrevistadoEO) flowScope.get("entrevista");
		entrevista.setIdEntrevistado(entrevistado.getIdContacto());
		try {
			entrevista.setNickActualizacion(getUsuario().getNick());
			sqlSession.insert("encuestas.edomex2017.entrevistaEntrevistador.entrevistaEntrevistados.actualizar",
					entrevista);
			sqlSession.update("encuestas.edomex2017.v2.captura.actualizarEncuestado", flowScope);
			return "success";
		} catch (Exception error) {
			error.printStackTrace();
			return "error";
		}
	}

	public String actualizar2(RequestContext context) {
		HashMap<String, Object> flowScope;
		EntrevistaEntrevistadoEO entrevista;
		EncuestaEO entrevistado;

		flowScope = (HashMap<String, Object>) context.getFlowScope().asMap();
		entrevistado = (EncuestaEO) flowScope.get("entrevistado");
		entrevista = (EntrevistaEntrevistadoEO) flowScope.get("entrevista");
		entrevista.setIdEntrevistado(entrevistado.getIdContacto());
		if(flowScope.get("preguntaNueve").equals(SiNoNSNCDO.SI)){
			entrevista.set_8(PartidosEleccionEdomex2017DO.PRI);
			entrevista.set_9(CandidatosEdomex2017DO.ALFREDO_DEL_MAZO_MAZA);
		}else if(flowScope.get("preguntaNueve").equals(SiNoNSNCDO.NO)){
			entrevista.set_8(PartidosEleccionEdomex2017DO.OTRO);
			entrevista.set_9(CandidatosEdomex2017DO.OTRO);
		}else{
			entrevista.set_8(PartidosEleccionEdomex2017DO.NS_NC);
			entrevista.set_9(CandidatosEdomex2017DO.NS_NC);
		}
		try {
			entrevista.setNickActualizacion(getUsuario().getNick());
			sqlSession.insert("encuestas.edomex2017.entrevistaEntrevistador.entrevistaEntrevistados.actualizar_ss",
					entrevista);
			sqlSession.update("encuestas.edomex2017.v2.captura.actualizarEncuestado_ss", flowScope);
			return "success";
		} catch (Exception error) {
			error.printStackTrace();
			return "error";
		}
	}
	public UsuarioEO getUsuario() {
		return ((Usuario) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsuario();
	}
}
